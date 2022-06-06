package com.caonam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.caonam.hibernate.demo.entity.Student;




public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory, 
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
					
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 3010;
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			Student st = session.get(Student.class, studentId);
//			
//			System.out.println("Delete student on id = " + studentId + "!!!");
//			session.delete(st);
//			
			System.out.println("\nDelete student id = 3011");
			session.createQuery("delete from Student where id = 3011").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("done");
		} finally {
			factory.close();
		}
		
	}

}
