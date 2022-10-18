package com.ll.exam.books_YonghoSong.app.post;

import com.ll.exam.books_YonghoSong.app.post.dto.ResponsePost;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    /**
     * todo
     * Primary : 글 작성, 글 수정, 글 리스트, 글 삭제
     *
     */

    @Autowired
    private final PostService postService;

    @GetMapping("/")
    @ResponseBody
    String mainPage(){

        return "성공!";
    }

    @GetMapping("/post/list")
    List<Post> list(){
        return postService.findAll();
    }

    @GetMapping("/post/{id}")
    ResponsePost view(@RequestParam long id){
       return postService.findPostById(id);
    }

    @GetMapping("/post/write")
    void write(){}

    @GetMapping("/post/{id}/modify")
    void modify(){}

    @PostMapping("/post/{id}/modify")
    void modifyPost(){}


}

