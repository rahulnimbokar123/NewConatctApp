package com.me.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "mandetory name")
    @Size( min=3 ,message = "min 3 ")
        private String name;

        @Email(message = "Invalid email ")
         @NotBlank(message = "email  requird")
    private String email;

    @NotBlank(message = "password requird")
    @Size(min=6, message="min 6 char")
    private String password;

     @NotBlank(message = "About requird")
    private String about;

    @Size(min=8, max = 12, message="Invalid number")
     private String phoneNumber;

}
