package module.data;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import module.interceptor.BeforeLoginInterceptor;
import module.table.DataTableModel;

@Before(BeforeLoginInterceptor.class)
public class ChartController extends Controller {

    public void index() {
        setAttr("chartAbleColumn", DataTableModel.dao.find("SELECT * FROM dataTable where isChartAble=1"));
        render("index.html");
    }

    public void item() {
        String column = getPara(0);
        if (column == null) {
            redirect("/chart");
        } else {
            setAttr("column",DataTableModel.dao.find("SELECT * FROM dataTable WHERE name='"+column+"'"));
            setAttr("staticTotal", DataModel.dao.find("SELECT count("+column+") count FROM data WHERE "+column+" IS NOT NULL AND "+column+" <> ''"));
            setAttr("staticDistinct", DataModel.dao.find("SELECT count(DISTINCT "+column+") count FROM data"));
            setAttr("dataTop30", DataModel.dao.find("SELECT DISTINCT "+column+" name,count("+column+") count FROM data where "+column+" IS NOT NULL AND "+column+" <> '' GROUP BY "+column+" ORDER BY count DESC LIMIT 30"));
            setAttr("dataDistinct", DataModel.dao.find("SELECT DISTINCT "+column+" name,count("+column+") count FROM data where "+column+" IS NOT NULL AND "+column+" <> '' GROUP BY "+column+" ORDER BY count DESC LIMIT 100"));
            setAttr("dataSource", DataModel.dao.find("SELECT DISTINCT LaiYuan name,count(\"+column+\") count FROM data where \"+column+\" IS NOT NULL AND "+column+" <> '' GROUP BY LaiYuan ORDER BY count DESC"));
            render("item.html");
        }
    }

}


