package ma.cinema;

import ma.cinema.service.InitService;
import ma.cinema.service.InitServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(InitServiceImpl initService){
		return args -> {
			initService.initVilles();
			initService.initCinemas();
			initService.initSalles();
		};}

}
