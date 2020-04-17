package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Courses;
import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;
import com.sharkjava.hibernate.entity.Reviews;
import com.sharkjava.hibernate.entity.Student;

public class deleteReviews {

	public static void main(String[] args) {
		
				// TODO Auto-generated method stub

		        SessionFactory factory = new Configuration()
		        						.configure("hibernate.cfg.xml")
		        							.addAnnotatedClass(Instructor.class)
		        							.addAnnotatedClass(Instructor_details.class)
		        							.addAnnotatedClass(Courses.class)
		        							.addAnnotatedClass(Student.class)
		        							.addAnnotatedClass(Reviews.class)
		        							.buildSessionFactory();
		       //create session
		        Session session = factory.getCurrentSession();
		        try{
		       	 //get object 
		        	  session.beginTransaction();
		        	int insID = 4;
		        	Reviews  reviews = 
		        			    session.get(Reviews.class, insID);
		         System.out.println(reviews);
		        	// check if nul
		        	if ( reviews != null ){
		        		 session.delete(reviews);
		        	}		         
		           
		           // assign the objects
		               
		           session.getTransaction().commit();
		           System.out.println("DONE...........");
		        
		        }finally{
		       	 factory.close();
		        }
				
			}

	

	

}
