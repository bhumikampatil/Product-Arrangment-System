package org.productarrangment.service;

import org.productarrangement.repositry.*;
import org.productarrangment.model.CategoryModel;

public class CategoryService extends CategoryRepository {
	
	CategoryRepository inProduct = new CategoryRepository();
	
	public boolean addNewProduct(CategoryModel cModel) {
		boolean b =  inProduct.addNewCategory(cModel);
		return b;
	}

}
