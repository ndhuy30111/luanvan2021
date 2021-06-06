package com.stu.luanvan.request;

import com.stu.luanvan.locales.MessageLocales;
import com.stu.luanvan.locales.PatternLocales;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = MessageLocales.USERNAME_NOTBLANK)
    @Pattern(regexp = PatternLocales.USERNAME_PATTERN,message = MessageLocales.USERNAME_PATTERN)
    private String userName;

    @NotBlank(message = MessageLocales.NAME_NOTBLANK)
    @Pattern(regexp = PatternLocales.NAME_PATTERN,message = MessageLocales.NAME_PATTERN)
    private String name;
    public void setName(String name) {
        this.name = StringUtils.normalizeSpace(name);
    }

    @Email(message = MessageLocales.EMAIL_PATTERN)
    @NotBlank(message = MessageLocales.EMAIL_BLANK)
    private String email;
    public void setEmail(String email) {
        this.email = StringUtils.normalizeSpace(email);
    }
    @NotBlank(message = MessageLocales.PASSWORD_NOTBLANK)
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$\n",message = "Password không hợp lệ")
    private String password;
}
