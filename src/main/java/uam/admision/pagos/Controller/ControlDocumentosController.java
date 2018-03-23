package uam.admision.pagos.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import uam.admision.pagos.Model.PagosEntity;
import uam.admision.pagos.Model.PagosEntityPK;
import uam.admision.pagos.Service.PagosEntityService;
import uam.admision.pagos.Service.PagosEntityTransactionException;

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
                                     final ModelMap model) {

        LocalDate fechaDefault = LocalDate.now();
        Integer claveInicial = 0;
        pagosEntity.setPersonalCl("");

        //model.addObject("fechaCorteBuscar", fechaDefault);
        //model.addObject("personaClaveBuscar", claveInicial);

        return "actualizaPersona";
    }

    @RequestMapping(value = "/documentos/registra", params = {"buscarClave"})
    public String buscaPersona(final @Valid @ModelAttribute("pagosEntity") PagosEntity pagosEntity,
                               final BindingResult bindingResult,
                               final ModelMap model) {
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
        if (!optionalPagosEntity.isPresent()) {
            mensaje = "No se encontró información";
            log.warn("NO encontrado");
            return "actualizaPersona";
        }
        mensaje = "SE encontró!!";
        log.warn("encontrado");
        BeanUtils.copyProperties(optionalPagosEntity.get(), pagosEntity);
        //BeanUtils.copyProperties(optionalPagosEntity.get(), pagosEntityEncontrado);
        System.out.println(optionalPagosEntity.get().toString());
        //System.out.println(pagosEntityEncontrado.toString());
        //model.addObject("mensaje", mensaje);
        return "actualizaPersona";
    }

    @RequestMapping(value = "/documentos/registra", params = {"actualizaDatos"})
    public String actualizarDatos(final @Valid @ModelAttribute("pagosEntity") PagosEntity pagosEntity,
                                  final BindingResult bindingResult,
                                  final ModelMap model) {
        if (bindingResult.hasErrors()) {
            log.warn("Errores en forma actualizar");
            return "actualizaPersona";
        }
        String mensaje = "Solicitando actualizar";
        log.warn("solicitando actualizar");
        try {
            Boolean procesaActualizacion = pagosEntityService.actualizaPagos(pagosEntity);
            if (procesaActualizacion) {
                log.warn("Actualización ok");
            } else {
                log.warn("No se procesó actualización");
            }
        } catch (PagosEntityTransactionException e) {
            log.warn("Error al actualizar");
        }
        model.clear();
        return "redirect:/documentos/registra";
    }
}
