package com.javashark.jbdc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharkjava.hibernate.entity.Courses;
import com.sharkjava.hibernate.entity.Instructor;
import com.sharkjava.hibernate.entity.Instructor_details;
import com.sharkjava.hibernate.entity.Reviews;
import com.sharkjava.hibernate.entity.Student;

public class AssignCoursestostudent {

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
					   int studid=18;
					    Student stud = session.get(Student.class, studid);
					    System.out.println("printing student*********");
					    System.out.println("stud info"+ stud);
					    System.out.println("stud info"+ stud.getListCourses());
					    //assign courses to student
//					    Courses course1 = new Courses("Agricultural Science");
//					    Courses course2 = new Courses("Life Skill");
//					    Courses course3 = new Courses("Vocatioal Skills");
//					    
//					    stud.addCourse(course1);
//					    stud.addCourse(course2);
//					    stud.addCourse(course3);
//					  
//					    session.save(course1);
//					    session.save(course2);
//					    session.save(course3);
					    
					    session.getTransaction().commit();
				 }catch(Exception exc){
					  exc.printStackTrace();
				 }finally{
					session.close();
					factory.close();
				 }


	}

}
