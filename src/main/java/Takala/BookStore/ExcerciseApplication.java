package Takala.BookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Takala.BookStore.Book.User;
import Takala.BookStore.Book.UserRepository;
import Takala.BookStore.Book.BookRepositort;
import Takala.BookStore.Book.Book;
import Takala.BookStore.Book.Category;
import Takala.BookStore.Book.CategoryRepository;

@SpringBootApplication
public class ExcerciseApplication {
	private static final Logger log = LoggerFactory.getLogger(ExcerciseApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ExcerciseApplication.class, args);
	}
	
@Bean
public CommandLineRunner bookDemo(BookRepositort repository, CategoryRepository crepository, UserRepository urepository){
	return (args) -> {
		log.info("save a couple of books");
		crepository.save(new Category("Sci-Fi"));
		crepository.save(new Category("Fantasy"));
		crepository.save(new Category("Science"));
		
		
		repository.save(new Book("Dune", "Frank Herbert", 1965, "111-222", 22.99, crepository.findByName("Sci-Fi").get(0)));
		repository.save(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1937, "333-44", 23.99, crepository.findByName("Fantasy").get(0)));
		
		
					User user1 = new User("user", "$2a$04$J2AH4PPW382lfKAQx6SBAONo7l/e21bhLCe.bZGY93ndyFO/frpQO", "USER");
					User user2 = new User("admin", "$2a$04$FRP6wG0k8sNoXYOgaYwM/OjRin7QlNvpI.I6zrFrw.PvoRvfs0kb2", "ADMIN");
					urepository.save(user1);
					urepository.save(user2);
		
		log.info("fetch all books");
		for (Book book : repository.findAll()) {
			log.info(book.toString());
		}
	};
}

}
