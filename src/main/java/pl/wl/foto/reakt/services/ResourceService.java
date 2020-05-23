package pl.wl.foto.reakt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.wl.foto.reakt.api.AllResources;
import pl.wl.foto.reakt.api.Wywolanie;
import pl.wl.foto.reakt.entity.*;
import pl.wl.foto.reakt.repository.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import pl.wl.foto.reakt.entity.Filmy;


@Service
public class ResourceService {

    @Autowired
    FilmyRepository filmyRepository;

    @Autowired
    ChemikaliaRepository chemikaliaRepository;

    @Autowired
    WywolaniaRepository wywolaniaRepository;

    @Autowired
    ProducentRepository producentRepository;

    @Autowired
    ObiektywyRepository obiektywyRepository;

    @Autowired
    AparatyRepository aparatyRepository;


    @Value("${foto.path}")
    public String fotopath;


    @Value("${foto.dir}")
    public String fotodir;


    public AllResources getAllResources() {
        AllResources allResources = new AllResources();
        List<Filmy> filmy = (List<Filmy>) filmyRepository.findAll();
        List<Chemikalia> chemikalia = (List<Chemikalia>) chemikaliaRepository.findAll();
        allResources.setFilmy(filmy);
        allResources.setChemikalia(chemikalia);

        List<Producent> producent = (List<Producent>) producentRepository.findAll();
        allResources.setProducenci(producent);

        List<Aparaty> aparaty = (List<Aparaty>) aparatyRepository.findAll();
        allResources.setAparaty(aparaty);

        List<Obiektywy> obiektywy = (List<Obiektywy>) obiektywyRepository.findAll();
        allResources.setObiektywy(obiektywy);
        return allResources;
    }


    public List<Producent> getProducenci() {
        List<Producent> producent = (List<Producent>) producentRepository.findAll();
        return producent;
    }

    public Wywolania getWywolania(Integer id) {
        Optional<Wywolania> w = wywolaniaRepository.findById(id);
        return w.get();
    }

    public void saveWywolanie(Wywolanie wywolanie) {
        System.out.println("saveWywolanie   asa=" + wywolanie.getAsa());
        Wywolania w = new Wywolania();
        w.setAsa(wywolanie.getAsa());
        Optional<Chemikalia> chemikalia = chemikaliaRepository.findById(wywolanie.getChemikaliaId());
        w.setChemikaliaByChemikalia(chemikalia.get());
        Optional<Filmy> film = filmyRepository.findById(wywolanie.getFilmId());
        w.setFilmyByFilmy(film.get());
        w.setCzasWolania(wywolanie.getCzasWolania());
        // w.setData(wywolanie.getData());
        w.setKatalog(wywolanie.getKatalog());
        w.setRezultat(wywolanie.getRezultat());
        w.setRozcienczenie(Integer.parseInt(wywolanie.getRozcienczenie()));
        w.setUwagi(wywolanie.getUwagi());
        w.setNumerNegatywu(wywolanie.getNumerNegatywu());

        wywolaniaRepository.save(w);
        createDirectory(wywolanie.getKatalog());
    }


    private void createDirectory(String pathName) {
        System.out.println("pathane= " + pathName);
        String dirName = fotodir + fotopath + pathName;
        Path path = Paths.get(dirName);
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            System.err.println("Cannot create directories - " + e);
        }
        System.out.println("dirName = " + dirName);
    }


    /**
     * filmy wg producenta
     *
     * @param id
     * @return
     */
    public List<Filmy> getFilmyByProducent(Integer id) {
        List<Filmy> filmy = filmyRepository.findFilmyByProducent(id);
        return filmy;
    }


    /**
     * filmy wg producenta
     *
     * @return
     */
    public List<Filmy> getFilmyAll() {
        List<Filmy> filmy = (List<Filmy>) filmyRepository.findAll();
        return filmy;
    }


    public List<Chemikalia> getChemikaliaByProducent(Integer id) {
        List<Chemikalia> list = chemikaliaRepository.findChemikaliaByProducent(id);
        return list;
    }


    /**
     * wywolanie filmu wg parametrtrów
     *
     * @param ASA
     * @param rozcienczenie
     * @param filmId
     * @param chemikaliaId
     * @return
     */
    public Wywolanie getWywolanie(Integer ASA, Integer rozcienczenie, Integer filmId, Integer chemikaliaId) {
        Wywolanie w = new Wywolanie();

        Optional<Filmy> film = filmyRepository.findById(filmId);
        Optional<Chemikalia> chemikalia = chemikaliaRepository.findById(chemikaliaId);

        Wywolania q = wywolaniaRepository.findFirstByAsaAndAndRozcienczenieAndFilmyByFilmyAndChemikaliaByChemikalia(
                ASA, rozcienczenie, film.get(), chemikalia.get());

        Integer idChem = chemikalia.get().getProducent();
        Optional<Producent> prodChem = producentRepository.findById(idChem);

        Integer idFilm = film.get().getProducent();
        Optional<Producent> prodFilm = producentRepository.findById(idFilm);


        if (q != null) {
            List<String> images = getImageList(q.getKatalog());
            w.setImages(images);

            w.setId(q.getId());
            w.setAsa(q.getAsa());
            w.setRozcienczenie("1 do " + q.getRozcienczenie());
            w.setCzasWolania(q.getCzasWolania());
            w.setData(q.getData());
            w.setKatalog(q.getKatalog());
            w.setNumerNegatywu(q.getNumerNegatywu());
            w.setRezultat(q.getRezultat());
            w.setUwagi(q.getUwagi());
            w.setFilmName(prodFilm.get().getNazwa() + "  " + film.get().getNazwa() +
                    "  czułość nominalna: " + film.get().getNominalAsa() + " ASA" +
                    " naświetlony jak: " + w.getAsa() + " ASA"
            );
            w.setChemiaName(prodChem.get().getNazwa() + "  " + chemikalia.get().getNazwa());

        }

        return w;
    }


    /**
     * zwraca listę nazw plikow ze zdjęciami dla podanego wywołania
     * asset\images\Fuji400\
     * <p>
     * 100ASA\   100 "ASA"
     * <p>
     * Ultrafin\
     * <p>
     * 1do20\	"1do"  20
     * <p>
     * 20min   20  "min"
     *
     * @return
     */
    private List<String> getImageList(String katalog) {
        List<String> imageList = new ArrayList<>();
        System.out.println("fotopath = " + fotopath);
        System.out.println("katalog = " + katalog);


        // String path = fotopath + "/" + katalog;
        String path = fotodir + fotopath + katalog;

        System.out.println("path = " + path);

        String[] pathnames;
        File f = new File(path);
        pathnames = f.list();
        if (pathnames != null && pathnames.length > 0) {
            for (String p : pathnames
            ) {
                System.out.println("p = " + p);
                imageList.add(p);
            }
        } else {
            System.out.println(" NIE ODCZYTANO KATALOGU " + path);
        }
        return imageList;
    }


}
