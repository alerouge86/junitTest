package com.alerouge.prova1.utility;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UtiJson {

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
