package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.frontend.main.MainView;
import com.hardhwpc.backend.services.ProductService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.List;


/**
 * A Designer generated component for the all-products template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("all-products")
@JsModule("./src/views/all-products.js")

public class AllProducts extends PolymerTemplate<AllProducts.AllProductsModel> {


    private ProductService productService;
    int nelementiriga=4;
    @Id("orderbox")
    private ComboBox<String> orderbox;
    @Id("ordertype")
    private ComboBox<String> ordertype;
    List<String> ordertypeitems=new ArrayList<String>();
    List<String> orderboxitems=new ArrayList<String>();
    @Id("productsGrid")
    private VerticalLayout productsGrid;
    private MainView puntatoreMainView;
    final static int pagesize=12;
    int currentpage=0;
    @Id("backbutton")
    private Button backbutton;
    @Id("forwardbutton")
    private Button forwardbutton;
    boolean nomorecontent=false;
    private TextField filter;
    private Boolean havetorefinetheresearch=false;


    /**
     * Creates a new AllProducts.
     */
    @Autowired
    public AllProducts(ProductService productService) {
        this.productService=productService;
        initcomboboxs();
        backbutton.addClickListener(buttonClickEvent -> {
            if(currentpage==0)return;
            previouspage();
            popola();
        });
        forwardbutton.addClickListener(buttonClickEvent -> {
            nextpage();
            popola();
            if(nomorecontent){currentpage--;return;}

        });
        ordertype.addValueChangeListener(comboBoxStringComponentValueChangeEvent -> {
            popola();
        });
        orderbox.addValueChangeListener(comboBoxStringComponentValueChangeEvent ->{
            popola();
        });

    }



    @PostConstruct
    void popola(){
        List<Component>prodotti=composer();
        if(nomorecontent)return;
        productsGrid.removeAll();
        //inizializzazione dei combobox
         int index=0;
         HorizontalLayout puntatore=new HorizontalLayout();
         for(Component c: prodotti) {
             if(index==nelementiriga-1){
                 productsGrid.add(puntatore);
                 puntatore=new HorizontalLayout();
                 index=0;
             }

             puntatore.add(c);
             index++;
         }if (index!=0){
             productsGrid.add(puntatore);
        }

    }

    private List<Component> composer() {
        List<Product>catalogo=new ArrayList<>();
        if(!havetorefinetheresearch) {
            if (orderbox.getValue() == "Nome" && ordertype.getValue() == "Crescente") {
                catalogo = productService.showAllProducts(currentpage, pagesize, "name", "ascending");
            } else if (orderbox.getValue() == "Nome" && ordertype.getValue() == "Decrescente") {
                catalogo = productService.showAllProducts(currentpage, pagesize, "name", "descending");
            } else if (ordertype.getValue() == "Crescente") {
                catalogo = productService.showAllProducts(currentpage, pagesize, "price", "ascending");
            } else {
                catalogo = productService.showAllProducts(currentpage, pagesize, "price", "descending");
            }
            if (catalogo.size() == 0){ nomorecontent = true;}else{ nomorecontent = false;}
        }else if(havetorefinetheresearch){
            catalogo=productService.showProductsByName(filter.getValue());
        }
        List<Component> prodotti = new ArrayList<>();
        for(Product p : catalogo){
            prodotti.add(mappa(p));
        }
        return prodotti;
    }



    private int nextpage() {
        currentpage++;
        return  currentpage;
    }
    private int previouspage(){
        if(currentpage==0)return 0;
        currentpage--;
        return currentpage;
    }

    private GridproductItem mappa(Product p) {

        GridproductItem item =new GridproductItem();
        item.setImg(p.getImg());
        item.setName(p.getName());
        item.setRef(puntatoreMainView);
        item.setProductprice(p.getPrice());
        StringBuilder sb = new StringBuilder(p.getDescription());
        String description;
        if(sb.length()>=150){
            description=sb.substring(0,150);
        }else{
            description=sb.substring(0, sb.length());
        }
        item.setDescription(  description +"...");
        item.getLayout().addClickListener(event -> {
            ProductDialog pd=new ProductDialog();
            pd.mostra(p);
            pd.setRef(puntatoreMainView);
        });
        return item;
    }

    private void initcomboboxs(){

        ordertypeitems.add("Crescente");
        ordertypeitems.add("Decrescente");
        ordertype.setItems(ordertypeitems);
        ordertype.setValue("Crescente");
        orderboxitems.add("Nome");
        orderboxitems.add("Prezzo");
        orderbox.setItems(orderboxitems);
        orderbox.setValue("Nome");
    }

    private void cambiaversoordine() {
    }

    private void riordina() {
    }

    public void setRef(MainView mainView) {
        this.puntatoreMainView=mainView;
    }



    public void manageReseach(TextField filter) {
        this.filter=filter;
        filter.addValueChangeListener(textFieldStringComponentValueChangeEvent -> {
            if(!filter.getValue().isEmpty()){
                havetorefinetheresearch=true;
            }else{
                havetorefinetheresearch=false;
            }
            popola();
        });
    }

    /**
     * This model binds properties between AllProducts and all-products
     */
    public interface AllProductsModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
