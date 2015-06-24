/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.ngemp.sms.dao;

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class StatsManager.
 */
public class StatsManager {

	/** The Constant LOG. */
	static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
			.getLogger(StatsManager.class);

	/** The ngop data source. */
	public static NGOPDataSource ngopDataSource;
	/**
	 * Instantiates a new stats manager.
	 */
	public StatsManager() {
		StatsManager.ngopDataSource = new NGOPDataSource();	
	}


	public NGOPDataSource getDatasource() {
		return ngopDataSource;
	}
}
