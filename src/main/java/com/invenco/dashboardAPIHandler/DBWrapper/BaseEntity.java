package com.invenco.dashboardAPIHandler.DBWrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

	@JsonIgnore
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
