package com.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo/")
public class TestController {
	
	//http://localhost:8080/demo/version1
	@RequestMapping(value = "version1", method = RequestMethod.GET)
	public String getVersion1() {
		return "Welcome to Rest API session";
	}

	//http://localhost:8080/demo/version11/1
	@RequestMapping(value = "version11/{var}", method = RequestMethod.GET)
	public String getVersion11(@PathVariable("var") final String var) {
		return "Hello, " + var + " . You have owe $500 to me";
	}
	
	//http://localhost:8080/demo/version11/1/2
	@RequestMapping(value = "version11/{var1}/{var2}", method = RequestMethod.GET)
	public String getVersion12(@PathVariable("var1") final String var1,@PathVariable("var2") final String var2) {
		return "Hello, " + var1 + ". "+  var2;
	}
	
	//http://localhost:8080/demo/version2?param1=Remo
	@RequestMapping(value = "version2", method = RequestMethod.GET)
	public String getVersion2(@RequestParam("param1") String param1) {
		return "Hello, " + param1 + ". You won $1000 bonus. Now wake up from your dream !!";
	}
	
	//http://localhost:8080/demo/version3?param1=Remo&param2=Hello
	@RequestMapping(value = "version3", method = RequestMethod.GET)
	public String getVersion21(@RequestParam("param1") String param1,@RequestParam("param2") String param2) {
		return "Hello, " + param1 + ". "+  param2;
	}
	
	//http://localhost:8080/demo/version4
	@RequestMapping(value = "version4", method = RequestMethod.GET)
	public ResultEntity<String> getVersion2() {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		return response;
	}
	
	
	
	
}
