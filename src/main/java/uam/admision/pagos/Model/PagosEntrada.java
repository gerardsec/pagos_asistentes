package uam.admision.pagos.Model;

import com.opencsv.bean.CsvBindByName;
import java.math.BigDecimal;



public class PagosEntrada {

    @CsvBindByName
    private String personal_cl;
    @CsvBindByName
   
    private String pago_fe;
    @CsvBindByName
    private String u_version;
    @CsvBindByName
    private BigDecimal monto_pago_nu;
    @CsvBindByName
    private Integer dias_pago_nu;
    @CsvBindByName
    private Integer festivos_nu;
    @CsvBindByName
    private BigDecimal horas_pago_nu;
    @CsvBindByName
    private BigDecimal horas_doble_nu;
    @CsvBindByName
    private Integer per_pago_cl;
    @CsvBindByName
    
    private String ini_pago_fe;
    @CsvBindByName
  
    private String fin_pago_fe;
    @CsvBindByName
    private String ape_pat_xx;
    @CsvBindByName
    private String ape_mat_xx;
    @CsvBindByName
    private String rfc_xx;
    @CsvBindByName
    private Integer contable_nu;
    @CsvBindByName
    private String personal_m_no;
    @CsvBindByName
   
    private String jornada_min;
    @CsvBindByName
 
    private String jornada_max;
    @CsvBindByName
    private Integer plaza_cl1;
    @CsvBindByName
    private Integer plaza_cl2;
    @CsvBindByName
    private Integer categoria1;
    @CsvBindByName
    private Integer categoria2;
    @CsvBindByName
    private String puesto1;
    @CsvBindByName
    private String puesto2;
    @CsvBindByName
    private String plantel1;
    @CsvBindByName
    private String plantel2;



    public String getPersonal_cl() {
        return personal_cl;
    }

    public void setPersonal_cl(String personal_cl) {
        this.personal_cl = personal_cl;
    }
  
    public String getPago_fe() {
        return pago_fe;
    }

    public void setPago_fe(String pago_fe) {
        this.pago_fe = pago_fe;
    }

    public String getU_version() {
        return u_version;
    }

    public void setU_version(String u_version) {
        this.u_version = u_version;
    }

    public BigDecimal getMonto_pago_Nu() {
        return monto_pago_nu;
    }

    public void setMonto_pago_Nu(BigDecimal monto_pago_Nu) {
        this.monto_pago_nu = monto_pago_Nu;
    }

    public Integer getDias_pago_nu() {
        return dias_pago_nu;
    }

    public void setDias_pago_nu(Integer dias_pago_nu) {
        this.dias_pago_nu = dias_pago_nu;
    }

    public Integer getFestivos_nu() {
        return festivos_nu;
    }

    public void setFestivos_nu(Integer festivos_nu) {
        this.festivos_nu = festivos_nu;
    }

    public BigDecimal getHoras_pago_nu() {
        return horas_pago_nu;
    }

    public void setHoras_pago_nu(BigDecimal horas_pago_nu) {
        this.horas_pago_nu = horas_pago_nu;
    }

    public BigDecimal getHoras_doble_nu() {
        return horas_doble_nu;
    }

    public void setHoras_doble_nu(BigDecimal horas_doble_nu) {
        this.horas_doble_nu = horas_doble_nu;
    }

    public Integer getPer_pago_cl() {
        return per_pago_cl;
    }

    public void setPer_pago_cl(Integer per_pago_cl) {
        this.per_pago_cl = per_pago_cl;
    }
  
    public String getIni_pago_fe() {
        return ini_pago_fe;
    }

    public void setIni_pago_fe(String ini_pago_fe) {
        this.ini_pago_fe = ini_pago_fe;
    }
  
    public String getFin_pago_fe() {
        return fin_pago_fe;
    }

    public void setFin_pago_fe(String fin_pago_fe) {
        this.fin_pago_fe = fin_pago_fe;
    }

    public String getApe_pat_xx() {
        return ape_pat_xx;
    }

