package uam.admision.pagos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uam.admision.pagos.Model.PagosEntity;

public interface PagosEntityRepository extends JpaRepository<PagosEntity, Integer>{
}
