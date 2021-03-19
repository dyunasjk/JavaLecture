package lecture_210319;

public class LoginPasswordException extends loginException {

    private static final long serialVersionUID = 1L;
    public LoginPasswordException(String errMsg) {
        super(errMsg);
    }

    public LoginPasswordException(String errMsg, int errorCode) {
        super(errMsg, errCode);
    }
    
}
