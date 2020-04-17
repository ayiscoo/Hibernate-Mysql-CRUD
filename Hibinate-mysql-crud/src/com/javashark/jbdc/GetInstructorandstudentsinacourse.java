package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Courses;
import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;
import com.sharkjava.hibernate.entity.Student;

public class GetInstructorandstudentsinacourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(Instructor_details.class)
			.addAnnotatedClass(Courses.class)
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
          
		 Session session = factory.getCurrentSession();
		 
		 try
		 {
			 session.beginTransaction();
			 int courseID = 1;
			 
			 Courses courseInstructor = session.get(Courses.class, courseID);
			
			 System.out.println("**********instructor Course*********");
			 System.out.println("course Instructor"+ courseInstructor.getInstructorCourse());
			 System.out.println("**********students of a course ***************");
			 //System.out.println("Students of Course"+ courseInstructor.getStudentList());

		 }catch(Exception exe){
			 exe.printStackTrace();
		 }finally{
		    session.close();
		    factory.close();
		 }
	}

}
