package uam.admision.pagos.Model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;
import uam.admision.pagos.Utils.LocalDateTimeConverter;

@Entity
@Table(name = "pagos", schema = "controlpagos", catalog = "")
@IdClass(PagosEntityPK.class)
public class PagosEntity {
    private String personalCl;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate pagoFe;
    private Float montoPagoNu;
    private Integer diasPagoNu;
    private Integer festivosNu;
    private Float horasPagoNu;
    private Float horasDobleNu;
    private Integer perPagoCl;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate iniPagoFe;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate finPagoFe;
    private String apePatXx;
    private String apeMatXx;
    private String personalMNo;
    private String rfcXx;
    private Integer contableNu;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate jornadaMin;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate jornadaMax;
    private Integer plazaCl1;
    private Integer plazaCl2;
    private Integer categoria1;
    private Integer categoria2;
    private String puesto1;
    private String puesto2;
    private String plantel1;
    private String plantel2;
    private Float diasEquivalentes;
    private Integer categoriaPago;
    private Integer diasPagarNu;
    private Float diferenciaNu;
    private Float extrasAutorizadas;
    private Float pagoCantDias;
    private Float pagoCantExtra;
    private Float pagoCantTotal;
    private Integer generaPago;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate generaPagoFe;
    private Integer tieneRfc;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate entregaRfcFe;
    private Integer tieneHorarios;
    private Integer tieneRetencion;
    private Integer pagoProcesado;
    private Integer pagoGenerado;
    private String observaciones;
    private String causaError;
    private String listaError;

