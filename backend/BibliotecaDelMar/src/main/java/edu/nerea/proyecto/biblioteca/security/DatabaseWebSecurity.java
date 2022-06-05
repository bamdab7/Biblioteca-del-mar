package edu.nerea.proyecto.biblioteca.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, status from usuarios where username=?")
		.authoritiesByUsernameQuery("select u.username, p.perfil from usuarioperfil up " + 
				"inner join usuarios u on u.id = up.idUsuario "+ 
				"inner join perfiles p on p.id = up.idPerfil "+
				"where u.username = ?");	
	}
	
	//personalizacion de acceso a las url
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**",
											"/static/**",
											"/img/**",
											"/css/**").permitAll().antMatchers("/",
																				"/signup",
																				"/bcrypt/**",
																				"/actividad1",
																				"/actividad2",
																				"/actividad3",
																				"/noticias",
																				"/FA",
																				"/aboutus",
																				"/resources/**",
																				"/static/**",
																				"/libros").permitAll()
																					.antMatchers("/detalle/**").hasAnyAuthority("ADMINISTRADOR","USUARIO")
																					.antMatchers("/noticia1").hasAnyAuthority("ADMINISTRADOR","USUARIO")
																					.antMatchers("/noticia2").hasAnyAuthority("ADMINISTRADOR","USUARIO")
																					.antMatchers("/noticia3").hasAnyAuthority("ADMINISTRADOR","USUARIO")
																					.antMatchers("/noticia4").hasAnyAuthority("ADMINISTRADOR","USUARIO")
																					.antMatchers("/noticia5").hasAnyAuthority("ADMINISTRADOR","USUARIO")
																					//permisos de mis libros para USUARIO
																					.antMatchers("/createLibro/**").hasAnyAuthority("ADMINISTRADOR")
																					.antMatchers("/editLibro/**").hasAnyAuthority("ADMINISTRADOR")
																					.antMatchers("/eliminarLibro/**").hasAnyAuthority("ADMINISTRADOR")
																					.antMatchers("/autores/**").hasAnyAuthority("ADMINISTRADOR")
																					.antMatchers("/editAutor/**").hasAnyAuthority("ADMINISTRADOR")
																					.antMatchers("/createAutor/**").hasAnyAuthority("ADMINISTRADOR")
																					.antMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
																					.antMatchers("/deleteuser/**").hasAnyAuthority("ADMINISTRADOR")
																					
																					
																					
																					
		
		.anyRequest().authenticated().and().formLogin().permitAll();	
		
	}
	//encriptamiento de contraseñas
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
