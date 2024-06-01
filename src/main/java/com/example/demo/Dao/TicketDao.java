package com.example.demo.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.Response.TicketResponse;

@Repository
public class TicketDao {
	
  private Map<String, TicketResponse> ticketMap=new HashMap<>();
  
  public String saveTicket(TicketResponse response)
  {
	  ticketMap.put(response.getPnr(), response);
	  return response.getPnr();
  }
  
  public TicketResponse getTicketByPnr(String pnr) {
	  if(ticketMap.containsKey(pnr)) {
		  return ticketMap.get(pnr);
	  }
	  return null;
  }
  
  public String updateTicket(TicketResponse response)
  {
	  String pnr = response.getPnr();
	  ticketMap.put(pnr, response);
	  return "Update Ticket Successfully";
  }
  
  public String deleteBookedTicket(String pnr) {
	  ticketMap.remove(pnr);
	  return "Delete Booked Ticket Successfully";
  }
}
