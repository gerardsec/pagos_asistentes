package uam.admision.pagos.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uam.admision.pagos.Model.PagosEntity;
import uam.admision.pagos.Model.PagosEntityPK;
import uam.admision.pagos.Service.PagosEntityService;

import javax.validation.Valid;

import java.time.LocalDate;

import java.util.Optional;

@Controller
public class ControlDocumentosController {

    private final static Logger log = LoggerFactory.getLogger(ControlDocumentosController.class);


    @Autowired
    private PagosEntityService pagosEntityService;

    @RequestMapping(value = "/documentos/registra")
    public String registraDocumentos(final @ModelAttribute("pagosEntity") PagosEntity pagosEntity,
                                     ModelAndView model) {

        LocalDate fechaDefault = LocalDate.now();
        Integer claveInicial = 0;

        model.addObject("fechaCorteBuscar", fechaDefault);
        model.addObject("personaClaveBuscar", claveInicial);

        return "actualizaPersona";
    }

    @RequestMapping(value = "/documentos/registra", params = {"buscarClave"})
    public String buscaPersona(final @Valid @ModelAttribute("pagosEntity") PagosEntity pagosEntity,
                               BindingResult bindingResult,
                               ModelAndView model,
                               RedirectAttributes redirectAttributes) {
        String mensaje = "";

        if (bindingResult.hasErrors()) {
            return "actualizaPersona";
        }
        //Forma clave a buscar
        PagosEntityPK corteClaveBuscar = new PagosEntityPK();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        corteClaveBuscar.setPagoFe(pagosEntity.getPagoFe());
        corteClaveBuscar.setPersonalCl(pagosEntity.getPersonalCl());
        log.warn("Clavecorte a buscar:" + corteClaveBuscar.getPersonalCl() + ">>" + corteClaveBuscar.getPagoFe());
        Optional<PagosEntity> optionalPagosEntity = pagosEntityService.buscaPorId(corteClaveBuscar);
        if (optionalPagosEntity.isPresent()) {
            PagosEntity copiaPagosEntity = new PagosEntity();
            BeanUtils.copyProperties(optionalPagosEntity.get(), copiaPagosEntity);
            mensaje = "SE encontró!!";
            log.warn("encontrado");
        } else {
            mensaje = "No se encontró información";
            log.warn("NO encontrado");
            return "actualizaPersona";
        }
        model.addObject("pagosEntity", optionalPagosEntity.get());
        model.addObject("pagosEntityEncontrado", optionalPagosEntity.get());
        System.out.println(optionalPagosEntity.get().toString());
        model.addObject("mensaje", mensaje);
        //redirectAttributes.addAttribute("modelAndView", model);
        return "actualizaPersona";

    }

    @RequestMapping(value = "/documentos/registra", params = {"Actualizar"})
    public String actualizarDatos(){
        String mensaje = "Solicitando actualizar";
        log.warn("solicitando actualizar");
        return "actualizaPersona";
    }


}
