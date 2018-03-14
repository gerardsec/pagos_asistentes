package uam.admision.pagos.Model;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private BigDecimal montoPagoNu;
    private Integer diasPagoNu;
    private Integer festivosNu;
    private BigDecimal horasPagoNu;
    private BigDecimal horasDobleNu;
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
    private BigDecimal diasEquivalentes;
    private Integer categoriaPago;
    private Integer diasPagarNu;
    private BigDecimal diferenciaNu;
    private BigDecimal extrasAutorizadas;
    private BigDecimal pagoCantDias;
    private BigDecimal pagoCantExtra;
    private BigDecimal pagoCantTotal;
    private Integer generaPago;
    private Integer tieneRfc;
    private Integer tieneHorarios;
    private Integer tieneRetencion;
    private Integer pagoProcesado;
    private Integer pagoGenerado;
    private String observaciones;
    private String causaError;

    @Id
    @Column(name = "personal_cl", nullable = false, length = 45)
    public String getPersonalCl() {
        return personalCl;
    }

    public void setPersonalCl(String personalCl) {
        this.personalCl = personalCl;
    }

    @Id
    @Column(name = "pago_fe", nullable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDate getPagoFe() {
        return pagoFe;
    }

    public void setPagoFe(LocalDate pagoFe) {
        this.pagoFe = pagoFe;
    }

    @Basic
    @Column(name = "monto_pago_nu", nullable = true, precision = 2)
    public BigDecimal getMontoPagoNu() {
        return montoPagoNu;
    }

    public void setMontoPagoNu(BigDecimal montoPagoNu) {
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
    public BigDecimal getHorasPagoNu() {
        return horasPagoNu;
    }

    public void setHorasPagoNu(BigDecimal horasPagoNu) {
        this.horasPagoNu = horasPagoNu;
    }

    @Basic
    @Column(name = "horas_doble_nu", nullable = true, precision = 2)
    public BigDecimal getHorasDobleNu() {
        return horasDobleNu;
    }

    public void setHorasDobleNu(BigDecimal horasDobleNu) {
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
    public BigDecimal getDiasEquivalentes() {
        return diasEquivalentes;
    }

    public void setDiasEquivalentes(BigDecimal diasEquivalentes) {
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
    public BigDecimal getDiferenciaNu() {
        return diferenciaNu;
    }

    public void setDiferenciaNu(BigDecimal diferenciaNu) {
        this.diferenciaNu = diferenciaNu;
    }

    @Basic
    @Column(name = "extras_autorizadas", nullable = true, precision = 2)
    public BigDecimal getExtrasAutorizadas() {
        return extrasAutorizadas;
    }

    public void setExtrasAutorizadas(BigDecimal extrasAutorizadas) {
        this.extrasAutorizadas = extrasAutorizadas;
    }

    @Basic
    @Column(name = "pago_cant_dias", nullable = true, precision = 2)
    public BigDecimal getPagoCantDias() {
        return pagoCantDias;
    }

    public void setPagoCantDias(BigDecimal pagoCantDias) {
        this.pagoCantDias = pagoCantDias;
    }

    @Basic
    @Column(name = "pago_cant_extra", nullable = true, precision = 2)
    public BigDecimal getPagoCantExtra() {
        return pagoCantExtra;
    }

    public void setPagoCantExtra(BigDecimal pagoCantExtra) {
        this.pagoCantExtra = pagoCantExtra;
    }

    @Basic
    @Column(name = "pago_cant_total", nullable = true, precision = 2)
    public BigDecimal getPagoCantTotal() {
        return pagoCantTotal;
    }

    public void setPagoCantTotal(BigDecimal pagoCantTotal) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagosEntity that = (PagosEntity) o;
        return Objects.equals(personalCl, that.personalCl) &&
                Objects.equals(pagoFe, that.pagoFe) &&
                Objects.equals(montoPagoNu, that.montoPagoNu) &&
                Objects.equals(diasPagoNu, that.diasPagoNu) &&
                Objects.equals(festivosNu, that.festivosNu) &&
                Objects.equals(horasPagoNu, that.horasPagoNu) &&
                Objects.equals(horasDobleNu, that.horasDobleNu) &&
                Objects.equals(perPagoCl, that.perPagoCl) &&
                Objects.equals(iniPagoFe, that.iniPagoFe) &&
                Objects.equals(finPagoFe, that.finPagoFe) &&
                Objects.equals(apePatXx, that.apePatXx) &&
                Objects.equals(apeMatXx, that.apeMatXx) &&
                Objects.equals(personalMNo, that.personalMNo) &&
                Objects.equals(rfcXx, that.rfcXx) &&
                Objects.equals(contableNu, that.contableNu) &&
                Objects.equals(jornadaMin, that.jornadaMin) &&
                Objects.equals(jornadaMax, that.jornadaMax) &&
                Objects.equals(plazaCl1, that.plazaCl1) &&
                Objects.equals(plazaCl2, that.plazaCl2) &&
                Objects.equals(categoria1, that.categoria1) &&
                Objects.equals(categoria2, that.categoria2) &&
                Objects.equals(puesto1, that.puesto1) &&
                Objects.equals(puesto2, that.puesto2) &&
                Objects.equals(plantel1, that.plantel1) &&
                Objects.equals(plantel2, that.plantel2) &&
                Objects.equals(diasEquivalentes, that.diasEquivalentes) &&
                Objects.equals(categoriaPago, that.categoriaPago) &&
                Objects.equals(diasPagarNu, that.diasPagarNu) &&
                Objects.equals(diferenciaNu, that.diferenciaNu) &&
                Objects.equals(extrasAutorizadas, that.extrasAutorizadas) &&
                Objects.equals(pagoCantDias, that.pagoCantDias) &&
                Objects.equals(pagoCantExtra, that.pagoCantExtra) &&
                Objects.equals(pagoCantTotal, that.pagoCantTotal) &&
                Objects.equals(generaPago, that.generaPago) &&
                Objects.equals(tieneRfc, that.tieneRfc) &&
                Objects.equals(tieneHorarios, that.tieneHorarios) &&
                Objects.equals(tieneRetencion, that.tieneRetencion) &&
                Objects.equals(pagoProcesado, that.pagoProcesado) &&
                Objects.equals(pagoGenerado, that.pagoGenerado) &&
                Objects.equals(observaciones, that.observaciones) &&
                Objects.equals(causaError, that.causaError);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personalCl, pagoFe, montoPagoNu, diasPagoNu, festivosNu, horasPagoNu, horasDobleNu, perPagoCl, iniPagoFe, finPagoFe, apePatXx, apeMatXx, personalMNo, rfcXx, contableNu, jornadaMin, jornadaMax, plazaCl1, plazaCl2, categoria1, categoria2, puesto1, puesto2, plantel1, plantel2, diasEquivalentes, categoriaPago, diasPagarNu, diferenciaNu, extrasAutorizadas, pagoCantDias, pagoCantExtra, pagoCantTotal, generaPago, tieneRfc, tieneHorarios, tieneRetencion, pagoProcesado, pagoGenerado, observaciones, causaError);
    }
}
