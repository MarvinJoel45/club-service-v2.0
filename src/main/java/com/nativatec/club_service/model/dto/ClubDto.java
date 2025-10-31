package com.nativatec.club_service.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClubDto {
    private UUID id;
    private String code;

    @NotBlank
    private String name;

    @JsonProperty("logo_url")
    private LocalDate foundationDate;

    @JsonProperty("district_code")
    private String districtCode;

    private Boolean active;

    @JsonProperty("logo_url")
    private String logoUrl;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
