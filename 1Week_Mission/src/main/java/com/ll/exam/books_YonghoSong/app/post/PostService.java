package com.ll.exam.books_YonghoSong.app.post;

import com.ll.exam.books_YonghoSong.app.post.dto.ResponsePost;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private final PostRepository postRepository;

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
        return null;
    }


}
