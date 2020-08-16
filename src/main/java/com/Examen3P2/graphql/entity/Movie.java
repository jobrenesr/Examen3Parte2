package com.Examen3P2.graphql.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


@Entity
@Table(name = "peliculas")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "original_title")
	private String title;
	
	@Column(name = "budget")
	private int budget;
	
	@Column(name = "runtime")
	private double runtime;
	
	@Column(name = "original_language")
	private String language;
	
	@Column(name = "release_date")
	private Date release;
	
	@Transient
	private int day;

	@Transient
	private int month;
	
	@Transient
	private int year;
	
	@PostLoad
	public void postLoad() {
		Calendar cal = Calendar.getInstance();
	      cal.setTime(release);
		this.year = cal.get(Calendar.YEAR);
		this.month = cal.get(Calendar.MONTH);
		this.day = cal.get(Calendar.DATE);
	}

	public int getYear() {
		return year;
	}

	public Movie(String title, int budget, double runtime, String language, Date release) {
		super();
		this.title = title;
		this.budget = budget;
		this.runtime = runtime;
		this.language = language;
		this.release = release;
	}
	
	

	public Movie() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public double getRuntime() {
		return runtime;
	}

	public void setRuntime(double runtime) {
		this.runtime = runtime;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	

}
