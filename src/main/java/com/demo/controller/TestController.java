package com.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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

	//http://localhost:8080/demo/version/1
	@RequestMapping(value = "version1/{var}", method = RequestMethod.GET)
	public String getVersions(@PathVariable("var") final String var) {
		return var;
	}
	
	//http://localhost:8080/demo/version/1/2
	@RequestMapping(value = "version1/{var1}/{var2}", method = RequestMethod.GET)
	public String getVersionss(@PathVariable("var1") final String var1,@PathVariable("var2") final String var2) {
		return var1 + " " + var2;
	}
	
	//http://localhost:8080/demo/version
	@RequestMapping(value = "version2", method = RequestMethod.GET, consumes="application/json", produces="application/json")
	public ResultEntity<String> getVersion2() {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		return response;
	}
	
	
	
	
}
