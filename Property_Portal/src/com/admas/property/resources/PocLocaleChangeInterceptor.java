package com.admas.property.resources;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import com.admas.property.constant.WebAppConstants;

/**
 * The Class NGOPLocaleChangeInterceptor.
 */
public class PocLocaleChangeInterceptor extends LocaleChangeInterceptor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.i18n.LocaleChangeInterceptor#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws ServletException {
		String orgCode = null;
		orgCode = WebAppConstants.DEFAULT_VALUE;
		orgCode = orgCode.replace(" ", "");
		String locale = request.getParameter(this.getParamName());
		if (locale == null) {
			if (WebUtils.getSessionAttribute(request,
					SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME) != null) {
				Locale loc = (Locale) WebUtils.getSessionAttribute(request,
						SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
				if (!orgCode.equals(loc.getVariant())) {
					LocaleResolver localeResolver = RequestContextUtils
							.getLocaleResolver(request);
					if (localeResolver == null) {
						throw new IllegalStateException(
								"No LocaleResolver found: not in a DispatcherServlet request?");
					}

					localeResolver.setLocale(request, response,
							new Locale(loc.getLanguage(), "", orgCode));
				}
			}
		} else {
			LocaleResolver localeResolver = RequestContextUtils
					.getLocaleResolver(request);
			if (localeResolver == null) {
				throw new IllegalStateException(
						"No LocaleResolver found: not in a DispatcherServlet request?");
			}

			localeResolver.setLocale(request, response, new Locale(locale, "",
					orgCode + "_Complience"));
		}
		// Proceed in any case.
		return true;
	}

}
