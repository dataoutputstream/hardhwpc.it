package com.hardhwpc.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.server.StreamResource;


import javax.persistence.*;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "stock")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable=false)
    private BigInteger id;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name="description", nullable = true, length = 1000)
    private String description;
    @Basic
    @Column(name="productcode",nullable=false, length =15)
    private String productcode;
    @Basic
    @Column(name="serialnumber", nullable = true, length = 50)
    private String serialnumber;
    @Basic
    @Column(name = "price", nullable = false, length =10)
    private Double price;

    @Basic
    @Column(name="quantity", nullable = false)
    private Integer quantita;

    @Basic(fetch = FetchType.LAZY)
    @Column(name="image",
    columnDefinition = "clob")
    private byte[] img;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Order> productInOrders;

    /**@Version
    @Column(name = "optimistic_locking")
    private Integer version;


   protected Integer getVersion(){
        return version;
    }

    protected void setVersion(Integer version){
        this.version=version;
    }
    **/

    //getter and setter

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Image getImg() {
        StreamResource sr = new StreamResource("product", () ->  {
            return new ByteArrayInputStream(img);
        });
        Image image = new Image(sr, "product-picture");
        try {

            sr.setContentType("image/png");
            image.setHeight("300px");
            image.setMaxWidth("300px");
        }catch (Exception e)
        {
            sr.setContentType("image/jpg");
            image.setHeight("300px");
            image.setMaxWidth("300px");

        }
        return image;
    }

    public void setImg(byte[] img) {
        this.img = img;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }


    public List<Order> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(List<Order> productsInOrders) {
        this.productInOrders= productsInOrders;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    /**public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    **/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return this.id.equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductcode());
    }

    public byte[] getImg2() {
        return img;
    }


}
