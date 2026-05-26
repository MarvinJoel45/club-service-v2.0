package com.nativatec.club_service.controller;

import com.nativatec.club_service.model.dto.ClubDto;
import com.nativatec.club_service.model.dto.ClubRequestDto;
import com.nativatec.club_service.service.ClubService;
import com.nativatec.club_service.service.impl.ClubServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    private final ClubService service;

    public ClubController(ClubServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ClubDto>> list(@PageableDefault(sort = "name",page = 0, size = 10, direction =
            Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(this.service.findAllOnlyActives(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClubDto> create(@Valid @RequestBody ClubRequestDto clubRequestDto) {
        return ResponseEntity.ok(service.create(clubRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClubDto> update(@PathVariable UUID id, @Valid @RequestBody ClubRequestDto clubRequestDto) {
        return ResponseEntity.ok(service.update(id, clubRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}