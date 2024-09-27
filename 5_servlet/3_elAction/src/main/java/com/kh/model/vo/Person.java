package com.kh.model.vo;

public class Person {
	private String name;
	private int age;
	private String gender;
	
	public Person() {	// 기본생성자
		super();
	}
	
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {	// 필드부에 저장된 값들을 확인하는 용도
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}
