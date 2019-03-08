package module.data;

import com.jfinal.plugin.activerecord.Page;

public class DataService {

    private static final DataModel dao = new DataModel().dao();

    public Page<DataModel> paginate(int pageNumber, int pageSize, String option, String keyword) {
        if (option != "") {
            return dao.paginate(pageNumber, pageSize, "select *", "from data where concat_ws(" + option + ") like ? order by id desc", "%" + keyword + "%");
        } else {
            return null;
        }
    }

    public DataModel findById(int id) {
        return dao.findById(id);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
