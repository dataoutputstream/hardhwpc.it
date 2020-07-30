package com.hardhwpc.backend.entities;

public class ProductCart extends Product{
    int quantita;
    Double totale;

   public ProductCart(){
        super();
    }
    public void setProduct(Product p){
        this.setDescription(p.getDescription());
        this.setId(p.getId());
        this.setPrice(p.getPrice());
        this.setProductcode(p.getProductcode());
        this.setSerialnumber(p.getSerialnumber());
        this.setName(p.getName());
    }
    public void setQuantity(int quantita){
        this.quantita=quantita;
        totale = Double.valueOf(this.getPrice())*Double.valueOf(this.quantita);
    }
    public double getTotale(){
        return this.totale;
    }

    public int getQuantity() {
        return  quantita;
    }
}
