package com.example.test.test.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@AllArgsConstructor
@Builder
@Data
public class ErrorResponse
{
    private ZonedDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    //Вместо стандартной ошибки часть (которую я предусмотрел) перехватываю и отправляю объектом этого класса. Внешне он отличается лишь полем message
}
