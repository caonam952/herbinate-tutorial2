package com.caonam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.caonam.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		//create session
		Session session = factory.getCurrentSession();

		try {
			//create new object
			System.out.println("Create new student!!!");
			Student student1 = new Student("Nam", "Cao", "caonam952@gmail.com");
			Student student2 = new Student("hu", "Cwwao", "caossdnam952@gmail.com");
			Student student3 = new Student("Nadam", "Cssao", "cassonam952@gmail.com");
			//start transaction
			session.beginTransaction();

			//save object
			System.out.println("Saving the student");
			session.save(student1);
			System.out.println(student1.getId());
			session.save(student2);
			System.out.println(student2.getId());
			session.save(student3);
			System.out.println(student3.getId());
			//commit transaction
			session.getTransaction();
			System.out.println("done");
		} finally {
			factory.close();
		}

	}

}
