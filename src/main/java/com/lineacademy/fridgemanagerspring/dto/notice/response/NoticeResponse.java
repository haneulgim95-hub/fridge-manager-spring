package com.lineacademy.fridgemanagerspring.dto.notice.response;

import com.lineacademy.fridgemanagerspring.domain.notice.Notice;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class NoticeResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 1. Notice 엔티티 객체를 파라미터로 받음
    public static NoticeResponse from(Notice notice) {
        // 2. NoticeResponse 전용 빌더를 시작함
        return NoticeResponse.builder()
                // 3. Notice에서 꺼낸 값을 NoticeResponse 필드에 세팅
                .id(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdAt(notice.getCreatedAt())
                .updatedAt(notice.getUpdatedAt())
                // 4. 세팅된 값으로 최종 NoticeResponse 객체를 생성하여 반환
                .build();
    }
}
