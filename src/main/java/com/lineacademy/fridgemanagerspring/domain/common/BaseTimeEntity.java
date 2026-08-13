package com.lineacademy.fridgemanagerspring.domain.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @CreatedDate // 이 엔티티가 처음 생성되어 저장될 때 생성 시간을 자동으로 저장
    @Column(updatable = false, name = "created_at")  // 이 변수가 DB 칼럼 데이터 지정, updatable = false를 통해 생성 이후 업데이트 불가 처리
    private LocalDateTime createdAt;

    @LastModifiedDate  // 엔티티의 값이 변경될 때마다 자동으로 시간을 업데이트
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    // deletedAt처럼, soft delete를 하기 위한 칼럼은 어노테이션이 없음. 수동 메서드를 구현해줬음
    public void markAsDeleted() {
        this.deletedAt = LocalDateTime.now();
    }
}
