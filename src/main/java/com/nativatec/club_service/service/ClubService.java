package com.nativatec.club_service.service;

import com.nativatec.club_service.model.dto.ClubDto;
import com.nativatec.club_service.model.dto.ClubRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClubService {
    ClubDto findById(UUID id);
    Page<ClubDto> findAll(Pageable pageable);
    Page<ClubDto> findAllOnlyActives(Pageable pageable);
    ClubDto create(ClubRequestDto clubRequestDto);
    ClubDto update(UUID id, ClubRequestDto clubRequestDto);
    void delete(UUID id);
}
