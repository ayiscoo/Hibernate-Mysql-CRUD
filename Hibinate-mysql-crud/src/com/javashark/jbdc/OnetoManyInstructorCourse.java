package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Courses;
import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;

public class OnetoManyInstructorCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		
		 SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(Instructor_details.class)
			.addAnnotatedClass(Courses.class)
			.buildSessionFactory();
         // create factory session
		 
		 Session session = factory.getCurrentSession();
		 
		 try{
			 // begin session transaction 
			 session.beginTransaction();
			 // adding data for instructor and instructor details
			 
//			 Instructor instruct  = 
//					  			    new Instructor("kwame", "otoo","kwame@gmail.com");
//			 Instructor_details instructorDetails  = 
//					 						new Instructor_details("facebook.com","football");
//			 instruct.setInstructorDetail(instructorDetails);
//			 
			 // get instructor
			    int insID = 4;
			    
			    Instructor instructor = session.get(Instructor.class, insID);
			
			    System.out.println("print instructor Course"+instructor.getCourse());
			 


			    session.getTransaction().commit();
			
		 }catch(Exception exc){
			  exc.printStackTrace();
		 }finally{
			session.close();
			factory.close();
		 }

	}

	

}
