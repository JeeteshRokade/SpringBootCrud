package com.javatpoint.util;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.javatpoint.model.Books;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BooksUtil.class)
public class BooksUtilTest {

//	@Before
	public void setup () {
		System.out.println("setup starts");
		Books books = new Books();

		books.setAuthor("Dummy Author");
		books.setBookid(0);
		books.setBookname("Dummy book name");
		books.setPrice(100);
		
		System.out.println("setup ends");
	}
	
	@Test
	public void testBookService() {
		System.out.println("testBookService starts");

		BooksUtil booksUtil = new BooksUtil();
		booksUtil.getBooksById(0);
		
		System.out.println("testBookService ends");
	}
}