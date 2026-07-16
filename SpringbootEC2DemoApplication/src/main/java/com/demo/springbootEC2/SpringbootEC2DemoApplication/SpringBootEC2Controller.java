package com.demo.springbootEC2.SpringbootEC2DemoApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootEC2Controller {
	
	@GetMapping("/getEc2Response")
	public String getSampleEC2Response () {
		
		
		return "hi This controller for EC2 and AWS integration";	
	}

}
