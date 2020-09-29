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
	public int getNumberOfUniqueEmailsUrl(@PathVariable("emails") List<String> emails) {
		Set<String> uniqueEmails = uniqueEmailsService.getUniqueEmails(emails );
		return uniqueEmails.size();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getNumberOfUniqueEmails", consumes=MediaType.APPLICATION_JSON_VALUE)
	public int getNumberOfUniqueEmails(@RequestBody  List<String> emails) {
		Set<String> uniqueEmails = uniqueEmailsService.getUniqueEmails(emails );
		return uniqueEmails.size();
	}
}
