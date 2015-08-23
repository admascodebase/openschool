package com.admas.logiware.logic.masters;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.masters.MastersDao;
import com.admas.logiware.dto.CityDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.City;

public class MastersLogicImpl implements MastersLogic {

	private static MastersDao mastersDao;
	Logger logger = LoggerFactory.getLogger(MastersLogicImpl.class);

	/**
	 * @return the mastersDao
	 */
	public static MastersDao getMastersDao() {
		return mastersDao;
	}

	/**
	 * @param mastersDao
	 *            the mastersDao to set
	 */
	public static void setMastersDao(MastersDao mastersDao) {
		MastersLogicImpl.mastersDao = mastersDao;
	}

	@Override
	public List<CityDto> getAllCity() throws LogiwareExceptionHandler {
		List<City> lCities = null;
		List<CityDto> lCityDtos = new ArrayList<CityDto>();
		try {
			lCities = mastersDao.getAllCity();
			for (City city : lCities) {
				CityDto cityDto = new CityDto();
				cityDto.setId(city.getId());
				cityDto.setName(city.getName());
				cityDto.setStateId(city.getStateId());
				lCityDtos.add(cityDto);
				logger.info("City converted to Dto Successfully");
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lCityDtos;
	}

}