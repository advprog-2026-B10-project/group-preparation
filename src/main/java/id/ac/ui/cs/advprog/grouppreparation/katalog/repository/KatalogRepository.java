package id.ac.ui.cs.advprog.grouppreparation.katalog.repository;

import id.ac.ui.cs.advprog.grouppreparation.katalog.model.Katalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KatalogRepository extends JpaRepository<Katalog, Long> {

}
