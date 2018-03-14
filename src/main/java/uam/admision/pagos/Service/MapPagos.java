package uam.admision.pagos.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.admision.pagos.Model.PagosEntity;
import uam.admision.pagos.Model.PagosEntityPK;
import uam.admision.pagos.Model.PagosEntrada;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
            System.out.println("Pagos entrada: " + pagosEntrada.toString());

            try {
                PagosEntity pagosEntity = this.mapColumnasPagos(pagosEntrada);
                log.warn("--Map ok: ");
                pagosEntityList.add(pagosEntity);
            } catch (ParseException | NullPointerException e) {
                log.warn("** Error en línea " + (i + 1) + " Datos:" + pagosEntrada);
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
        PagosEntityPK llavePagos = new PagosEntityPK();

        for (int i = 0; i < listaPagosEntity.size(); i++) {

            //log.warn("formando llave compuesta, con: "+listaPagosEntity.get(i).getPagoFe()+" "+
            //        listaPagosEntity.get(i).getPersonalCl());
            PagosEntity pagosEntityGuardar = listaPagosEntity.get(i);
            //log.warn("pagosEntityGuardar:" + pagosEntityGuardar.toString());

            llavePagos.setPagoFe(pagosEntityGuardar.getPagoFe());
            llavePagos.setPersonalCl(pagosEntityGuardar.getPersonalCl());
            //log.warn("Antes dias equivalentes");
            pagosEntityGuardar.setDiasEquivalentes(pagosEntityGuardar.getHorasPagoNu() / (float) 8);

            pagosEntityGuardar.setCategoriaPago(pagosEntityGuardar.getCategoria2());
            //log.warn("despues get cat");
            pagosEntityGuardar.setDiasPagarNu(pagosEntityGuardar.getDiasPagoNu());
            //log.warn("despues dias pagar nu");
            pagosEntityGuardar.setDiferenciaNu(pagosEntityGuardar.getHorasPagoNu() - (pagosEntityGuardar.getDiasPagarNu() * (float) 8));
            //log.warn("despues get diferencia");
            if (pagosEntityGuardar.getExtrasAutorizadas() == null) {
                pagosEntityGuardar.setExtrasAutorizadas((float) 0);
            }
            if (pagosEntityGuardar.getCategoriaPago() == 1) {
                //log.warn("categoría 1:");
                pagosEntityGuardar.setPagoCantDias((float) pagosEntityGuardar.getDiasPagarNu() * (float) 215);
                //log.warn("categoría 1 pagocantdias:");
                pagosEntityGuardar.setPagoCantExtra(pagosEntityGuardar.getExtrasAutorizadas() * ((float) 215 / (float) 8));
                //log.warn("categoría 1: pagocantextra");
            } else {
                if (pagosEntityGuardar.getCategoriaPago() == 2) {
                    //log.warn("categoría 2:");
                    pagosEntityGuardar.setPagoCantDias((float) pagosEntityGuardar.getDiasPagarNu() * (float) 250);
                    pagosEntityGuardar.setPagoCantExtra(pagosEntityGuardar.getExtrasAutorizadas() * ((float) 250 / (float) 8));
                } else {
                    log.error("Categoría no definida " + pagosEntityGuardar.toString());
                }
            }
            //log.warn("sale catego:");
            pagosEntityGuardar.setPagoCantTotal(pagosEntityGuardar.getPagoCantDias() + pagosEntityGuardar.getPagoCantExtra());

            //log.warn("después formar llaves");
            Optional<PagosEntity> pagosEntity = pagosEntityService.buscaPorId(llavePagos);
            //log.warn("Después buscar llave compuesta:"+pagosEntity);
            if (pagosEntity.isPresent()) {
                log.warn("** AVISO. Registro ya existe. No se guardó: " + pagosEntity.get().toString());
                erroresNum++;
            } else {
                Boolean errorAlGuardar = pagosEntityService.guardaPagos(pagosEntityGuardar);
                if (errorAlGuardar == Boolean.TRUE) {
                    erroresNum++;
                }
            }
            if (erroresNum > 10) {
                log.error("Demasiados errores al guardar revise log");
                erroresGuardar = Boolean.TRUE;
                return erroresGuardar;
            }
        }
        return erroresGuardar;
    }
}

