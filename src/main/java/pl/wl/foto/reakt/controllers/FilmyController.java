package pl.wl.foto.reakt.controllers;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import pl.wl.foto.reakt.api.AllResources;
import pl.wl.foto.reakt.api.Wywolanie;
import pl.wl.foto.reakt.entity.Chemikalia;
import pl.wl.foto.reakt.entity.Filmy;
import pl.wl.foto.reakt.entity.Producent;
import pl.wl.foto.reakt.entity.Wywolania;
import pl.wl.foto.reakt.repository.WywolaniaRepository;
import pl.wl.foto.reakt.services.ResourceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/foto")
public class FilmyController {

    @Autowired
    ResourceService resourceController;

    @Autowired
    WywolaniaRepository wywolaniaRepository;

    @Value("${foto.path}")
    public String fotopath;

    @Value("${foto.dir}")
    public String fotodir;


    @RequestMapping(value = "/resource", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getResources() {
        AllResources allResources = resourceController.getAllResources();
        return new ResponseEntity<>(allResources, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/wywolanie", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> saveItem(@RequestBody Wywolanie wywolanie) {
        System.out.println("  saveItem   wywolanie = " + wywolanie);
        resourceController.saveWywolanie(wywolanie);
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:3000");
//        responseHeaders.set("Access-Control-Allow-Methods"," GET, POST, HEAD, OPTIONS, PUT, DELETE, PATCH");
        return new ResponseEntity(HttpStatus.OK);
    }


//    @RequestMapping(value = "/filmy/w", method = RequestMethod.GET, produces = "application/json")
//    public ResponseEntity<?> getWywolanie(@RequestParam Integer id) {
//        Optional<Wywolania> w = wywolaniaRepository.findById(id);
//        return new ResponseEntity(w.get(), HttpStatus.OK);
//    }


    //========================================================

    //https://www.baeldung.com/spring-response-header
    //Access-Control-Allow-Origin: *

    // @CrossOrigin(origins = "http://localhost:8000")

    /**
     * Lista producentów filmów i chemii
     */
    @RequestMapping(value = "/producenci", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getResourcesProducenci() {
        List<Producent> list = resourceController.getProducenci();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Methods", " GET, POST, HEAD, OPTIONS, PUT, DELETE, PATCH");
        return new ResponseEntity<>(list, responseHeaders, HttpStatus.OK);
    }


    /**
     * 2	GET
     * /foto/filmy
     * Producent
     * Lista filmów wg producenta
     */
    @RequestMapping(value = "/filmy", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getResoucesFilmy(@RequestParam Integer id) {
        List<Filmy> list = resourceController.getFilmyByProducent(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Methods", " GET, POST, HEAD, OPTIONS, PUT, DELETE, PATCH");
        return new ResponseEntity<>(list, responseHeaders, HttpStatus.OK);
    }

    /**
     * 2	GET
     * /foto/filmy
     * Producent
     * Lista wszystkich filmów
     */
    @RequestMapping(value = "/filmy/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getResoucesFilmy() {
        List<Filmy> list = resourceController.getFilmyAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(list, responseHeaders, HttpStatus.OK);
    }

    /**
     * 3	GET
     * /foto/chemia
     * Producent
     * Lista chemikaliów wg producenta
     */
    @RequestMapping(value = "/chemia", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getResourcesChemia(@RequestParam Integer id) {
        List<Chemikalia> list = resourceController.getChemikaliaByProducent(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(list, responseHeaders, HttpStatus.OK);

    }

    /**
     * 4	POST
     * /foto/wywolanie
     * Film, chemia, czas, rozcieńczenie, ASA
     * Zapis wywolanie filmu
     */
//    @RequestMapping(value ="/wywolanie", method = RequestMethod.POST, produces =  "application/json")
//    public ResponseEntity<?>


    /**
     * 5	GET
     * /foto/wywolanie
     * Film, chemia, rozcieńczenie, ASA
     * Czas wywołania
     */
    @RequestMapping(value = "/wywolanie", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getWywolanie(@RequestParam String asa, @RequestParam String roz, @RequestParam String film, @RequestParam String chemia) {
        System.out.println("==============  wywolanie : asa " + asa + "  roz " + roz + "   film " + film + " chemia " + chemia);
//if(asa != null && roz!=null && fil)
        Wywolanie w = resourceController.getWywolanie(Integer.parseInt(asa), Integer.parseInt(roz), Integer.parseInt(film), Integer.parseInt(chemia));
        System.out.println("==============  wywolanie : " + w);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(w, responseHeaders, HttpStatus.OK);
    }


    /**
     * 6	GET
     * /foto/wywolanie
     * Id
     * Lista linków do zdjęc
     */


    /**
     * @param katalog
     * @param foto
     * @param response
     * @param request
     * @throws IOException
     * @throws NullPointerException
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public @ResponseBody
    void getImage(
            @RequestParam("k") String katalog,
            @RequestParam("f") String foto,
            HttpServletResponse response,
            HttpServletRequest request) throws
            IOException, NullPointerException {
        System.out.println("================/image ==== k == f =========================");

        String path = fotodir + fotopath + katalog + File.separator + foto;
        System.out.println("path =" + path);
        File imageFile = new File(path);
        response.setContentType("image/jpeg");

        response.setHeader("Access-Control-Allow-Origin", "*");
        InputStream in = new FileInputStream(imageFile);
        IOUtils.copy(in, response.getOutputStream());
    }


    @RequestMapping(value = "photo", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getPhoto(@RequestParam("k") String katalog,
                                           @RequestParam("f") String foto
    ) throws IOException {
        System.out.println("================/photo ==== k == f =========================");

        String path = fotodir + fotopath + katalog + File.separator + foto;
        System.out.println("path =" + path);
        File imageFile = new File(path);
        // File imgPath = new File("D:\\test.jpg");

        byte[] image = Files.readAllBytes(imageFile.toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);
        headers.set("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }


    public String getOsFileSeparator() {
        String ret = "";
        ret = File.separator;
        ret = System.getProperty("file.separator");
        ret = String.valueOf(File.separatorChar);
        System.out.println("Current OS file separator = " + ret);
        String filePath = "test" + ret + "dev2qa.txt";
        System.out.println("filePath = " + filePath);
        return ret;
    }

}
