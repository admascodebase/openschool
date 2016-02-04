package com.admas.property.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.admas.property.dao.IHomeDao;
import com.admas.property.dto.BlogDto;
import com.admas.property.dto.BuilderDto;
import com.admas.property.dto.FilterDto;
import com.admas.property.dto.FloorPlanDto;
import com.admas.property.dto.InquiryDto;
import com.admas.property.dto.PaymentStructureDto;
import com.admas.property.dto.ProjectDto;
import com.admas.property.dto.VideoDto;
import com.admas.property.exception.PropertyBaseException;

@Component
@Qualifier("homeServiceImpl")
public class HomeServiceImpl implements IHomeService{

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(HomeServiceImpl.class);
	
	@Autowired
	@Qualifier("homeDaoImpl")
	private IHomeDao homeDaoImpl;// = new HomeDaoImpl();

	@Override
	public List<String> getLocations(String searchKey) throws PropertyBaseException {
		List<String> searchBooks = null;
		try{
			 searchBooks =  homeDaoImpl.getLocation("%"+searchKey+"%") ;
		}catch(Exception e){
			
		}
		return searchBooks;
	}

	
	@Override
	public List<ProjectDto> getRecentProjectsByFilter() throws PropertyBaseException {

		List<ProjectDto> projectList = new ArrayList<ProjectDto>();

		projectList = homeDaoImpl.getRecentProjectsByFilter();

		return projectList;

	}
	
	@Override
	public List<BuilderDto> getAllAgents() throws PropertyBaseException {
		
		List<BuilderDto> agentList =new ArrayList<BuilderDto>();
		agentList = homeDaoImpl.getAllAgents();
		return agentList;
	}

	@Override
	public List<ProjectDto> getProjectsByFilter(FilterDto filterDto) throws PropertyBaseException {

		List<ProjectDto> projectList = new ArrayList<ProjectDto>();

		projectList = homeDaoImpl.getProjectsByFilter(filterDto);

		return projectList;
	}


	@Override
	public ProjectDto getProjectsDetails(Integer projectId) {

		ProjectDto projectDto = new ProjectDto();
		try {
			projectDto = homeDaoImpl.getProjectsDetails(projectId);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return projectDto;

	}


	@Override
	public List<BlogDto> getAllBlogs() throws PropertyBaseException {
		List<BlogDto> blogList = new ArrayList<BlogDto>();
		blogList = homeDaoImpl.getAllBlogs();
	
		return blogList;
	}


	@Override
	public Boolean saveInquiryDto(InquiryDto inquiryDto) throws PropertyBaseException {
		
		
		Boolean result = false;
		result = homeDaoImpl.saveInquiryDto(inquiryDto);
		return result;
		
	}

	
	@Override
	public List<FloorPlanDto> floorPlanDetails(Integer projectId) {
		List<FloorPlanDto> floorplanList = new ArrayList<FloorPlanDto>(); 
		floorplanList = homeDaoImpl.floorPlanDetails(projectId);
		return floorplanList;
	}


	@Override
	public List<VideoDto> videoGallery(Integer builderId , Integer priprojectId) {
		
		List<VideoDto> videoList = new ArrayList<VideoDto>();
		videoList = homeDaoImpl.videoGallery(builderId , priprojectId);
		return videoList;
	}


	@Override
	public List<PaymentStructureDto> paymentStructure() {

		List<PaymentStructureDto> paymentList = new ArrayList<PaymentStructureDto>();
		paymentList = homeDaoImpl.paymentStructure();
		return paymentList;
	}	

	
	
	/*@Override
	public Map<String, Object> searchBooks(Map<String, Object> reqDtoObjects, Map<String, Object> resDtoObjects)
			throws PropertyBaseException {
		logger.info("HomeServiceImpl searchBooks method start. ");
		try {
			String searchKey  = reqDtoObjects.get("searchKey") !=null? reqDtoObjects.get("searchKey")+"" :"";
			//Search book and kept it in map ..
			
			Map<String, List<Book>> searchData = new HashMap<String, List<Book>>();
			
			List<Book> searchBooks =  homeDaoImpl.getBooks("%"+searchKey+"%") ;
			boolean isPrefectMatchTitle = !searchBooks.isEmpty();
			List<Book> searchAuthorBooks =  homeDaoImpl.getAuthors("%"+searchKey+"%") ;
			boolean isPrefectMatchAuthor = !searchAuthorBooks.isEmpty();
			List<Book> searchSeriesBooks =  homeDaoImpl.getSeries("%"+searchKey+"%") ;
			boolean isPrefectMatchSeries = !searchSeriesBooks.isEmpty();
			
			String closedMatchTitle = "";
			String closedMatchAuthor = "";
			String closedMatchSeries = "";
			
			if(!isPrefectMatchTitle && !isPrefectMatchAuthor && !isPrefectMatchSeries){
				List<String> booksTitles = homeDaoImpl.getBooksTitle();
				int counter= 0 ;
				int distance;
				for (String title : booksTitles) {
					distance = LevenshteinDistance.getDistance(title, searchKey);
					if((title.length() * .2) >= distance){
						searchBooks.addAll(homeDaoImpl.getBooks(title));
					}
				}	
			
				List<String> authors = homeDaoImpl.getBooksAuthors();
				counter= 0 ;
				for (String author : authors) {
					distance = LevenshteinDistance.getDistance(author, searchKey);
					if((author.length() * .2) >= distance){
						searchAuthorBooks.addAll(homeDaoImpl.getAuthors(author));
						closedMatchAuthor = author;
					}
				}
				resDtoObjects.put("closedMatchAuthor", closedMatchAuthor);
				
				List<String> serieses = homeDaoImpl.getBooksSeries();
				counter= 0 ;
				for (String series : serieses) {
					distance = LevenshteinDistance.getDistance(series, searchKey);
					if((series.length() * .2) >= distance){
						searchSeriesBooks.addAll( homeDaoImpl.getSeries(series));
						closedMatchSeries = series;
					}
				}
				resDtoObjects.put("closedMatchSeries", closedMatchSeries);
				
			}else{
				if(isPrefectMatchAuthor)
					resDtoObjects.put("closedMatchAuthor", searchKey);
				if(isPrefectMatchSeries)
					resDtoObjects.put("closedMatchSeries", searchKey);				
			}
			
			searchData.put("books", searchBooks);
			searchData.put("authors", searchAuthorBooks);
			searchData.put("series", searchSeriesBooks);
			resDtoObjects.put("searchData", searchData);	
			
		} catch (PropertyBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In EnterpriseControllerService: searchBooks client method end.",
					e);
			throw new PropertyBaseException(
					PropertyErrors.INVALID_REQUEST.getErrorCode(),
					PropertyErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("HomeServiceImpl searchBooks method end. ");
		return resDtoObjects;
	}
*/
}
