package com.skillstorm.flight.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import com.skillstorm.flight.beans.Flight;





public class FlightDAO {
	
	// database credentials
	private static final String url = "jdbc:mysql://localhost:3306/flight-api";
	private static final String username = "root";
	private static final String password = "Root";
	
	// 1. load class into memory
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//insert 
	public Flight create(Flight flight)
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql = "insert into flights (airline, flightNumber, departureCity, departureDate, departureGate, arrivalCity, arrivalDate, arrivalGate) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
			 
		     PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		     
		    stmt.setString(1, flight.getAirline());
		    stmt.setInt(2, flight.getFlightNumber());
		    stmt.setString(3, flight.getDepartureCity());
		    stmt.setString(4, flight.getDepartureDate());
		    stmt.setString(5, flight.getDepartureGate());
		    stmt.setString(6, flight.getArrivalCity());
		    stmt.setString(7, flight.getArrivalDate());
		    stmt.setString(8, flight.getArrivalGate());
		    
		    stmt.executeUpdate();
	        
		    ResultSet keys = stmt.getGeneratedKeys();
		   
		    
		    keys.next();
		    
		    int flightID = keys.getInt(1);
	
	
		    flight.setId(flightID);
		}
		    
		    catch (SQLException e) {
				
				e.printStackTrace();
			}
	
	
	return flight;
	
	}
	
	
	
	
	
    public List<Flight> findAll() {
		
		List<Flight> allFlights = new LinkedList<>();
		
		
		// 2. create the connection -AND- 5. closing the connection
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			// 3. creating our statement
			String sql = "select id, airline, flightNumber, departureCity, departureDate, departureGate, arrivalCity, arrivalDate, arrivalGate from flights";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// 4. execute the statement
			ResultSet rs = stmt.executeQuery();	// Query because retrieving from table
			
			while(rs.next()) {
				
				// retrieving our returned attributes
				int flightID = rs.getInt("id");
				String airline = rs.getString(2);
				int flightNumber = rs.getInt(3);
				String departureCity = rs.getString(4);
				String departureDate = rs.getString(5);
				String departureGate = rs.getString(6);
				String arrivalCity = rs.getString(7);
				String arrivalDate = rs.getString(8);
				String arrivalGate = rs.getString(9);
				
				
				// creating new movie object with those attributes
				Flight flight = new Flight(flightID, airline, flightNumber, departureCity,  departureDate, departureGate, arrivalCity,  arrivalDate, arrivalGate);
				
				// adding new movie to set of all movies
				allFlights.add(flight);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		// return back the set of all movies
		return allFlights;
	}
                       /* ********************************************************** */
                       
                       public Flight findById(int id) 
                       {
                   		Flight flight = new Flight();
                   		
                   		try(Connection conn = DriverManager.getConnection(url, username, password)){
                   		
                   		
                   		String sql = "select id, title, rating from flights where id = ?";
                  		PreparedStatement stmt = conn.prepareStatement(sql);	
                   		stmt.setInt(1, id);
                   		
                   		} catch (SQLException e) {
                			
                			e.printStackTrace();
                		}
                   		
                   		return flight;
                   	    }
                       
                       
                       /* ************************************************************ */

//     public void update(Flight updatedFlight)
//    {
//        try(Connection conn = DriverManager.getConnection(url, username, password))
//         { 
//        	 String sql = "update flights set airline = ?, flightNumber = ?, departureCity =?, departureDate = ?, departureGate = ?, arrivalCity = ?, arrivalDate = ?, arrivalGate = ?  where id = ?";
//        	 PreparedStatement stmt = conn.prepareStatement(sql);
//      	 
//       	 stmt.setString(1, updatedFlight.getAirline());
//       	 stmt.setInt(2, updatedFlight.getFlightNumber());
//       	 stmt.setString(3, updatedFlight.getDepartureCity());        	
//       	 stmt.setString(4, updatedFlight.getDepartureDate());
//         stmt.setString(5, updatedFlight.getDepartureGate());
//         stmt.setString(6, updatedFlight.getArrivalCity());
//       	 stmt.setString(7, updatedFlight.getArrivalDate());
//       	 stmt.setString(8, updatedFlight.getArrivalGate());
//       	 stmt.setInt(9, updatedFlight.getId());
//       	     stmt.executeUpdate(); 
//       	     
//       	  }  
//        
//         catch (SQLException e) {
//			
//		e.printStackTrace();
//	}    
//        }
//    
//    
                     

                       
                       
                       public void update(Flight updatedFlight)
                       {
                           try(Connection conn = DriverManager.getConnection(url, username, password))
                           { 
                          	 String sql = "update flights set airline = ?, flightNumber = ?, departureCity =?, departureDate = ?, departureGate = ?, arrivalCity = ?, arrivalDate = ?, arrivalGate = ?  where id = ?";
                          	 PreparedStatement stmt = conn.prepareStatement(sql);
                          	 
                          	 stmt.setString(1, updatedFlight.getAirline());
                          	 stmt.setInt(2, updatedFlight.getFlightNumber());
                          	 stmt.setString(3, updatedFlight.getDepartureCity());
                          	 stmt.setString(4, updatedFlight.getDepartureDate());
                          	 stmt.setString(5, updatedFlight.getDepartureGate());
                          	 stmt.setString(6, updatedFlight.getArrivalCity());
                          	 stmt.setString(7, updatedFlight.getArrivalDate());
                          	 stmt.setString(8, updatedFlight.getArrivalGate());
                          	 stmt.setInt(9, updatedFlight.getId());
                          	 
                          	 stmt.executeUpdate();
                          	 
                          	 
                           } 
                           catch (SQLException e) {
                  			
                  			e.printStackTrace();
                  		}
                       }
                     
                       
                       
                       
                       
     
    	 public void delete(Flight flight) throws SQLException {


    	        try(Connection conn = DriverManager.getConnection(url, username, password))
    	        {

    	            String sql = "DELETE FROM flights WHERE flightNumber = ?";

    	            PreparedStatement stmt= conn.prepareStatement(sql);

    				stmt.setInt(1, flight.getFlightNumber());
    			
    	            stmt.executeUpdate();            

    	        }
    	        catch(SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }

 	 

}
