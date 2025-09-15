package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class MainServer {
    Tomcat tomcat;

    public MainServer() {
        tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context rootContext = tomcat.addContext("", null);

        Tomcat.addServlet(rootContext, "AnagramServlet", new AnagramServlet());
        rootContext.addServletMappingDecoded("/anagram", "AnagramServlet");


        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
        tomcat.getServer().await();
    }
    }
