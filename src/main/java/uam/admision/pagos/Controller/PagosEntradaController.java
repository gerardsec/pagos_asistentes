package uam.admision.pagos.Controller;

import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uam.admision.pagos.Model.PagosEntity;
import uam.admision.pagos.Model.PagosEntrada;
import uam.admision.pagos.Service.MapPagos;
import uam.admision.pagos.Service.PagosEntityService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PagosEntradaController {
    private static final Logger log = LoggerFactory.getLogger(PagosEntradaController.class);
    private static String UPLOADED_FOLDER = "/Users/uamadm01/Data/files_sendmail/";
    //private static String UPLOADED_FOLDER = "/Users/gerardsec/Documents/temporales/files_sendmail/";

    String fileName;

    @Autowired
    MapPagos mapPagos;


    @RequestMapping(value = "/envio/archivoDatos")
    public String archivoDatos() {
        return "archivoDatos";
    }

    @RequestMapping(value = "/envio/archivoDatos", params = {"datos"})
    public String archivoDatosRecibe(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        fileName = file.getOriginalFilename();
        System.out.println(file.getName());
        log.warn("Archivo de datos:" + fileName);
        if (fileName.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Archivo vacío. Seleccione uno");
            return "redirect:/envio/archivoDatos";
        }
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "El archivo se guardó correctamente: " + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Error al guardar el archivo");
            e.printStackTrace();
        }
        //Conversión a CSV en un Array
        String stringFileName = UPLOADED_FOLDER + file.getOriginalFilename();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(stringFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<PagosEntrada> listaPagos = new ArrayList<>();
        listaPagos = new CsvToBeanBuilder(fileReader).withType(PagosEntrada.class).withSeparator('\t').build().parse();
        List<PagosEntity> pagosEntityList = mapPagos.mapToPagosRevisa(listaPagos);
        log.warn("regresa de pagosrevisa");
        if (pagosEntityList == null) {
            log.error("Demasiados errores al convertir los datos");

            redirectAttributes.addFlashAttribute("message",
                    "ver log. Demasiados errores en formato de datos: " + file.getOriginalFilename() + "'");
            return "redirect:/envio/archivoDatos";
        }
        Boolean erroresenGuarda = mapPagos.mapToPagosGuarda(pagosEntityList);
        if (erroresenGuarda == Boolean.TRUE) {
            redirectAttributes.addFlashAttribute("message",
                    "ver log. Demasiados errores al intentar guardar los datos: " + file.getOriginalFilename() + "'");
            //agregar MessageError
            return "redirect:/envio/archivoDatos";
        }
        return "redirect:/envio/archivoDatos";
    }
}
