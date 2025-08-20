package com.reto.reto.Service;


import ch.qos.logback.core.model.Model;
import com.reto.reto.Model.Usuarios;
import com.reto.reto.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class UsuariosService {

   @Autowired
    private UsuariosRepository usuariosRepository;

   //@Autowired
   // private UsuariosService usuariosService;
   @GetMapping
   public List<Usuarios> ListUsers(){
       return usuariosRepository.findAll();
   }

   public void MirarUsuarios(Model model){
       usuariosRepository.findAll();
   }



    public void guardarUsuario(Usuarios usuario) {
        usuariosRepository.save(usuario);
    }


}
