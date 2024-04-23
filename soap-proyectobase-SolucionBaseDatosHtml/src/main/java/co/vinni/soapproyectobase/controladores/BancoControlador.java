package co.vinni.soapproyectobase.controladores;


import co.vinni.soapproyectobase.entidades.CuentaBancaria;
import co.vinni.soapproyectobase.repositorios.CuentaBancariaRepositorio;
import co.vinni.soapproyectobase.servicios.CuentaBancariaServicio;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BancoControlador {

    @Autowired
    private CuentaBancariaServicio cuentaBancariaServicio;
    @Autowired
    private CuentaBancariaRepositorio cuentaBancariaRepositorio;

    @GetMapping("/")
    public String menu() {
        return "menu";
    }

    @GetMapping("/crear-cuenta")
    public String crearCuentaForm(@NotNull Model model) {
        model.addAttribute("cuenta", new CuentaBancaria());
        return "crear-cuenta";
    }

    @PostMapping("/crear-cuenta")
    public String crearCuentaSubmit(@ModelAttribute CuentaBancaria cuenta) {
        cuentaBancariaServicio.crearCuenta(cuenta);
        return "redirect:/";
    }

    @GetMapping("/consignar")
    public String consignarForm(Model model) {
        model.addAttribute("cuenta", new CuentaBancaria());
        return "consignar";
    }

    @PostMapping("/consignar")
    public String consignarSubmit(@RequestParam Long id, @RequestParam double cantidad) {
        cuentaBancariaServicio.consignar(id, cantidad);
        return "redirect:/";
    }

    @GetMapping("/retirar")
    public String retirarForm(Model model) {
        model.addAttribute("cuenta", new CuentaBancaria());
        return "retirar";
    }

    @PostMapping("/retirar")
    public String retirarSubmit(@RequestParam Long id, @RequestParam double cantidad) {
        cuentaBancariaServicio.retirar(id, cantidad);
        return "redirect:/";
    }

    @GetMapping("/transferir")
    public String transferirForm(Model model) {
        model.addAttribute("cuentaOrigen", new CuentaBancaria());
        model.addAttribute("cuentaDestino", new CuentaBancaria());
        return "transferir";
    }

    @PostMapping("/transferir")
    public String transferirSubmit(@RequestParam Long idOrigen, @RequestParam Long idDestino, @RequestParam double cantidad) {
        cuentaBancariaServicio.transferir(idOrigen, idDestino, cantidad);
        return "redirect:/";
    }

    @GetMapping("/listar-cuentas")
    public String listadoCuentas(Model model) {
        List<CuentaBancaria> cuentas = cuentaBancariaRepositorio.findAll();
        model.addAttribute("cuentas", cuentas);
        return "cuentas";
    }

    @GetMapping("/list-cuentas")
    public String listarCuentas(Model model) {
        List<CuentaBancaria> cuentas = cuentaBancariaRepositorio.findAll();
        model.addAttribute("cuentas", cuentas);
        return "list-cuentas";
    }


}