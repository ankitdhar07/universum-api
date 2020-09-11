package com.universum.service.i18service.service;

import com.universum.service.i18service.entity.AvailableLanguage;
import com.universum.service.i18service.repository.AvailableLanguageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class LanguageService {
	@Autowired
	private AvailableLanguageRepository languageRepository;
	
	public Iterable<AvailableLanguage> getAllLanguages(){
		log.debug("Calling getAllLanguages()");
        return languageRepository.findAll();
    }

    public AvailableLanguage findByCode(final String langCode){
    	log.debug("Calling findByCode() for language code {}.", langCode);
        return languageRepository.findByCode(langCode);
    } 
}
