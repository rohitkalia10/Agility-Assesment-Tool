package agility.lifecyle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.agility"})
@EntityScan("com.agility.domain.repository")
@SpringBootApplication
public class AgilityApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AgilityApplication.class, args);
	}
}
