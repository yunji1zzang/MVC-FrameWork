package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

// DispatcherServlet는 Front Controller 기능의 클래스로서 
// Controller 구성 요소 중 가장 중요한 역할을 수행한다. 
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	// 수정된 DispatcherServlet 클래스에는 init() 메서드가 재정의되어 있다.
	// 서블릿의 init() 메서드는 서블릿 객체가 생성된 후에 멤버변수를 초기화하기 위해
	// 자동으로 실행한다. 따라서, init() 메서드에서 DispatcherServlet이 
	// 사용할 HandlerMapping과 viewResolver 객체를 초기화한다. 
	// 그리고, DispatcherServlet은 이렇게 생성된 HandlerMapping과
	// viewResolver를 이용하여 사용자의 요청을 처리한다. 
	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./"); // 접두사 
		viewResolver.setSuffix(".jsp"); // 접미사 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	// 가장 중요한 process() 메서드를 보면 클라이언트의 요청 path 정보를 추출하는 
	// 코드를 제외하고 코드 대부분이 수정되었다. 먼저 클라이언트의 요청 path에 해당하는
	// Controller를 검색하기 위해 HandlerMapping 객체의 getController()
	// 메서드를 호출한다. 그리고 나서, 검색된 Controller의 handlerRequest
	// 메서드를 호출하여 요청에 해당하는 로직을 처리하고 나면 이동할 화면 정보가 리턴된다. 
	// 마지막으로 Controller가 리턴한 View 이름을 이용하여 실행될 View를 찾아서
	// 해당 화면으로 이동한다.
	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {

		// 1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));

			// 2. HandlerMapping 을 통해 path에 해당하는 Controller를 검색한다.
			Controller ctrl = handlerMapping.getController(path);
			
			// 3. 검색된 Controller를 실행한다. 
			String viewName = ctrl.handlerRequest(request, response);
			
			// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
			String view = null;
			if(!viewName.contains(".do")) {
				view = viewResolver.getView(viewName);
			} else {
				view = viewName;
			}
			
			// 5. 검색된 화면으로 이동한다. 
			response.sendRedirect(view);
		}
	}
