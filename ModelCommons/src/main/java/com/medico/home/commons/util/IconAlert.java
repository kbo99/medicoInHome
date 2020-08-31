package com.medico.home.commons.util;

public enum IconAlert {
	WARNING("warning"),
	ERROR("error"),
	SUCCESS("success"),
	INFO("info");
	
	private final String value;

	IconAlert (String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
