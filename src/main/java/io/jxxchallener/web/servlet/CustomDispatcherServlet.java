package io.jxxchallener.web.servlet;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ConfigurableWebEnvironment;
import org.springframework.web.servlet.DispatcherServlet;

public class CustomDispatcherServlet extends DispatcherServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 5013843383774020586L;

    public CustomDispatcherServlet() {
        super();
        this.addRequiredProperty("requiredProperty"); //指定servlet 必须设置的参数
    }

    @Override
    protected void postProcessWebApplicationContext(ConfigurableWebApplicationContext wac) {
        ConfigurableEnvironment env = wac.getEnvironment();
        if (env instanceof ConfigurableWebEnvironment) {
            ((ConfigurableWebEnvironment) env).setRequiredProperties("requiredProperties");// 指定application context级必须设置的参数
        }
    }
    
    

}
