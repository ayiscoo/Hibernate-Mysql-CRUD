package com.sharkjava.hibernate.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Courses {
	// this is bidirectional tutorial Many to one class
    // declare parameters
	// load getters and setters
	//load constructors
	// add annotations 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructorCourse;
	
	
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="course_student",
	            joinColumns=@JoinColumn(name="course_id"),
	            inverseJoinColumns=@JoinColumn(name="student_id")			)
	private List<Student> ListStudents;
    
	@OneToMany(fetch=FetchType.LAZY, mappedBy="course_object_review",
			  cascade=CascadeType.ALL)
	   private List<Reviews> listReviews;
	
	
    public Courses() {
		
	}

	public Courses(String title) {
		
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public Instructor getInstructorCourse() {
		return instructorCourse;
	}

	public void setInstructorCourse(Instructor instructorCourse) {
		this.instructorCourse = instructorCourse;
	}

	@Override
	public String toString() {
		return "Courses [title=" + title + "]";
	}
	

	public List<Reviews> getListReviews() {
		return listReviews;
	}

	public void setListReviews(List<Reviews> listReviews) {
		this.listReviews = listReviews;
	}
	
	
	public void add_Reviews(Reviews review){
		if (review == null){
			listReviews = new ArrayList<Reviews>();
			listReviews.add(review);
		}
		review.setCourse_object_review(this);
	}

	public List<Student> getListStudents() {
		return ListStudents;
	}

	public void setListStudents(List<Student> listStudents) {
		ListStudents = listStudents;
	}
	
	public void addStudents(Student student){
		if (ListStudents == null){
			ListStudents = new ArrayList<Student>();
				}
	    	 ListStudents.add(student);		  
	}
	

	
	
}
