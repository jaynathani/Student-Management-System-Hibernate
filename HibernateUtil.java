package com.hibernate.proj.entity;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	 private static final SessionFactory sessionFactory;

	    static {
	        try {
	        	Configuration configuration = new Configuration().configure();
	        	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
	        	builder.applySettings(configuration.getProperties());
	        	sessionFactory = configuration.buildSessionFactory(builder.build());
	        	
	        } catch (Throwable ex) {
	            // Log the exception. 
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
