package tn.esprit.backendpi.Service.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.backendpi.Entities.FileDB;
import tn.esprit.backendpi.Repository.FileDBRepository;

import java.io.IOException;
import java.util.Objects;

@Service
public class FileStorageService {
    @Autowired
    FileDBRepository fileDBRepository;

    //store a file (image)
    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileDB fileDb = new FileDB(fileName, file.getContentType(), file.getBytes());
        return fileDBRepository.save(fileDb);
    }
}
