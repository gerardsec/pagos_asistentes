package uam.admision.pagos.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uam.admision.pagos.Model.PagosEntity;
import uam.admision.pagos.Model.PagosEntityPK;
import uam.admision.pagos.Service.PagosEntityService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ControlDocumentosController {

    private final static Logger log = LoggerFactory.getLogger(ControlDocumentosController.class);


    @Autowired
    private PagosEntityService pagosEntityService;

    @RequestMapping(value = "/documentos/registra")
    public String registraDocumentos(final @ModelAttribute("pagosEntity") PagosEntity pagosEntity,
                                     ModelAndView model) {
        String claveInicial = "4321";
        LocalDate fechaDefault = LocalDate.now();

        model.addObject("fechaCorteBuscar",fechaDefault);
        model.addObject("personaClaveBuscar",claveInicial);

        return "actualizaPersona";
    }

    @RequestMapping(value = "/documentos/registra", params = {"buscarClave"})
    public String buscaPersona(ModelAndView model, RedirectAttributes redirectAttributes,
                               @RequestParam(value = )) {


        try {
            Integer claveBuscar = Integer.parseInt(personaClaveBuscar);
        } catch (NumberFormatException e) {
            redirectAttributes.addFlashAttribute("message", "Verifique que sea una clave o matrícula correcta");
            return "redirect:/documentos/registra";
        }
        //Forma clave a buscar
        PagosEntityPK corteClaveBuscar = new PagosEntityPK();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        corteClaveBuscar.setPagoFe(LocalDate.parse(fechaCorteBuscar, formatter));
        corteClaveBuscar.setPersonalCl(personaClaveBuscar);
        log.warn("Clavecorte a buscar:"+corteClaveBuscar.getPersonalCl()+">>"+corteClaveBuscar.getPagoFe());
        redirectAttributes.addAttribute("modelMap",modelMap);
        return "redirect:/documentos/registra";

    }


}
