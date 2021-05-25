package com.stu.luanvan.request;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryRequest {
    private Integer id;
    @NotBlank(message = "Bạn không được để trống name")
    @Pattern(regexp = "^[\\p{L} . '-]+$",message = "Tên không hợp lệ")
    private String name;
    public void setName(String name) {
        this.name = StringUtils.normalizeSpace(name);
    }
    private Integer sort;
    private String category;

}
