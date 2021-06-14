package com.stu.luanvan.controller.admin.detailsproduct;

import com.stu.luanvan.request.DetailsProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface DetailsProductInterfaceController {
    ResponseEntity<?> postSave(@Valid @RequestBody DetailsProductRequest detailsProductRequest) throws Exception;
}
