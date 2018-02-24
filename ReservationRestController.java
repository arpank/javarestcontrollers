package com.example;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;
import javax.ws.rs.Produces;

import org.apache.catalina.core.ApplicationContext;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class ReservationRestController{
	@RequestMapping(value="/reservations", method = RequestMethod.GET, produces ="application/json")
	public String reservations()
	{
		RestTemplate restTemplate = new RestTemplate();
		
		 
	    ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/reservations1",   String.class); 
	    HttpHeaders headers = new HttpHeaders();
	    HttpEntity<String> entity = new HttpEntity<String>("Hello World11111111!", headers);
	    
		ResponseEntity<String> personEntity = restTemplate.exchange("http://localhost:8080/reservations1", HttpMethod.GET, entity, String.class, 100);
		
		
	    System.out.println("Response from service is " + response.getBody());
	    
	    ResponseEntity<HashMap> response1 = restTemplate.getForEntity("http://localhost:8080/reservations2",  HashMap.class ); 
        
	    System.out.println("Response from service is " + response.getBody());

	    
	    System.out.println("Response from service11 is " + response1.getBody());
		Map <String, String> aa = response1.getBody();
		
		return response + "test";
	}
	
	@RequestMapping("/{id}")
	public String getById(@PathVariable Integer id) {
		return  "test111111";
		
	}
	
}
@RestController
class ReservationRestController1{
	@RequestMapping("/reservations1")
	String reservations()
	{
		return "test shivji is great";
	}
}
@RestController
class ReservationRestController2{
	@RequestMapping("/reservations2")
	  Map <String, ? extends Object> reservations()
	{
		Map <String, String> aa = new HashMap();
		aa.put("shivji", "protects and forgives");
		
		return aa;
	}
}
