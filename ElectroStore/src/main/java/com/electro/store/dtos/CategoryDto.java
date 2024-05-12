package com.electro.store.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private String categoryId;

    @NotBlank(message = "title is required !!")
    @Size(min = 4,message = "title must be minimum 4 Charactor")
    private String title;

    @NotBlank(message = "description required !!")
    private String description;

    private String coverImage;

}
