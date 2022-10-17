package com.ll.exam.books_YonghoSong.app.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    @GetMapping("/")
    void mainPage(){}

    @GetMapping("/post/list")
    void list(){}

    @GetMapping("/post/{id}")
    void view(){}

    @GetMapping("/post/write")
    void write(){}

    @GetMapping("/post/{id}/modify")
    void modify(){}

    @PostMapping("/post/{id}/modify")
    void modifyPost(){}


}

