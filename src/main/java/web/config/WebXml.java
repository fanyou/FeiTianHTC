package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author fanyou
 * @description 去除web.xml配置
 * @date 2018/11/17
 **/
public class WebXml extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
    <!--把applicationContext.xml加入到配置文件中-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/applicationContext.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    **/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
            ApplicationContextXml.class
        };
    }

    /**
    <!--配置springmvc DispatcherServlet-->
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <!--配置dispatcher-servlet.xml作为mvc的配置文件-->
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/dispatcher-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
        <async-supported>true</async-supported>
    </servlet>
    **/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {
            DispatcherServletXml.class
        };
    }

    /**
    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    **/
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
