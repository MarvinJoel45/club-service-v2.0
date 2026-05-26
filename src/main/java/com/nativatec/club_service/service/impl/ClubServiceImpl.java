package com.nativatec.club_service.service.impl;

import com.nativatec.club_service.exception.CustomException;
import com.nativatec.club_service.exception.Message;
import com.nativatec.club_service.mapper.ClubMapper;
import com.nativatec.club_service.model.Club;
import com.nativatec.club_service.model.dto.ClubDto;
import com.nativatec.club_service.model.dto.ClubRequestDto;
import com.nativatec.club_service.repository.ClubRepository;
import com.nativatec.club_service.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    public ClubServiceImpl(ClubMapper clubMapper) {
        this.clubMapper = clubMapper;
    }

    private Club findByUuid(UUID id) {
        return clubRepository.findById(id)
                .orElseThrow(() -> new CustomException(Message.CLUB_NOT_FOUND, HttpStatus.NOT_FOUND.value()));
    }

    @Override
    public ClubDto findById(UUID id) {
        return this.clubMapper.toDto(findByUuid(id));
    }

    @Override
    public Page<ClubDto> findAll(Pageable pageable) {
        return this.clubRepository.findAll(pageable).map(clubMapper::toDto);
    }

    @Override
    public Page<ClubDto> findAllOnlyActives(Pageable pageable) {
        Page<Club> clubs = this.clubRepository.findAll(pageable);

        List<ClubDto> dtoList = clubMapper.toDtoList(
                clubs.getContent()
                        .stream()
                        .filter(p -> Boolean.TRUE.equals(p.getActive()))
                        .toList());

        return new PageImpl<>(dtoList, pageable, dtoList.size());
    }

    @Override
    public ClubDto create(ClubRequestDto clubRequestDto) {
        Optional<Club> club = this.clubRepository.findByName(clubRequestDto.getName());
        if (club.isPresent()) {
            return this.update(club.get().getId(), clubRequestDto);
        }
        else {
            return this.save(clubRequestDto);
        }
    }

    @Override
    public ClubDto update(UUID id, ClubRequestDto clubRequestDto) {
        Club club = this.clubRepository.findById(id)
                .orElseThrow(() -> new CustomException(Message.CLUB_NOT_FOUND, HttpStatus.NOT_FOUND.value()));
        this.clubMapper.updateClubFromDto(clubRequestDto, club);
        Club updated = this.clubRepository.save(club);
        return this.clubMapper.toDto(updated);
    }

    @Override
    public void delete(UUID id) {
        this.clubRepository.findById(id)
                .ifPresent(clubRepository::delete);
    }

    private ClubDto save(ClubRequestDto clubRequestDto) {
        Club newClub = clubMapper.toEntity(clubRequestDto);
        newClub = clubRepository.save(newClub);
        return clubMapper.toDto(newClub);
    }
}