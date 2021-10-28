package com.skillstorm.flight.servlets;

import java.awt.List;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.LinkedList;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.flight.beans.Flight;
import com.skillstorm.flight.data.FlightDAO;

@WebServlet(urlPatterns = "/api/flights")

public class FlightServlet extends HttpServlet{
	
	
    FlightDAO dao = new FlightDAO();
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	System.out.println("servlet POST()");
 
    	
    	 InputStream requestBody= req.getInputStream();

        Flight flight= new ObjectMapper().readValue(requestBody, Flight.class);


        Flight insertedFlight;

        insertedFlight = dao.create(flight);

		resp.getWriter().print(new ObjectMapper().writeValueAsString(insertedFlight));


		resp.setStatus(201);


		resp.setContentType("application/json");

    	
    }
    
    
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("servlet GET()");
		
		
         LinkedList<Flight> allFlights= (LinkedList<Flight>) dao.findAll();


        String json= new ObjectMapper().writeValueAsString(allFlights);


        resp.getWriter().print(json);

        resp.setContentType("application/json");
		
			
	}
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    	InputStream requestBody= req.getInputStream();
    	
    	Flight updatedFlight= new ObjectMapper().readValue(requestBody, Flight.class);
    	
    	dao.update(updatedFlight);
    	
    	resp.setContentType("application/json");
    }
    
    @Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        InputStream requestBody = req.getInputStream();
 		
 		
 		Flight movie = new ObjectMapper().readValue(requestBody, Flight.class);
 		
			try {
				dao.delete(movie);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} 

	}
    
    
	
}
