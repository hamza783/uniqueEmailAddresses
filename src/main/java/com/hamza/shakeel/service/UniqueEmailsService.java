package com.hamza.shakeel.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component("uniqueEmailsService")
public class UniqueEmailsService {
	
	 /*given a list of emails, returns a set of unique emails
		assumes email follows Gmails's rule of uniqueness-- dots are ignored and everything after + till @ is ignored
		assumes the email format is emailString@domain.com*/
	public Set<String> getUniqueEmails(List<String> emails) {
		Set<String> uniqueEmails = new HashSet<>();
		if(emails !=null) {
			for(String email : emails) {
				String actualEmail = email.substring(0, email.indexOf("@"));
				String domain = email.substring(email.indexOf("@"));
				actualEmail = actualEmail.replace(".", ""); // removes all the dots from the email
				int indexPlus = actualEmail.indexOf("+");
				if(indexPlus>=0) {
					// if there is a plus sign in the actual email address, only consider the string from 0 till + sign
					actualEmail=actualEmail.substring(0,indexPlus);
				}
				uniqueEmails.add(actualEmail+domain);
			}
		}
		return uniqueEmails;
	}
}
