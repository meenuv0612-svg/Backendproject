package com.project.glowweb.Service;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import com.project.glowweb.Entity.Product;
import com.project.glowweb.Repo.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    // CREATE
    public Product addProduct(Product product) {

        if (product.getId() == null || product.getId().isEmpty()) {
            product.setId(UUID.randomUUID().toString());
        }

        return productRepository.save(product);
    }


    // GET ALL
     public List<Product> getAllProducts() {


        return productRepository.findAll();        

     }


//      public List<Customerdetailsentity> getAllOrders() {

//     return crd.findAll(Sort.by(Sort.Direction.DESC,"amount"));

// }

    // GET BY ID
    public Product getProductById(String id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }


    // UPDATE
    public Product updateProduct(String id, Product product) {

        Product existingProduct =
                productRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Product not found"));


        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setOriginalPrice(product.getOriginalPrice());
        existingProduct.setDiscount(product.getDiscount());
        existingProduct.setStock(product.getStock());
        existingProduct.setImage(product.getImage());
        existingProduct.setShortDescription(product.getShortDescription());
        existingProduct.setRating(product.getRating());
        existingProduct.setReviews(product.getReviews());


        return productRepository.save(existingProduct);
    }


    // DELETE
    public void deleteProduct(String id) {

        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }

        productRepository.deleteById(id);
 
 
 
    }

  
}
