package com.crud.jsf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.crud.service.ConnectionClass;



public class StudentBean {

	private int id;
	private String roll,name,email,phone,username,password;
	private List dataFromDB;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List getDataFromDB() {
		return dataFromDB;
	}
	
	ConnectionClass cc = new ConnectionClass();
	@PostConstruct
	public void init()
	{
		dataFromDB = cc.getUserList();
	}
	
	public String login()
	{
		boolean valid = cc.validate(username, password);
		if(valid)
		{
			return "view";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
			"Incorrect username or password","Please enter correct Username and Password!!"));
			return "login";
		}
	}
	
	public String register()
	{
		return "register";
	}
	
	
	public String addUser(StudentBean S)
	{
		boolean added = cc.add(S);
		
		if(added)
		{	
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Registered Successfull!!"));
			return "login";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Error","Please enter all the details!!"));
					return "register";
		}

	}
	
	public String backLogin()
	{
		return "login";
	}
	
public String delete()
	
	{		
	
		FacesContext context = FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		String sid = (String) map.get("id");
		System.out.println(sid);
		int id = Integer.parseInt(sid);
		boolean valid = cc.delete(id);
		if(valid)
		{	
			
			dataFromDB = cc.getUserList();
			return "view";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
			"Error","Please try again!!!"));
			return "error";
		}
		
	}

public String editList()
{	
	StudentBean sn = null;
	FacesContext context = FacesContext.getCurrentInstance();
	Map map = context.getExternalContext().getRequestParameterMap();
	String sid = (String) map.get("id");
	System.out.println(sid);
	int id = Integer.parseInt(sid);
	
	Map<String,Object> sessionObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	
	sn = cc.editDB(id);
	sessionObj.put("editBean", sn);
	
	return "editList";
}

public String updateList(StudentBean sb)
{
	boolean added = cc.update(sb);
	
	if(added)
	{	
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Update Successfull!!"));
		dataFromDB = cc.getUserList();
		return "view";
	}
	else
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				"Error","Please enter all the details!!"));
				return "edit";
	}

	
}

public String backView()
{
	return "edit";
	
}


}
