package module.auth;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import module.interceptor.BeforeLoginInterceptor;
import module.log.LogModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AuthController extends Controller {

    static AuthService service = new AuthService();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ActionKey("/")
    public void index() {
        if (getSessionAttr("authUsername") == null) {
            redirect("login");
        } else {
            redirect("/dashboard");
        }
    }

    @ActionKey("/captcha")
    public void captcha() {
        renderCaptcha();
    }

    @ActionKey("/login")
    public void login() {
        String auth = getSessionAttr("authUsername");
        if (auth != null) {
            redirect("/");
        } else {
            setAttr("notifyInfo", "登陆后才可使用数据管理系统哟");
            render("login.html");
        }
    }

    @ActionKey("/logout")
    public void logout() {
        removeSessionAttr("authUsername");
        setAttr("notifyInfo", "注销成功！");
        render("login.html");
    }


    public void submit() {
        String username = getPara("username");
        String password = getPara("password");
//        boolean result = validateCaptcha("captcha");
//        if (!result) {
//            setAttr("notifyError", "你输入的验证码错误");
//            render("login.html");
//            return;
//        }
        List<AuthModel> auth = service.findByNameAndPwd(username, password);
        if (auth.size() > 0) {
            setSessionAttr("authUserID", auth.get(0).getInt("id"));
            setSessionAttr("authUsername", auth.get(0).getStr("username"));
            new LogModel().set("username", getSessionAttr("authUsername")).set("content", getSessionAttr("authUsername") + "用户登陆").set("type", "登陆").set("ip", getRequest().getRemoteAddr()).set("time", df.format(new Date())).save();
            redirect("/");
        } else {
            setAttr("notifyError", "你输入的登陆账号密码有误");
            render("login.html");
        }
    }

    @Before(BeforeLoginInterceptor.class)
    public void profile() {
        setAttr("profile", new AuthModel().dao().findById((int) getSessionAttr("authUserID")));
        render("profile.html");
    }

    @Before(BeforeLoginInterceptor.class)
    public void account() {
        // 传输授权用户分页数据
        int pageNumber;
        if (getParaToInt(0) == null) {
            pageNumber = 1;
        } else {
            pageNumber = getParaToInt(0);
        }
        setAttr("accountPage", AuthModel.dao.paginate(pageNumber, 10, "select *", "from auth"));
        render("list.html");
    }

    @Before(BeforeLoginInterceptor.class)
    public void add() {
    }

    @Before(BeforeLoginInterceptor.class)
    public void save() {
        getModel(AuthModel.class,"auth").save();
        // TODO 增加添加用户日志
        setSessionAttr("notifySuccess", "保存成功");
        redirect("/auth/account");
    }

    @Before(BeforeLoginInterceptor.class)
    public void edit() {
        setAttr("auth", AuthModel.dao.findById(getParaToInt()));
    }

    @Before(BeforeLoginInterceptor.class)
    public void update() {
        getModel(AuthModel.class,"auth").update();
        setSessionAttr("notifySuccess", "修改用户成功");
        //TODO 增加修改用户日志
        redirect("/auth/account");
    }

    @Before(BeforeLoginInterceptor.class)
    public void delete() {
        AuthModel.dao.deleteById(getParaToInt());
        setSessionAttr("notifySuccess", "删除授权用户成功");
        //TODO 增加删除用户日志
        redirect("/auth/account");
    }

}


