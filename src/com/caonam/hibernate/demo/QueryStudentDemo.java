package com.caonam.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.caonam.hibernate.demo.entity.Student;




public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory, 
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
					
		//create session
		Session session = factory.getCurrentSession();
		
		try {
				
			//start transaction
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.firstName ='Nam'").getResultList();
			System.out.println("Students whose first name is Nam");
			displayStudents(theStudents);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		} finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student a: theStudents ) {
			System.out.println(a);
		}
	}

}
