/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.logiware.resources;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.admas.logiware.constant.WebAppConstants;

/**
 * The Class NGOPSessionLocaleResolver.
 */
public class LogiwareLocaleResolver extends SessionLocaleResolver {
	
	@Override
	protected Locale determineDefaultLocale(HttpServletRequest request) {
		Locale defaultLocale = getDefaultLocale();
		if (defaultLocale == null) {
			defaultLocale = request.getLocale();
		}
		String orgCode = null;
			orgCode = WebAppConstants.DEFAULT_VALUE;
		defaultLocale = new Locale(defaultLocale.getLanguage(),
				defaultLocale.getCountry(), orgCode.replace(" ", ""));
		
		return defaultLocale;
	}

}
