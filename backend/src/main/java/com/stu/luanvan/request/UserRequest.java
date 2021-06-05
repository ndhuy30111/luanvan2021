package com.stu.luanvan.request;

import com.stu.luanvan.locales.ValidataLocales;
import com.stu.luanvan.locales.ValidataPattern;
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
    @NotBlank(message = ValidataLocales.USERNAME_NOTBLANK)
    @Pattern(regexp = ValidataPattern.USERNAME_PATTERN,message = ValidataLocales.USERNAME_PATTERN)
    private String userName;

    @NotBlank(message = ValidataLocales.NAME_NOTBLANK)
    @Pattern(regexp = ValidataPattern.NAME_PATTERN,message = ValidataLocales.NAME_PATTERN)
    private String name;
    public void setName(String name) {
        this.name = StringUtils.normalizeSpace(name);
    }

    @Email(message = ValidataLocales.EMAIL_PATTERN)
    @NotBlank(message = ValidataLocales.EMAIL_BLANK)
    private String email;
    public void setEmail(String email) {
        this.email = StringUtils.normalizeSpace(email);
    }
    @NotBlank(message = ValidataLocales.PASSWORD_NOTBLANK)
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$\n",message = "Password không hợp lệ")
    private String password;
}
