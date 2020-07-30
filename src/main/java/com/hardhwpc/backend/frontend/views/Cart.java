package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.entities.ProductCart;
import com.hardhwpc.backend.frontend.main.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

/**
 * A Designer generated component for the cart-dialog template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("cart-dialog")
@JsModule("./src/views/cart-dialog.js")
public class Cart extends PolymerTemplate<Cart.CartDialogModel> {
    Button cartButton;
    Dialog dialogCart;
    MainView puntatoreMainView;
    //ArrayList<ProductCart>carrello;
    //Per Ogni Prodotto Quantità,Totale
    Map<Product,Tuple<Integer,Double>>cartmap;
    ArrayList<Product>carrellobackend;
    @Id("totalecart")
    private TextField totalecart;
    @Id("svuota")
    private Button svuota;
    @Id("chiudi")
    private Button chiudi;
    @Id("ordina")
    private Button ordina;
    @Id("elimina")
    private Button elimina;
    TextField totmainview;
    TextField noggettimainview;
    @Id("productsGrid")
    private Grid<Product> productsGrid;


    /**
     * Creates a new CartDialog.
     */

    public Cart() {
        // You can initialise any data required for the connected UI components here.
        dialogCart=new Dialog();
        cartmap=new HashMap<Product, Tuple<Integer,Double>>();
        //carrello=new ArrayList<>();
        carrellobackend=new ArrayList<>();
        productsGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        productsGrid.addColumn(Product::getName).setHeader("Nome");
        productsGrid.addColumn(Product::getPrice).setHeader("Prezzo");
        productsGrid.addColumn(Product::getProductcode).setHeader("Codice Prodotto");


        this.chiudi.addClickListener(buttonClickEvent -> {
            dialogCart.close();
        });
        this.ordina.addClickListener(buttonClickEvent -> {
            if(carrellobackend.size()>0) {
                dialogCart.close();
                puntatoreMainView.ordina(carrellobackend);
            }

        });
        this.elimina.addClickListener(buttonClickEvent -> {
                List<Product> eliminare = new ArrayList<>();
                for (Product p : productsGrid.getSelectedItems()){
                    eliminare.add(p);
                }
                this.elimina(eliminare);
        });
        this.svuota.addClickListener(buttonClickEvent -> {
            List<Product> eliminare= carrellobackend;
            this.elimina(new ArrayList<>(eliminare));
        });
    }



    public void setCartbutton(Button cartbutton) {
        cartButton=cartbutton;
        cartButton.addClickListener(buttonClickEvent -> {

            dialogCart.setDraggable(true);
            dialogCart.setCloseOnOutsideClick(true);
            dialogCart.setWidth("600px");
            dialogCart.setHeight("700px");
            dialogCart.add(this);
            dialogCart.open();
        });
    }

    public void aggiungi(Product p, int quantità){
        Boolean giapresente=false;
        for(int i=0;i<quantità;i++){
            carrellobackend.add(p);
        }
        int quantita = 0;
        double nuovototale;
        if(cartmap.containsKey(p)) {
            quantita = cartmap.get(p).getX() + quantità;
            nuovototale = p.getPrice() * quantita;
            cartmap.remove(p);
        }else{
            quantita=quantità;
            nuovototale = p.getPrice() * quantita;
        }


        Tuple nuova=new Tuple<>(quantita,nuovototale);
        cartmap.put(p,nuova);
        productsGrid.setItems(carrellobackend);
        aggiornatotale();
    }

    private void aggiornatotale() {
        Double totalecart = 0.0;
        for (Product pc :new HashSet<>(carrellobackend)){
            totalecart+=cartmap.get(pc).getY();
        }
        this.totalecart.setValue(String.valueOf(totalecart));
        totmainview.setValue(String.valueOf(totalecart));
        String oggetto;
        if (carrellobackend.size()==1)oggetto="Oggetto";else oggetto="Oggetti";
        noggettimainview.setValue(String.valueOf(carrellobackend.size()+" "+oggetto+" nel carrello"));
    }

    private void elimina(List<Product> eliminare) {
        for(Product p : eliminare){
            int quantita = 0;
            double nuovototale=0;
            Tuple nuova=new Tuple<>(quantita,nuovototale);
            cartmap.remove(p);
            cartmap.put(p,nuova);
        }
        carrellobackend.removeAll(eliminare);
        productsGrid.setItems(carrellobackend);
        aggiornatotale();
    }
    private void elimina(Product elemento){
        int quantita= cartmap.get(elemento).getX()-1;
        double totale = cartmap.get(elemento).getY();
        double nuovototale=totale-elemento.getPrice();
        Tuple nuova=new Tuple<>(quantita,nuovototale);
        cartmap.remove(elemento);
        cartmap.put(elemento,nuova);
        carrellobackend.remove(elemento);
        productsGrid.setItems(carrellobackend);
        aggiornatotale();
    }

    public void setRef(MainView mainView) {
        puntatoreMainView=mainView;
    }

    public void setTotTextVew(TextField totalecarrello) {
        totmainview=totalecarrello;
    }

    public void setNoggetti(TextField nogetticarello) {
        noggettimainview=nogetticarello;
    }

    /**
     * This model binds properties between CartDialog and cart-dialog
     */
    public interface CartDialogModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

 }

 class Tuple<X, Y> {
    public X x;
    public  Y y;
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
    public X getX(){
        return x;
    }

     public Y getY() {
         return y;
     }
     public void setX(X x){
        this.x=x;
     }
     public void  setY(Y y){
        this.y=y;
     }
 }