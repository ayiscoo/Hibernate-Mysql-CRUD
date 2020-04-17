package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Courses;
import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;
import com.sharkjava.hibernate.entity.Reviews;
import com.sharkjava.hibernate.entity.Student;

public class AddReviews {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(Instructor_details.class)
			.addAnnotatedClass(Courses.class)
			.addAnnotatedClass(Reviews.class)
			.addAnnotatedClass(Student.class)
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
			    int insID = 2;
			    
			    Courses Courses = session.get(Courses.class, insID);
			    
			    System.out.println("print instructor"+Courses);
			 
			   // use that to add courses
			  
			    Reviews tempCourse1 = new Reviews("Good");
			    
			    Reviews tempCourse2 = new Reviews("Excellent");
			 
			    Reviews tempCourse3 = new Reviews("Fairly Good");
			    
			    Courses.add_Reviews(tempCourse1);
			    
			    Courses.add_Reviews(tempCourse2);
			    
			    Courses.add_Reviews(tempCourse3);
			    
			    session.save(tempCourse1);
			    session.save(tempCourse2);
			    session.save(tempCourse3);
			    session.getTransaction().commit();
			
		 }catch(Exception exc){
			  exc.printStackTrace();
		 }finally{
			session.close();
			factory.close();
		 }

	}
	

}
