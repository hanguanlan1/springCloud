package com.wisedu.cloud.entity;

import java.math.BigDecimal;

public class User {

	private Long id;

	private String username;

	private String name;

	private Short age;

	private BigDecimal balance;

	public Short getAge() {
		return age;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
