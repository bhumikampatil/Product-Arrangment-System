package org.productarrangment.model;

import java.util.Date;

public class ProductModel {
    private int categoryId;
    private int productId;
    private String productName;
    private int productPrice;
    private Date productManu;
    private Date productExp;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Date getProductManu() {
        return productManu;
    }

    public void setProductManu(Date productManu) {
        this.productManu = productManu;
    }

    public Date getProductExp() {
        return productExp;
    }

    public void setProductExp(Date productExp) {
        this.productExp = productExp;
    }
}
