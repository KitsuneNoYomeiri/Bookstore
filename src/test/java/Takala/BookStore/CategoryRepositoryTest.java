package Takala.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Takala.BookStore.Book.Category;
import Takala.BookStore.Book.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = repository.findByName("Sci-Fi");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCategoryid()).isEqualTo(1);
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Biography");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}

}
