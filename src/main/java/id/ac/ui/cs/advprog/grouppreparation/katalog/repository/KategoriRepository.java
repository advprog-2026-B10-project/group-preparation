package id.ac.ui.cs.advprog.grouppreparation.katalog.repository;

import id.ac.ui.cs.advprog.grouppreparation.katalog.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori, Long> {
    List<Kategori> findByParentIsNull();
}
