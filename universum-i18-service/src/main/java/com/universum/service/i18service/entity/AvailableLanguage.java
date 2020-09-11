package com.universum.service.i18service.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the available_language database table.
 * 
 */
@Table(name = "available_language")
@Entity
@Data
@NoArgsConstructor
public class AvailableLanguage extends AbstractBaseEntity {
	private static final long serialVersionUID = 510614895831100389L;
	
	@Column(unique=true, nullable=false, updatable=false, length = 36)
	private String code;
	
	private String dir;
	
	@Column(name = "default")
	private Boolean isDefault;
	
	private String label;
	
	@ManyToMany(mappedBy = "availableLanguageFk")
	private Set<ResourceMessage> messages;
}