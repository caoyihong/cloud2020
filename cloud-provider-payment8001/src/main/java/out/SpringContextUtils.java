package out;

import org.springframework.context.ApplicationContext;

public class SpringContextUtils {
    private static ApplicationContext context;

    public static void setApplicationContext(ApplicationContext context) {
        SpringContextUtils.context = context;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }
}
