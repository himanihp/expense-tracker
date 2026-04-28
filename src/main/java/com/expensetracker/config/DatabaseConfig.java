package com.expensetracker.config;

import com.expensetracker.entity.ExpenseTrackerEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DatabaseConfig {

    // DBConfig is actually a Singelton patterned Java Class
    // which is used to build and provide
    // a single SessionFactory instance

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private DatabaseConfig() {

    }
    private static SessionFactory buildSessionFactory() {
        Configuration config = new Configuration()
                .addAnnotatedClass(ExpenseTrackerEntity.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
        return config.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

}
