package com.reto.reto.Controller;


import com.reto.reto.Model.Usuarios;
import com.reto.reto.Repository.UsuariosRepository;
import com.reto.reto.Service.UsuariosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;


@Controller
public class UsuariosController {

    private final UsuariosRepository usuariosRepository;
    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosRepository usuariosRepository, UsuariosService usuariosService) {
        this.usuariosRepository = usuariosRepository;
        this.usuariosService = usuariosService;
    }


    @GetMapping("/usuarios/Registros")
    public String visualizar(Model model){
        System.out.println("Entrando al controlador: ");
        usuariosRepository.findAll();
        return "Registros";
    }

    @GetMapping("/usuarios/Inicio")
    public String visitar(Model model){
        System.out.println("Entrando al controlador: ");
        usuariosService.MirarUsuarios(new ch.qos.logback.core.model.Model());
        return "Inicio";
    }

    @GetMapping("usuarios/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return "formulario"; // Nombre de la vista Thymeleaf
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuarios usuarios) {
        usuariosService.guardarUsuario(usuarios);
        return "redirect:/exito"; // Redirige a una página de éxito
    }




/*

@GetMapping("/formulario")
        public String mostrarFormulario(Model model) {
            model.addAttribute("usuario", new Usuario());
            return "formulario"; // Nombre de la vista Thymeleaf
        }

        @PostMapping("/guardarUsuario")
        public String guardarUsuario(@ModelAttribute Usuario usuario) {
            usuarioService.guardarUsuario(usuario);
            return "redirect:/exito"; // Redirige a una página de éxito
        }

        @ModelAttribute
    @GetMapping("/usuarios/formulario")
    public String Agregar(Model model) {
        model.addAttribute("usuario", new Usuarios());
        System.out.println("Agregando exito: ");
        return "usuarios/formulario";
    }

    @ModelAttribute
    @PostMapping("/guardarUsuario")
    public String Guardar(@ModelAttribute Usuarios usuarios) {
        System.out.println("Info Guardada: ");
        usuariosRepository.save(usuarios);
        return "redirect:/Inicio";
    }



 model.addAttribute("usuario", new Usuario());

@PostMapping("/guardarUsuario")
            public String guardarUsuario(@ModelAttribute Usuario usuario) {
                usuarioRepository.save(usuario);
                return "redirect:/exito"; // Redirige a una página de éxito
            }
    @GetMapping("/usuarios/Inicio")
    public String visualizar(Model model){
        System.out.println("Entrando al controlador: ");
        usuariosRepository.findAll();
        return "Inicio";
    }



    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuarios> usuarios = usuariosRepository.findAll();
        return "usuarios";
    //eitar________________



    //Agregar---------

    @GetMapping("/usuarios/Inicio")
    public String AgregarUser(@PostMapping UsuariosRepository usuariosRepository)
    {
        System.out.println("Agregado");

    }
     */


}
