package repository;

import model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialyRepository extends JpaRepository<Specialty,Integer> {
}
