package com.stu.luanvan.request;

import com.stu.luanvan.locales.ValidataLocales;
import com.stu.luanvan.locales.ValidataPattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = ValidataLocales.USERNAME_NOTBLANK)
    @Pattern(regexp = ValidataPattern.USERNAME_PATTERN,message = ValidataLocales.USERNAME_PATTERN)
    private String userName;
    @NotBlank(message = ValidataLocales.PASSWORD_NOTBLANK)
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$\n",message = "Password không hợp lệ")
    private String password;
}
