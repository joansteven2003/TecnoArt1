package com.app.web.controllers;

import com.app.web.modelos.Cotizacion;
import com.app.web.servicios.CotizacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CotizacionController {
    @Autowired
    private CotizacionServicio servicio;

    @GetMapping("/Cotizacion")
    public String ListarCotizacion(Model modelo) {
        modelo.addAttribute("Cotizacion", servicio.ListarCotizaciones());
        return "/Cotizacion";
    }
    @GetMapping("/Cliente_Cotizacion")
    public String ListarCotizacionCliente(Model modelo) {
        modelo.addAttribute("Cotizacion", servicio.ListarCotizaciones());
        return "Cliente_Cotizacion";
    }

    @GetMapping("/Cotizacion/eliminar/{IdCotizacion}")
    public String eliminarCotizacion(@PathVariable long IdCotizacion) {
        servicio.eliminarCotizacion(IdCotizacion);
        return "redirect:/Cotizacion";
    }
    //experimentos//

    @GetMapping("/Cotizacion/Registrar")
    public String CotizacionFormulario(Model modelo) {
        Cotizacion cotizacion = new Cotizacion();
        modelo.addAttribute("Cotizacion", cotizacion);
        return "/Generar_Cotizacion";
    }

    @PostMapping("/Cotizacion/Guardar")
    public String guardarCotizacion(@ModelAttribute("Cotizacion") Cotizacion cotizacion) {
        servicio.guardarCotizacion(cotizacion);
        return "redirect:/Cotizacion";

    }

    @GetMapping("/Cotizacion/editar/{IdCotizacion}")
    public String EditarCotizacionFomulario(@PathVariable long IdCotizacion, Model modelo) {
        modelo.addAttribute("Cotizacion", servicio.obtenerCotizacionPorId(IdCotizacion));
        return "/Editar_cotizacion";
    }

    @PostMapping("/Cotizacion/{IdCotizacion}")
    public String EditarCotizacion(@PathVariable long IdCotizacion, @ModelAttribute("Cotizacion")
    Cotizacion cotizacion, Model modelo) {

        Cotizacion CotizacionExistente = servicio.obtenerCotizacionPorId(IdCotizacion);
        CotizacionExistente.setIdCotizacion(IdCotizacion);
        CotizacionExistente.setUsuario(cotizacion.getUsuario());
        CotizacionExistente.setDescriocion(cotizacion.getDescriocion());
        CotizacionExistente.setFecha(cotizacion.getFecha());
        CotizacionExistente.setRespuesta(cotizacion.getRespuesta());
        CotizacionExistente.setFechaRespuesta(cotizacion.getFechaRespuesta());

        servicio.actualizarCotizacion(CotizacionExistente);
        return "redirect:/Cotizacion";
    }


}
