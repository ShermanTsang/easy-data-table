package module.auth;

import java.util.List;

public class AuthService {

    private static final AuthModel dao = new AuthModel().dao();

    public List<AuthModel> findByNameAndPwd(String username, String password){
        return dao.find("select * from auth where username=? and password=?",username,password);
    }

}
