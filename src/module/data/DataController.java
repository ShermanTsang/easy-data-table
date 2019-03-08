package module.data;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import module.interceptor.BeforeLoginInterceptor;
import module.log.LogModel;

import java.text.SimpleDateFormat;
import java.util.Date;

@Before(BeforeLoginInterceptor.class)
public class DataController extends Controller {

    static DataService dataService = new DataService();

    public void index() {

        // 关键字处理
        String keyword;
        if (getPara("keyword") != null) {
            keyword = getPara("keyword");
            setSessionAttr("keyword", keyword);
        } else if (getSessionAttr("keyword") != null) {
            keyword = getSessionAttr("keyword");
        } else {
            keyword = "";
        }

        // 获取筛选项数量和内容
        String option;
        String[] optionList;
        if (getParaValues("option") != null) {
            optionList = getParaValues("option");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < optionList.length; i++) {
                sb.append(optionList[i].trim() + ",");
            }
            String optionStr = sb.toString();
            option = optionStr.substring(0, optionStr.length() - 1);
            setSessionAttr("option", option);
        } else if (getSessionAttr("option") != null) {
            option = getSessionAttr("option");
        } else {
            option = "";
        }
        setAttr("dataPage", dataService.paginate(getParaToInt(0, 1), 20, option, keyword));

        // 数据后台记录
        if (!keyword.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            new LogModel().set("username", getSessionAttr("authUsername")).set("content", keyword).set("type", "搜索").set("ip", getRequest().getRemoteAddr()).set("time", df.format(new Date())).save();
        }

        // 渲染页面
        render("list.html");
    }

    public void add() {
    }

    @Before(DataValidator.class)
    public void save() {
        getModel(DataModel.class,"data").save();
        setSessionAttr("notifySuccess", "保存成功");
        redirect("/data");
    }

    public void edit() {
        setAttr("data", dataService.findById(getParaToInt()));
    }

    @Before(DataValidator.class)
    public void update() {
        getModel(DataModel.class,"data").update();
        setSessionAttr("notifySuccess", "修改成功");
        redirect("/data");
    }

    public void delete() {
        dataService.deleteById(getParaToInt());
        setSessionAttr("notifySuccess", "删除成功");
        redirect("/data");
    }
}


