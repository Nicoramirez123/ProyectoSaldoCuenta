package co.vinni.soapproyectobase;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * author Vinni 2023
 */
@SpringBootApplication
@Log4j2

public class SoapProyectobaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapProyectobaseApplication.class, args);
        System.out.println("proyecto cuentas");

    }

}
