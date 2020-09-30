package com.hamza.shakeel.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hamza.shakeel.model.Response;
import com.hamza.shakeel.service.UniqueEmailsService;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UniqueEmailsController {
	
	@Autowired
	UniqueEmailsService uniqueEmailsService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/ping")
	public String test() {
		return "pong";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getNumberOfUniqueEmailsUrl/{emails}")
	public Response getNumberOfUniqueEmailsUrl(@PathVariable("emails") List<String> emails) {
		Response response = new Response();
		response = uniqueEmailsService.getUniqueEmails(emails);
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getNumberOfUniqueEmails", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Response getNumberOfUniqueEmails(@RequestBody  List<String> emails) {
		Response response = uniqueEmailsService.getUniqueEmails(emails);
		return response;
	}
}
