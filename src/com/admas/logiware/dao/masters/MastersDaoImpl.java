package com.admas.logiware.dao.masters;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyBranchDto;
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.ProductDto;
import com.admas.logiware.dto.TransportTypeDtlDto;
import com.admas.logiware.dto.TransportTypeDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.City;
import com.admas.logiware.jpa.Company;
import com.admas.logiware.jpa.CompanyBranch;
import com.admas.logiware.jpa.Employee;
import com.admas.logiware.jpa.Product;
import com.admas.logiware.jpa.Role;
import com.admas.logiware.jpa.Settings;
import com.admas.logiware.jpa.State;
import com.admas.logiware.jpa.TransportType;
import com.admas.logiware.jpa.TransportTypeDtl;
import com.admas.logiware.jpa.sms.SmsTemplate;

public class MastersDaoImpl implements MastersDao {

	private static EntityManager entityManager;
	Logger logger = LoggerFactory.getLogger(MastersDaoImpl.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		MastersDaoImpl.entityManager = entityManager;
	}

	@Override
	public List<City> getAllCity() throws LogiwareExceptionHandler {

		List<City> lCities = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<City> criteriaQuery = criteriaBuilder
					.createQuery(City.class);
			Root<City> cityJpa = criteriaQuery.from(City.class);
			Predicate notDeleted = criteriaBuilder.equal(cityJpa.get("delFlag"), 'N');
			criteriaQuery.select(cityJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<City> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lCities = typedQuery.getResultList();

			if (lCities != null && lCities.size() != 0) {
				return lCities;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CITY_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			City city = cityDto._toJpa();
			entityManager.persist(city);
			entityManager.flush();
			if (city.getId() != null || city.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editCity(CityDto cityDto) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			City city =cityDto._toJpa();
			entityManager.merge(city);
			entityManager.flush();
			if (city.getId() != null || city.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteCity(Integer cityId) throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE City SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", cityId);
			int updateResult = query.executeUpdate();
			if (updateResult != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	public List<Company> getAllCompany() throws LogiwareExceptionHandler {

		List<Company> lCompanies = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Company> criteriaQuery = criteriaBuilder
					.createQuery(Company.class);
			Root<Company> companyJpa = criteriaQuery.from(Company.class);
			Predicate notDeleted=criteriaBuilder.equal(companyJpa.get("delFlag"), 'N');
			criteriaQuery.select(companyJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<Company> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lCompanies = typedQuery.getResultList();

			if (lCompanies != null && lCompanies.size() != 0) {
				return lCompanies;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_COMPANY_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCompany",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllCompany ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addcompany(CompanyDto companyDto)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Company company = new Company();
			company.setName(companyDto.getName());
			company.setAddress(companyDto.getAddress());
			company.setContactNo1(companyDto.getContactNo1());
			company.setContactNo2(companyDto.getContactNo2());
			company.setCustId(companyDto.getCustId());
			company.setEmailId1(companyDto.getEmailId1());
			company.setEmailId2(companyDto.getEmailId2());
			company.setLogo(companyDto.getLogo());
			company.setPanNo(companyDto.getPanNo());
			company.setTanNo(companyDto.getTanNo());
			company.setTagLine(companyDto.getTagLine());
			company.setDelFlag('N');
			entityManager.persist(company);
			entityManager.flush();

			if (company.getId() != null || company.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > addCompany",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error(
			// "Exception Error in MastersDaoImpl - > addCompany",
			// e);

			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editCompany(CompanyDto companyDto)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Company company = new Company();
			company.setId(companyDto.getId());
			company.setName(companyDto.getName());
			company.setAddress(companyDto.getAddress());
			company.setContactNo1(companyDto.getContactNo1());
			company.setContactNo2(companyDto.getContactNo2());
			company.setCustId(companyDto.getCustId());
			company.setEmailId1(companyDto.getEmailId1());
			company.setEmailId2(companyDto.getEmailId2());
			company.setLogo(companyDto.getLogo());
			company.setPanNo(companyDto.getPanNo());
			company.setTanNo(companyDto.getTanNo());
			company.setTagLine(companyDto.getTagLine());
			company.setDelFlag('N');

			entityManager.merge(company);
			entityManager.flush();
			if (company.getId() != null || company.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error("Exception Error in MastersDaoImpl - > editCity ",
			// e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteCompany(Integer companyId)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE Company SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", companyId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > deleteCity",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Company getCompanyById(Integer companyId)
			throws LogiwareExceptionHandler {

		Company company = null;
		try {

			TypedQuery<Company> companyQuery = entityManager.createQuery(
					"SELECT c FROM Company c WHERE id = :id", Company.class);
			companyQuery.setParameter("id", companyId);
			company = companyQuery.getSingleResult();

			if (company != null) {
				return company;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_COMPANY_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getCompanyById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getCompanyById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public City getCityById(Integer cityId) throws LogiwareExceptionHandler {

		City city = null;
		try {

			TypedQuery<City> cityQuery = entityManager.createQuery(
					"SELECT c FROM City c WHERE id = :id", City.class);
			cityQuery.setParameter("id", cityId);
			city = cityQuery.getSingleResult();

			if (city != null) {
				return city;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_CITY_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getCityById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getCityById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Employee> getAllEmployee() throws LogiwareExceptionHandler {

		List<Employee> lEmployees = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder
					.createQuery(Employee.class);
			Root<Employee> employeeJpa = criteriaQuery.from(Employee.class);
			Predicate notDeleted=criteriaBuilder.equal(employeeJpa.get("delFlag"), 'N');
			criteriaQuery.select(employeeJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<Employee> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lEmployees = typedQuery.getResultList();

			if (lEmployees != null && lEmployees.size() != 0) {
				return lEmployees;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_EMPLOYEE_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllEmployee",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllEmployee ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}

	}

	@Override
	public Employee getEmployeeById(Integer employeeId)
			throws LogiwareExceptionHandler {

		Employee employee = null;
		try {

			TypedQuery<Employee> cityQuery = entityManager.createQuery(
					"SELECT e FROM Employee e WHERE id = :id", Employee.class);
			cityQuery.setParameter("id", employeeId);
			employee = cityQuery.getSingleResult();

			if (employee != null) {
				return employee;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_EMPLOYEE_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getEmployeeById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getEmployeeById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addEmployee(EmployeeDto employeeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Employee employee = new Employee();
			employee.setAddress(employeeDto.getAddress());
			employee.setBranchId(employeeDto.getBranchId());
			employee.setCompId(employeeDto.getCompId());
			employee.setContactNo(employeeDto.getContactNo());
			employee.setGender(employeeDto.getGender());
			// employee.setId(employeeDto.getId());
			employee.setIsSysAcc(employeeDto.getIsSysAcc());
			employee.setName(employeeDto.getName());
			employee.setPan(employeeDto.getPan());
			employee.setSalary(employeeDto.getSalary());
			employee.setSalaryType(employeeDto.getSalaryType());
			employee.setDelFlg(employeeDto.getDelFlag());
			employee.setRoleId(employeeDto.getRoleId());
			entityManager.persist(employee);
			entityManager.flush();
			if (employee.getId() != null || employee.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > addEmployee",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > addEmployee",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editEmployee(EmployeeDto employeeDto)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			Employee employee = new Employee();
			
			employee.setAddress(employeeDto.getAddress());
			employee.setBranchId(employeeDto.getBranchId());
			employee.setCompId(employeeDto.getCompId());
			employee.setContactNo(employeeDto.getContactNo());
			employee.setGender(employeeDto.getGender());
			 employee.setId(employeeDto.getId());
			employee.setIsSysAcc(employeeDto.getIsSysAcc());
			employee.setName(employeeDto.getName());
			employee.setPan(employeeDto.getPan());
			employee.setSalary(employeeDto.getSalary());
			employee.setSalaryType(employeeDto.getSalaryType());
			employee.setDelFlg(employeeDto.getDelFlag());
			employee.setRoleId(employeeDto.getRoleId());
			
			entityManager.merge(employee);
			entityManager.flush();
			
			if (employee.getId() != null || employee.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editEmployee",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error("Exception Error in MastersDaoImpl - > editCity ",
			// e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteEmployee(Integer employeeId)
			throws LogiwareExceptionHandler {
		
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE Employee SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", employeeId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteEmployee",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error(
			// "Exception Error in MastersDaoImpl - > deleteCity", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addaddTransportType(TransportTypeDto transportTypeDto)
			throws LogiwareExceptionHandler {

		Boolean result = false;
		try {
			TransportType transportType = new TransportType();
			transportType.setCompId(transportTypeDto.getCompId());
			transportType.setName(transportTypeDto.getName());
			transportType.setDescription(transportTypeDto.getDescription());
			transportType.setDelFlag('N');
			entityManager.persist(transportType);
			entityManager.flush();

			if (transportType.getId() != null || transportType.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > addaddTransportType",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > addaddTransportType ",e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<TransportType> getAllTransportType()
			throws LogiwareExceptionHandler {

		List<TransportType> lTransportTypes = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TransportType> criteriaQuery = criteriaBuilder
					.createQuery(TransportType.class);
			Root<TransportType> transportTypeJpa = criteriaQuery.from(TransportType.class);
			Predicate notDeleted=criteriaBuilder.equal(transportTypeJpa.get("delFlag"), 'N');
			criteriaQuery.select(transportTypeJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<TransportType> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lTransportTypes = typedQuery.getResultList();
			
			if (lTransportTypes != null && lTransportTypes.size() != 0) {
				return lTransportTypes;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_TRANSPORTTYPE_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllCity",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllCity ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	
	}

	@Override
	public TransportType getTransportTypeById(Integer transportTypeId)
			throws LogiwareExceptionHandler {		
		TransportType transportType = null;
		try {
			TypedQuery<TransportType> transportTypeQuery = entityManager.createQuery(
					"SELECT t FROM TransportType t WHERE id = :id", TransportType.class);
			transportTypeQuery.setParameter("id", transportTypeId);
			transportType = transportTypeQuery.getSingleResult();

			if (transportType != null) {
				return transportType;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_TRANSPORTTYPE_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getTransportTypeById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getTransportTypeById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editTransportType(TransportTypeDto transportTypeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			TransportType transportType = new TransportType();
			transportType.setCompId(transportTypeDto.getCompId());
			transportType.setDescription(transportTypeDto.getDescription());
			transportType.setId(transportTypeDto.getId());
			transportType.setDelFlag(transportTypeDto.getDelFlag());
			transportType.setName(transportTypeDto.getName());
			entityManager.merge(transportType);
			entityManager.flush();
			
			if (transportType.getId() != null || transportType.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editTransportType",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error("Exception Error in MastersDaoImpl - > editTransportType ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteTransportType(Integer transportTypeId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE TransportType SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", transportTypeId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteTransportType",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error( "Exception Error in MastersDaoImpl - > deleteTransportType", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	// start transport type details dao 
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addaddTransportTypeDtl(TransportTypeDtlDto transportTypeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			TransportTypeDtl transportTypeDtl = new TransportTypeDtl();
			transportTypeDtl = transportTypeDtl._toJpa(transportTypeDto);			
			entityManager.persist(transportTypeDtl);
			entityManager.flush();
			
			if (transportTypeDtl.getId() != null || transportTypeDtl.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > addaddTransportTypeDtl",he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > addaddTransportTypeDtl ",e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<TransportTypeDtl> getAllTransportTypeDtl(Integer transportTypeId)
			throws LogiwareExceptionHandler {
		List<TransportTypeDtl> lTransportTypeDtls = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<TransportTypeDtl> criteriaQuery = criteriaBuilder
					.createQuery(TransportTypeDtl.class);
			Root<TransportTypeDtl> transportTypeJpa = criteriaQuery.from(TransportTypeDtl.class);
			Predicate transId=criteriaBuilder.equal(transportTypeJpa.get("transId"), transportTypeId);
			Predicate notDeleted=criteriaBuilder.equal(transportTypeJpa.get("delFlag"), 'N');
			criteriaQuery.select(transportTypeJpa);
			criteriaQuery.where(transId, notDeleted);
			TypedQuery<TransportTypeDtl> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lTransportTypeDtls = typedQuery.getResultList();		
			
			if (lTransportTypeDtls != null && lTransportTypeDtls.size() != 0) {
				return lTransportTypeDtls;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_TRANSPORTTYPE_DTL_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllTransportTypeDtl",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllTransportTypeDtl ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public TransportTypeDtl getTransportTypeDtlById(Integer transportTypeId)
			throws LogiwareExceptionHandler {
		TransportTypeDtl transportTypeDtls = null;
		try {

			TypedQuery<TransportTypeDtl> transportTypeQuery = entityManager.createQuery(
					"SELECT t FROM TransportTypeDtl t WHERE id = :id", TransportTypeDtl.class);
			transportTypeQuery.setParameter("id", transportTypeId);
			transportTypeDtls = transportTypeQuery.getSingleResult();

			if (transportTypeDtls != null) {
				return transportTypeDtls;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_TRANSPORTTYPE_DTL_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getTransportTypeDtlById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getTransportTypeDtlById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editTransportTypeDtl(TransportTypeDtlDto transportTypeDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			TransportTypeDtl transportTypeDtl = new TransportTypeDtl();
			transportTypeDtl = transportTypeDtl._toJpa(transportTypeDto);
			entityManager.merge(transportTypeDtl);
			entityManager.flush();
			
			if (transportTypeDtl.getId() != null || transportTypeDtl.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editTransportTypeDtl",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error("Exception Error in MastersDaoImpl - > editTransportTypeDtl ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteTransportTypeDtl(Integer transportTypeDtlId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE TransportTypeDtl SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", transportTypeDtlId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteTransportTypeDtl",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error( "Exception Error in MastersDaoImpl - > deleteTransportTypeDtl", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}
	
	// end transport type details dao 
	
	// start branch details dao 

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addBranch(CompanyBranchDto companyBranchDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {	
			CompanyBranch companyBranch = new CompanyBranch();
			companyBranch = companyBranchDto._toJpa();
			entityManager.persist(companyBranch);
			entityManager.flush();			
			if (companyBranch.getId() != null || companyBranch.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > addaddTransportTypeDtl",he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > addaddTransportTypeDtl ",e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<CompanyBranch> getAllBranch() throws LogiwareExceptionHandler {
		List<CompanyBranch> lCompanyBranchs = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<CompanyBranch> criteriaQuery = criteriaBuilder
					.createQuery(CompanyBranch.class);
			Root<CompanyBranch> BranchJpa = criteriaQuery.from(CompanyBranch.class);
			Predicate notDeleted=criteriaBuilder.equal(BranchJpa.get("delFlag"), 'N');
			criteriaQuery.select(BranchJpa);
			criteriaQuery.where(notDeleted);
			TypedQuery<CompanyBranch> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lCompanyBranchs = typedQuery.getResultList();

			if (lCompanyBranchs != null && lCompanyBranchs.size() != 0) {
				return lCompanyBranchs;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_BRANCH_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllBranch",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllBranch ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public CompanyBranch getBranchById(Integer companyBranchId)
			throws LogiwareExceptionHandler {
		CompanyBranch companyBranch = null;
		try {

			TypedQuery<CompanyBranch> transportTypeQuery = entityManager.createQuery(
					"SELECT c FROM CompanyBranch c WHERE id = :id", CompanyBranch.class);
			transportTypeQuery.setParameter("id", companyBranchId);
			companyBranch = transportTypeQuery.getSingleResult();

			if (companyBranch != null) {
				return companyBranch;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_BRANCH_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getBranchById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getBranchById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editBranch(CompanyBranchDto companyBranchDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			entityManager.merge(companyBranchDto._toJpa());
			entityManager.flush();
			
			if (companyBranchDto._toJpa().getId() != null || companyBranchDto._toJpa().getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editBranch",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error("Exception Error in MastersDaoImpl - > editBranch ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteBranch(Integer companyBranchId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE CompanyBranch SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", companyBranchId);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteTransportTypeDtl",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error( "Exception Error in MastersDaoImpl - > deleteTransportTypeDtl", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<State> getAllState() throws LogiwareExceptionHandler {
		List<State> lStates = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<State> criteriaQuery = criteriaBuilder
					.createQuery(State.class);
			Root<State> transportTypeJpa = criteriaQuery.from(State.class);
			criteriaQuery.select(transportTypeJpa);
			TypedQuery<State> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lStates = typedQuery.getResultList();

			if (lStates != null && lStates.size() != 0) {
				return lStates;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_BRANCH_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllBranch",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllBranch ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}
	}

	@Override
	public Settings getSettingByType(Integer compId, String type)
			throws LogiwareExceptionHandler {
		Settings settings = null;
		try {
			TypedQuery<Settings> transportTypeQuery = entityManager.createQuery(
					"SELECT c FROM Settings c WHERE compId = :compId AND type = :type", Settings.class);
			transportTypeQuery.setParameter("compId", compId );
			transportTypeQuery.setParameter("type", type );
			settings = transportTypeQuery.getSingleResult();

			if (settings != null) {
				return settings;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_SETTINGS_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getSettingByType",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch(NoResultException noResult){
			logger.error(
					"Exception Error in MastersDaoImpl - > NoResultException",
					noResult);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.NO_SETTINGS_FOUND);
		}catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getSettingByType",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Settings> getSettingAllByType(Integer compId, String type)
			throws LogiwareExceptionHandler {
		 List<Settings> lSettings = null;
		try {
			TypedQuery<Settings> settingQuery = entityManager.createQuery(
					"SELECT c FROM Settings c WHERE compId = :compId AND type = :type", Settings.class);
			settingQuery.setParameter("compId", compId );
			settingQuery.setParameter("type", type );
			lSettings = settingQuery.getResultList();

			if (lSettings != null) {
				return lSettings;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_SETTINGS_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getSettingAllByType",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch(NoResultException noResult){
			logger.error(
					"Exception Error in MastersDaoImpl - > getSettingAllByType",
					noResult);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.NO_SETTINGS_FOUND);
		}catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getSettingAllByType",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}
	
	// end branch details dao
	
	
	@Override
	public List<State> getAllStates() throws LogiwareExceptionHandler {


		List<State> lStates = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<State> criteriaQuery = criteriaBuilder
					.createQuery(State.class);
			Root<State> stateJpa = criteriaQuery.from(State.class);
			criteriaQuery.select(stateJpa);
			TypedQuery<State> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lStates = typedQuery.getResultList();

			if (lStates != null && lStates.size() != 0) {
				return lStates;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_STATE_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllStates",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllStates ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}

	
	}

	@Override
	public List<Role> getAllRole(int compId) throws LogiwareExceptionHandler {
		List<Role> lRoles = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Role> criteriaQuery = criteriaBuilder
					.createQuery(Role.class);
			Root<Role> roleJpa = criteriaQuery.from(Role.class);
			Predicate notDeleted=criteriaBuilder.equal(roleJpa.get("delFlag"), 'N');
			Predicate companyId=criteriaBuilder.equal(roleJpa.get("compId"), compId);
			criteriaQuery.select(roleJpa);
			criteriaQuery.where(notDeleted, companyId);
			TypedQuery<Role> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lRoles = typedQuery.getResultList();

			if (lRoles != null && lRoles.size() != 0) {
				return lRoles;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_ROLE_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllRole",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllRole ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}

	}

	@Override
	public SmsTemplate getTemplateByType(Integer compId, String type)
			throws LogiwareExceptionHandler {
		SmsTemplate template = null;
		try {
			TypedQuery<SmsTemplate> templateTypeQuery = entityManager.createQuery(
					"SELECT c FROM SmsTemplate c WHERE compId = :compId AND type = :type", SmsTemplate.class);
			templateTypeQuery.setParameter("compId", compId );
			templateTypeQuery.setParameter("type", type );
			template = templateTypeQuery.getSingleResult();

			if (template != null) {
				return template;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_SETTINGS_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getTemplateByType",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch(NoResultException noResult){
			logger.error(
					"Exception Error in MastersDaoImpl - > NoResultException",
					noResult);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.NO_SETTINGS_FOUND);
		}catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getTemplateByType",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<SmsTemplate> getAllTemplateByType(Integer compId, String type)
			throws LogiwareExceptionHandler {
		 List<SmsTemplate> lSettings = null;
			try {
				TypedQuery<SmsTemplate> settingQuery = entityManager.createQuery(
						"SELECT c FROM SmsTemplate c WHERE compId = :compId AND templateType = :templateType", SmsTemplate.class);
				settingQuery.setParameter("compId", compId );
				settingQuery.setParameter("templateType", type );
				lSettings = settingQuery.getResultList();

				if (lSettings != null) {
					return lSettings;
				} else {
					throw new LogiwareExceptionHandler(
							LogiwareServiceErrors.NO_SETTINGS_FOUND);
				}

			} catch (HibernateException he) {
				logger.error(
						"HibernateException Error in MastersDaoImpl - > getAllTemplateByType",
						he);
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
			} catch(NoResultException noResult){
				logger.error(
						"Exception Error in MastersDaoImpl - > getAllTemplateByType",
						noResult);
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_SETTINGS_FOUND);
			}catch (Exception e) {
				logger.error(
						"Exception Error in MastersDaoImpl - > getAllTemplateByType",
						e);
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.GENERIC_EXCEPTION);
			} finally {
				entityManager.close();
			}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean addProduct(ProductDto productDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {	
			Product product = new Product();
			product = productDto._toJpa();
			entityManager.persist(product);
			entityManager.flush();			
			if (product.getId() != null || product.getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > addProduct",he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > addProduct ",e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Product> getAllProduct() throws LogiwareExceptionHandler {
		List<Product> lProduct = null;
		CriteriaBuilder criteriaBuilder = null;
		try {

			criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Product> criteriaQuery = criteriaBuilder
					.createQuery(Product.class);
			Root<Product> stateJpa = criteriaQuery.from(Product.class);
			Predicate notDeleted=criteriaBuilder.equal(stateJpa.get("delFlag"), 'N');
			criteriaQuery.where(notDeleted);
			criteriaQuery.select(stateJpa);
			TypedQuery<Product> typedQuery = entityManager
					.createQuery(criteriaQuery);
			lProduct = typedQuery.getResultList();

			if (lProduct != null && lProduct.size() != 0) {
				return lProduct;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_STATE_FOUND);
			}

		} catch (LogiwareExceptionHandler ex) {
			throw ex;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getAllProduct",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getAllStates ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			criteriaBuilder = null;
		}

	}

	@Override
	public Product getProductById(Integer id) throws LogiwareExceptionHandler {
		Product companyBranch = null;
		try {

			TypedQuery<Product> transportTypeQuery = entityManager.createQuery(
					"SELECT c FROM Product c WHERE id = :id", Product.class);
			transportTypeQuery.setParameter("id", id);
			companyBranch = transportTypeQuery.getSingleResult();

			if (companyBranch != null) {
				return companyBranch;
			} else {
				throw new LogiwareExceptionHandler(
						LogiwareServiceErrors.NO_BRANCH_FOUND);
			}

		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > getProductById",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			logger.error(
					"Exception Error in MastersDaoImpl - > getProductById",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean editProduct(ProductDto productDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			entityManager.merge(productDto._toJpa());
			entityManager.flush();
			
			if (productDto._toJpa().getId() != null || productDto._toJpa().getId() != 0) {
				result = true;
			}
			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > editProduct",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error("Exception Error in MastersDaoImpl - > editProduct ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Boolean deleteProduct(Integer id) throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			Query query = entityManager
					.createQuery("UPDATE Product SET  delFlag = 'Y' WHERE id = :id");
			query.setParameter("id", id);
			int updateResult = query.executeUpdate();

			if (updateResult != 0) {
				result = true;
			}

			return result;
		} catch (HibernateException he) {
			logger.error(
					"HibernateException Error in MastersDaoImpl - > deleteProduct",
					he);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION_HIBERNATE);
		} catch (Exception e) {
			 logger.error( "Exception Error in MastersDaoImpl - > deleteProduct", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		} finally {
			entityManager.close();
		}
	}
	
	
}
