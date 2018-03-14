package uam.admision.pagos.Model;

import org.springframework.format.annotation.DateTimeFormat;
import uam.admision.pagos.Utils.LocalDateTimeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PagosEntityPK implements Serializable {
    private String personalCl;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate pagoFe;

    @Column(name = "personal_cl", nullable = false, length = 45)
    @Id
    public String getPersonalCl() {
        return personalCl;
    }

    public void setPersonalCl(String personalCl) {
        this.personalCl = personalCl;
    }

    @Column(name = "pago_fe", nullable = false)
    @Id
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDate getPagoFe() {
        return pagoFe;
    }

    public void setPagoFe(LocalDate pagoFe) {
        this.pagoFe = pagoFe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagosEntityPK that = (PagosEntityPK) o;
        return Objects.equals(personalCl, that.personalCl) &&
                Objects.equals(pagoFe, that.pagoFe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personalCl, pagoFe);
    }
}
