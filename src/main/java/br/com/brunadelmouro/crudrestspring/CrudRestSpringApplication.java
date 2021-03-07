package br.com.brunadelmouro.crudrestspring;

import br.com.brunadelmouro.crudrestspring.model.Contact;
import br.com.brunadelmouro.crudrestspring.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class CrudRestSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudRestSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ContactRepository repository){
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i->{
						Contact c = new Contact();
						c.setName("Contact " + i);
						c.setEmail("contact" + i + "@gmail.com");
						c.setPhone("(35) 99999-9999");
						return  c;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}


}
