package com.alerouge.prova1.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DatiSessione {

	private String nomeSessione;

	public void init(String nome) {
		setNomeSessione(nome);
	}
	
	public String getNomeSessione() {
		return nomeSessione;
	}

	public void setNomeSessione(String nomeSessione) {
		this.nomeSessione = nomeSessione;
	}
	
}
