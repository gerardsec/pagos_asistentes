package uam.admision.pagos.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import uam.admision.pagos.Model.PagosEntity;
import uam.admision.pagos.Model.PagosEntityPK;
import uam.admision.pagos.Repository.PagosEntityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PagosEntityService {

    private static final Logger log = LoggerFactory.getLogger(PagosEntity.class);


    @Autowired
    PagosEntityRepository pagosEntityRepository;

    Boolean guardaPagos(PagosEntity pagosEntity) {
        try {
            pagosEntityRepository.save(pagosEntity);
            pagosEntityRepository.
            log.warn("__ Registro guardado: "+pagosEntity.toString());
        } catch (DataAccessException e) {
            log.error("** ERROR No se pudo escribir registro:" + pagosEntity.toString());
            e.printStackTrace();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    Optional<PagosEntity> buscaPorId(PagosEntityPK pagosEntityPK) {
        Optional<PagosEntity> pagosEntity;
        try {
            pagosEntity = pagosEntityRepository.findById(pagosEntityPK);
        } catch (DataAccessException e) {
            log.error("Error al buscar por llave" + pagosEntityPK.toString());
            return null;
        }
        return pagosEntity;
    }
}
