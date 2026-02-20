package id.ac.ui.cs.advprog.grouppreparation.katalog.controller;

import id.ac.ui.cs.advprog.grouppreparation.katalog.model.Katalog;
import id.ac.ui.cs.advprog.grouppreparation.katalog.service.KatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/katalog")
@CrossOrigin(origins = "*") // Penting banget biar Next.js bisa nge-fetch tanpa error CORS
public class KatalogController {

    private final KatalogService katalogService;

    @Autowired
    public KatalogController(KatalogService katalogService) {
        this.katalogService = katalogService;
    }

    @GetMapping
    public ResponseEntity<List<Katalog>> getAllKatalog() {
        return ResponseEntity.ok(katalogService.getAllKatalog());
    }
}