package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.TicketDao;
import com.example.demo.Request.PassengerRequest;
import com.example.demo.Response.TicketResponse;

@Service
public class TicketService {
	@Autowired
	TicketDao dao;
	
	public String bookTicket(PassengerRequest passengerRequest) {
		
		TicketResponse response=new TicketResponse();
		response.setTicketId(123);
		response.setCost(540.00);
		response.setStatus("Confirmed");
		response.setFrom(passengerRequest.getFrom());
		response.setTo(passengerRequest.getTo());
		response.setJdate(passengerRequest.getJdate());
		response.setPnr("PNR2354545");
		response.setName(passengerRequest.getName());
		
		System.out.println( dao.saveTicket(response));
		return "PNR2354545";
	}
	
	public TicketResponse getTicketResponse(String pnr) {
		return dao.getTicketByPnr(pnr);
	}
	
	public String updateTicket(TicketResponse response) {
		return dao.updateTicket(response);	
	}
	
	public String deleteBookedTicket(String pnr) {
		return dao.deleteBookedTicket(pnr);
	}
}
