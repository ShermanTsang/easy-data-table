package common;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import module.auth.AuthController;
import module.config.ConfigController;
import module.data.ChartController;
import module.data.DashboardController;
import module.data.DataController;
import module.log.LogController;
import module.table.DataTableController;

public class InitConfig extends JFinalConfig {

    public static void main(String[] args) {
        JFinal.start("WebRoot", 8080, "/");
    }

    public void configConstant(Constants me) {
        PropKit.use("config.txt");
        me.setDevMode(PropKit.getBoolean("devMode", false));
    }

    public void configRoute(Routes me) {
        me.add("/auth", AuthController.class, "/VIEW/auth");
        me.add("/dashboard", DashboardController.class, "/VIEW/dashboard");
        me.add("/chart", ChartController.class, "/VIEW/chart");
        me.add("/data", DataController.class, "/VIEW/data");
        me.add("/log", LogController.class, "/VIEW/log");
        me.add("/config", ConfigController.class, "/VIEW/config");
        me.add("/table", DataTableController.class, "/VIEW/table");
    }

    public void configEngine(Engine me) {
        me.addSharedFunction("/VIEW/common/_layout.html");
        me.addSharedFunction("/VIEW/common/_paginate.html");
        me.addSharedMethod(new ShareController());
    }

    public static DruidPlugin createDruidPlugin() {
        return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    public void configPlugin(Plugins me) {
        DruidPlugin druidPlugin = createDruidPlugin();
        me.add(druidPlugin);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        _MappingKit.mapping(arp);
        me.add(arp);
    }

    public void configInterceptor(Interceptors me) {
        me.add(new SessionInViewInterceptor());
    }

    @Override
    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler("path"));
    }
}
