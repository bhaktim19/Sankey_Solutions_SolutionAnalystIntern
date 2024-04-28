package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSocketEndpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketEndpointApplication.class, args);
		System.out.println("My WebSocket Endpoint");
	}

}
