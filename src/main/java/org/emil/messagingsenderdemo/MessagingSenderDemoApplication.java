package org.emil.messagingsenderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@EnableJms
@SpringBootApplication
public class MessagingSenderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingSenderDemoApplication.class, args);
	}
	
	
	@Bean
	public MappingJackson2MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return  converter;
	}
}
