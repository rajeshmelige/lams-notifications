package org.egov.lams.notification.adapter;


import org.egov.lams.notification.broker.EmailNotificationProducer;
import org.egov.lams.notification.model.enums.Priority;
import org.egov.lams.notification.models.Agreement;
import org.egov.lams.notification.models.EmailRequest;
import org.egov.lams.notification.models.Sms;
import org.egov.lams.notification.service.EmailNotificationService;
import org.egov.lams.notification.types.SmsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailNotificationAdapter {

	public static final Logger LOGGER = LoggerFactory.getLogger(EmailNotificationAdapter.class);

	@Autowired
	private EmailNotificationService emailNotificationService;

	@Autowired
	private EmailNotificationProducer agreementNotificationProducer;
	
	@Autowired
	SmsRequest smsRequest;

	
	public void sendEmailNotification(Agreement agreement){

		EmailRequest emailRequest = new EmailRequest();
		
		emailRequest.setSubject(subject);
		emailRequest.setBody(body);
		emailRequest.setEmail(email);
		emailRequest.setSender(sender);
	
		String emailRequestJson = null;
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			emailRequestJson = mapper.writeValueAsString(emailRequest);
			}
		catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}

		try {
			agreementNotificationProducer.sendMessage("agreement-save-db", "save-agreement", emailRequestJson);
		}catch(Exception ex){
			ex.printStackTrace();
		}
 }
	
	
}

