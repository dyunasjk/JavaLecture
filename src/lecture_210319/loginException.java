package lecture_210319;

public class loginException extends Exception {
    private int errorCode;
   
    public loginException(String errMsg) {
        super(errMsg);
        this.errorCode = errorCode;
    }

    public loginException(String errMsg, int errorCode) {
        super(errMsg);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    } 
}
