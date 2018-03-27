package hh.palvelinohjelmointi.marketplace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.marketplace.domain.Product;
import hh.palvelinohjelmointi.marketplace.domain.ProductRepository;
import hh.palvelinohjelmointi.marketplace.domain.Category;
import hh.palvelinohjelmointi.marketplace.domain.CategoryRepository;
import hh.palvelinohjelmointi.marketplace.domain.User;
import hh.palvelinohjelmointi.marketplace.domain.UserRepository;


@SpringBootApplication
public class MarketplaceApplication {
private static final Logger log = LoggerFactory.getLogger(MarketplaceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner MarketplaceDemo(ProductRepository prepo,UserRepository urepo, CategoryRepository crepo) {
		return (args) ->{
			log.info("Save couple products");
			
			crepo.save(new Category("book"));
			crepo.save(new Category("movie"));
			crepo.save(new Category("game"));
			crepo.save(new Category("other"));
			
			prepo.save(new Product("riders of the lost ark", 12.25, crepo.findByName("movie").get(0)));
			prepo.save(new Product("Last Odyssey", 39.99, crepo.findByName("game").get(0)));
			// user1 pwd kissa1
			//user2 pwd koira
			User user1 = new User ("user1", "$2a$04$eFmZjG0ZDr2w88SS5pUo3.Cl.wYS0DbUA6CZQcGYGJHPGEdNXI7xy", "user1@email.com", "USER");
			User user2 = new User ("admin", "$2a$04$ASLbEOoFEFPSZY91ESWte.p28OVdQesWREu2xA84jSn9wZFGe49nm", "admin@email.com", "ADMIN");
			urepo.save(user1);
			urepo.save(user2);
		};
	}
}
