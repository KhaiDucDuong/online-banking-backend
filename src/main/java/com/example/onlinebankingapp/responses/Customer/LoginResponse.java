package com.example.onlinebankingapp.responses.Customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
//    @JsonProperty("message")
//    private String message;

    @JsonProperty("token")
    private String token;

    @JsonProperty("refresh_token")
    private String refreshToken;
    @Builder.Default
    private String tokenType = "Bearer";
    //user's detail
    private Long id;

    @JsonProperty("full_name")
    private String fullName;


}
