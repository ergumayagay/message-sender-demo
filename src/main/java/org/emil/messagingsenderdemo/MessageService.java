package org.emil.messagingsenderdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	private JmsTemplate jmsTemplate;
	
	@Autowired
	public MessageService(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendMessageService(String recipient, String message) {
		Message newMessage = new Message();
		newMessage.setRecipient(recipient);
		newMessage.setMessage(message);	
		jmsTemplate.convertAndSend("message-demo",newMessage);
	}

}
