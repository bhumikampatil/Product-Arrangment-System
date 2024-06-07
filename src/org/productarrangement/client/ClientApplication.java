package org.productarrangement.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.productarrangment.model.CategoryModel;
import org.productarrangment.model.ProductModel;
import org.productarrangment.service.CategoryService;
import org.productarrangment.service.ProductService;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientApplication {

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        ProductService pService = new ProductService();
        List<ProductModel> productList = pService.viewProducts();
     


        System.out.println("Enter Your Choice ");
        System.out.println("1) Add New Category");
        System.out.println("2) Add New Product");
        System.out.println("3) View product");
        System.out.println("4) Delete product");
        System.out.println("5) Update product");
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Category");
                    String categoryName = sc.next();
                    CategoryModel cModel = new CategoryModel();
                    CategoryService cService = new CategoryService();
                    cModel.setCategoryname(categoryName);
                    boolean addedCategory = cService.addNewCategory(cModel);
                    if (addedCategory) {
                        System.out.println("Category Added");
                    } else {
                        System.out.println("Category Not Added");
                    }
                    break;
                case 2:
                	ProductModel pModel = new ProductModel();
                    System.out.println("Enter Product Name");
                    sc.nextLine(); 
                    String pName = sc.nextLine();

                    System.out.println("Enter Product Price");
                    int pPrice = sc.nextInt();

                    System.out.println("Enter Product Manufacture Date (YYYY-MM-DD)");
                    java.util.Date pManu = java.sql.Date.valueOf(sc.next());

                    System.out.println("Enter Product Expiry Date (YYYY-MM-DD)");
                    java.util.Date pExp = java.sql.Date.valueOf(sc.next());
                    
                    System.out.println("Enter Product Category ID");
                    int pCid = sc.nextInt();
                    pModel.setCategoryId(pCid);

                    
                    System.out.println(pManu);
                    System.out.println(pExp);

                    
                    pModel.setProductName(pName);
                    pModel.setProductPrice(pPrice);
                    pModel.setProductManu(pManu);
                    pModel.setProductExp(pExp);
                    pModel.setProductId(pCid);

                    boolean addedProduct = pService.addNewProduct(pModel);
                    if (addedProduct) {
                        System.out.println("Product Added");
                    } else {
                        System.out.println("Product Not Added");
                    }
                    break;
                case 3:
                    pService = new ProductService();

                    if (productList.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        System.out.println("List of Products:");
                        for (ProductModel product : productList) {
                            System.out.println("Product ID: " + product.getProductId());
                            System.out.println("Product Name: " + product.getProductName());
                            System.out.println("Product Price: " + product.getProductPrice());
                            System.out.println("Manufacture Date: " + product.getProductManu());
                            System.out.println("Expiry Date: " + product.getProductExp());
                            System.out.println("Category ID: " + product.getCategoryId());
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case 4:
                    pService = new ProductService();
                    System.out.println("Select id to delete");
                    
                    if (productList.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        System.out.println("List of Products:");
                        for (ProductModel product : productList) {
                            System.out.println("ID: " + product.getProductId() + ", " +
                                               "Name: " + product.getProductName() + ", " +
                                               "Price: " + product.getProductPrice() + ", " +
                                               "Date: " + product.getProductManu() + ", " +
                                               "Date: " + product.getProductExp() + ", " +
                                               "Category ID: " + product.getCategoryId());
                           
                        }
                    }
                    int id = sc.nextInt();
                    boolean b = pService.isDeleteProductById(id);
                    if(b) {
                    	System.out.println("Product Deleted");
                    } else {
                    	System.out.println("Product Not Deleted");
                    }
                    break;
                    
                case 5:
                    pService = new ProductService();
                    
                    System.out.println("Select ID to update:");

                    if (productList.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        System.out.println("List of Products:");
                        for (ProductModel product : productList) {
                            System.out.println("ID: " + product.getProductId() + ", " +
                                               "Name: " + product.getProductName() + ", " +
                                               "Price: " + product.getProductPrice() + ", " +
                                               "Manufacture Date: " + product.getProductManu() + ", " +
                                               "Expiry Date: " + product.getProductExp() + ", " +
                                               "Category ID: " + product.getCategoryId());
                        }
                    }

                    int idToUpdate = sc.nextInt(); 

                    System.out.println("Enter updated details:");
                    System.out.print("Name: ");
                    String updatedName = sc.next();
                    System.out.print("Price: ");
                    int updatedPrice = sc.nextInt();
                    System.out.print("Manufacture Date (YYYY-MM-DD): ");
                    String updatedManuDateStr = sc.next();
                    System.out.print("Expiry Date (YYYY-MM-DD): ");
                    String updatedExpDateStr = sc.next();
                    System.out.print("Category ID: ");
                    int updatedCategoryId = sc.nextInt();
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date updatedManuDate = null;
                    Date updatedExpDate = null;
                    try {
                        updatedManuDate = dateFormat.parse(updatedManuDateStr);
                        updatedExpDate = dateFormat.parse(updatedExpDateStr);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                    }
                    
                    if (updatedManuDate != null && updatedExpDate != null) {
                        ProductModel updatedProduct = new ProductModel();
                        updatedProduct.setProductId(idToUpdate); 
                        updatedProduct.setProductName(updatedName);
                        updatedProduct.setProductPrice(updatedPrice);
                        updatedProduct.setProductManu(updatedManuDate);
                        updatedProduct.setProductExp(updatedExpDate);
                        updatedProduct.setCategoryId(updatedCategoryId);
                        
                        boolean isUpdated = pService.updateProductById(updatedProduct); 
                        
                        if (isUpdated) {
                            System.out.println("Product updated successfully.");
                        } else {
                            System.out.println("Failed to update product.");
                        }
                    }

                    break;



                default:
                    System.out.print("Wrong Input");
            }
        } while (choice < 5);
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    
}   
}
 
