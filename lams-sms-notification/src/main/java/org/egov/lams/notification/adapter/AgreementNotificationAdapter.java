package org.egov.lams.notification.adapter;

import org.egov.lams.notification.broker.AgreementNotificationProducer;
import org.egov.lams.notification.model.enums.Priority;
import org.egov.lams.notification.models.Agreement;
import org.egov.lams.notification.models.Sms;
import org.egov.lams.notification.service.SmsNotificationService;
import org.egov.lams.notification.types.SmsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AgreementNotificationAdapter {

	public static final Logger LOGGER = LoggerFactory.getLogger(AgreementNotificationAdapter.class);

	@Autowired
	private SmsNotificationService smsNotificationService;

	@Autowired
	private AgreementNotificationProducer agreementNotificationProducer;

	@Autowired
	SmsRequest smsRequest;

	public void sendSmsNotification(Agreement agreement) {

		Sms sms = new Sms();

		sms.setMessage(smsNotificationService.getSmsMessage(agreement));
		sms.setMobileNumber(agreement.getAllottee().getMobileNumber().toString());
		sms.setPriority(Priority.HIGH); // FIXME hardcoded;

		System.out.println("SMS------------" + sms);
		String smsRequestJson = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			smsRequestJson = mapper.writeValueAsString(sms);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

		try {
			agreementNotificationProducer.sendMessage("sms-notification-agreement", "sms-notification", smsRequestJson);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
