package com.matthewbaiamonte.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // this makes it so we can return jsp files. previously this was set to @RestController which is used to server up raw data like strings/JSON

//@RequestMapping("/hello") // this is class level, you need to have /hello in front of any sub path to reach it. ex) "/hello/world" ( with it) instead of "/world"(without it)
public class HomeController {
	 @RequestMapping("/")// this is method level annotation
     public String index(Model model) { 
		 model.addAttribute("dojoName","Denver"); //use model object to pass data value into our view. is set up as key value i believe
             return "demo.jsp";
	 }
//	 @RequestMapping("/world") //now since there's a class level annotation you'd need to write hello/world instead of jut /world if the class level wasn't there
//	 public String world() {
//		 return"Class annotations are cool too";
//	 }
//	 @RequestMapping("/{firstName}/{lastName}")
//	 public String helloPerson(@PathVariable("firstName")String firstName,@PathVariable("lastName") String lastName) {
//		 return "Hello " + firstName +" "+ lastName;
//	 }
}

//cntr+shift+o will auto generate/add imports once the @xxxxx is fully typed out. bottom left corner will tell you if anything was added or not