package com.nativatec.club_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "club", uniqueConstraints = {
        @UniqueConstraint(name = "club_code_uc", columnNames = {"code"}),
        @UniqueConstraint(name = "club_name_uc", columnNames = {"name"})
})
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, length = 10)
    private String code;

    @Column(nullable = false)
    private String name;

    @JsonProperty("foundation_date")
    @Column(name = "foundation_date")
    private LocalDate foundationDate;

    @JsonProperty("district_code")
    @Column(name = "district_code", length = 6)
    private String districtCode;

    @Column(nullable = false)
    private Boolean active;

    @JsonProperty("logo_url")
    @Column(name = "logo_url")
    private String logoUrl;

    @JsonProperty("created_at")
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}