package com.hotel;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class HotelController {
	
	@MessageMapping("/currentPrice")
	@SendTo("/topic/hotel")
	public Hotel hotel(HotelPrice price) {
		
	    String formattedPrice = String.valueOf(price.getPrice());
	    String escapedPrice = HtmlUtils.htmlEscape(formattedPrice);
	    Hotel existingHotel = new Hotel();
	    existingHotel.setMessage("Current Price : " + escapedPrice);
	    return existingHotel;

	}

}
