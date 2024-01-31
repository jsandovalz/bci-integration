package com.bci.bciintegration.dto;

import com.bci.bciintegration.models.Phone;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class UserResponse {
    private UUID id;
    private String name;
    private String email;
    private String token;
    private Set<Phone> phones = new HashSet<>();
    private Boolean active;
}
