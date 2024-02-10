package com.matthewbaiamonte.daikichiroutes.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@RequestMapping("//daikichi") // class level 
public class DaikichiController {
	@RequestMapping("/daikichi")
	public String pageOne(){
		return "Welcome!";
	}
	@RequestMapping("/daikichi/today")
	public String today() {
		return "today you will find luck in all your endevors";
	}
	@RequestMapping("/daikichi/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an oppertunity will arise, so be sure to be open to new ideas";
	}
	@RequestMapping("/daikichi/travel/{location}")
	public String travel(@PathVariable("location") String location ) {
		return "Congradualations youll soon be travaling to " + location ;
	}
	@RequestMapping("/daikichi/lotto/{someNum}")
	public String lotto(@PathVariable("someNum") Integer someNum ) {
		String output="";
		if (someNum % 2==0) {  
			output="You will take a grand journey in the near future, but be weary of tempting offers";
		}
		else {
			output="You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
		return output;
	}
}//end controller
