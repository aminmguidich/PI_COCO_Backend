package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import tn.esprit.backendpi.Entities.Product;
import tn.esprit.backendpi.Repository.ProductRepository;
import tn.esprit.backendpi.Service.Interfaces.IProductService;





import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements IProductService {

    private final ProductRepository ProductRepo;


    @Override
    public Product addProduct(Product product) {
        return ProductRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return ProductRepo.save(product);
    }

    @Override
    public void removeProduct(long idProduct) {
        ProductRepo.deleteById(idProduct);

    }

    @Override
    public List<Product> retrieveProducts() {
        return (List<Product>) ProductRepo.findAll();
    }

    @Override
    public Product retrieveProduct(long idProduct) {
        return ProductRepo.findById(idProduct).orElse(null);
    }
}