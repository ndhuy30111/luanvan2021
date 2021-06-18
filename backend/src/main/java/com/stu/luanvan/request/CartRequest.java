package com.stu.luanvan.request;

import com.stu.luanvan.locales.MessageLocales;
import com.stu.luanvan.locales.PatternLocales;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CartRequest {
    private Integer quantity;
    private String color;
    private String size;
}
