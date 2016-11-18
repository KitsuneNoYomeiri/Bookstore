package Takala.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Takala.BookStore.Book.Category;
import Takala.BookStore.Book.Book;
import Takala.BookStore.Book.BookRepositort;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositortTest {

	@Autowired
	private BookRepositort repository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Dune");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getIsbn()).isEqualTo("111-222");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Potato", "Takala", 2016, "333-444", 33.45, new Category("Sci-Fi"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
}
