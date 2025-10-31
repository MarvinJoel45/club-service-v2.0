package com.nativatec.club_service.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClubRequestDto {
    @NotBlank
    private String name;

    @JsonProperty("foundation_date")
    private LocalDate foundationDate;

    @JsonProperty("district_code")
    private String districtCode;

    private Boolean active;

    @JsonProperty("logo_url")
    private String logoUrl;
}
