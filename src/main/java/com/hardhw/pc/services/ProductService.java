package com.hardhw.pc.services;


import com.hardhw.pc.entities.Product;
import com.hardhw.pc.repositories.ProductRepository;
import com.hardhw.pc.support.exceptions.ProductExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = false)
    public void addProduct(Product product) throws ProductExistException{
        if ( product.getProductcodebar() != null && productRepository.existsByProductCode(product.getProductcodebar()) ) {
            throw new ProductExistException();
        }
            productRepository.save(product);
    }
    @Transactional(readOnly = true)
    public List<Product> showProductsByProductCodeBar(String productbarcode) {
        return productRepository.findBySerialnumber(productbarcode);
    }
    @Transactional(readOnly = true)
    public List<Product> showProductsBySerialNumber(String serialnumber) {
        return productRepository.findBySerialnumber(serialnumber);
    }
    @Transactional(readOnly = true)
    public List<Product> showProductsByName(String name) {
        return productRepository.findByNameContainingAndIgnoreCase(name);
    }
    @Transactional(readOnly = true)
    public List<Product> showAllProducts() {
        return productRepository.findAll();
    }
    @Transactional(readOnly = true)
    public List<Product> showAllProducts(int pageNumber, int pageSize, String sortBy) {
        Pageable paging =  PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Product> pagedResult = productRepository.findAll(paging);
        if ( pagedResult.hasContent() ) {
            return pagedResult.getContent();
        }
        else {
            return new ArrayList<>();
        }
    }


}
