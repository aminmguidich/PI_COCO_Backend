package tn.esprit.backendpi.Service.Interfaces;



import tn.esprit.backendpi.Entities.Product;


import java.util.List;

public interface IProductService {


    Product addProduct (Product product);
    Product updateProduct (Product product);
    void removeProduct (long idProduct);
    List<Product> retrieveProducts ();
    Product retrieveProduct (long idProduct);
    //public Product addProduct(String description, String title, String categorie, MultipartFile multipartFile) throws IOException  ;
   // byte[] getPhotoAccomndation(Long id);
}
