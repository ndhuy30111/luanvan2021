package com.stu.luanvan.request;

import com.stu.luanvan.locales.ValidataLocales;
import com.stu.luanvan.locales.ValidataPattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorRequest {
    private Integer id;
    @NotBlank(message = ValidataLocales.NAME_NOTBLANK)
    @Pattern(regexp = ValidataPattern.NAME_PATTERN,message = ValidataLocales.NAME_PATTERN)
    private String name;
    public void setName(String name) {
        this.name = StringUtils.normalizeSpace(name);
    }
    private String code;
}
