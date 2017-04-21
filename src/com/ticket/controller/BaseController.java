package com.ticket.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseController
 */
public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 每一个get请求都会进入到这个方法
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		// TODO Auto-generated method stub
		//获取参数名method,每个请求URL都会带一个method参数，指定调用的方法
		String methodName = request.getParameter("method");
		try {
			//通过反射获取子类的该方法，并且传入参数类型，HttpServletRequest，HttpServletResponse
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			//设置允许访问
			method.setAccessible(true);
			//方法执行调用
			method.invoke(this, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//异常抛出
			e.printStackTrace();
			System.out.println("BaseController 执行失败");
			throw new RuntimeException();
		}
	}

	/**
	 * 每个post请求都会进入到此方法
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//调用get方法，让所有的实现都在get方法里实现
		doGet(request, response);
	}

}