    @Id
    @Column(name = "personal_cl", nullable = false, length = 45)
    @Size(min = 1,max = 10, message = "Longitud entre 1 y 10")
    public String getPersonalCl() {
        return personalCl;
    }
    public void setPersonalCl(String personalCl) {
        this.personalCl = personalCl;
    }
    @Id
    @Column(name = "pago_fe", nullable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    @PastOrPresent
    public LocalDate getPagoFe() {
        return pagoFe;
    }
    public void setPagoFe(LocalDate pagoFe) {
        this.pagoFe = pagoFe;
    }
    @Basic
    @Column(name = "monto_pago_nu", nullable = true, precision = 2)
    public Float getMontoPagoNu() {
        return montoPagoNu;
    }
    public void setMontoPagoNu(Float montoPagoNu) {
        this.montoPagoNu = montoPagoNu;
    }
    @Basic
    @Column(name = "dias_pago_nu", nullable = true)
    public Integer getDiasPagoNu() {
        return diasPagoNu;
    }
    public void setDiasPagoNu(Integer diasPagoNu) {
        this.diasPagoNu = diasPagoNu;
    }
    @Basic
    @Column(name = "festivos_nu", nullable = true)
    public Integer getFestivosNu() {
        return festivosNu;
    }

    public void setFestivosNu(Integer festivosNu) {
        this.festivosNu = festivosNu;
    }

    @Basic
    @Column(name = "horas_pago_nu", nullable = true, precision = 2)
    public Float getHorasPagoNu() {
        return horasPagoNu;
    }

    public void setHorasPagoNu(Float horasPagoNu) {
        this.horasPagoNu = horasPagoNu;
    }

    @Basic
    @Column(name = "horas_doble_nu", nullable = true, precision = 2)
    public Float getHorasDobleNu() {
        return horasDobleNu;
    }

    public void setHorasDobleNu(Float horasDobleNu) {
        this.horasDobleNu = horasDobleNu;
    }

    @Basic
    @Column(name = "per_pago_cl", nullable = true)
    public Integer getPerPagoCl() {
        return perPagoCl;
    }

    public void setPerPagoCl(Integer perPagoCl) {
        this.perPagoCl = perPagoCl;
    }

    @Basic
    @Column(name = "ini_pago_fe", nullable = true)
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDate getIniPagoFe() {
        return iniPagoFe;
    }

    public void setIniPagoFe(LocalDate iniPagoFe) {
        this.iniPagoFe = iniPagoFe;
    }

    @Basic
    @Column(name = "fin_pago_fe", nullable = true)
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDate getFinPagoFe() {
        return finPagoFe;
    }

    public void setFinPagoFe(LocalDate finPagoFe) {
        this.finPagoFe = finPagoFe;
    }

    @Basic
    @Column(name = "ape_pat_xx", nullable = true, length = 45)
    public String getApePatXx() {
        return apePatXx;
    }

    public void setApePatXx(String apePatXx) {
        this.apePatXx = apePatXx;
    }

    @Basic
    @Column(name = "ape_mat_xx", nullable = true, length = 45)
    public String getApeMatXx() {
        return apeMatXx;
    }

    public void setApeMatXx(String apeMatXx) {
        this.apeMatXx = apeMatXx;
    }

    @Basic
    @Column(name = "personal_m_no", nullable = true, length = 45)
    public String getPersonalMNo() {
        return personalMNo;
    }

    public void setPersonalMNo(String personalMNo) {
        this.personalMNo = personalMNo;
    }

    @Basic
    @Column(name = "rfc_xx", nullable = true, length = 45)
    public String getRfcXx() {
        return rfcXx;
    }

    public void setRfcXx(String rfcXx) {
        this.rfcXx = rfcXx;
    }

    @Basic
    @Column(name = "contable_nu", nullable = true)
    public Integer getContableNu() {
        return contableNu;
    }

    public void setContableNu(Integer contableNu) {
        this.contableNu = contableNu;
    }

    @Basic
    @Column(name = "jornada_min", nullable = true)
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDate getJornadaMin() {
        return jornadaMin;
    }

    public void setJornadaMin(LocalDate jornadaMin) {
        this.jornadaMin = jornadaMin;
    }

    @Basic
    @Column(name = "jornada_max", nullable = true)
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDate getJornadaMax() {
        return jornadaMax;
    }

    public void setJornadaMax(LocalDate jornadaMax) {
        this.jornadaMax = jornadaMax;
    }

    @Basic
    @Column(name = "plaza_cl_1", nullable = true)
    public Integer getPlazaCl1() {
        return plazaCl1;
    }

    public void setPlazaCl1(Integer plazaCl1) {
        this.plazaCl1 = plazaCl1;
    }

    @Basic
    @Column(name = "plaza_cl_2", nullable = true)
    public Integer getPlazaCl2() {
        return plazaCl2;
    }

    public void setPlazaCl2(Integer plazaCl2) {
        this.plazaCl2 = plazaCl2;
    }

    @Basic
    @Column(name = "categoria_1", nullable = true)
    public Integer getCategoria1() {
        return categoria1;
    }

    public void setCategoria1(Integer categoria1) {
        this.categoria1 = categoria1;
    }

    @Basic
    @Column(name = "categoria_2", nullable = true)
    public Integer getCategoria2() {
        return categoria2;
    }

    public void setCategoria2(Integer categoria2) {
        this.categoria2 = categoria2;
    }

    @Basic
    @Column(name = "puesto_1", nullable = true, length = 45)
    public String getPuesto1() {
        return puesto1;
    }

    public void setPuesto1(String puesto1) {
        this.puesto1 = puesto1;
    }

    @Basic
    @Column(name = "puesto_2", nullable = true, length = 45)
    public String getPuesto2() {
        return puesto2;
    }

    public void setPuesto2(String puesto2) {
        this.puesto2 = puesto2;
    }

    @Basic
    @Column(name = "plantel_1", nullable = true, length = 30)
    public String getPlantel1() {
        return plantel1;
    }

    public void setPlantel1(String plantel1) {
        this.plantel1 = plantel1;
    }

    @Basic
    @Column(name = "plantel_2", nullable = true, length = 30)
    public String getPlantel2() {
        return plantel2;
    }

    public void setPlantel2(String plantel2) {
        this.plantel2 = plantel2;
    }

    @Basic
    @Column(name = "dias_equivalentes", nullable = true, precision = 2)
    public Float getDiasEquivalentes() {
        return diasEquivalentes;
    }

    public void setDiasEquivalentes(Float diasEquivalentes) {
        this.diasEquivalentes = diasEquivalentes;
    }

    @Basic
    @Column(name = "categoria_pago", nullable = true)
    public Integer getCategoriaPago() {
        return categoriaPago;
    }

    public void setCategoriaPago(Integer categoriaPago) {
        this.categoriaPago = categoriaPago;
    }

    @Basic
    @Column(name = "dias_pagar_nu", nullable = true)
    public Integer getDiasPagarNu() {
        return diasPagarNu;
    }

    public void setDiasPagarNu(Integer diasPagarNu) {
        this.diasPagarNu = diasPagarNu;
    }

    @Basic
    @Column(name = "diferencia_nu", nullable = true, precision = 2)
    public Float getDiferenciaNu() {
        return diferenciaNu;
    }

    public void setDiferenciaNu(Float diferenciaNu) {
        this.diferenciaNu = diferenciaNu;
    }

    @Basic
    @Column(name = "extras_autorizadas", nullable = true, precision = 2)
    public Float getExtrasAutorizadas() {
        return extrasAutorizadas;
    }

    public void setExtrasAutorizadas(Float extrasAutorizadas) {
        this.extrasAutorizadas = extrasAutorizadas;
    }

    @Basic
    @Column(name = "pago_cant_dias", nullable = true, precision = 2)
    public Float getPagoCantDias() {
        return pagoCantDias;
    }

    public void setPagoCantDias(Float pagoCantDias) {
        this.pagoCantDias = pagoCantDias;
    }

    @Basic
    @Column(name = "pago_cant_extra", nullable = true, precision = 2)
    public Float getPagoCantExtra() {
        return pagoCantExtra;
    }

    public void setPagoCantExtra(Float pagoCantExtra) {
        this.pagoCantExtra = pagoCantExtra;
    }

    @Basic
    @Column(name = "pago_cant_total", nullable = true, precision = 2)
    public Float getPagoCantTotal() {
        return pagoCantTotal;
    }

    public void setPagoCantTotal(Float pagoCantTotal) {
        this.pagoCantTotal = pagoCantTotal;
    }

    @Basic
    @Column(name = "genera_pago", nullable = true)
    public Integer getGeneraPago() {
        return generaPago;
    }

    public void setGeneraPago(Integer generaPago) {
        this.generaPago = generaPago;
    }

    @Basic
    @Column(name = "tiene_rfc", nullable = true)
    public Integer getTieneRfc() {
        return tieneRfc;
    }

    public void setTieneRfc(Integer tieneRfc) {
        this.tieneRfc = tieneRfc;
    }

    @Basic
    @Column(name = "tiene_horarios", nullable = true)
    public Integer getTieneHorarios() {
        return tieneHorarios;
    }

    public void setTieneHorarios(Integer tieneHorarios) {
        this.tieneHorarios = tieneHorarios;
    }

    @Basic
    @Column(name = "tiene_retencion", nullable = true)
    public Integer getTieneRetencion() {
        return tieneRetencion;
    }

    public void setTieneRetencion(Integer tieneRetencion) {
        this.tieneRetencion = tieneRetencion;
    }

    @Basic
    @Column(name = "pago_procesado", nullable = true)
    public Integer getPagoProcesado() {
        return pagoProcesado;
    }

    public void setPagoProcesado(Integer pagoProcesado) {
        this.pagoProcesado = pagoProcesado;
    }

    @Basic
    @Column(name = "pago_generado", nullable = true)
    public Integer getPagoGenerado() {
        return pagoGenerado;
    }

    public void setPagoGenerado(Integer pagoGenerado) {
        this.pagoGenerado = pagoGenerado;
    }

    @Basic
    @Column(name = "observaciones", nullable = true, length = 250)
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Basic
    @Column(name = "causa_error", nullable = true, length = 250)
    public String getCausaError() {
        return causaError;
    }

    public void setCausaError(String causaError) {
        this.causaError = causaError;
    }

    @Basic
    @Column(name = "genera_pago_fe", nullable = true)
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDate getGeneraPagoFe() {
        return generaPagoFe;
    }

    public void setGeneraPagoFe(LocalDate generaPagoFe) {
        this.generaPagoFe = generaPagoFe;
    }

    @Basic
    @Column(name = "entrega_rfc_fe", nullable = true)
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDate getEntregaRfcFe() {
        return entregaRfcFe;
    }

    public void setEntregaRfcFe(LocalDate entregaRfcFe) {
        this.entregaRfcFe = entregaRfcFe;
    }

    public String getListaError() {
        return listaError;
    }

    public void setListaError(String listaError) {
        this.listaError = listaError;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagosEntity that = (PagosEntity) o;
        return Objects.equals(getPersonalCl(), that.getPersonalCl()) &&
                Objects.equals(getPagoFe(), that.getPagoFe()) &&
                Objects.equals(getMontoPagoNu(), that.getMontoPagoNu()) &&
                Objects.equals(getDiasPagoNu(), that.getDiasPagoNu()) &&
                Objects.equals(getFestivosNu(), that.getFestivosNu()) &&
                Objects.equals(getHorasPagoNu(), that.getHorasPagoNu()) &&
                Objects.equals(getHorasDobleNu(), that.getHorasDobleNu()) &&
                Objects.equals(getPerPagoCl(), that.getPerPagoCl()) &&
                Objects.equals(getIniPagoFe(), that.getIniPagoFe()) &&
                Objects.equals(getFinPagoFe(), that.getFinPagoFe()) &&
                Objects.equals(getApePatXx(), that.getApePatXx()) &&
                Objects.equals(getApeMatXx(), that.getApeMatXx()) &&
                Objects.equals(getPersonalMNo(), that.getPersonalMNo()) &&
                Objects.equals(getRfcXx(), that.getRfcXx()) &&
                Objects.equals(getContableNu(), that.getContableNu()) &&
                Objects.equals(getJornadaMin(), that.getJornadaMin()) &&
                Objects.equals(getJornadaMax(), that.getJornadaMax()) &&
                Objects.equals(getPlazaCl1(), that.getPlazaCl1()) &&
                Objects.equals(getPlazaCl2(), that.getPlazaCl2()) &&
                Objects.equals(getCategoria1(), that.getCategoria1()) &&
                Objects.equals(getCategoria2(), that.getCategoria2()) &&
                Objects.equals(getPuesto1(), that.getPuesto1()) &&
                Objects.equals(getPuesto2(), that.getPuesto2()) &&
                Objects.equals(getPlantel1(), that.getPlantel1()) &&
                Objects.equals(getPlantel2(), that.getPlantel2()) &&
                Objects.equals(getDiasEquivalentes(), that.getDiasEquivalentes()) &&
                Objects.equals(getCategoriaPago(), that.getCategoriaPago()) &&
                Objects.equals(getDiasPagarNu(), that.getDiasPagarNu()) &&
                Objects.equals(getDiferenciaNu(), that.getDiferenciaNu()) &&
                Objects.equals(getExtrasAutorizadas(), that.getExtrasAutorizadas()) &&
                Objects.equals(getPagoCantDias(), that.getPagoCantDias()) &&
                Objects.equals(getPagoCantExtra(), that.getPagoCantExtra()) &&
                Objects.equals(getPagoCantTotal(), that.getPagoCantTotal()) &&
                Objects.equals(getGeneraPago(), that.getGeneraPago()) &&
                Objects.equals(getGeneraPagoFe(), that.getGeneraPagoFe()) &&
                Objects.equals(getTieneRfc(), that.getTieneRfc()) &&
                Objects.equals(getEntregaRfcFe(), that.getEntregaRfcFe()) &&
                Objects.equals(getTieneHorarios(), that.getTieneHorarios()) &&
                Objects.equals(getTieneRetencion(), that.getTieneRetencion()) &&
                Objects.equals(getPagoProcesado(), that.getPagoProcesado()) &&
                Objects.equals(getPagoGenerado(), that.getPagoGenerado()) &&
                Objects.equals(getObservaciones(), that.getObservaciones()) &&
                Objects.equals(getCausaError(), that.getCausaError()) &&
                Objects.equals(getListaError(), that.getListaError());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPersonalCl(), getPagoFe(), getMontoPagoNu(), getDiasPagoNu(), getFestivosNu(), getHorasPagoNu(), getHorasDobleNu(), getPerPagoCl(), getIniPagoFe(), getFinPagoFe(), getApePatXx(), getApeMatXx(), getPersonalMNo(), getRfcXx(), getContableNu(), getJornadaMin(), getJornadaMax(), getPlazaCl1(), getPlazaCl2(), getCategoria1(), getCategoria2(), getPuesto1(), getPuesto2(), getPlantel1(), getPlantel2(), getDiasEquivalentes(), getCategoriaPago(), getDiasPagarNu(), getDiferenciaNu(), getExtrasAutorizadas(), getPagoCantDias(), getPagoCantExtra(), getPagoCantTotal(), getGeneraPago(), getGeneraPagoFe(), getTieneRfc(), getEntregaRfcFe(), getTieneHorarios(), getTieneRetencion(), getPagoProcesado(), getPagoGenerado(), getObservaciones(), getCausaError(), getListaError());
    }
}
