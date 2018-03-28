package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtility {
	private static SessionFactory sessionFactory;
	static{
		Configuration cfg = new Configuration().configure("/com/util/Hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
				applySettings(cfg.getProperties()).build();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	}
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
