package com.hardhwpc.backend.repositories;


import com.hardhwpc.backend.entities.Product;
import org.hibernate.LockMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.math.BigInteger;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger> {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findBySerialnumber(String serialnumber);
    List<Product> findByProductcode(String productcode);
    List<Product> findAll();
    @Override
    @Lock(value = LockModeType.WRITE)
    <S extends Product> S save(S entity);
    Product findProductById(BigInteger id);
    boolean existsProductsBySerialnumber(String serialnumber);
    @Query( "select true from Product p where p.productcode = ?1 " )
    boolean existsByProductcode(String productcode);
    List<Product> findByDescription(String description);

}
