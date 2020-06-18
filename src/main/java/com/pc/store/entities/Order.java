package com.pc.store.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "orders", schema = "stock")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchase_time")
    private Date purchaseTime;
    @ManyToOne
    @JoinColumn(name = "buyer")
    private User buyer;
    @OneToMany(mappedBy = "orders", cascade = CascadeType.MERGE)
    private List<Product> productsInOrder;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public List<Product> getproductsInOrder() {
        return productsInOrder;
    }

    public void setproductsInOrder(List<Product> productsInOrder) {
        this.productsInOrder = productsInOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return id == that.id &&
                Objects.equals(purchaseTime, that.purchaseTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, purchaseTime);
    }

    @ManyToOne(optional = false)
    private Operator operators;

    public Operator getOperators() {
        return operators;
    }

    public void setOperators(Operator operators) {
        this.operators = operators;
    }

    @ManyToOne(optional = false)
    private Product products;

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
