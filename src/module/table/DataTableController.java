package module.table;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import module.interceptor.BeforeLoginInterceptor;

@Before(BeforeLoginInterceptor.class)
public class DataTableController extends Controller {

    public void index() {
        int pageNumber;
        if (getParaToInt(0) == null) {
            pageNumber = 1;
        }else{
            pageNumber = getParaToInt(0);
        }
        setAttr("dataTablePage", DataTableModel.dao.paginate(pageNumber, 20, "select *", "from dataTable"));
        // 渲染页面
        render("list.html");
    }

    public void add() {
    }

    public void save() {
        getModel(DataTableModel.class, "dataTable").save();
        // TODO 新增表格数据设置
        setSessionAttr("notifySuccess", "保存成功");
        redirect("/table");
    }

    public void edit() {
        setAttr("dataTable", DataTableModel.dao.findById(getParaToInt()));
    }

    public void update() {
        getModel(DataTableModel.class, "dataTable").update();
        setSessionAttr("notifySuccess", "修改数据列成功");
        //TODO 增加修改数据列表格数据
        redirect("/table");
    }

    public void delete() {
        DataTableModel.dao.deleteById(getParaToInt());
        setSessionAttr("notifySuccess", "删除数据列成功");
        redirect("/table");
    }

    
}


