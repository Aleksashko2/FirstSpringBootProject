package com.shopingcart.tryout.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponse {
    private String message;
    private Object data;


}
