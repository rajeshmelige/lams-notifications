package org.egov.lams.notification.service;

import org.egov.lams.notification.models.Agreement;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService {


	public String getSmsNotification(Agreement agreement){


		Double totalAmount = agreement.getSecurityDeposit() + agreement.getBankGuaranteeAmount();
		String message = "Letter of acceptance with LOA number " + XXXX 
				+ " for agreement amount" + BBBB 
				+ "is approved. "
				+ "Please contact ward engineer for further details";
		return message;

	}
}



