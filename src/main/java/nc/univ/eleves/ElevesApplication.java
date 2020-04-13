package nc.univ.eleves;

import nc.univ.eleves.controller.EleveController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@SpringBootApplication
@ComponentScan(basePackages = { "nc.univ.eleves.dao" })
@ComponentScan(basePackageClasses = EleveController.class)
public class ElevesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ElevesApplication.class, args);
	}

}
