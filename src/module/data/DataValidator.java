package module.data;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class DataValidator extends Validator {

    protected void validate(Controller controller) {
        validateRequiredString("data.username", "usernameMsg", "用户名不能为空");
    }

    protected void handleError(Controller controller) {
        controller.keepModel(DataModel.class);

        String actionKey = getActionKey();
        if (actionKey.equals("/data/save"))
            controller.render("add.html");
        else if (actionKey.equals("/data/update"))
            controller.render("edit.html");
    }
}
