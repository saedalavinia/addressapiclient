package me.alavinia.saed.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import me.alavinia.saed.pojos.Person;
import me.alavinia.saed.restclient.CallRest;


@ManagedBean(name = "viewmembers", eager = true)
@RequestScoped
public class ViewMembers {

	private List<Person> members; 
	
	public ViewMembers(){
		System.out.println("View Member Dialog is loaded");
		members = CallRest.getPersons();
	}

	public List<Person> getMembers() {
		return members;
		
	}

	public void setMembers(List<Person> members) {
		this.members = members;
	}
	
	
}
