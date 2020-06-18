package com.pc.store.repositories;

import com.pc.store.entities.Product;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContainingAndIgnoreCase(String name);
    List<Product> findBySerialnumber(String serialnumber);
    List<Product> findByProductCode(String productcodebar);
    boolean existsBySerialNumber(String barCode);
    boolean existsByProductCode (String productcodebar);
    List<Product> findByDescription(String description);

}
