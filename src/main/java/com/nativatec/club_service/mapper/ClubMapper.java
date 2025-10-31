package com.nativatec.club_service.mapper;

import com.nativatec.club_service.model.Club;
import com.nativatec.club_service.model.dto.ClubDto;
import com.nativatec.club_service.model.dto.ClubRequestDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    ClubMapper INSTANCE = Mappers.getMapper(ClubMapper.class);
    ClubDto toDto(Club club);
    Club toEntity(ClubRequestDto clubRequestDto);
    List<ClubDto> toDtoList(List<Club> clubs);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClubFromDto(ClubRequestDto clubRequestDto, @MappingTarget Club club);
}
