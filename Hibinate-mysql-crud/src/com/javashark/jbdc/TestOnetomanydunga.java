package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Courses;
import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;
import com.sharkjava.hibernate.entity.Student;

public class TestOnetomanydunga {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)			
			.addAnnotatedClass(Courses.class)
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(Instructor_details.class)
			.buildSessionFactory();
       // create factory session
		 
		 Session session = factory.getCurrentSession();
		 
		 try{
			 // begin session transaction 
			 session.beginTransaction();
			 // adding data for instructor and instructor details
			 
		// Student stud  = 
					  			//    new Student("kwame", "otoo","kwame@gmail.com");
	//	 Instructor_details instructorDetails  = 
				 			//			new Instructor_details("facebook.com","football");
//			 instruct.setInstructorDetail(instructorDetails);
//			 
			 // get course
			  int insID =1 ;
			    
			   Courses course = session.get(Courses.class, insID);
			    
			    System.out.println("print instructor"+course);
			 
			    Student stud1 = new Student("mary", "ohene","mary@gmail.com");
			    Student stud2 = new Student("irene", "agato","irene@gmail.com");
			    Student stud3 = new Student("mavis", "mavis","mavis@gmail.com");
			    Student stud4 = new Student("ohenewaa", "princess","ohenewaa@gmail.com");
			    Student stud5 = new Student("salomey", "danso","danso@gmail.com");
			   // use that to add courses
			  
//			   course.add_students(stud1);
//			   course.add_students(stud2);
//			   course.add_students(stud3);
//			   course.add_students(stud4);
//			   course.add_students(stud5);
			    
			   session.save(stud1);
			   session.save(stud2);
			   session.save(stud3);
			   session.save(stud4);
			   session.save(stud5);
			   
			    session.getTransaction().commit();
			
		 }catch(Exception exc){
			  exc.printStackTrace();
		 }finally{
			session.close();
			factory.close();
		 }

	}

}
