package com.stu.luanvan.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private String message;
    private Object data;

    public MessageRequest(String message) {
        this.message = message;
    }
}
