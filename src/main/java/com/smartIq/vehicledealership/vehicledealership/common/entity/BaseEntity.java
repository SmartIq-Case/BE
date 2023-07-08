package com.smartIq.vehicledealership.vehicledealership.common.entity;


import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * Entity nesnelerinin ortak alanlarının tanımlandığı temel abstract
 * sınıfıdır.Bir entity nesnesi oluşturulurken bu nesne extend edilerek
 * ortak alanlara ulaşılabilinir.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass

public abstract class BaseEntity {
    //TODO:-PreCreate - PreUpdate yazılacak security de dahil olacak.

    @Column(name = "created_by")
    protected Long createdBy;
    @Column(name = "created_at")
    protected LocalDateTime createdAt;
    @Column(name = "updated_by")
    protected Long updatedBy;
    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

}
