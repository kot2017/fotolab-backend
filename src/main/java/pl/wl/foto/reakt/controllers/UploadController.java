package pl.wl.foto.reakt.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/foto")
@CrossOrigin(origins = "http://localhost:3000")
public class UploadController {

    @Value("${foto.path}")
    public String fotopath;

    @Value("${foto.dir}")
    public String fotodir;

    //Save the uploaded file to this folder
  //  private   String UPLOADED_FOLDER = fotodir + fotopath;        //"C://Temp//test//";


//
//    @PostMapping("/upload") // //new annotation since 4.3
//    public String singleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadStatus";
//        }
//
//        try {
//
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/uploadStatus";
//    }
//
//    @GetMapping("/uploadStatus")
//    public String uploadStatus() {
//        return "uploadStatus";
//    }




    @PostMapping("/upload")
    public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file, @RequestParam String katalog ) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = Paths.get(fotodir + fotopath    + File.separator+ katalog + File.separator+ fileName);
        System.out.println("files: "+ file.getName() + "  path: "+ path);
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName)
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);
    }




    @PostMapping("/multi-upload")
    public ResponseEntity multiUpload(@RequestParam("files") MultipartFile[] files, @RequestParam String katalog ) {
        System.out.println("files: "+ files.length + "  katalog: "+ katalog);
        List<Object> fileDownloadUrls = new ArrayList<>();
        Arrays.asList(files)
                .stream()
                .forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file, katalog).getBody()));
        return ResponseEntity.ok(fileDownloadUrls);
    }


    /*
    https://www.devglan.com/spring-boot/spring-boot-file-upload-download
    To save the uploaded file in the DB, we have a model class and we are using byte[] as a data type to save it in the DB.
    @Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String docName;

    @Column
    @Lob
    private byte[] file;

}
     */

    /*
    @PostMapping("/upload/db")
    public ResponseEntity uploadToDB(@RequestParam("file") MultipartFile file) {
        Document doc = new Document();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        doc.setDocName(fileName);
        try {
            doc.setFile(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        documentDao.save(doc);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName).path("/db")
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);
    }
    */



    /*
    Spring Boot File Download from Database

The below implementation only difers in the process of getting the file from databse rather then a file system.
     */

    /*
    @GetMapping("/download/{fileName:.+}/db")
    public ResponseEntity downloadFromDB(@PathVariable String fileName) {
        Document document = documentDao.findByDocName(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(document.getFile());
    }
    */

}