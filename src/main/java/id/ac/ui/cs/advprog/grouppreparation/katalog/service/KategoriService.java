package id.ac.ui.cs.advprog.grouppreparation.katalog.service;

import id.ac.ui.cs.advprog.grouppreparation.katalog.model.Kategori;
import id.ac.ui.cs.advprog.grouppreparation.katalog.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KategoriService {

    private final KategoriRepository kategoriRepository;

    @Autowired
    public KategoriService(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    public Kategori createKategori(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    public List<Kategori> getHierarkiKategori() {
        return kategoriRepository.findByParentIsNull();
    }
}
