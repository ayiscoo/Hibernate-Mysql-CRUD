package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;
import com.sharkjava.hibernate.entity.Student;

public class savehibernatedata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create a session Factory
		
         SessionFactory factory = new Configuration()
         						.configure("hibernate.cfg.xml")
         						.addAnnotatedClass(Instructor.class)
         						.addAnnotatedClass(Instructor_details.class)
         						.buildSessionFactory();
        //create session
         Session session = factory.getCurrentSession();
         try{
        	 //create new object
            System.out.println("creating new instructor...........");
            Instructor Instructor = new Instructor("dunga", "ohene", "ayiscoo@yahoo.com");
            Instructor_details instructordetails = 
            		           new Instructor_details("https://youtube.com/12344", "football");
            //begin session
            session.beginTransaction();
            
            // assign the objects
            
            Instructor.setInstructorDetail(instructordetails);
            
            //saving into db
            System.out.println("saving new student...........");
            session.save(Instructor);
            
            //comit transaction
            
            session.getTransaction().commit();
            System.out.println("DONE...........");
         
         }finally{
        	 factory.close();
         }
	}	

}
