package com.hardhwpc.backend.services;

import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.repositories.ProductRepository;
import com.hardhwpc.backend.support.exceptions.ProductAlreadyExistException;
import com.hardhwpc.backend.support.exceptions.ProductExistException;
import com.hardhwpc.backend.support.exceptions.ProductQuantityFault;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.server.StreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = false)
    public void addProduct(Product product) throws ProductExistException {
        if ( product.getProductcode() != null && productRepository.existsByProductcode(product.getProductcode()) ) {
            throw new

                    ProductExistException();
        }
            productRepository.save(product);
    }
    @Transactional(readOnly = true)
    public List<Product> showProductsByProductCode(String productbarcode) {
        return productRepository.findByProductcode(productbarcode);
    }
    @Transactional
    public Image generateImage(Product product) {
        BigInteger id = product.getId();
        StreamResource sr = new StreamResource("product", () ->  {
            Product attached = productRepository.findProductById(id);
            return new ByteArrayInputStream(product.getImg2());
        });
        sr.setContentType("image/png");
        Image image = new Image(sr, "profile-picture");
        return image;
    }
    @Transactional(readOnly = true)
    public List<Product> showProductsBySerialNumber(String serialnumber) {
        return productRepository.findBySerialnumber(serialnumber);
    }
    @Transactional(readOnly = true)
    public List<Product> showProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    @Transactional(readOnly = true)
    public List<Product> showProductsByDescription(String description){
        return productRepository.findByDescription(description);
    }
    @Transactional(readOnly = true)
    public List<Product> showAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> showAllProductsByPriceAsc(){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,"price"));
    }
    @Transactional(readOnly = true)
    public List<Product> showAllProductsByNameAsc(){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
    }
    @Transactional(readOnly = true)
    public List<Product> showAllProductsByPriceDes(){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,"price"));
    }
    @Transactional(readOnly = true)
    public List<Product> showAllProductsByNameDes(){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
    }

    @Transactional(readOnly = true)
    public List<Product> showAllProducts(int pageNumber, int pageSize, String sortBy, String type) {
        Pageable paging;
        if(type.equalsIgnoreCase("ascending")) {
           paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        }else paging = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy).descending());
        Page<Product> pagedResult = productRepository.findAll(paging);
        if ( pagedResult.hasContent() ) {
            return pagedResult.getContent();
        }
        else {
            return new ArrayList<>();
        }
    }

    @Transactional(readOnly = false,rollbackFor = ProductQuantityFault.class,propagation = Propagation.REQUIRES_NEW)
    public void updateQuantity(List<Product> productsInOrder) throws ProductQuantityFault{
        for (Product p : productsInOrder) {
            if(p.getQuantita()>0) {
                p.setQuantita(p.getQuantita()-1);
                productRepository.save(p);
            }else{
                throw  new ProductQuantityFault();
            }
        }
    }
    @Transactional(readOnly = false)
    public void registerProduct(Product product) throws ProductAlreadyExistException {
    }
    @Transactional(readOnly = false)
    public Product updateProduct(BigInteger id, Product newProduct) {
        return null;
    }
    @Transactional(readOnly = false)
    public void delete(BigInteger id) {
        productRepository.deleteById(id);
    }
}
