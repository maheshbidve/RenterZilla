package com.renterZilla.model.payload;

import java.util.List;

public record UserInfoResponse(Long id,
                               String username,
                               String email,
                               List<String> roles) {
}
