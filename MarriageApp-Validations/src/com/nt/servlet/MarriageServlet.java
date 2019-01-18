package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {

	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:process(-,-) method");
		PrintWriter pw = null;
		String name = null;
		int age = 0;
		String tage = null;
		String gender = null;
		List<String> errList = null;
		String vstatus = null;
		// general settings
		pw = res.getWriter();
		res.setContentType("text/html");
		// read form data
		name = req.getParameter("pname");
		tage = req.getParameter("page");
		gender = req.getParameter("gen");
		vstatus = req.getParameter("vflag");
		// server side form validation logic
		if (vstatus.equalsIgnoreCase("no")) {
			System.out.println("Server side form validations..");
			errList = new ArrayList();
			if (name == null || name.equals("") || name.length() == 0) { // required
																			// rule
				errList.add("<h3 style='color:red;text-align:center'>Person name is required </h3>");
			}
			if (tage == null || tage.equals("") || tage.length() == 0) { // required
																			// rule
				errList.add("<h3 style='color:red;text-align:center'>Person age  is required </h3>");
			} else {
				try {
					age = Integer.parseInt(tage);
					if (age <= 0 || age > 125) { // validation
						errList.add(
								"<h3 style='color:red;text-align:center'>Person age  muse be in the range of 1 through 125</h3>");
					}
				} catch (Exception e) { // validation
					errList.add("<h3 style='color:red;text-align:center'>Person age must be  numeric value  </h3>");
				}
			}

			if (errList.size() > 0) {
				for (String errMsg : errList) {
					pw.println(errMsg);
				} // for
				return;
			} // if
		} // if
		else{
			age=Integer.parseInt(tage);
		}

		// process the request
		if (gender.equalsIgnoreCase("M")) {
			if (age < 21) {
				pw.println("<h1 style='color:red;text-align:center'>Mr. " + name
						+ " u  r not eglible for marriage, Enjoy  u r life");
			} else {
				pw.println("<h1 style='color:blue;text-align:center'>Mr. " + name
						+ " u  r  eglible for marriage, But Think Thrice");
			}
		} else {
			if (age < 18) {
				pw.println("<h1 style='color:red;text-align:center'>Miss. " + name
						+ " u  r not eglible for marriage, Take a breathe");
			} else {
				pw.println("<h1 style='color:blue;text-align:center'>Miss. " + name
						+ " u  r  eglible for marriage , Let others to live");
			}
		}

		// add hyperlink
		pw.println("<a href='input.html'>home</a>");

		// close stream
		pw.close();
	}// doGet(-,-)

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:doGet(-,-)");
		process(req, res);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:doPost(-,-)");
		process(req, res);

	}

}// class
