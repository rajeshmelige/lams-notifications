package org.egov.lams.notification.service;

import org.egov.lams.notification.models.Agreement;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService {

	public String getSmsMessage(Agreement agreement) {

		Double totalAmount = agreement.getSecurityDeposit() + agreement.getBankGuaranteeAmount();
		String message = "Dear " + agreement.getAllottee().getName() + ","
			    +" \n We have processed your application for agreement of " + agreement.getAsset().getCategory() + " "
				+ agreement.getAsset().getName() + " with acknowledgement number "
				+ agreement.getAcknowledgementNumber() + ". Monthly amount generated for agreement is Rs."
				+ agreement.getRent() + ". Advance amount and good will for your application is Rs." //Goodwill amount is provided by the user
				+ agreement.getSecurityDeposit() + " and Rs." + agreement.getBankGuaranteeAmount()
				+ ". We request you to pay the amount Rs." + totalAmount
				+ " at the ULB counter, so that we can process your agreement.\nThanks, "
				+ agreement.getAsset().getLocationDetails().getRevenueWard();

		return message;

	}
}
