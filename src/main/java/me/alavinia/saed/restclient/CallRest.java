package me.alavinia.saed.restclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import me.alavinia.saed.pojos.Address;
import me.alavinia.saed.pojos.Person;

@Component
public class  CallRest {
	
	private static final String URL = "https://addressapi.cfapps.io/";
	
	public static void addPerson(Person person){
		RestTemplate restTemplate = new RestTemplate();
		Person result = restTemplate.postForObject(URL + "/persons", person, Person.class);
		System.out.println(result);	
	}

	
	public static List<Person> getPersons(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Person []> responseEntity = restTemplate.getForEntity(URL + "/persons", Person[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	
	
	public static Person memberExists(int sin){
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Person> result = restTemplate.getForEntity(URL + "/persons/" + sin, Person.class);
			System.out.println("Member with SIN: " + result.getBody().getSin() + " exists.");
			return  result.getBody();

		}catch(NullPointerException e){
			System.out.println("Member does not exists");
			return null;
		}
	}
	
	
	public static List<Address> getAddressHistory(int sin){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Address []> responseEntity = restTemplate.getForEntity(URL + "/persons/" + sin + "/addresses" , Address[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	
	
	public static void addAddress(int sin, Address address){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL + "/persons/" + sin + "/addresses" , address, Address.class);
	}
	
}
