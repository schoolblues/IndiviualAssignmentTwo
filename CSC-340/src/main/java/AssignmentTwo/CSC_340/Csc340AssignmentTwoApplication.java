package AssignmentTwo.CSC_340;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class Csc340AssignmentTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Csc340AssignmentTwoApplication.class, args);
	}

	/**
	 * This did not work but I was doing some searching and reading around to
	 * try and figure out how to exactly send an api key as a header.
	 * You would think its fairly straightforward.
	 * @Bean
	 * 	    NexusModsPublicApi nexusModsPublicApi () {
	 * 				.baseUrl("https://api.nexusmods.com")
	 * 				defaultHeader(header: "apikey", value: "" )
	 *    }
	 * @return
	 */
}
