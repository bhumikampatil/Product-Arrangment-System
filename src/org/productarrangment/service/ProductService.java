package org.productarrangment.service;

import java.util.List;

import org.productarrangement.repositry.ProductRepository;
import org.productarrangment.model.*;

public class ProductService {
	ProductRepository product = new ProductRepository();
	ProductModel pModel = new ProductModel();
	
	public ProductService() {
        this.product = new ProductRepository();
    }

	
	public boolean addNewProduct(ProductModel pModel) {
		boolean b =  product.addNewProduct(pModel);
		return b;
	}
	
	 public List<ProductModel> viewProducts() {
	        return product.viewProducts(pModel);
	    }
	 
	 public boolean isDeleteProductById(int id ) {
		 return product.isDeleteProductById(id);
	 }
	 
	 public boolean updateProductById(ProductModel pModel) {
		 return product.updateProductById(pModel);
	 }

}
