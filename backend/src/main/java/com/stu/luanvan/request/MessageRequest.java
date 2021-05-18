package com.stu.luanvan.request;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private String message;
    private Object data;

    public MessageRequest(String message) {
        this.message = message;
    }
}
