package com.caonam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.caonam.hibernate.demo.entity.Student;



public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory, 
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
					
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create new object
			System.out.println("Create new student!!!");
			Student student1 = new Student("eeee", "Cao", "caonam952@gmail.com");
		
			//start transaction
			session.beginTransaction();
			
			//save object
			System.out.println("Saving the student");
			System.out.println(session.save(student1));
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		} finally {
			factory.close();
		}
		
	}

}
