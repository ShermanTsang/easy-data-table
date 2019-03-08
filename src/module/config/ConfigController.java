package module.config;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import module.interceptor.BeforeLoginInterceptor;

@Before(BeforeLoginInterceptor.class)
public class ConfigController extends Controller {

    public void index() {
        setAttr("configPage", ConfigModel.dao.paginate(1, 10, "select *", "from config"));
        // 渲染页面
        render("list.html");
    }

    public void add() {
    }

    public void save() {
        getModel(ConfigModel.class, "config").save();
        // TODO 新增日志设置
        setSessionAttr("notifySuccess", "保存成功");
        redirect("/config/account");
    }

    public void edit() {
        setAttr("config", ConfigModel.dao.findById(getParaToInt()));
    }

    public void update() {
        getModel(ConfigModel.class, "config").update();
        setSessionAttr("notifySuccess", "修改配置成功");
        //TODO 增加修改配置日志
        redirect("/config/account");
    }

    public void delete() {
        ConfigModel.dao.deleteById(getParaToInt());
        setSessionAttr("notifySuccess", "删除配置成功");
        redirect("/config");
    }

    
}


