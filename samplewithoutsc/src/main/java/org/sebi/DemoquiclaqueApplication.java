package org.sebi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoquiclaqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoquiclaqueApplication.class, args);
	}
}

@Controller
class DemoController {

	@Autowired
	ProductService productService;

	private @Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landing() {
		return "landing";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getProducts());
		return "products";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String handleLogoutt() throws ServletException{
		request.logout();
		return "landing";
	}
}

@Service
class ProductService {
	public List<String> getProducts() {
		return Arrays.asList("Ipad","iPhone","IMac");
	}
}



