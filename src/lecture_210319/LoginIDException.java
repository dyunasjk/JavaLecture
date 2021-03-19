package lecture_210319;

import javax.security.auth.login.LoginException;

public class LoginIDException extends LoginException {
    
    public LoginIDException(String errMsg) {
        super(errMsg);
    }

    public LoginIDException(String errMsg, int errorCode) {
        super(errMsg, errCode);
    }
}
