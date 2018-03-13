package uam.admision.pagos.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import uam.admision.pagos.Model.PagosEntity;
import uam.admision.pagos.Repository.PagosEntityRepository;

@Service
public class PagosEntityService {

    private static final Logger log = LoggerFactory.getLogger(PagosEntity.class);


    @Autowired
    PagosEntityRepository pagosEntityRepository;

    Boolean guardaPagos(PagosEntity pagosEntity){

        try {
            pagosEntityRepository.save(pagosEntity);
        } catch (DataAccessException e) {
            log.error("No se pudo escribir registro:"+pagosEntity.toString());
            e.printStackTrace();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
