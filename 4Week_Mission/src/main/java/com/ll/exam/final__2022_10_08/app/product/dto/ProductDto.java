package com.ll.exam.final__2022_10_08.app.product.dto;

import com.ll.exam.final__2022_10_08.app.product.entity.Product;
import com.ll.exam.final__2022_10_08.util.DateTimeParser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.validation.constraints.NotNull;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class ProductDto {
    Long id;
    List<Integer> createDate;
    List<Integer> modifyDate;

    public static ProductDto fromEntity(@NotNull Product product){
        return ProductDto.builder()
                .id(product.getId())
                .createDate(DateTimeParser.dateTimeToIntegerList(product.getCreateDate()))
                .modifyDate(DateTimeParser.dateTimeToIntegerList(product.getModifyDate()))
                .build();
    }
}
