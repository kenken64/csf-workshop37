package sg.edu.nus.iss.fileupload.server.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;



@Repository
public class FileUploadRepository {
    private static final String INSERT_POSTS_TBL = "INSERT INTO posts (blobc, title, complain) VALUES(?, ?, ?)";
    @Autowired
    private DataSource dataSource;


    public void uploadBlob(MultipartFile file, String title, String complain) 
            throws SQLException, IOException  {
        
        try (Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_POSTS_TBL)) {
            InputStream is = file.getInputStream();
            pstmt.setBinaryStream(1, is, file.getSize());
            pstmt.setString(2, title);
            pstmt.setString(3, complain);
            pstmt.executeUpdate();
        }
        
    }
}
