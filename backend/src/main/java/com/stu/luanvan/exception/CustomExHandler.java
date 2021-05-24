package com.stu.luanvan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExHandler {
    /**
     *  mã lỗi 404
     * @param ex Thu thập lỗi
     * @param req webrequests
     * @return không tìm thấy dự liệu
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundEx.class)
    public ResponseError handlerNotFound(NotFoundEx ex, WebRequest req){
        return new ResponseError(HttpStatus.NOT_FOUND,ex.getMessage());
    }

    /**
     * lỗi code 500
     * @param ex Thu nhập lỗi
     * @param req webrequests
     * @return xử lý code lỗi
     */
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public ResponseError handlerException(Exception ex,WebRequest req){
//        return new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
//    }

    /**
     *  lỗi code 400
     * @param ex Thu nhập lỗi
     * @param req webrequests
     * @return gửi dữ liệu không phù hợp với request nhận
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestEx.class)
    public ResponseError handlerBadRequest(BadRequestEx ex,WebRequest req){
        return new ResponseError(HttpStatus.BAD_REQUEST,ex.getMessage());
    }

    /**
     * Mã lỗi 403
     * @param ex thu nhập lỗi
     * @param req webrequests
     * @return không có quyền truy cập
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenEx.class)
    public ResponseError handlerForbidden(ForbiddenEx ex,WebRequest req){
        return new ResponseError(HttpStatus.FORBIDDEN,ex.getMessage());
    }

}
