package com.ll.exam.final__2022_10_08.app.myBook.restcontroller;

import com.ll.exam.final__2022_10_08.app.base.dto.RsData;
import com.ll.exam.final__2022_10_08.app.base.rq.Rq;
import com.ll.exam.final__2022_10_08.app.member.service.MemberService;
import com.ll.exam.final__2022_10_08.app.myBook.dto.MyBookDetailDto;
import com.ll.exam.final__2022_10_08.app.myBook.dto.MyBookDto;
import com.ll.exam.final__2022_10_08.app.myBook.entity.MyBook;
import com.ll.exam.final__2022_10_08.app.myBook.service.MyBookService;
import com.ll.exam.final__2022_10_08.util.Ut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/v1/myBooks")
public class MyBookRestController {

    private final MemberService memberService;
    private final Rq rq;
    private final MyBookService myBookService;

    //@PreAuthorize("isAuthenticated()")
    @GetMapping("/api/v1/myBooks")
    public ResponseEntity<RsData>  BooksList(){

        Long id = rq.getMember() != null ? rq.getMember().getId() : 1; //임시, 로그인 정보 못 가져올시 1로
        List<MyBookDto> myBooks = myBookService.findAllByOwnerId(id);

       return Ut.spring.responseEntityOf(
                RsData.of(
                        "S-1",
                        "내 책 리스트 조회 성공",
                        Ut.mapOf(
                                "myBooks", myBooks
                        )
                )
        );
    }

    //@PreAuthorize("isAuthenticated()")
    @GetMapping("/api/v1/myBooks/{id}")
    public ResponseEntity<RsData>  BookDetail(long id){

        MyBook myBook = myBookService.findById(id);
        MyBookDetailDto myBookDetailDto = MyBookDetailDto.fromEntity(myBook);

        //myBookDetailDto.setBookChapters();
        return Ut.spring.responseEntityOf(
                RsData.of(
                        "S-1",
                        "내 책 조회 성공",
                        Ut.mapOf(
                                "myBook", myBookDetailDto
                        )
                )
        );
    }

}
