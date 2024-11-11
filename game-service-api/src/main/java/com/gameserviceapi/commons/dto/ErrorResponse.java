package com.gameserviceapi.commons.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private Integer statusCode;
    private String message;
}
