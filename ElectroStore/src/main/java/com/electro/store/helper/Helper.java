package com.electro.store.helper;

import com.electro.store.dtos.PageableResponce;
import com.electro.store.dtos.UserDto;
import com.electro.store.entites.User;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    public static <U,V> PageableResponce<V> getPagableResponce(Page<U> page,Class<V> type){

        List<U> entity = page.getContent();
        List<V> dtoList = entity.stream().map(object -> new ModelMapper().map(object,type)).collect(Collectors.toList());

        PageableResponce<V> responce = new PageableResponce<>();
        responce.setContent(dtoList);
        responce.setPageNumber(page.getNumber());
        responce.setPageSize(page.getSize());
        responce.setTotelelements(page.getTotalElements());
        responce.setTotelPages(page.getTotalPages());
        responce.setLastPage(page.isLast());

        return responce;


    }
}
