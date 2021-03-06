package com.universum.service.security.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.universum.common.model.UniversumPageRequest;
import com.universum.common.model.UniversumPageResponse;
import com.universum.service.security.dto.RoleDTO;
import com.universum.service.security.entity.ApplicationRole;
import com.universum.service.security.repository.AppRoleRepository;

@Service
public class AppRoleService {
	@Autowired
	private AppRoleRepository roleRepository;
	
	public UniversumPageResponse<RoleDTO> findAllRoles(final UniversumPageRequest appPageRequest) {
		Optional<Direction> sortDir = Direction.fromOptionalString(appPageRequest.getOrder());
		PageRequest pageRequest = PageRequest.of(appPageRequest.getOffset(), appPageRequest.getLimit(), sortDir.isPresent() ? sortDir.get() : Direction.ASC , appPageRequest.getSort());
        
		Page<ApplicationRole> pageResponse = roleRepository.findAllByDeletedFalse(pageRequest);
		List<RoleDTO> roleDTOList = Optional.of(pageResponse.getContent()).orElseGet(Collections::emptyList).stream()
                .map(RoleDTO::fromEntity).collect(Collectors.toList());
        
        return new UniversumPageResponse<>(pageResponse.getTotalElements(), pageResponse.getTotalPages(), pageResponse.getNumber(), roleDTOList);
    }
}
