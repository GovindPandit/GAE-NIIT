package com.niit.userapi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.api.server.spi.config.Api;
//import com.google.api.server.spi.config.ApiMethod;
import com.niit.datasource.DataSource;
import com.niit.model.User;
//
//@Api
//public class UserAPIServlet 
//{
//	@ApiMethod(path = "message",httpMethod = "get")
//	public String message()
//	{
//		return "Hello";
//	}
//}
