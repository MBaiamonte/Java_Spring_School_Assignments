package com.matthewbaiamonte.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	@RequestMapping("/")
	public String welcomePage() {
		return "Welcome Human";
	}
	@RequestMapping("/firstName")
	public String helloFirstName(@RequestParam(value="firstName", required=false) String personsFirstName) {
		return "hello "  + personsFirstName;
	}
	@RequestMapping("/fullName")
	public String helloFullName(@RequestParam(value="firstName", required=false) String personsFirstName, @RequestParam(value="lastName", required=false) String personsLastName) {
		return "hello "  + personsFirstName+" "+ personsLastName;
	}
//	@RequestMapping("/fullNameTimes")
//	public String helloFullNameTimes(@RequestParam(value="firstName", required=false) String personsFirstName, @RequestParam(value="lastName", required=false) String personsLastName,@RequestParam(value="repeat", required=false) Integer repeatNum) {
//		System.out.println(repeatNum);
//		String output="";
//		for(int i=0;i<=repeatNum;i++) {
//			output+= "hello"+ personsFirstName + personsLastName;
//		}
//		return output;
//	}
	
	//^^^coulndt get to work to reapet hello name with 
}


// after looking to see how they built the repeat function it turns out I could have put these all in just one line  this was their code from the learn platform

//public class HomeController {
//	@RequestMapping("/")
//	public String hello(
//			@RequestParam(value="name", required=false) String name, 
//			@RequestParam(value="last_name", required=false) String last_name,
//			@RequestParam(value="times", required=false) Integer times) {
//		if(times != null && times > 0) {
//			String output = "";
//			for(int i = 0; i < times; i++) {
//				if(name != null && last_name != null) {
//					output += "Hello " + name + " " + last_name + " ";
//				}else if(name != null) {
//					output += "Hello " + name + " ";
//				}else if(last_name != null) {
//					output += "Hello " + last_name + " ";
//				}else {
//					output += "Hello Human ";
//				}
//			}
//			return output;
//		}
//		
//		if(name != null && last_name != null) {
//			return "Hello " + name + " " + last_name;
//		}else if(name != null) {
//			return "Hello " + name;
//		}else if(last_name != null) {
//			return "Hello " + last_name;
//		}
//		return "Hello Human";