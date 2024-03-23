package com.example.demo.JWT;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RefreshTokenDTO {

    @NotEmpty
    String refreshToken;
}
