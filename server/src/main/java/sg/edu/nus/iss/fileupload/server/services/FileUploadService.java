package sg.edu.nus.iss.fileupload.server.services;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sg.edu.nus.iss.fileupload.server.repository.FileUploadRepository;

@Service
public class FileUploadService {
    @Autowired
    private FileUploadRepository flRepo;

    public void uploadBlob(MultipartFile file, String title, String complain) 
            throws SQLException, IOException  {
        flRepo.uploadBlob(file, title, complain);
    }
}
