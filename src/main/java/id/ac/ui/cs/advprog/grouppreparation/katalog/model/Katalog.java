package id.ac.ui.cs.advprog.grouppreparation.katalog.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "katalog")
public class Katalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String judul;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    @Column(nullable = false)
    private Double hargaAwal;

    // Default constructor (wajib buat JPA)
    public Katalog() {}

    public Katalog(String judul, String deskripsi, Double hargaAwal) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.hargaAwal = hargaAwal;
    }

    // --- GETTERS & SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public Double getHargaAwal() { return hargaAwal; }
    public void setHargaAwal(Double hargaAwal) { this.hargaAwal = hargaAwal; }
}
