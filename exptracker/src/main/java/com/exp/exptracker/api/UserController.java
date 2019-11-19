package com.exp.exptracker.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.exptracker.model.ExpenseData;
import com.exp.exptracker.model.UserDetails;
import com.exp.exptracker.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/register",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public void register(@RequestBody UserDetails userdetails)
	{
		userservice.adduser(userdetails);
	}
	
	@RequestMapping(value="/getall",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDetails> getAll()
	{
		return userservice.getall();
	}
	
	@RequestMapping(value="/login/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDetails> getById(@PathVariable(name="id") int userid)
    {
		return userservice.getByUserid(userid);
    }
	
	@RequestMapping(value="/addexpense",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public void addExpense(@RequestBody ExpenseData expensedata)
	{
		userservice.addExpense(expensedata);
	}
	@RequestMapping(value="/totalexpense/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public int totalexpense(@PathVariable(name="id") int id)
	{
		return userservice.totalexpense(id);
	}
	
	@RequestMapping(value="/dailytotal/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public int dailytotal(@PathVariable(name="id") int id)
	{
		return userservice.dailytotal(id);
	}
	@RequestMapping(value="/weeklytotal/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public int weeklytotal(@PathVariable(name="id") int id)
	{
		return userservice.weeklytotal(id);
	}
	
}
