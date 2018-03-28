package hh.palvelinohjelmointi.todolist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.todolist.domain.Object;
import hh.palvelinohjelmointi.todolist.domain.ObjectRepository;
import hh.palvelinohjelmointi.todolist.domain.Category;
import hh.palvelinohjelmointi.todolist.domain.CategoryRepository;
import hh.palvelinohjelmointi.todolist.domain.User;
import hh.palvelinohjelmointi.todolist.domain.UserRepository;


@SpringBootApplication
public class TodolistApplication {
private static final Logger log = LoggerFactory.getLogger(TodolistApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner MarketplaceDemo(ObjectRepository orepo,UserRepository urepo, CategoryRepository crepo) {
		return (args) ->{
			log.info("Save couple products");
			
			crepo.save(new Category("book"));
			crepo.save(new Category("movie"));
			crepo.save(new Category("game"));
			crepo.save(new Category("series"));
			
			orepo.save(new Object("riders of the lost ark", "watched", crepo.findByName("movie").get(0)));
			orepo.save(new Object("Darker than black", "watched", crepo.findByName("series").get(0)));
			// user1 pwd kissa1
			//user2 pwd koira
			//User user1 = new User ("user1", "$2a$04$eFmZjG0ZDr2w88SS5pUo3.Cl.wYS0DbUA6CZQcGYGJHPGEdNXI7xy", "user1@email.com", "USER");
			User user2 = new User ("admin", "$2a$04$ASLbEOoFEFPSZY91ESWte.p28OVdQesWREu2xA84jSn9wZFGe49nm", "admin@email.com", "ADMIN");
			//urepo.save(user1);
			urepo.save(user2);
		};
	}
}
