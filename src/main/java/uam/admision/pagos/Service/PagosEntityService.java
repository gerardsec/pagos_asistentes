package uam.admision.pagos.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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

    public Boolean guardaPagos(PagosEntity pagosEntity) {
        try {
            pagosEntityRepository.save(pagosEntity);

            log.warn("__ Registro guardado: "+pagosEntity.toString());
        } catch (DataAccessException e) {
            log.error("** ERROR No se pudo escribir registro:" + pagosEntity.toString());
            e.printStackTrace();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Optional<PagosEntity> buscaPorId(PagosEntityPK pagosEntityPK) {
        Optional<PagosEntity> pagosEntity;
        try {
            pagosEntity = pagosEntityRepository.findById(pagosEntityPK);
        } catch (DataAccessException e) {
            log.error("Error al buscar por llave" + pagosEntityPK.toString());
            return null;
        }
        return pagosEntity;
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = PagosEntityTransactionException.class)
    public Boolean actualizaPagos(PagosEntity pagosEntity) throws PagosEntityTransactionException {
        PagosEntityPK pagosEntityPK = new PagosEntityPK();
        pagosEntityPK.setPersonalCl(pagosEntity.getPersonalCl());
        pagosEntityPK.setPagoFe(pagosEntity.getPagoFe());
        Optional<PagosEntity> pagosEntityOptional = this.buscaPorId(pagosEntityPK);
        if (!pagosEntityOptional.isPresent()) {
            return Boolean.FALSE;
        }
        PagosEntity pagosEntityActualizar = pagosEntityOptional.get();
        pagosEntityActualizar.setGeneraPago(pagosEntity.getGeneraPago());
        pagosEntityActualizar.setTieneRfc(pagosEntity.getTieneRfc());
        pagosEntityActualizar.setTieneHorarios(pagosEntity.getTieneHorarios());
        pagosEntityActualizar.setTieneRetencion(pagosEntity.getTieneRetencion());
        pagosEntityActualizar.setPagoProcesado(pagosEntity.getPagoProcesado());
        pagosEntityActualizar.setObservaciones(pagosEntity.getObservaciones());
        pagosEntityActualizar.setEntregaRfcFe(pagosEntity.getEntregaRfcFe());
        pagosEntityActualizar.setCausaError(pagosEntity.getCausaError());
        log.warn(">>antes de actualizar:"+pagosEntity.toString());
        log.warn("Después de actualizar:"+pagosEntityActualizar.toString());
        return Boolean.TRUE;

    }
}
