package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Courses;
import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;

public class deleteInstructorCourseOnetoMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(Instructor_details.class)
			.addAnnotatedClass(Courses.class)
			.buildSessionFactory();
      // create factory session
		 
		 Session session = factory.getCurrentSession();
		   int insID =3;
		    
		   session.beginTransaction();
		   
		    Courses instructorCourse = session.get(Courses.class, insID);
		
		   // System.out.println("print instructor Course"+instructor.getCourse());
		 
           System.out.println("found Course"+instructorCourse);
           
           session.delete(instructorCourse);
	
	       session.getTransaction().commit();
	}

}
