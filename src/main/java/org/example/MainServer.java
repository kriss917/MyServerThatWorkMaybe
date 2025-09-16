package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class MainServer {
    Tomcat tomcat;

    public MainServer() {
        tomcat = new Tomcat();
        //lager en instans av tomcat
        tomcat.setPort(8080);
        //setter porten der tomcat ser etter httpReq
        tomcat.getConnector();


        Context rootContext = tomcat.addContext("", null);


        Tomcat.addServlet(rootContext, "AnagramServlet", new AnagramServlet());
        rootContext.addServletMappingDecoded("/anagram", "AnagramServlet");


        Tomcat.addServlet(rootContext, "IdkServlet", new IdkServlet());
        rootContext.addServletMappingDecoded("/idk", "IdkServlet");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
        tomcat.getServer().await();
    }
    }
