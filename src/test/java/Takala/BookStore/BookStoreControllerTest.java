package Takala.BookStore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import Takala.BookStore.web.BookStoreController;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BookStoreControllerTest {

		@Autowired
		private BookStoreController controller;
		
		@Test
		public void contextLoads() throws Exception{
			assertThat(controller).isNotNull();
		}
}
