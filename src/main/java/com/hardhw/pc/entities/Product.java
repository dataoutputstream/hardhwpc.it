package com.hardhw.pc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "stock")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable=false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name="description", nullable = true, length = 1000)
    private String description;
    @Basic
    @Column(name="productcode",nullable=false, length =15)
    private String productcodebar;
    @Basic
    @Column(name="serialnumber", nullable = true, length = 50)
    private String serialnumber;
    @Basic
    @Column(name = "price", nullable = false, length =10)
    private String price;

    @OneToMany(targetEntity = Order.class, mappedBy = "products", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> productsInPurchase;

    //getter and setter
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductcodebar() {
        return productcodebar;
    }

    public void setProductcodebar(String productcodebar) {
        this.productcodebar = productcodebar;
    }

    public List<Order> getProductsInPurchase() {
        return productsInPurchase;
    }

    public void setProductsInPurchase(List<Order> productsInPurchase) {
        this.productsInPurchase = productsInPurchase;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() &&
                getName().equals(product.getName()) &&
                getDescription().equals(product.getDescription()) &&
                getSerialnumber().equals(product.getSerialnumber()) &&
                getPrice().equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getSerialnumber(), getPrice());
    }

    @ManyToOne(optional = false)
    private Order orders;

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }
}
