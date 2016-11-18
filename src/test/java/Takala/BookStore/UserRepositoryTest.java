package Takala.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import Takala.BookStore.Book.User;
import Takala.BookStore.Book.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByUserNameShouldReturnRole() {
		User users = repository.findByUsername("admin");
		
		assertThat(users.getRole()).isEqualTo("ADMIN");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("Potato", "$2a$08$ugDu4yzVXm9VNMoOLRhd9.lYN03woLuHX21u8IWgFopNZOARJMbxC", "USER");
		repository.save(user);
		assertThat(user.getRole()).isNotNull();
	}
}
