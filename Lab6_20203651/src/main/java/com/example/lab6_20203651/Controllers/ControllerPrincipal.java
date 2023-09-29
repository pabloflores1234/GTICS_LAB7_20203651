package com.example.lab6_20203651.Controllers;


import com.example.lab6_20203651.Entity.SiteEntity;
import com.example.lab6_20203651.Entity.TechnicianEntity;
import com.example.lab6_20203651.Repository.LocationRepository;
import com.example.lab6_20203651.Repository.SitioRepository;
import com.example.lab6_20203651.Repository.TecnicoRepository;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ControllerPrincipal {

    final SitioRepository sitioRepository;
    final LocationRepository locationRepository;

    final TecnicoRepository tecnicoRepository;


    public ControllerPrincipal(SitioRepository sitioRepository, LocationRepository locationRepository, TecnicoRepository tecnicoRepository) {
        this.sitioRepository = sitioRepository;
        this.locationRepository = locationRepository;
        this.tecnicoRepository = tecnicoRepository;
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


    @GetMapping("/Tecnicos")
    public String vistasTecnicos(Model model){
        model.addAttribute("listaTecnicos", tecnicoRepository.findAll());
        return "Tecnicos";
    }


    @GetMapping("/crearTecnico")
    public String crearTecnico(@ModelAttribute("tecnico")TechnicianEntity tecnico, Model model){


        return "NewEditTec";
    }

     @GetMapping("/editartecnico")
    public String editarTecnico(@ModelAttribute("tecnico") TechnicianEntity tecnico, Model model, @RequestParam("id") int id){

         Optional<TechnicianEntity> optTecnico = tecnicoRepository.findById(id);
         if (optTecnico.isPresent()){
             tecnico =  optTecnico.get();
             model.addAttribute("tecnico",tecnico);
         }
        return "NewEditTec";
     }

     @PostMapping("/guardarTecnico")
    public String guardareditartec(@ModelAttribute("tecnico") @Valid TechnicianEntity tecnico, BindingResult bindingResult, RedirectAttributes attr){



        if(tecnico.getTechnicianId() == 0){
            attr.addFlashAttribute("msg", "Técnico " + tecnico.getFirstName() +" "+ tecnico.getLastName() + " Creado Exitosamente");
        }else{
            attr.addFlashAttribute("msg", "Técnico " + tecnico.getFirstName() +" "+ tecnico.getLastName() + " Actualizado Exitosamente");
        }
        //if(bindingResult.getFieldValue()  )
         tecnicoRepository.save(tecnico);
        return "redirect:/Tecnicos";
     }

}
