package uam.admision.pagos.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uam.admision.pagos.Model.PagosEntity;
import uam.admision.pagos.Model.PagosEntrada;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class MapPagos {
    private static final Logger log = LoggerFactory.getLogger(MapPagos.class);
    private static Integer MAXERRORES = 50;

    public PagosEntity mapColumnasPagos(PagosEntrada pagosEntrada) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            PagosEntity pagosEntity = null;
            pagosEntity.setPersonalCl(pagosEntrada.getPersonal_cl());
            System.out.println(pagosEntity.getPersonalCl());
            pagosEntity.setPagoFe(LocalDate.parse(pagosEntrada.getPago_fe(), formatter));
            System.out.println(pagosEntity.getPagoFe());
            return pagosEntity;
        }


    public Boolean mapToPagosRevisa(List<PagosEntrada> listaPagos) {

        Boolean erroresEnMap = Boolean.FALSE;

        for (int i = 0; i < listaPagos.size(); i++) {
            PagosEntrada pagosEntrada = listaPagos.get(i);
            System.out.println(pagosEntrada.toString());

            try {
                PagosEntity pagosEntity = this.mapColumnasPagos(pagosEntrada);
            } catch (ParseException | NullPointerException e) {
                log.warn("Error en línea " + (i+1));
                e.printStackTrace();
            }

        }
        return erroresEnMap;

    }

    public Boolean mapToPagosGuarda(List<PagosEntrada> listaPagos) {

        Boolean erroresEnMap = Boolean.FALSE;

        PagosEntity pagos = null;

        for (int i = 0; i < listaPagos.size(); i++) {
            PagosEntrada pagosEntrada = listaPagos.get(i);
            System.out.println(pagosEntrada.toString());
        }

        return erroresEnMap;

    }
}
