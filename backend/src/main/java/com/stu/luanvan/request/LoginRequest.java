package com.stu.luanvan.request;

import com.stu.luanvan.locales.MessageLocales;
import com.stu.luanvan.locales.PatternLocales;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = MessageLocales.USERNAME_NOTBLANK)
    @Pattern(regexp = PatternLocales.USERNAME_PATTERN,message = MessageLocales.USERNAME_PATTERN)
    private String userName;
    @NotBlank(message = MessageLocales.PASSWORD_NOTBLANK)
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$\n",message = "Password không hợp lệ")
    private String password;
}
