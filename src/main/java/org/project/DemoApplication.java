package org.project;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.project.config.MappingJacksonHttpMessageConverterEx;
import org.project.config.filter.RequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("org.project.dao")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


    /**
     * mybatis page handler
     * @return
     */
	@Bean
    public PageHelper pageHelper(){
	    PageHelper pageHelper = new PageHelper();
	    Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
	    properties.setProperty("reasonable", "true");
	    properties.setProperty("dialect", "mysql");
	    pageHelper.setProperties(properties);
	    return pageHelper;
    }

    /**
     * 跨域设置 filter
     * @return
     */
    @Bean
    public FilterRegistrationBean fliterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("requestFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 数据转化
     * @return
     */
    @Bean
    public MappingJacksonHttpMessageConverterEx mappingJackson2HttpMessageConverter(){
        return new MappingJacksonHttpMessageConverterEx();
    }


}
