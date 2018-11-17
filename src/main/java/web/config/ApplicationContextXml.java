package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author fanyou
 * @description 去除applicationContext.xml配置
 * @date 2018/11/17
 **/
@Configuration
@ComponentScan(basePackages={"web"},
        excludeFilters={
            @ComponentScan.Filter(type= FilterType.ANNOTATION,value= EnableWebMvc.class)
        })
public class ApplicationContextXml {
}
