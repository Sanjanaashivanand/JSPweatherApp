package com.weather.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weather.data.Data;
import com.weather.util.WeatherFunctions;

@WebServlet("/")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WeatherFunctions service = new WeatherFunctions();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Data weatherdata = new Data();
		try {
			weatherdata = service.getDetails();
			request.setAttribute("weatherdata", weatherdata);
			RequestDispatcher dispatcher = request.getRequestDispatcher("weather.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
