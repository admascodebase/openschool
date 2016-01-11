package com.admas.property.resources;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.admas.property.constant.WebAppConstants;

/**
 * The Class NGOPSessionLocaleResolver.
 */
public class PocLocaleResolver extends SessionLocaleResolver {
	
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
