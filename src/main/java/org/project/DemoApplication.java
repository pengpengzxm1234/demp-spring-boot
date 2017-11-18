package org.project;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.project.config.MappingJacksonHttpMessageConverterEx;
import org.project.filter.RequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@SpringBootApplication
@MapperScan("org.project.dao")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

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

    @Bean
    public MappingJacksonHttpMessageConverterEx mappingJackson2HttpMessageConverter(){
        return new MappingJacksonHttpMessageConverterEx();
    }

	@RequestMapping(value = "/")
	Response index(){
		Response response = new Response();
		response.setCode("100000");
		response.setRlt("true");
		response.setMsg("ok");
		return response;
	}

	@RequestMapping(value = "/type", method = RequestMethod.GET)
	Response type(){
		Response response = new Response();
		response.setCode("100000");
		response.setRlt("true");
		response.setMsg("ok");
		response.setData("is a new data");
		return response;
	}
}
