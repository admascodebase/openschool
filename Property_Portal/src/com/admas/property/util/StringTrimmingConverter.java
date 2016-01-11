package com.admas.property.util;

import org.springframework.core.convert.converter.Converter;

/**
 * The Class StringTrimmingConverter.
 */
public class StringTrimmingConverter implements Converter<String, String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.convert.converter.Converter#convert(java.lang
	 * .Object)
	 */
	@Override
	public String convert(String source) {
		return source.trim();
	}

}
