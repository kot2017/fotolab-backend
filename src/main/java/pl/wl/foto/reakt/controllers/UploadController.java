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


    @PostMapping("/upload")
    public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file, @RequestParam String katalog ) {
        if(file != null && katalog !=null) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path path = Paths.get(fotodir + fotopath + File.separator + katalog + File.separator + fileName);
            System.out.println("files: " + file.getName() + "  path: " + path);
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
        return (ResponseEntity) ResponseEntity.badRequest();
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





}