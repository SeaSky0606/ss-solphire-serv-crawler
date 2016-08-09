package org.sun.java;

public class Student implements Comparable<Student> {

	private String name;
	private String school;
	private double weight;
	private double height;
	private double score;

	@Override
	public String toString() {
		return "Student [name=" + name + ", school=" + school + ", weight=" + weight + ", height=" + height + ", score="
				+ score + "]";
	}

	public Student() {
		super();
	}

	public Student(String name, String school, double weight, double height, double score) {
		super();
		this.name = name;
		this.school = school;
		this.weight = weight;
		this.height = height;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public int compareTo(Student o) {
		return this.score > o.score ? 1 : 0;
	}

}
