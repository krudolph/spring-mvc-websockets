package de.kimrudolph.tutorials.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext context) throws ServletException {

        final AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();

        root.scan("de.kimrudolph.tutorials");

        context.addListener(new ContextLoaderListener(root));

        final ServletRegistration.Dynamic appServlet = context.addServlet(
            "appServlet",
            new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setAsyncSupported(true);
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/*");
    }

}