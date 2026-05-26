package uts.edu.java.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
    "uts.edu.java.proyecto",
    "controlador",
    "servicio",
    "seguridad"
})
@EntityScan(basePackages = "modelo")
@EnableJpaRepositories(basePackages = "repositorio")
public class ConsultasmedicasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultasmedicasApplication.class, args);
    }
}