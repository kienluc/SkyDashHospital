package com.dht.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                TilesConfig.class,
                HibernateConfig.class,
                SpringSecurityConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
            MyWebConfigs.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
}
