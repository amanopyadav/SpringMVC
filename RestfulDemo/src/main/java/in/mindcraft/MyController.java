package in.mindcraft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//SpringServerlet --> spring-servlet.xml
@RestController

public class MyController {
	
	private List<Product> list = new ArrayList<>();
	
	public MyController() {
		list.add(new Product(101,"marker", 50));
		list.add(new Product(102,"water bottle", 70));
		list.add(new Product(103,"bag", 250));
	}
	
	@ResponseBody
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public List<Product> getProduct(){
		System.out.println("get all products..");
		
		return list;
	}
	
	@RequestMapping(value="/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable int id) {
		for(Product p:list)
		{
			if(p.getPid()==id)
				return p;
			
		}
		return null;
	}

}





