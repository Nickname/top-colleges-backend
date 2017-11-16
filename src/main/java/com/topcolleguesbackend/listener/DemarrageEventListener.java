package com.topcolleguesbackend.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.topcolleguesbackend.service.InitialiserDonneesService;

@Component
public class DemarrageEventListener {
	@Autowired InitialiserDonneesService initData;
	
	@EventListener({ContextRefreshedEvent.class})
	public void initialiser() {
		initData.init();
	}
}
