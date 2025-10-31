package com.nativatec.club_service.repository;

import com.nativatec.club_service.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClubRepository extends JpaRepository<Club, UUID> {
    Optional<Club> findByName(String name);
}