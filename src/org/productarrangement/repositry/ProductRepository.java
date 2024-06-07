package org.productarrangement.repositry;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.productarrangment.config.DBconfig;
import org.productarrangment.model.ProductModel;

public class ProductRepository<AdminModel> extends DBconfig {

    public boolean addNewProduct(ProductModel pModel) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO product (prod_name, prod_price, prod_manu, prod_expiry, cid) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, pModel.getProductName());
            stmt.setInt(2, pModel.getProductPrice());
            stmt.setDate(3, new java.sql.Date(pModel.getProductManu().getTime())); 
            stmt.setDate(4, new java.sql.Date(pModel.getProductExp().getTime()));
            stmt.setInt(5, pModel.getCategoryId());

            System.out.println("Product Name: " + pModel.getProductName());
            System.out.println("Product Price: " + pModel.getProductPrice());
            System.out.println("Product Manufacture Date: " + new java.sql.Date(pModel.getProductManu().getTime()));
            System.out.println("Product Expiry Date: " + new java.sql.Date(pModel.getProductExp().getTime()));
            System.out.println("Category ID: " + pModel.getCategoryId());

            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<ProductModel> viewProducts(ProductModel pModel) {
        List<ProductModel> products = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM product";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                ProductModel product = new ProductModel();
                product.setProductId(rs.getInt("prod_id"));
                product.setProductName(rs.getString("prod_name"));
                product.setProductPrice(rs.getInt("prod_price"));
                product.setProductManu(rs.getDate("prod_manu"));
                product.setProductExp(rs.getDate("prod_expiry"));
                product.setCategoryId(rs.getInt("cid"));
                
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        }
        
        return products;
    }
    
    public boolean isDeleteProductById(int id) {
    	 PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("DELETE FROM product WHERE prod_id = ?");
			stmt.setInt(1, id);
			int value = stmt.executeUpdate();
			return value > 0;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
    public boolean updateProductById(ProductModel pModel) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE product SET prod_name=?, prod_price=?, prod_manu=?, prod_expiry=?, cid=? WHERE prod_id=?");
            stmt.setString(1, pModel.getProductName());
            stmt.setInt(2, pModel.getProductPrice());
            stmt.setDate(3, new java.sql.Date(pModel.getProductManu().getTime())); 
            stmt.setDate(4, new java.sql.Date(pModel.getProductExp().getTime())); 
            stmt.setInt(5, pModel.getCategoryId());
            stmt.setInt(6, pModel.getProductId());

            System.out.println("Product ID: " + pModel.getProductId());
            System.out.println("Product Name: " + pModel.getProductName());
            System.out.println("Product Price: " + pModel.getProductPrice());
            System.out.println("Product Manufacture Date: " + new java.sql.Date(pModel.getProductManu().getTime()));
            System.out.println("Product Expiry Date: " + new java.sql.Date(pModel.getProductExp().getTime()));
            System.out.println("Category ID: " + pModel.getCategoryId());

            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
