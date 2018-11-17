package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author fanyou
 * @description 去除dispatcher-servle.xml配置
 * @date 2018/11/17
 **/
@Configuration
@EnableWebMvc
@ComponentScan("web.feiFei.controller")
public class DispatcherServletXml extends WebMvcConfigurerAdapter {
    /**
     <!-- 对模型视图名称的解析，即在模型视图名称添加前后缀(如果最后一个还是表示文件夹,则最后的斜杠不要漏了) 使用JSP-->
     <!-- 默认的视图解析器 在上边的解析错误时使用 (默认使用html)- -->
     <bean id="defaultViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
     <!--设置JSP文件的目录位置-->
     <property name="prefix" value="/WEB-INF/view/"/>
     <property name="suffix" value=".jsp"/>
     <property name="exposeContextBeansAsAttributes" value="true"/>
     </bean>
     **/
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        super.configureDefaultServletHandling(configurer);
    }

    /**
     <!--静态资源映射-->
     <!--本项目把静态资源放在了webapp的statics目录下，资源映射如下-->
     <mvc:resources mapping="/css/**" location="/WEB-INF/statics/css/"/>
     <mvc:resources mapping="/js/**" location="/WEB-INF/statics/js/"/>
     <mvc:resources mapping="/image/**" location="/WEB-INF/statics/image/"/>
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/statics/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/statics/js/");
        registry.addResourceHandler("/image/**").addResourceLocations("WEB-INF/statics/image/");
        super.addResourceHandlers(registry);
    }
}
