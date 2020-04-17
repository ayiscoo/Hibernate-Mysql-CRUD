package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Courses;
import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;
import com.sharkjava.hibernate.entity.Reviews;
import com.sharkjava.hibernate.entity.Student;

public class Deletehbonetoone {

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
        	int insID = 1;
        	Courses  tempinstructor = 
        			    session.get(Courses.class, insID);
         System.out.println(tempinstructor);
        	// check if nul
        	if ( tempinstructor != null ){
        		 session.delete(tempinstructor);
        	}
         
           
           // assign the objects
               
           session.getTransaction().commit();
           System.out.println("DONE...........");
        
        }finally{
       	 factory.close();
        }
		
	}

}
