package com.example.demo;

import org.springframework.data.annotation.Id;

public class Emp {

	@Id
    private long id;
    private String name;
    
    public void setId(long id) {
		this.id = id;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public long getId() {
		return id;
	}
    
    public String getName() {
		return name;
	}
    
}
