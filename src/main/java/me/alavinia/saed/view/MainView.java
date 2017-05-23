package me.alavinia.saed.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



@ManagedBean(name = "mainview", eager = true)
@RequestScoped
public class MainView {

	private boolean showPeopleTable = false;

	public MainView(){
		
	}
	
	public void pageOnLoad(){
		System.out.println("Main Page is loaded");
		
	}

	public boolean isShowPeopleTable() {
		return showPeopleTable;
	}

	public void setShowPeopleTable(boolean showPeopleTable) {
		this.showPeopleTable = showPeopleTable;
	}
	
	
	public void renderTable(){
		this.showPeopleTable = true;
	}

}
