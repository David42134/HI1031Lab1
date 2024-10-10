package bo;

import db.DBManager;
import db.UserDB;
import ui.UserInfo;

public class UserHandler {
    private final UserDB userDAO;
    public UserHandler() {
        this.userDAO = new UserDB();
    }

    public UserInfo verify(String username, String password) {
        User user = userDAO.login(username,password);
        if(user != null) {
            return new UserInfo(user.getUsername(), user.getPassword());
        }
        return null;
    }
}
