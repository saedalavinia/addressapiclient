package me.alavinia.saed.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import me.alavinia.saed.pojos.Person;
import me.alavinia.saed.restclient.CallRest;


@ManagedBean(name = "addperson", eager = true)
@RequestScoped
public class AddPerson {

	
	private Person person = new Person();
	
	public AddPerson(){
		System.out.println("AddPerson is Initialized");
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	public void commit(){
		CallRest.addPerson(this.person);
		addMessage("personAdded");
		RequestContext.getCurrentInstance().execute("PF('AddPersonDialog').hide();");
	}
	
	private void addMessage(String messageReason) {
		FacesMessage message = null;
		if (messageReason.equalsIgnoreCase("personAdded"))
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"New Member added", "New Member was successfully persissted");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
