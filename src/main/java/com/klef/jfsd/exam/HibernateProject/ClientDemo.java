package com.klef.jfsd.exam.HibernateProject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class ClientDemo {

    public static void main(String[] args) {
        // Load configuration and build SessionFactory
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Insert operation
        insertDepartment(sessionFactory, "Computer Science", "Block A", "Dr. Smith");
        insertDepartment(sessionFactory, "Electrical Engineering", "Block B", "Dr. John");

		/*
		 * // Delete operation deleteDepartmentById(sessionFactory, 1);
		 */

        sessionFactory.close();
    }

    public static void insertDepartment(SessionFactory sessionFactory, String name, String location, String hodName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Creating a new Department object
        Department dept = new Department();
        dept.setName(name);
        dept.setLocation(location);
        dept.setHodName(hodName);

        // Persisting the object
        session.save(dept);

        transaction.commit();
        session.close();
        System.out.println("Department inserted successfully.");
    }

    
}