package module.data;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import module.interceptor.BeforeLoginInterceptor;
import module.log.LogModel;

@Before(BeforeLoginInterceptor.class)
public class DashboardController extends Controller {

    public void index() {
        setAttr("chartSourceTop10",DataModel.dao.find("SELECT DISTINCT LaiYuan,count(LaiYuan) count FROM data where LaiYuan IS NOT NULL GROUP BY LaiYuan ORDER BY count DESC LIMIT 10"));
        setAttr("chartSourceAll",DataModel.dao.find("SELECT DISTINCT LaiYuan,count(LaiYuan) count FROM data where LaiYuan IS NOT NULL GROUP BY LaiYuan ORDER BY count DESC"));
        setAttr("chartKeywordTop20",LogModel.dao.find("SELECT DISTINCT content,count(content) count FROM log WHERE type='搜索' GROUP BY content ORDER BY count DESC Limit 20"));
        setAttr("chartDateClick",LogModel.dao.find("SELECT DISTINCT date_format(time,'%Y%m%d') day,count(time) count FROM log GROUP BY day"));
        setAttr("staticTotal",DataModel.dao.find("SELECT count(*) count FROM data"));
        setAttr("staticPeople",DataModel.dao.find("SELECT count(DISTINCT XingMing) count FROM data"));
        setAttr("staticSource",DataModel.dao.find("SELECT count(DISTINCT LaiYuan) count FROM data"));
        setAttr("staticXueHao",DataModel.dao.find("SELECT count(DISTINCT XueHao) count FROM data"));
        setAttr("notifySuccess","欢迎来访数据平台");
        render("index.html");
    }

}


