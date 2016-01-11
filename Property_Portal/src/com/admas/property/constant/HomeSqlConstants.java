package com.admas.property.constant;

public class HomeSqlConstants {

	public static final String GET_LOCATION_DETAILS = "select NAME from distict where NAME like ?";

	public static final String GET_PROJECTS_BY_FILTER = "select * from builder_property_detail p where p.city like ? and p.category = ? and p.type = ? and p.cost between ? and ? and p.delFlg = 'N'";

//	public static final String GET_PROJECT_DETAILS = "select p.builder_prop_Id, p.propertyName, p.companyName, p.builder_Id, p.state_id, p.city_id, p.area_id, p.contact_person, p.site_address, p.site_contact_detail, p.land_line, p.survey_no, p.site_location, p.site_email, p.site_website, p.co_status, p.certified_type, p.property_status, p.latitude, p.longitude, p.specialities, p.amenities, p.about_us, p.isAdvertisement, p.advSequence, p.is_salb_percentage, s.PROJ_SPEC_ID, s.PROJ_ID, s.SPCIFY_ID, s.VALUE, s.DESCRIPTION, s.STATUS_FLAG from builder_property_detail p inner join project_specification s on p.builder_prop_Id=s.PROJ_ID where p.builder_prop_Id = ? and p.delFlg = 'N' and s.STATUS_FLAG ='S'";

	public static final String GET_PROJECT_DETAILS = "select * from builder_property_detail p where p.builder_prop_Id = ? and p.delFlg = 'N' ";
	
	public static final String GET_RECENT_PROJECTS = "SELECT * FROM (SELECT * FROM builder_property_detail where delFlg = 'N' ORDER BY builder_prop_Id DESC LIMIT 6)propertyTable ORDER BY builder_prop_Id ASC";

//	public static final String GET_RECENT_PROJECTS ="SELECT * FROM (select * from builder_property_detail p inner join builder_property_image i on p.builder_prop_Id = i.builder_prop_Id where i.img_type = 'Logo' ORDER BY builder_prop_Id DESC LIMIT 6)propertyTable ORDER BY builder_prop_Id ASC";
	
	public static final String GET_AMENITIES = " select * from project_specification a where a.PROJ_ID = ? and a.STATUS_FLAG ='A' ";

	public static final Object SAVE_INQUIRY = "insert into property_inquiry(name, emailId, property_message, Subject) values (?, ?, ?, ?)";

	public static final String GETBUILDERS = "select * from builder b where b.ISAGENT = 'N' and DELFLG = 'N'";
	
	public static final String GETAGENTS = "select * from builder b where b.ISAGENT = 'Y' and DELFLG = 'N'";
	
	public static final String GETBLOG = "select * from (select * from propertyblogs where BUILDER_ID = 1 order by BLOG_ID desc limit 10 ) blog order by BLOG_ID ASC";
	public static final String GETNEWS = "select * from (select * from news order by id desc limit 10) news order by id ASC";
	public static final String GET_NEWS_DETAILS_BY_ID = "select * from news where id = ?";

	public static final String GET_BUILDER_IMAGE_URL = "select image_type from builder_property_image where builder_prop_Id = ? and img_type = 'advertisement'";

	public static final String GET_PANORAMA_IMAGE = "select image_type from builder_property_image where builder_prop_Id = ? and img_type = 'Panorama Image'";
	
	public static final String GET_GALLERY_IMAGES = "select image_type from builder_property_image where builder_prop_Id = ? and img_type = 'Gallery'";
	
	public static final String GET_FLOOR_IMAGES = "select image_type from builder_property_image where builder_prop_Id = ? and img_type = 'Floor Image'";

	public static final String GET_PROJECT_SPECIFICATION = "select * from project_specification a where a.PROJ_ID = ? and a.STATUS_FLAG ='S'";
	
	public static final String GET_AGENT_IMAGE_URL = "select image_type from default_image where builder_id = ? and img_type = 'Logo'";

	/*
	 * public static final Object GET_PROJECT_DETAILS = "select
	 * p.builder_prop_Id, p.propertyName, p.companyName, p.builder_Id,
	 * p.state_id, p.city_id, p.area_id, p.contact_person, p.site_address,
	 * p.site_contact_detail, p.land_line, p.survey_no, p.site_location,
	 * p.site_email, p.site_website, p.co_status, p.certified_type,
	 * p.property_status, p.latitude, p.longitude, p.specialities, p.amenities,
	 * p.about_us, p.isAdvertisement, p.advSequence, p.is_salb_percentage,
	 * s.PROJ_SPEC_ID, s.PROJ_ID, s.SPCIFY_ID, s.VALUE, s.DESCRIPTION,
	 * s.STATUS_FLAG , a.PROJ_SPEC_ID as A_PROJ_SPEC_ID, a.PROJ_ID as A_PROJ_ID,
	 * a.SPCIFY_ID as A_SPCIFY_ID, a.VALUE as A_VALUE, a.DESCRIPTION as
	 * A_DESCRIPTION, a.STATUS_FLAG as A_STATUS_FLAG from
	 * builder_property_detail p inner join project_specification s on
	 * p.builder_prop_Id= s.PROJ_ID inner join project_specification a on
	 * p.builder_prop_Id= a.PROJ_ID and a.STATUS_FLAG='A' where
	 * p.builder_prop_Id=?";
	 * 
	 * select
	 * p.builder_prop_Id,p.propertyName,p.companyName,p.builder_Id,p.state_id,p.
	 * city_id,p.area_id,p.contact_person,p.site_address,p.site_contact_detail,p
	 * .land_line,p.survey_no,p.site_location,p.site_email,p.site_website,p.
	 * co_status,p.certified_type,p.property_status,p.latitude,p.longitude,p.
	 * specialities,p.amenities,p.about_us,p.isAdvertisement,p.advSequence,p.
	 * is_salb_percentage,s.PROJ_SPEC_ID,s.PROJ_ID,s.SPCIFY_ID,s.VALUE,s.
	 * DESCRIPTION,s.STATUS_FLAG,a.PROJ_SPEC_ID,a.PROJ_ID,a.SPCIFY_ID,a.VALUE,a.
	 * DESCRIPTION, a.STATUS_FLAG from builder_property_detail p inner join
	 * project_specification s on p.builder_prop_Id= s.PROJ_ID inner join
	 * project_specification a on p.builder_prop_Id= a.PROJ_ID where
	 * p.builder_prop_Id=4 and a.STATUS_FLAG="A";
	 * 
	 * public static final String FETCH_AUTHOR_DETAILS =
	 * "select  b.title , b.code,a.name as 'author' , p.name as 'publisher' ,s.name as 'series' from book b left join author a on a.ID = b.auth_id left join  publisher p on p.ID = b.pub_id left join series s on s.ID = b.series_id where a.name COLLATE UTF8_GENERAL_CI like ?"
	 * ;
	 * 
	 * public static final String FETCH_SERIES_DETAILS =
	 * "select  b.title , b.code,a.name as 'author' , p.name as 'publisher' ,s.name as 'series' from book b left join author a on a.ID = b.auth_id left join  publisher p on p.ID = b.pub_id left join series s on s.ID = b.series_id where s.name COLLATE UTF8_GENERAL_CI like ?"
	 * ;
	 * 
	 * public static final String FETCH_BOOK_DETAILS_ByTITLE =
	 * "select title from book";
	 * 
	 * public static final String FETCH_AUTHOR_DETAILS_ByNAME =
	 * "select name from author";
	 * 
	 * public static final String FETCH_SERIES_DETAILS_ByNAME =
	 * "select name from series";
	 */
}