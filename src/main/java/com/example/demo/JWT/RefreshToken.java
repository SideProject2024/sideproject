package com.example.demo.JWT;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@AllArgsConstructor
@RedisHash(value = "refreshToken", timeToLive = 60 * 60 * 24 * 7)
@Builder
public class RefreshToken {

    @Id
    private String refreshToken;
    private Long memberId;
}
