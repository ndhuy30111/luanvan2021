package com.stu.luanvan.request;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorRequest {
    private Integer id;
    @NotBlank(message = "Bạn không được để trống name")
    @Pattern(regexp = "^[\\p{L} . '-]+$",message = "Tên không hợp lệ")
    private String name;
    public void setName(String name) {
        this.name = StringUtils.normalizeSpace(name);
    }
    private String image;
    private FileRequest file;
    private Collection<SizeRequest> size;
    private Integer productId;
}
