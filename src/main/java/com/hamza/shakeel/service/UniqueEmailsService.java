package com.hamza.shakeel.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.hamza.shakeel.model.Response;

@Component("uniqueEmailsService")
public class UniqueEmailsService {
	
	 /*given a list of emails, returns a set of unique emails
		assumes email follows Gmails's rule of uniqueness-- dots are ignored and everything after + till @ is ignored
		assumes the email format is emailString@domain.com*/
	public Response getUniqueEmails(List<String> emails) {
		Response response = new Response();
		boolean success=true;
		try {
			Set<String> uniqueEmails = new HashSet<>();
			if(emails !=null) {
				for(String email : emails) {
					int indexOfAt = email.indexOf("@");
					if(indexOfAt==-1) {
						// not a valid email address
						response.setStatus("WARNING");
						response.setMessage("One of the emails is not a valid email: "+ email);
						response.setNumberOfUniqueEmailAddresses(-1);
						success=false;
						break;
					} else {
						String actualEmail = email.substring(0, indexOfAt);
						String domain = email.substring(indexOfAt);
						actualEmail = actualEmail.replace(".", ""); // removes all the dots from the email
						int indexPlus = actualEmail.indexOf("+");
						if(indexPlus>=0) {
							// if there is a plus sign in the actual email address, only consider the string from 0 till + sign
							actualEmail=actualEmail.substring(0,indexPlus);
						}
						uniqueEmails.add(actualEmail+domain);
					}
				}
				if(success) {
					response.setStatus("SUCCESS");
					response.setMessage("Successfully completed");
					response.setNumberOfUniqueEmailAddresses(uniqueEmails.size());
				}
			}
		} catch (Exception e) {
			response.setStatus("ERROR");
			response.setMessage(e.toString());
		}
		return response;
	}
}
