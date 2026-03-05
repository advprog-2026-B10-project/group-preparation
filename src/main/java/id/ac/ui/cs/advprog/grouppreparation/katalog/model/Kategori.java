package id.ac.ui.cs.advprog.grouppreparation.katalog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "kategori")
@Getter
@Setter
public class Kategori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Kategori parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Kategori> subKategori;

    public Kategori() {}

    public Kategori(String nama, Kategori parent) {
        this.nama = nama;
        this.parent = parent;
    }
}