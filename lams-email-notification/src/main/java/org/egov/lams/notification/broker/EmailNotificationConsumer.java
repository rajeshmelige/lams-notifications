package org.egov.lams.notification.broker;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.egov.lams.notification.adapter.EmailNotificationAdapter;
import org.egov.lams.notification.models.Agreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmailNotificationConsumer {

	public static final Logger LOGGER = LoggerFactory.getLogger(EmailNotificationConsumer.class);
	
	@Autowired
	private EmailNotificationAdapter agreementNotificationAdapter;
	
	@KafkaListener(containerFactory="kafkaListenerContainerFactory",topics ="agreement-save-db")
	public void listen(ConsumerRecord<String, String> record) {
		LOGGER.info("key:"+ record.key() +":"+ "value:" +record.value());
	    if (record.topic().equals("agreement-save-db")) {
			ObjectMapper objectMapper=new ObjectMapper();
			try {
				
				agreementNotificationAdapter.sendEmailNotification(objectMapper.readValue(record.value(),Agreement.class));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}