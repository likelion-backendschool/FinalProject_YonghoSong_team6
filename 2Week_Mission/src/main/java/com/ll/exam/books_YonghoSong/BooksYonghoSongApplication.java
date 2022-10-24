package com.ll.exam.books_YonghoSong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BooksYonghoSongApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksYonghoSongApplication.class, args);
	}

}