    public void setApe_pat_xx(String ape_pat_xx) {
        this.ape_pat_xx = ape_pat_xx;
    }

    public String getApe_mat_xx() {
        return ape_mat_xx;
    }

    public void setApe_mat_xx(String ape_mat_xx) {
        this.ape_mat_xx = ape_mat_xx;
    }

    public String getPersonalMNo() {
        return personal_m_no;
    }

    public void setPersonalMNo(String personalMNo) {
        this.personal_m_no = personalMNo;
    }

    public String getRfc_xx() {
        return rfc_xx;
    }

    public void setRfc_xx(String rfc_xx) {
        this.rfc_xx = rfc_xx;
    }

    public Integer getContable_nu() {
        return contable_nu;
    }

    public void setContable_nu(Integer contable_nu) {
        this.contable_nu = contable_nu;
    }
 
    public String getJornada_min() {
        return jornada_min;
    }

    public void setJornada_min(String jornada_min) {
        this.jornada_min = jornada_min;
    }
  
    public String getJornada_max() {
        return jornada_max;
    }

    public void setJornada_max(String jornada_max) {
        this.jornada_max = jornada_max;
    }

    public Integer getPlaza_cl1() {
        return plaza_cl1;
    }

    public void setPlaza_cl1(Integer plaza_cl1) {
        this.plaza_cl1 = plaza_cl1;
    }

    public Integer getPlaza_cl2() {
        return plaza_cl2;
    }

    public void setPlaza_cl2(Integer plaza_cl2) {
        this.plaza_cl2 = plaza_cl2;
    }

    public Integer getCategoria1() {
        return categoria1;
    }

    public void setCategoria1(Integer categoria1) {
        this.categoria1 = categoria1;
    }

    public Integer getCategoria2() {
        return categoria2;
    }

    public void setCategoria2(Integer categoria2) {
        this.categoria2 = categoria2;
    }

    public String getPuesto1() {
        return puesto1;
    }

    public void setPuesto1(String puesto1) {
        this.puesto1 = puesto1;
    }

    public String getPuesto2() {
        return puesto2;
    }

    public void setPuesto2(String puesto2) {
        this.puesto2 = puesto2;
    }

    public String getPlantel1() {
        return plantel1;
    }

    public void setPlantel1(String plantel1) {
        this.plantel1 = plantel1;
    }

    public String getPlantel2() {
        return plantel2;
    }

    public void setPlantel2(String plantel2) {
        this.plantel2 = plantel2;
    }


    @Override
    public String toString() {
        return "PagosEntrada{" +
                "personal_cl='" + personal_cl + '\'' +
                ", pago_fe=" + pago_fe +
                ", u_version='" + u_version + '\'' +
                ", monto_pago_Nu=" + monto_pago_nu +
                ", dias_pago_nu=" + dias_pago_nu +
                ", festivos_nu=" + festivos_nu +
                ", horas_pago_nu=" + horas_pago_nu +
                ", horas_doble_nu=" + horas_doble_nu +
                ", per_pago_cl=" + per_pago_cl +
                ", ini_pago_fe=" + ini_pago_fe +
                ", fin_pago_fe=" + fin_pago_fe +
                ", ape_pat_xx='" + ape_pat_xx + '\'' +
                ", ape_mat_xx='" + ape_mat_xx + '\'' +
                ", personalMNo='" + personal_m_no + '\'' +
                ", rfc_xx='" + rfc_xx + '\'' +
                ", contable_nu=" + contable_nu +
                ", jornada_min=" + jornada_min +
                ", jornada_max=" + jornada_max +
                ", plaza_cl1=" + plaza_cl1 +
                ", plaza_cl2=" + plaza_cl2 +
                ", categoria1=" + categoria1 +
                ", categoria2=" + categoria2 +
                ", puesto1='" + puesto1 + '\'' +
                ", puesto2='" + puesto2 + '\'' +
                ", plantel1='" + plantel1 + '\'' +
                ", plantel2='" + plantel2 + '\'' +
                '}';
    }

}

