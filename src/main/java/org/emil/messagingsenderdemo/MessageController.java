package org.emil.messagingsenderdemo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class MessageController {
	
	private Logger logger = (Logger) LoggerFactory.getLogger(MessageController.class);
	
	private MessageService messageService;
	
	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@PostMapping("/send")
	public String sendMessage(@RequestParam String to, @RequestBody String message) {
		
		String successMessage = "to "+ to +" Message" + message;
		messageService.sendMessageService(to, message);
		logger.info(successMessage);;
		
		return successMessage;
	}

}
