package com.ll.exam.final__2022_10_08.app.myBook.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/v1/myBooks")
public class MyBookRestController {

    @GetMapping("/api/v1/myBooks")
    void BooksList(){
    }

    @GetMapping("/api/v1/myBooks/{id}")
    void BooksDetail(){
    }

}
