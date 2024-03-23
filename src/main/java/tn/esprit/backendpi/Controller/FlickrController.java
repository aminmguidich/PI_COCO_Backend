package tn.esprit.backendpi.Controller;

import com.flickr4java.flickr.FlickrException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Service.Interfaces.FlickrService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

@AllArgsConstructor
@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class FlickrController {
    FlickrService service;

 /*   @PostMapping("/savePhoto")
    public String uploadPhoto(@RequestParam("file") MultipartFile photoFile) {
        try {
            return service.uploadPhoto(convertToFile(photoFile));
        } catch (FlickrException e) {
            e.printStackTrace();
            return "Failed to upload photo to Flickr.";
        }
    }

    // Helper method to convert MultipartFile to File
    private File convertToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try {
            file.transferTo(convertedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertedFile;
    }
*/
 @PostMapping("/savePhoto")
 public String savePhoto(@RequestParam("file") MultipartFile photoFile, @RequestParam("title") String title) {
     try {
         InputStream photoInputStream = photoFile.getInputStream();

         return service.savePhoto(photoInputStream, title);
     } catch (Exception e) {
         e.printStackTrace();
         return "Failed to upload photo to Flickr.";
     }
 }
}
