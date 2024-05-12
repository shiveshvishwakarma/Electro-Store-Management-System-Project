package com.electro.store.dtos;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PageableResponce<T> {

    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totelelements;
    private int totelPages;
    private boolean lastPage;

}
