package com.stu.luanvan.request;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailsProductRequest {
    private Integer id;
    private ColorRequest color;
    private String image;
    private FileRequest file;
    private Collection<SizeRequest> size;
    private Integer productId;
}
