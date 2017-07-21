package com.hotelfinder.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotelfinder.DealFinder;
import com.hotelfinder.Deals;

/**
 * Servlet implementation class DealFinderServlet
 * This servlet is responsible for serving user requests
 */
@WebServlet("/DealFinderServlet")
public class DealFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DealFinderServlet() {
		super();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DealFinder dealFinder = new DealFinder();
		Deals deals;
		try {
			deals = dealFinder.findDeals(request);
			request.getSession().setAttribute("deals", deals);
			request.getRequestDispatcher("/dealfinder/layouts/SearchResult.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.getSession().setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("/dealfinder/layouts/ErrorPage.jsp").forward(request, response);		
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		service(request, response);
	}

}
