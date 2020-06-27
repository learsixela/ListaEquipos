package com.web.bean;

import java.util.ArrayList;

public class Player {

	//atributos
	String first_name, last_name;
	Integer age;
	Integer idTeam=0;
	ArrayList<Player> arrayListPlayer = new ArrayList<Player>();
	
	public Player() {
		super();
	}
	public Player(String first_name, String last_name, Integer age) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Player [first_name=" + first_name + ", last_name=" + last_name + ", age=" + age + "]";
	}
	
	
}
