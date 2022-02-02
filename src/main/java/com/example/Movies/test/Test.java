package com.example.Movies.test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Test {
	
	
	@GetMapping( value = "/list")
	public String test() {
		return "test";
		
	}
	}



