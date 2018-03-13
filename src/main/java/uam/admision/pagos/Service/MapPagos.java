package uam.admision.pagos.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.admision.pagos.Model.PagosEntity;
import uam.admision.pagos.Model.PagosEntrada;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class MapPagos {
    private static final Logger log = LoggerFactory.getLogger(MapPagos.class);
    private static Integer MAXERRORES = 50;

    @Autowired
    PagosEntityService pagosEntityService;

    public PagosEntity mapColumnasPagos(PagosEntrada pagosEntrada) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss.S");

        PagosEntity pagosEntity = new PagosEntity();
        //log.warn("setpersonal--->"+pagosEntrada.getPersonal_cl());
        pagosEntity.setPersonalCl(pagosEntrada.getPersonal_cl());
        System.out.println(pagosEntity.getPersonalCl());
        //log.warn("setpagofe--->");
        pagosEntity.setPagoFe(LocalDate.parse(pagosEntrada.getPago_fe(), formatter));
        System.out.println(pagosEntity.getPagoFe());
        pagosEntity.setMontoPagoNu(pagosEntrada.getMonto_pago_Nu());
        pagosEntity.setDiasPagoNu(pagosEntrada.getDias_pago_nu());
        pagosEntity.setFestivosNu(pagosEntrada.getFestivos_nu());
        pagosEntity.setHorasPagoNu(pagosEntrada.getHoras_pago_nu());
        pagosEntity.setHorasDobleNu(pagosEntrada.getHoras_doble_nu());
        pagosEntity.setPerPagoCl(pagosEntrada.getPer_pago_cl());
        pagosEntity.setIniPagoFe(LocalDate.parse(pagosEntrada.getIni_pago_fe(), formatter));
        pagosEntity.setFinPagoFe(LocalDate.parse(pagosEntrada.getFin_pago_fe(), formatter));
        pagosEntity.setApePatXx(pagosEntrada.getApe_pat_xx());
        pagosEntity.setApeMatXx(pagosEntrada.getApe_mat_xx());
        pagosEntity.setPersonalMNo(pagosEntrada.getPersonalMNo());
        pagosEntity.setRfcXx(pagosEntrada.getRfc_xx());
        pagosEntity.setContableNu(pagosEntrada.getContable_nu());
        pagosEntity.setJornadaMin(LocalDate.parse(pagosEntrada.getJornada_min(), formatterHour));
        pagosEntity.setJornadaMax(LocalDate.parse(pagosEntrada.getJornada_max(), formatterHour));
        pagosEntity.setPlazaCl1(pagosEntrada.getPlaza_cl1());
        pagosEntity.setPlazaCl2(pagosEntrada.getPlaza_cl2());
        pagosEntity.setCategoria1(pagosEntrada.getCategoria1());
        pagosEntity.setCategoria2(pagosEntrada.getCategoria2());
        pagosEntity.setPuesto1(pagosEntrada.getPuesto1());
        pagosEntity.setPuesto2(pagosEntrada.getPuesto2());
        pagosEntity.setPlantel1(pagosEntrada.getPlantel1());
        pagosEntity.setPlantel2(pagosEntrada.getPlantel2());

        return pagosEntity;
    }

    public List<PagosEntity> mapToPagosRevisa(List<PagosEntrada> listaPagos) {

        Boolean erroresEnMap = Boolean.FALSE;
        Integer erroresNum = 0;
        List<PagosEntity> pagosEntityList = new ArrayList<>();

        for (int i = 0; i < listaPagos.size(); i++) {
            PagosEntrada pagosEntrada = listaPagos.get(i);
            System.out.println(pagosEntrada.toString());

            try {
                PagosEntity pagosEntity = this.mapColumnasPagos(pagosEntrada);
                pagosEntityList.add(pagosEntity);
            } catch (ParseException | NullPointerException e ) {
                log.warn("Error en línea " + (i + 1)+" Datos:"+pagosEntrada);
                erroresNum++;
                //e.printStackTrace();
                if (erroresNum > 10) {
                    pagosEntityList = null;
                    return pagosEntityList;
                }
            }
        }

        return pagosEntityList;
    }

    public Boolean mapToPagosGuarda(List<PagosEntity> listaPagosEntity) {

        Boolean erroresGuardar = Boolean.FALSE;
        Integer erroresNum = 0;

        for (int i = 0; i < listaPagosEntity.size(); i++) {
            Boolean errorAlGuardar = pagosEntityService.guardaPagos(listaPagosEntity.get(i));
            if (errorAlGuardar == Boolean.TRUE){
                erroresNum++;
                if(erroresNum > 10) {
                    log.error("Demasiados errores al guardar");
                    erroresGuardar = Boolean.TRUE;
                    return erroresGuardar;
                }
            }
        }
        return erroresGuardar;
    }
}
