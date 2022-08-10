package com.bilgeadam.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.Account;
import com.bilgeadam.entity.AccountType;
import com.bilgeadam.entity.Branch;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.entity.ProcessDetail;

public class HibernateSession {

		private static final SessionFactory sessionFactory= sessionFactory();
		
		private static SessionFactory sessionFactory() {
			
			SessionFactory factory = null;
			
			try {
				Configuration configuration = new Configuration();		
				
				configuration.addAnnotatedClass(Account.class);
				configuration.addAnnotatedClass(AccountType.class);
				configuration.addAnnotatedClass(Branch.class);
				configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(Process.class);
				configuration.addAnnotatedClass(ProcessDetail.class);

				factory =configuration.configure("hibernate.cfg.xml").buildSessionFactory();
				System.out.println("Connection to PostgreSQL via Hibernate established.");
				
			
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			return factory;
			
		}
		
		public static SessionFactory getSessionFactory() {
			
			try {
				return sessionFactory;
			} catch (Exception ex) {
			}
			return sessionFactory;
			
		}
		
	}

