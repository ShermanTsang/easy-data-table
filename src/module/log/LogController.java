package module.log;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import module.interceptor.BeforeLoginInterceptor;

@Before(BeforeLoginInterceptor.class)
public class LogController extends Controller {

    public void index() {
        // 传输日志分页数据
        int pageNumber;
        if (getParaToInt(0) == null) {
            pageNumber = 1;
        }else{
            pageNumber = getParaToInt(0);
        }
        setAttr("logPage", LogModel.dao.paginate(pageNumber, 10, "select *", "from log order by id desc"));
        // 渲染页面
        render("index.html");
    }

    public void add() {
    }

    public void delete() {
        LogModel.dao.deleteById(getParaToInt());
        setSessionAttr("notifySuccess", "删除日志成功");
        redirect("/log");
    }
}


