package module.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class BeforeLoginInterceptor implements Interceptor {

    public void intercept(Invocation inv) {
        Controller c = inv.getController();
        String auth = c.getSessionAttr("authUsername");
        if (auth == null) {
            c.redirect("/login");
            return;
        } else {
            inv.invoke();
        }
    }
}
