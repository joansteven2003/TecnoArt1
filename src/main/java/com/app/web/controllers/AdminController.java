package com.app.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {

    @GetMapping("/admin/Bienvenida")
    public String bienbenidoAdmin(Model model){
        return "/bienvenidaAdmin";
    }

    @GetMapping("/admin/Cargo")
    public String GenerarCargo(Model model){
        return "/Generar_cargo";
    }

    @GetMapping("/admin/Cita")
    public String GenerarCita(Model model){
        return "/Generar_Cita";
    }

    @GetMapping("/admin/Contrato")
    public String GenerarContrato(Model model){
        return "/Generar_contrato";
    }

    @GetMapping("/admin/Resultado")
    public String GenerarResultado(Model model){
        return "/Generar_Resultado";
    }


    @GetMapping("/admin/Vacante")
    public String GenerarVacante(Model model){
        return "/Generar_Vacante";
    }

    @GetMapping("/admin/CosulHojaVida")
    public String ConsultarHojaVida(Model model){
        return "/HojaDeVida";
    }

    @GetMapping("/admin/PQRS")
    public String ConsultarPQRS(Model model){
        return "/pqrs";
    }

    @GetMapping("/admin/Venta")
    public String ConsultarVenta(Model model){
        return "/Venta";
    }

    @GetMapping("/admin/citas")
    public  String ConsultarCita(Model model){
        return "/Cita";
    }
}
