package com.example.test.Response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {

    private String token;
}
