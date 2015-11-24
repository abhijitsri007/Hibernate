package com.abhi.singleton.singleton;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
		 
	    private static SessionFactory factory;
	//to disallow creating objects by other classes.
	
	    private HibernateUtility() {
	    }
	//maling the Hibernate SessionFactory object as singleton
	 
	    public synchronized static SessionFactory getSessionFactory() {
	 
	        if (factory == null) {
	            factory = new Configuration().configure().addResource("employeeDTO.hbm.xml").buildSessionFactory();
	            System.out.println("Object is created for the 1st time");
	            
	        }else {
	        	System.out.println("Object is already created");
			}
	        
	        return factory;
	    }
}
