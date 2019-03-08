package common;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import module.config.ConfigModel;

import java.util.List;

public class ShareController extends Controller {

    public String getConfig(String name) {
        List<ConfigModel> config = ConfigModel.dao.find("select * from config where name=?", name);
        if (config.size() > 0) {
            return config.get(0).getStr("value");
        } else {
            return null;
        }
    }

    public List showColumn(String name) {
        List result = Db.find("SHOW columns FROM " + name);
        return result;
    }

    public List getColumnByCategory(String category){
        List result = Db.find("SELECT * FROM dataTable RIGHT JOIN (SELECT COLUMN_NAME FROM information_schema.columns WHERE table_name = 'data') t ON dataTable.name = t.COLUMN_NAME WHERE dataTable.isVisible = 1 AND dataTable.category = ?",category);
        return result;
    }

    public List getColumnCategory(){
        List result = Db.find("SELECT DISTINCT category FROM dataTable");
        return result;
    }


}


