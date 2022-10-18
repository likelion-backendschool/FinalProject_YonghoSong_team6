package com.ll.exam.books_YonghoSong.app.post;

import com.ll.exam.books_YonghoSong.app.post.dto.RequestPostModify;
import com.ll.exam.books_YonghoSong.app.post.dto.RequestPostRegister;
import com.ll.exam.books_YonghoSong.app.post.dto.ResponsePost;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    /**
     * todo
     * Primary : 글 작성 o, 글 수정 o, 글 리스트 O, 글 삭제
     *
     */

    @Autowired
    private final PostService postService;

    @GetMapping("/")
    @ResponseBody
    String mainPage(){

        return "스프링 세팅 성공, 시큐리티 설정 성공";
    }

    @GetMapping("/post/list")
    List<Post> list(){
        return postService.findAll();
    }

    @GetMapping("/post/{id}")
    ResponsePost view(@RequestParam long id){
       return postService.findPostById(id);
    }

    @PostMapping("/post/write")
    long write(RequestPostRegister requestPostRegister){
        return postService.createPost(requestPostRegister);
    }

    @GetMapping("/post/{id}/modify")
    void modifyPage(@RequestParam long id){
        //front
    }

    @PostMapping("/post/{id}/modify")
    long modify(@RequestParam long id, @RequestBody RequestPostModify requestPostModify){
        return postService.updatePost(id,requestPostModify);
    }


}

