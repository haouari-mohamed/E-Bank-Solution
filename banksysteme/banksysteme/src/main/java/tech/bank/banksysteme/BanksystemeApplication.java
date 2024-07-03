package tech.bank.banksysteme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("model")
public class BanksystemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanksystemeApplication.class, args);
	}

}
