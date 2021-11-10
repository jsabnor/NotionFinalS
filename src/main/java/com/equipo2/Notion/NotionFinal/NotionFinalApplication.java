package com.equipo2.Notion.NotionFinal;

import com.equipo2.Notion.NotionFinal.Entities.Articulo;
import com.equipo2.Notion.NotionFinal.Entities.Categoria;
import com.equipo2.Notion.NotionFinal.Entities.Usuario;
import com.equipo2.Notion.NotionFinal.Services.ArticuloService;
import com.equipo2.Notion.NotionFinal.Services.CategoriaService;
import com.equipo2.Notion.NotionFinal.Services.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class NotionFinalApplication {

	public static void main(String[] args) {
		//Obtenemos el context
		ApplicationContext context=SpringApplication.run(NotionFinalApplication.class, args);
		//obtenemos los services para crear ejemplos apra la base de datos
		ArticuloService articuloService=context.getBean(ArticuloService.class);
		UsuarioService usuarioService=context.getBean(UsuarioService.class);
		CategoriaService categoriaService=context.getBean(CategoriaService.class);

		//Creamos un usuario con rol 0 que equivale al rol ADMIN y lo guardamos en la base de datos
		usuarioService.save(new Usuario(
				"josema",
				"password",
				"josema@equipo2.com",
				0));
		//Creamos un usuario con rol 1 que equivale al rol USER y lo guardamos en la base de datos
		usuarioService.save(new Usuario(
				"clemen",
				"password",
				"clemen@equipo2.com",
				1));
		//Creamos categorias
		Categoria cat1=new Categoria("Spring");
		Categoria cat2=new Categoria("React");

		//Salvamos en la base de datos
		categoriaService.save(cat1);
		categoriaService.save(cat2);

		//Creamos los articulos
		Articulo art1=new Articulo(
				"josema",
				LocalDate.now(),
				"Tutorial de Spring desde 0",
				"En este tutorial vamos a ver desde cero como empezar a programar con Spring....",
				cat1);
		Articulo art2=new Articulo(
				"josema",
				LocalDate.now(),
				"Despliegue de React en VPS",
				"Explicamos en este articulo como desplegar una aplicacion React en un VPS....",
				cat2);
		//Los guardamos en la base de datos
		articuloService.save(art1);
		articuloService.save(art2);


	}

}
