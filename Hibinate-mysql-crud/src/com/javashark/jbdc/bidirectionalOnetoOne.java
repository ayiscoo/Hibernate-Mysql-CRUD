package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;

public class bidirectionalOnetoOne {
  

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
         //get object of instructor details
           int insDetailsID=2;
         session.beginTransaction();
         Instructor_details tempInstructor =
        		   session.get(Instructor_details.class, insDetailsID);
         
           System.out.println("found object "+ tempInstructor);
           
           System.out.println("instructor details"+ tempInstructor.getInstructor());
           
           session.getTransaction().commit();
           
          factory.close();
         
	}
}
