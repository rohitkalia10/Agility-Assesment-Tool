package agility.lifecyle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"agility"})
@EntityScan({"agility"})
@EnableJpaRepositories({"agility"})
public class AgilityApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AgilityApplication.class, args);
	}
}
