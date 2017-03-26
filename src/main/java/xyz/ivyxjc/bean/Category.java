package xyz.ivyxjc.bean;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by jc on 3/7/2017.
 */


public class Category {
    private int id;

    private String name;

    private List<Product> products;

    private List<List<Product>> productsByRow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }
}
