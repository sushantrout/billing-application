package com.tech.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseDTO<T> {
    private String message;
    private T data;
    private List<T> dataList;
    Long pageNumber;
    Long pageSize;
    Long totalRecords;
}
