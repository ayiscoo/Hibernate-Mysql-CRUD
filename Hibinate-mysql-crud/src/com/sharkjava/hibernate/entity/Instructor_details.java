package com.sharkjava.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_details")
public class Instructor_details {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer Id;
	
	@Column(name="youtube_channel")
	private String Youtube_Channel;
	
	@Column(name="hobby")
	private String Hobby;
	
	// the object of instructor( instructor instructorDetail) in the instructor class
	@OneToOne(mappedBy="instructorDetail", cascade=CascadeType.ALL)
	private Instructor instructor;
	
	public Instructor_details() {
		
	}

	public Instructor_details(String youtube_Channel, String hobby) {
		
		Youtube_Channel = youtube_Channel;
		Hobby = hobby;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getYoutube_Channel() {
		return Youtube_Channel;
	}

	public void setYoutube_Channel(String youtube_Channel) {
		Youtube_Channel = youtube_Channel;
	}

	public String getHobby() {
		return Hobby;
	}

	public void setHobby(String hobby) {
		Hobby = hobby;
	}

	@Override
	public String toString() {
		return "Instructor_details [Id=" + Id + ", Youtube_Channel="
				+ Youtube_Channel + ", Hobby=" + Hobby + "]";
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
 
	
}
