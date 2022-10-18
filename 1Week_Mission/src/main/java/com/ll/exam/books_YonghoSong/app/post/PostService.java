package com.ll.exam.books_YonghoSong.app.post;

import com.ll.exam.books_YonghoSong.app.member.MemberService;
import com.ll.exam.books_YonghoSong.app.post.dto.RequestPostModify;
import com.ll.exam.books_YonghoSong.app.post.dto.RequestPostRegister;
import com.ll.exam.books_YonghoSong.app.post.dto.ResponsePost;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final MemberService memberService;

    public ResponsePost findPostById(long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 글이 없습니다."));
       ResponsePost responsePost = ResponsePost.fromEntity(post);
       if(post.getAuthor()==null)
           throw new RuntimeException("작가 정보가 없습니다.");
       responsePost.setAuthorName(post.getAuthor().getNickname());
       return responsePost;
    }


    public List<Post> findAll() {
        List<Post> posts = postRepository.findAll();
        // :(
        return posts;
    }


   // @Transactional
    public long createPost(RequestPostRegister requestPostRegister) {
        Post post =Post.builder()
                .subject(requestPostRegister.getSubject())
                .content(requestPostRegister.getContent())
                .contentHtml(requestPostRegister.getContentHtml())
                .author(memberService.findByUsername(requestPostRegister.getAuthorName()))
                .build();

        return postRepository.save(post).getId();
    }

    public long updatePost(long id, RequestPostModify requestPostModify) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 글이 없습니다."));
        post.setContent(requestPostModify.getContent());
        post.setSubject(requestPostModify.getSubject());
        post.setContentHtml(requestPostModify.getContentHtml());
        return post.getId();
    }
}
