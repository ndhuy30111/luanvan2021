package com.stu.luanvan.request;

import com.stu.luanvan.model.CategoryModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryRequest {
    private Integer id;
    private String name;
    private Integer sort;
    private CategoryRequest category_id;
}
