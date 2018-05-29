package app02a.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app02a.controller.Controller;
import app02a.controller.InputProductController;
import app02a.controller.SaveProductController;

@WebServlet(asyncSupported=true, loadOnStartup=10, value={"/product_input", "/product_save"})
public class DispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9111454017486497956L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("in doGet");
		}
		
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("in doPost");
		}
		
		process(req, resp);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		String dispatchUrl = null;
		
		if(action.equals("product_input")){
			Controller inputController = new InputProductController();
			dispatchUrl = inputController.handleRequest(request, response);
		}
		else if(action.equals("product_save")){
			Controller saveController = new SaveProductController();
			dispatchUrl = saveController.handleRequest(request, response);
		}
		
		
		
		if(dispatchUrl != null){
			request.getRequestDispatcher(dispatchUrl).forward(request, response);
		}
		
	}
}
