package com.example.integration.integration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class IntegrationApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
//		System.out.println("Hello World");
/*		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "value");
		MessageHeaders headers = new MessageHeaders(map);

		Message message = new GenericMessage<String>("Hello world", headers);*/

		Message<String> message = MessageBuilder.withPayload("Hello from builder")
				.setHeader("newHeader", "newValue")
				.build();
		PrintService service = new PrintService();
		service.print(message);
	}
}
