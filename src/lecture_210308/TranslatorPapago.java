package lecture_210308;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.Paths;
import java.net.*;

import com.google.gson.*;
import org.json.simple.*;
import org.json.simple.parser.*;

// use array and add more word // use papago api
public class TranslatorPapago extends JFrame implements ActionListener{
    private JButton convertBtn;
    private JButton cancelBtn;
    private JTextArea textIn;
    private JTextArea textOut;
    
    public TranslatorPapago() {
        super("text Convert");

        textIn = new JTextArea(10, 14);
        textIn.setLineWrap(true);
        textIn.setEditable(true);
        textOut = new JTextArea(10,14);
        textOut.setLineWrap(true);
        textOut.setEditable(false);

        JPanel textAreaPanel = new JPanel(new GridLayout(1,2,20,20));
        textAreaPanel.add(textIn);
        textAreaPanel.add(textOut);

        convertBtn = new JButton("Convert");
        convertBtn.addActionListener(this);
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(this);

        JPanel btnPanel = new JPanel();
        btnPanel.add(convertBtn);
        btnPanel.add(cancelBtn);

        JPanel mainPanel = new JPanel(new BorderLayout(10,10));
        mainPanel.add(textAreaPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        this.add(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convertBtn) {
            textOut.setText("");
            String result = PapagoTrans(textIn.getText());
            textOut.append(result);

        }
        if (e.getSource() == cancelBtn) {
            textOut.setText(null);
            textIn.setText(null);
        }
    }

    public String PapagoTrans(String str) {
        String clientId = "JNPgYK8sDHpiL3EH3Q9I";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "HU7WYScbb3";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(str, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source=ko&target=en&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            String TransText = response.toString(); // JSon -> String
       
            JsonParser parser = new JsonParser();    
            JsonObject obj = (JsonObject) parser.parse(TransText); //JSon (massage -> result -> trans...)
            
            JsonObject msg = (JsonObject) obj.get("message"); //obj -> msg
            JsonObject Result = (JsonObject) msg.get("result"); //msg -> result
            String Trans = Result.get("translatedText").toString(); //JSon:translatedText -> String
            Trans=Trans.replaceAll("\\\"","");  // String 따옴표 제거
            return Trans;
        } catch (Exception e) {
            System.out.println(e);
            return " ";
        }
    }

    //add papago api

   public static void main(String[] args) {
       new TranslatorPapago();
   }
 
}
