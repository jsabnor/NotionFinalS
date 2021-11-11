package com.equipo2.Notion.NotionFinalS.Controllers;

import com.equipo2.Notion.NotionFinalS.DTO.JwtDto;
import com.equipo2.Notion.NotionFinalS.DTO.LoginUsuario;
import com.equipo2.Notion.NotionFinalS.DTO.NuevoUsuario;
import com.equipo2.Notion.NotionFinalS.Entities.Rol;
import com.equipo2.Notion.NotionFinalS.Entities.Usuario;
import com.equipo2.Notion.NotionFinalS.Enums.RolNombre;
import com.equipo2.Notion.NotionFinalS.JWT.JwtProvider;
import com.equipo2.Notion.NotionFinalS.Services.RolService;
import com.equipo2.Notion.NotionFinalS.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    //ATRIBUTOS
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    //METODOS
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity("Campos mal puestos o email invalido", HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByUsername(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity("El nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity("El email ya existe", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario=
                new Usuario(nuevoUsuario.getNombreUsuario(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()),
                        nuevoUsuario.getEmail());
        Set<Rol> roles=new HashSet<>();
        roles.add(rolService.findByRolNombre(RolNombre.USER).get());
        if(nuevoUsuario.getRoles().contains("admin")){
            roles.add(rolService.findByRolNombre(RolNombre.ADMIN).get());
        }
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity("Usuario guardado", HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity("Campos mal puestos", HttpStatus.BAD_REQUEST);
        }
        Authentication authentication=
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),
                                loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt=jwtProvider.generateToken(authentication);
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto=new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
