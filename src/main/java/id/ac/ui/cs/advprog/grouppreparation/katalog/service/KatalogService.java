package id.ac.ui.cs.advprog.grouppreparation.katalog.service;

import id.ac.ui.cs.advprog.grouppreparation.katalog.model.Katalog;
import id.ac.ui.cs.advprog.grouppreparation.katalog.repository.KatalogRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class KatalogService {

    private final KatalogRepository katalogRepository;

    @Autowired
    public KatalogService(KatalogRepository katalogRepository) {
        this.katalogRepository = katalogRepository;
    }

    // Method ini otomatis jalan pas Spring Boot baru nyala
    @PostConstruct
    public void initDummyData() {
        if (katalogRepository.count() == 0) {
            List<Katalog> dummyData = Arrays.asList(
                    new Katalog("iPhone 15 Pro Bekas", "Kondisi 99% mulus, baterai health 95%", 15000000.0),
                    new Katalog("MacBook Air M2", "RAM 8GB, SSD 256GB, warna Midnight", 13500000.0),
                    new Katalog("Sony WH-1000XM5", "Headphone noise cancelling, lengkap dengan box", 4000000.0)
            );
            katalogRepository.saveAll(dummyData);
            System.out.println("Data dummy berhasil di-inject ke PostgreSQL!");
        }
    }

    // Method buat dipanggil Controller
    public List<Katalog> getAllKatalog() {
        return katalogRepository.findAll();
    }
}
