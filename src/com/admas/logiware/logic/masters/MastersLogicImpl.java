package com.admas.logiware.logic.masters;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.masters.MastersDao;
import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyBranchDto;
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.SettingsDto;
import com.admas.logiware.dto.StateDto;
import com.admas.logiware.dto.TransportTypeDtlDto;
import com.admas.logiware.dto.TransportTypeDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.City;
import com.admas.logiware.jpa.Company;
import com.admas.logiware.jpa.CompanyBranch;
import com.admas.logiware.jpa.Employee;
import com.admas.logiware.jpa.Settings;
import com.admas.logiware.jpa.State;
import com.admas.logiware.jpa.TransportType;
import com.admas.logiware.jpa.TransportTypeDtl;

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
				lCityDtos.add(city._toDto());
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

	@Override
	public Boolean addCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			result = mastersDao.addCity(cityDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > addCity ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean editCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			result = mastersDao.editCity(cityDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > editCity ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;

	}

	@Override
	public Boolean deleteCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			result = mastersDao.deleteCity(cityDto);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > deleteCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public List<CompanyDto> getAllcompany() throws LogiwareExceptionHandler {

		List<Company> lCompanies = null;
		List<CompanyDto> lCompanyDtos = new ArrayList<CompanyDto>();
		try {
			lCompanies = mastersDao.getAllCompany();
			for (Company company : lCompanies) {
				CompanyDto companyDto = new CompanyDto();
				companyDto.setId(company.getId());
				companyDto.setAddress(company.getAddress());
				companyDto.setContactNo1(company.getContactNo1());
				companyDto.setContactNo2(company.getContactNo2());
				companyDto.setEmailId1(company.getEmailId1());
				companyDto.setEmailId2(company.getEmailId2());
				companyDto.setCustId(company.getId());
				companyDto.setLogo(company.getLogo());
				companyDto.setName(company.getName());
				companyDto.setPanNo(company.getPanNo());
				companyDto.setTanNo(company.getPanNo());
				companyDto.setTagLine(company.getTagLine());
				companyDto.setTanNo(company.getTanNo());
				lCompanyDtos.add(companyDto);
				logger.info("Company converted to Dto Successfully");
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lCompanyDtos;

	}

	@Override
	public Boolean addCompany(CompanyDto companyDto)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			result = mastersDao.addcompany(companyDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > addCompany ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean editCompany(CompanyDto companyDto)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			result = mastersDao.editCompany(companyDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersLogicImpl - > editCompany ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean deleteCompany(Integer companyId)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			result = mastersDao.deleteCompany(companyId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > deleteCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public CompanyDto getCompanyById(Integer companyId)
			throws LogiwareExceptionHandler {
		Company company = null;
		CompanyDto companyDto = new CompanyDto();
		try {
			company = mastersDao.getCompanyById(companyId);

			companyDto.setId(company.getId());
			companyDto.setAddress(company.getAddress());
			companyDto.setContactNo1(company.getContactNo1());
			companyDto.setContactNo2(company.getContactNo2());
			companyDto.setEmailId1(company.getEmailId1());
			companyDto.setEmailId2(company.getEmailId2());
			companyDto.setCustId(company.getId());
			companyDto.setLogo(company.getLogo());
			companyDto.setName(company.getName());
			companyDto.setPanNo(company.getPanNo());
			companyDto.setTanNo(company.getPanNo());
			companyDto.setTagLine(company.getTagLine());
			companyDto.setTanNo(company.getTanNo());
			logger.info("Company converted to Dto Successfully");

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersLogicImpl - > getCompanyById ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return companyDto;
	}

	@Override
	public CityDto getCityById(Integer cityId) throws LogiwareExceptionHandler {

		City city = null;
		try {
			city = mastersDao.getCityById(cityId);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersLogicImpl - > getCityById ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return city._toDto();

	}

	@Override
	public List<EmployeeDto> getAllEmployee() throws LogiwareExceptionHandler {

		List<Employee> lEmployees = null;
		List<EmployeeDto> lEmployeeDtos = new ArrayList<EmployeeDto>();
		try {
			lEmployees = mastersDao.getAllEmployee();

			for (Employee employee : lEmployees) {
				EmployeeDto employeeDto = new EmployeeDto();

				employeeDto.setAddress(employee.getAddress());
				employeeDto.setBranchId(employee.getBranchId());
				employeeDto.setCompId(employee.getCompId());
				employeeDto.setContactNo(employee.getContactNo());
				employeeDto.setGender(employee.getGender());
				employeeDto.setId(employee.getId());
				employeeDto.setIsSysAcc(employee.getIsSysAcc());
				employeeDto.setName(employee.getName());
				employeeDto.setPan(employee.getPan());
				employeeDto.setSalary(employee.getSalary());
				employeeDto.setSalaryType(employee.getSalaryType());
				employeeDto.setDelFlag(employee.getDelFlg());

				lEmployeeDtos.add(employeeDto);
			}

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersLogicImpl - > getAllEmployee ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lEmployeeDtos;

	}

	@Override
	public EmployeeDto getEmployeeById(Integer employeeId)
			throws LogiwareExceptionHandler {

		Employee employee = null;
		EmployeeDto employeeDto = new EmployeeDto();

		try {
			employee = mastersDao.getEmployeeById(employeeId);
			
			employeeDto.setAddress(employee.getAddress());
			employeeDto.setBranchId(employee.getBranchId());
			employeeDto.setCompId(employee.getCompId());
			employeeDto.setContactNo(employee.getContactNo());
			employeeDto.setGender(employee.getGender());
			employeeDto.setId(employee.getId());
			employeeDto.setIsSysAcc(employee.getIsSysAcc());
			employeeDto.setName(employee.getName());
			employeeDto.setPan(employee.getPan());
			employeeDto.setSalary(employee.getSalary());
			employeeDto.setSalaryType(employee.getSalaryType());
			employeeDto.setDelFlag(employee.getDelFlg());
			

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersLogicImpl - > getEmployeeById ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return employeeDto;

	}

	@Override
	public Boolean addEmployee(EmployeeDto employeeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = mastersDao.addEmployee(employeeDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > addEmployee ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean editEmployee(EmployeeDto employeeDto)
			throws LogiwareExceptionHandler {
		
		Boolean result = false;
		try {
			result = mastersDao.editEmployee(employeeDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > editEmployee ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
		
	}

	@Override
	public Boolean deleteEmployee(Integer employeeId)
			throws LogiwareExceptionHandler {
		
		Boolean result = false;
		try {
			result = mastersDao.deleteEmployee(employeeId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > deleteEmployee ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
		
	}

	@Override
	public Boolean addTransportType(TransportTypeDto transportTypeDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			result = mastersDao.addaddTransportType(transportTypeDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > addTransportType Method ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	
	}

	@Override
	public List<TransportTypeDto> getAllTransportType()
			throws LogiwareExceptionHandler {
		
		List<TransportTypeDto> lTransportTypes = new ArrayList<TransportTypeDto>();
		List<TransportType> transportTypes=null;
		try {
			transportTypes = mastersDao.getAllTransportType();
			for (TransportType transportType : transportTypes) {
				
				TransportTypeDto transportTypeDto = new TransportTypeDto();
				transportTypeDto.setCompId(transportType.getCompId());
				transportTypeDto.setDescription(transportType.getDescription());
				transportTypeDto.setId(transportType.getId());
				transportTypeDto.setName(transportType.getName());
				lTransportTypes.add(transportTypeDto);
				logger.info("Successfully Converted TransportType To Dto.");
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > getAllTransportType ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lTransportTypes;
		
	}

	@Override
	public TransportTypeDto getTransportTypeById(Integer transportTypeId)
			throws LogiwareExceptionHandler {
	
		TransportType transportType = null;
		TransportTypeDto transportTypeDto = new TransportTypeDto();
		try {
			transportType = mastersDao.getTransportTypeById(transportTypeId);

			transportTypeDto.setCompId(transportType.getCompId());
			transportTypeDto.setDescription(transportType.getDescription());
			transportTypeDto.setName(transportType.getName());
			transportTypeDto.setId(transportType.getId());
			transportTypeDto.setDelFlag(transportType.getDelFlag());
			logger.info("TransportType Converted to Dto Successfully");

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersLogicImpl - > getTransportTypeById ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return transportTypeDto;

	}

	@Override
	public Boolean editTransportType(TransportTypeDto traTypeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = mastersDao.editTransportType(traTypeDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > editTransportType ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean deleteTransportType(Integer transportTypeId)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			result = mastersDao.deleteTransportType(transportTypeId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > deleteTransportType ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	//start transport type details logic impl services
	
	@Override
	public Boolean addTransportTypeDtl(TransportTypeDtlDto transportTypeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = mastersDao.addaddTransportTypeDtl(transportTypeDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > addTransportTypeDtl ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public List<TransportTypeDtlDto> getAllTransportTypeDtl(Integer transportTypeId)
			throws LogiwareExceptionHandler {
		List<TransportTypeDtlDto> lTransportTypeDtls = new ArrayList<TransportTypeDtlDto>();
		List<TransportTypeDtl> transportTypeDtls=null;
		try {
			transportTypeDtls = mastersDao.getAllTransportTypeDtl(transportTypeId);
			for (TransportTypeDtl transportType : transportTypeDtls) {
				TransportTypeDtlDto transportTypeDto = new TransportTypeDtlDto();
				lTransportTypeDtls.add(transportTypeDto._toDto(transportType));
				logger.info("Successfully Converted TransportType To Dto.");
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > getAllTransportType ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lTransportTypeDtls;
	}

	@Override
	public TransportTypeDtlDto getTransportTypeDtlById(Integer transportTypeId)
			throws LogiwareExceptionHandler {
		TransportTypeDtl transportTypeDtl = null;
		TransportTypeDtlDto transportTypeDto = new TransportTypeDtlDto();
		try {
			transportTypeDtl = mastersDao.getTransportTypeDtlById(transportTypeId);	
			transportTypeDto = transportTypeDto._toDto(transportTypeDtl);
			logger.info("getTransportTypeDtl Converted to Dto Successfully");

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersLogicImpl - > getTransportTypeDtlById ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return transportTypeDto;
	}

	@Override
	public Boolean editTransportTypeDtl(TransportTypeDtlDto traTypeDtlDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = mastersDao.editTransportTypeDtl(traTypeDtlDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > editTransportTypeDtl ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean deleteTransportTypeDtl(Integer transportTypeDtlId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = mastersDao.deleteTransportTypeDtl(transportTypeDtlId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > deleteTransportTypeDtl ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	//end transport type details logic impl services
	
	//start branch logic impl services
	
	@Override
	public Boolean addBranch(CompanyBranchDto companyBranchDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = mastersDao.addBranch(companyBranchDto);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > addBranch ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public List<CompanyBranchDto> getAllBranch()
			throws LogiwareExceptionHandler {
		List<CompanyBranchDto> lCompanyBranchDto = new ArrayList<CompanyBranchDto>();
		List<CompanyBranch> lBranch=null;
		try {
			lBranch = mastersDao.getAllBranch();
			for (CompanyBranch companyBranchJpa : lBranch) {
				lCompanyBranchDto.add(companyBranchJpa._toDto());
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > getAllBranch ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lCompanyBranchDto;
	}

	@Override
	public CompanyBranchDto getBranchById(Integer compBranchId)
			throws LogiwareExceptionHandler {
		CompanyBranch companyBranch = null;
		try {
			companyBranch = mastersDao.getBranchById(compBranchId);	
			logger.info("getTransportTypeDtl Converted to Dto Successfully");

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersLogicImpl - > getBranchById ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return companyBranch._toDto();
	}

	@Override
	public Boolean editBranch(CompanyBranchDto comBranchDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = mastersDao.editBranch(comBranchDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > editBranch ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean deleteBranch(Integer compBranchId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = mastersDao.deleteBranch(compBranchId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > deleteBranch ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public List<StateDto> getAllState() throws LogiwareExceptionHandler {
		List<StateDto> lStateDto = new ArrayList<StateDto>();
		List<State> lState=null;
		try {
			lState = mastersDao.getAllState();
			for (State state : lState) {
				lStateDto.add(state._toDto());
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in MastersLogicImpl - > getAllState ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lStateDto;
	}

	@Override
	public SettingsDto getSettingByType(Integer compId, String type)
			throws LogiwareExceptionHandler {
		Settings settings = null;
		try {
			settings = mastersDao.getSettingByType(compId, type);	

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersLogicImpl - > getSettingByType ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return settings._toDto();
	}
	
	//end branch logic impl services
	

}