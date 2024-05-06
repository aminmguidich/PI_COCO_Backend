package tn.esprit.backendpi.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderDto {
    Long idCommand;
    String description;
    Float price;
    LocalDate dateCommand;
    private String status;
    private  int quantite;
     private String title;
     private String username;
     private  Long tel;
     private  String adress;
     private String adresss;
}
