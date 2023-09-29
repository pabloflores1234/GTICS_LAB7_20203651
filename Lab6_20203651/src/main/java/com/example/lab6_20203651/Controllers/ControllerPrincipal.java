package com.example.lab6_20203651.Controllers;


import com.example.lab6_20203651.Entity.SiteEntity;
import com.example.lab6_20203651.Repository.LocationRepository;
import com.example.lab6_20203651.Repository.SitioRepository;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerPrincipal {

    final SitioRepository sitioRepository;
    final LocationRepository locationRepository;


    public ControllerPrincipal(SitioRepository sitioRepository, LocationRepository locationRepository) {
        this.sitioRepository = sitioRepository;
        this.locationRepository = locationRepository;
    }


    @GetMapping("/")
    public String paginaprincipal(){
        return "VistaPrincipal";
    }

    @GetMapping("/Sitios")
    public String vistasitios(Model model){
        model.addAttribute("listaSitios", sitioRepository.findAll());
        return "Sitios";
    }

    @GetMapping("/crearSitio")
    public String crearSitio(Model model) {

        model.addAttribute("listaLocation", locationRepository.findAll());
        return "crearSitio";
    }

    @PostMapping("/guardarSitio")
    public String guardarSitio(SiteEntity site, RedirectAttributes attr){
        attr.addFlashAttribute("msg", "Sitio creado correctamente");
        sitioRepository.save(site);
        return "redirect:/Sitios";
    }

    @GetMapping("/Equipos")
    public String vistasEquipos(){
        return "Equipos";
    }

    @GetMapping("/Estadisticas")
    public String vistasEstadisticas(){
        return "Estadisticas";
    }
}
