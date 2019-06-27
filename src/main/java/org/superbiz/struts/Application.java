package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new SiteMeshFilter());
        bean.setUrlPatterns(Arrays.asList(
                "/*"
        ));
        Map<String, String> params = new HashMap<>();
        params.put("actionPackages", "com.lq");
        bean.setInitParameters(params);
        return bean;
    }

    @Bean
    public FilterRegistrationBean strutsPrepareAndExecuteFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        StrutsPrepareAndExecuteFilter filter = new StrutsPrepareAndExecuteFilter();
        bean.setFilter(filter);
        bean.setUrlPatterns(Arrays.asList(
                "/",
                "/addUserForm.action",
                "/addUser.action",
                "/findUserForm.action",
                "/findUser.action",
                "/listAllUsers.action"
                ));
        return bean;

    }

}
