/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.configs;

import com.dht.formatter.AppointmentFormatter;
import com.dht.formatter.DepartmentFormatter;
import com.dht.formatter.DoctorFormatter;
import com.dht.formatter.RoleFormatter;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.dht.controllers", "com.dht.repository", "com.dht.service"})
public class MyWebConfigs implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/resources/fonts/");
        registry.addResourceHandler("/scss/**").addResourceLocations("/resources/scss/");
        registry.addResourceHandler("/vendors/**").addResourceLocations("/resources/vendors/");

//        Cac trang client
//        registry.addResourceHandler("/client/css/**").addResourceLocations("resources/client/css/");
//        registry.addResourceHandler("/client/fonts/**").addResourceLocations("resources/client/fonts/");
//        registry.addResourceHandler("/client/images/**").addResourceLocations("resources/client/images/");
//        registry.addResourceHandler("/client/js/**").addResourceLocations("resources/client/js/");
    }
    
//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/WEB-INF/jsp/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
        resource.addBasenames("messages", "products");
        
        return resource;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
    @Override
    public Validator getValidator(){
        return validator();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DepartmentFormatter());
        registry.addFormatter(new RoleFormatter());
        registry.addFormatter(new DoctorFormatter());
        registry.addFormatter(new AppointmentFormatter());
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(20971520);
        resolver.setMaxInMemorySize(1048576);
        return resolver;
    }

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("1851050120phuoc@ou.edu.vn");
        mailSender.setPassword("0961032543sq");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }
}
