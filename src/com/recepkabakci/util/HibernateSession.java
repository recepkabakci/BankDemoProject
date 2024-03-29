package com.recepkabakci.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.recepkabakci.entity.Account;
import com.recepkabakci.entity.AccountType;
import com.recepkabakci.entity.Branch;
import com.recepkabakci.entity.Customer;
import com.recepkabakci.entity.ProcessDetail;

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

