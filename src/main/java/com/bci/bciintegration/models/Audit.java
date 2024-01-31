package com.bci.bciintegration.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class Audit {

    @CreatedDate
    @Column(name = "created", updatable = false)
    @JsonProperty("created")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified")
    @JsonProperty("modified")
    private LocalDateTime modifiedDate;

    @LastModifiedDate
    @Column(name = "last_login")
    @JsonProperty("last_login")
    private LocalDateTime lastLogin;
}
