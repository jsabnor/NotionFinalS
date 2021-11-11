package com.equipo2.Notion.NotionFinalS.Config;

import com.equipo2.Notion.NotionFinalS.Enums.RolNombre;
import com.equipo2.Notion.NotionFinalS.JWT.JwtEntryPoint;
import com.equipo2.Notion.NotionFinalS.JWT.JwtTokenFilter;
import com.equipo2.Notion.NotionFinalS.Services.UsuarioDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Clase que organiza toda la seguridad
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
//Anotacion para los permisos de acceso de los administradores
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {
    //ATRIBUTOS
    @Autowired
    UsuarioDetailsServiceImpl usuarioDetailsService;
    @Autowired
    JwtEntryPoint jwtEntryPoint;

    //METODOS
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * Metodo que configura los accesos a los endpoints de la APIres
     * @param http configuracion HttpSecurity
     * @throws Exception si sale algo mal
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui/").permitAll()
                //ARTICULOS
                .antMatchers("api/articulos/crear").hasRole(RolNombre.ADMIN.name())
                .antMatchers("api/articulos/modificar").hasRole(RolNombre.ADMIN.name())
                .antMatchers("api/articulos/modificar/**").hasRole(RolNombre.ADMIN.name())
                .antMatchers("api/articulos/eliminar").hasRole(RolNombre.ADMIN.name())
                .antMatchers("api/articulos/eliminar/**").hasRole(RolNombre.ADMIN.name())
                .antMatchers("api/articulos/mostrar").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())
                .antMatchers("api/articulos/mostrar/**").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())
                //CATEGORIAS
                .antMatchers("api/categorias/crear").hasRole(RolNombre.ADMIN.name())
                .antMatchers("api/categorias/modificar").hasRole(RolNombre.ADMIN.name())
                .antMatchers("api/categorias/modificar/**").hasRole(RolNombre.ADMIN.name())
                .antMatchers("api/categorias/eliminar").hasRole(RolNombre.ADMIN.name())
                .antMatchers("api/categorias/eliminar/**").hasRole(RolNombre.ADMIN.name())
                .antMatchers("api/categorias/mostrar").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())
                .antMatchers("api/categorias/mostrar/**").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())
                //USUARIOS
                .antMatchers("api/usuarios/crear").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())
                .antMatchers("api/usuarios/modificar").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())
                .antMatchers("api/usuarios/modificar/**").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())
                .antMatchers("api/usuarios/eliminar").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())
                .antMatchers("api/usuarios/eliminar/**").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())
                .antMatchers("api/usuarios/mostrar").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())
                .antMatchers("api/usuarios/mostrar/**").hasAnyRole(RolNombre.USER.name(), RolNombre.ADMIN.name())

                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}
