package com.electro.store.dtos;

import com.electro.store.validate.ImageNameValid;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String userId;

    @Size(min = 3, max = 15, message = "Invalid Name !!")
    private String name;


    @Pattern(regexp = "",message = "Invalid User Email !!")
    @NotBlank(message = "Email is required!!")
    private String email;


    @NotBlank(message = "Password is required !!")
    private String password;

    @Size(min = 4, max = 6, message = "Invalid gender !!")
    private String gender;

    @NotBlank(message = "Write something about yourself")
    private String about;

    //pattern
    //custom validator

    @ImageNameValid
    private String imageName;
}
