package app15.session;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import app07b.domain.Product;

@Controller
@RequestMapping("/app15")
public class SessionController {

	@RequestMapping("/session_create")
	public String session(HttpSession session){
		if(session.getAttribute("sessionAttr") == null){
			//Map<String, Product> products = new HashMap<String, Product>();
			Product product = new Product();
			product.setName("product_A");
			product.setDescription("this is product A");
			product.setPrice(163563.5f);
			product.setProductionDate(new Date());
			
			
			//products.put("product_a", product);
			session.setAttribute("sessionAttr", product);
		
		}
		return "app15/CreateSession";
		
	}
	
	
	@RequestMapping(value="/session_view")
	public String viewSession(){
		return "app15/ViewSession";
	}
}
