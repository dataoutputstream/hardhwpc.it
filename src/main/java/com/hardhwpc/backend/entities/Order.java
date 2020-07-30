package com.hardhwpc.backend.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "orders", schema = "stock")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;
    @Basic
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchase_time")
    private Date purchaseTime;
    @Basic
    @Column(name="totalprice")
    private String totalprice;
    @Basic
    @Column(name="ordernumber")
    private String ordernumber;
    @Basic
    @Column(name="orderstate")
    private String orderstate;
    @Basic
    @Column(name="shippingnumber")
    private String shippingnumber;

    @ManyToOne
    @JoinColumn(name = "buyer")
    private User buyer;

    @ManyToMany(cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "products_orders", schema = "stock",
            joinColumns = @JoinColumn(name = "orders"),
            inverseJoinColumns = @JoinColumn(name = "products")
    )
   private List<Product> products;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    public User getUser(){
        return buyer;
    }
    public void setUser(User u){
        this.buyer=u;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public String getShippingnumber() {
        return shippingnumber;
    }

    public void setShippingnumber(String shippingnumber) {
        this.shippingnumber = shippingnumber;
    }

    public List<Product> getProductsInOrder() {
        return products;
    }

    public void setProductsInOrder(List<Product> productsInOrder) {
        this.products = productsInOrder;
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

    /**
    @ManyToOne(optional = false)
    private Operator operators;

    public Operator getOperators() {
        return operators;
    }

    public void setOperators(Operator operators) {
        this.operators = operators;
    }

   // @ManyToOne(optional = false)
    //private Product products;
    /**
    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
     **/
}
