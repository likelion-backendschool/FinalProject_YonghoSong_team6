package com.ll.exam.books_YonghoSong.app.product.dto;

import com.ll.exam.books_YonghoSong.app.post.tags.PostKeyword;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;


@Data
@AllArgsConstructor
@Builder
public class RequestProductCreate {

    @NotNull
    String subject;

    @NotNull
    long price;

    @Nullable
    PostKeyword postKeyword;
}
