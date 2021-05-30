package com.stu.luanvan.request;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest{
    private Integer id;
    @NotBlank(message = "Bạn không được để trống name")
    @Pattern(regexp = "^[\\p{L} . '-]+$",message = "Tên không hợp lệ")
    private String name;
    public void setName(String name) {
        this.name = StringUtils.normalizeSpace(name);
    }
    private Long price;
    private String image;
    private String info;
    private String info_small;
    private FileRequest file;
    @NotBlank(message="Ban phai them category")
    private Integer category;
    private Collection<DetailsProductRequest> detailsProduct;


}
