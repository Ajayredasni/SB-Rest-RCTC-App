package com.example.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Request.PassengerRequest;
import com.example.demo.Response.TicketResponse;
import com.example.demo.service.TicketService;

@RestController
public class TicketRestController {
	 @Autowired
	TicketService ticketService=new TicketService();
	
	 @PostMapping(value = "/bookTicket", consumes = {"application/xml","application/json"} )
	public ResponseEntity<String> bookTicket(@RequestBody PassengerRequest passengerRequest){
		String pnr = ticketService.bookTicket(passengerRequest);
		String msg="Ticket Booking Completed ::"+pnr;
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	 
	 @GetMapping(value = "/ticket/{pnr}", produces = {"application/xml","application/json"})
	 public ResponseEntity<TicketResponse> getTicket(@PathVariable String pnr){
		 TicketResponse ticket=ticketService.getTicketResponse(pnr);
		 return new ResponseEntity<TicketResponse>(ticket, HttpStatus.OK); 
	 }
	 
	 @PutMapping(value = "/ticket/update",consumes = {"application/xml","application/json"})
	 public ResponseEntity<String> updateTicket(@RequestBody TicketResponse response) {
		 String msg = ticketService.updateTicket(response);
		 return new ResponseEntity<String>(msg, HttpStatus.OK);
	 }
	 
	 public ResponseEntity<String> deleteBookingTicket(String pnr){
		  String msg = ticketService.deleteBookedTicket(pnr);
		  return new ResponseEntity<String>(msg, HttpStatus.OK);
	 }
}
