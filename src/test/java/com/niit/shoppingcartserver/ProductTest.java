package com.niit.shoppingcartserver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.Dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product product = (Product) context.getBean("product");

		product.setId("PD002");
		product.setName("samsung");
		product.setDescription("this is laptop product");
		product.setPrice(26000);

		if (productDAO.saveOrUpdate(product) == true) {
			System.out.println("product created successfully");
		} else {
			System.out.println("not able to create product");
		}

	}
}
