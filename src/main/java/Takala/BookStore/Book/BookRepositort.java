package Takala.BookStore.Book;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BookRepositort extends CrudRepository<Book, Long> {
	
	List<Book> findByTitle(String title);

}
