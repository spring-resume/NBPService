package pl.edu.pjwstk.nbpservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.nbpservice.model.Result;

@Repository
public interface NbpRepository extends JpaRepository<Result, Long> {
}
