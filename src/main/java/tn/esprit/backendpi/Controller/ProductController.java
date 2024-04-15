package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.backendpi.Entities.Email;
import tn.esprit.backendpi.Entities.Product;
import tn.esprit.backendpi.Entities.TypeStatus;
import tn.esprit.backendpi.Service.Classes.CategorieServiceImpl;
import tn.esprit.backendpi.Service.Classes.EmailService;
import tn.esprit.backendpi.Service.Interfaces.IProductService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Product")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    CategorieServiceImpl categorieService;
    public static String UPLOAD_DIRECTORY = "C:\\Users\\Lenovo\\Desktop\\pi_spring2\\Frentendv2\\COCO-ESPRIT\\COCO-ESPRIT\\src\\assets\\documents\\";

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Email request) {
        emailService.sendSimpleMessage(request.getTo(), request.getSubject(), request.getBody());
        return "Email sent successfully!";
    }
    @PostMapping("/addProduct")

    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PostMapping("/add")
    public Product addProduct2(@RequestParam("img") MultipartFile img, @RequestParam("description") String description, @RequestParam("price") float price, @RequestParam("title") String title, @RequestParam("status") String status, @RequestParam("categorie") Long idCategorie) throws IOException {
        Product pr = new Product();
        pr.setDescription(description);
        pr.setPrice(price);
        pr.setTitle(title);
        String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String fileName = currentDate + img.getOriginalFilename();
        pr.setImg(fileName);
        pr.setStatus(TypeStatus.valueOf(status));
        pr.setCategorie(categorieService.retrieveCategorie(idCategorie));
        byte[] bytes = img.getBytes();
        Path path = Paths.get(UPLOAD_DIRECTORY + fileName);
        Files.write(path, bytes);

        return productService.addProduct(pr);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @PutMapping("/updateProduct2")
    public Product updateProduct2(@RequestParam("id") Long id,
                                  @RequestParam(value = "img", required = false) MultipartFile img,
                                  @RequestParam("description") String description,
                                  @RequestParam("price") float price,
                                  @RequestParam("title") String title,
                                  @RequestParam("status") String status,
                                  @RequestParam("category") Long idCategory) throws IOException {
        Product pr = productService.retrieveProduct(id);
        pr.setDescription(description);
        pr.setPrice(price);
        pr.setTitle(title);
        pr.setStatus(TypeStatus.valueOf(status));
        pr.setCategorie(categorieService.retrieveCategorie(idCategory));

        if (img != null && !img.isEmpty()) {
            String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
            String fileName = currentDate + img.getOriginalFilename();
            pr.setImg(fileName);
            byte[] bytes = img.getBytes();
            Path path = Paths.get(UPLOAD_DIRECTORY + fileName);
            Files.write(path, bytes);
        }

        return productService.addProduct(pr);
    }


    @DeleteMapping("/removeProduct/{idProduct}")
    public void removeProduct(@PathVariable("idProduct") long idProduct) {
        productService.removeProduct(idProduct);
    }

    @GetMapping("/retrieveProduct")
    public List<Product> retrieveProducts() {
        return productService.retrieveProducts();
    }


    @GetMapping("/retrieveProduct/{idProduct}")
    public Product retrieveProduct(@PathVariable("idProduct") long idProduct) {
        return productService.retrieveProduct(idProduct);
    }

}