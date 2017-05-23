package me.alavinia.saed.view;

import java.util.ArrayList;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import me.alavinia.saed.pojos.Address;
import me.alavinia.saed.pojos.Person;
import me.alavinia.saed.restclient.CallRest;


@ManagedBean(name = "addaddress", eager = true)
@ViewScoped
public class AddAddress {

	
	
	private Person person;
	private List<Address> addresses; 
	private Address newAddress;
	private boolean memberSelected;
	
	public AddAddress(){
		person = new Person();
		addresses = new ArrayList<Address>(); 
		newAddress = new Address();
		memberSelected = false;
		System.out.println("addAddress is called");
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	public void lookup(){
		try{
			this.person = CallRest.memberExists(this.person.getSin());
			if(this.person != null){
				this.memberSelected = true;
				this.newAddress.setPerson(this.person);
				this.addresses =  CallRest.getAddressHistory(this.person.getSin());
				addMessage("memberSelected");
				return;

			}else{
				this.memberSelected = false;
				addMessage("memberDoesNotExist");
				FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove("addaddress");
				return;
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	private void addMessage(String messageReason) {
		FacesMessage message = null;
		if (messageReason.equalsIgnoreCase("memberDoesNotExist")){ 
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Member Does Not Exist", "Try Another SIN or Add Member");
		    FacesContext.getCurrentInstance().addMessage(null, message);
		    return;
		} 
		if (messageReason.equalsIgnoreCase("memberSelected")){ 
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Member Selected", "Member\nSin:" + this.person.getSin() + "\nFirst Name: " + this.person.getFirstName() + "\nLast Name: " + this.person.getLastName() + "\nhas been selected.");
		    FacesContext.getCurrentInstance().addMessage(null, message);
		    return;
		} 
		if (messageReason.equalsIgnoreCase("AddressAdded")){ 
			message = new FacesMessage(FacesMessage.SEVERITY_INFO ,"Address Was Successfully added", "");
		    FacesContext.getCurrentInstance().addMessage(null, message);
		    return;
		} 
		if (messageReason.equalsIgnoreCase("AddressFailed")){ 
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Could not add the address", "Please try again.");
		    FacesContext.getCurrentInstance().addMessage(null, message);
		    return;
		} 
	}
	
	
	
	public void commit(){
			
			try{
				System.out.println(this.newAddress.getPostalCode());
				System.out.println(this.newAddress.getDateFrom());
				CallRest.addAddress(this.person.getSin(),this.newAddress);
				addMessage("AddressAdded");
				RequestContext.getCurrentInstance().execute("PF('AddAddressDialog').hide();");
				this.newAddress = null;
				this.addresses =  CallRest.getAddressHistory(this.person.getSin());
			}catch(Exception e){
				addMessage("AddressFailed");
				
			}

	}


	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(Address newAddress) {
		this.newAddress = newAddress;
	}
	
	
	public boolean isMemberSelected() {
		return memberSelected;
	}

	public void setMemberSelected(boolean memberSelected) {
		this.memberSelected = memberSelected;
	}

	
}
