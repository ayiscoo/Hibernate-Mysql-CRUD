package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Courses;
import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;
import com.sharkjava.hibernate.entity.Reviews;
import com.sharkjava.hibernate.entity.Student;

public class ManytoManystudentandcourses {

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
			   int id=4;
			    Instructor instruct = session.get(Instructor.class, id);
			    
			   
			    System.out.println("********done saving course****************");
			    // adding students to a course

			    Courses Courses = new Courses("Social Studies");
			    instruct.add(Courses);
			    System.out.println("saving a course****************");
			    session.save(Courses);
			    System.out.println("********done saving course****************");
			    // adding students to a course
			    
			    Student student1 = new Student("Jonathan","Ohene","joe@yahoo.com");
			    Student student2 = new Student("obenewaa","Bediado","obenewaa@yahoo.com");
			    Student student3 = new Student("ebenezer","acauah","smith@yahoo.com");
			    
			    Courses.addStudents(student1);
			    Courses.addStudents(student2);
			    Courses.addStudents(student3);
			
			    System.out.println("***********saving a students****************");
			    session.save(student1);
			    session.save(student2);
			    session.save(student3);
			    System.out.println("***********done saving a students****************");
			    session.getTransaction().commit();
			
		 }catch(Exception exc){
			  exc.printStackTrace();
		 }finally{
			session.close();
			factory.close();
		 }

	}

}
