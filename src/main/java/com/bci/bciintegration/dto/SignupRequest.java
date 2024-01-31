package com.bci.bciintegration.dto;

import com.bci.bciintegration.models.Phone;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class SignupRequest {
    @NotBlank
    @Length(min = 2,max =30)
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
    private Set<Phone> phones = new HashSet<>();
}
