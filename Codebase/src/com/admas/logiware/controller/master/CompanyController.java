package com.admas.logiware.controller.master;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.dto.FlowData;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

@Controller
public class CompanyController {

	public CompanyController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;
	
	@RequestMapping(value="/getAllBranches.htm",method = RequestMethod.GET)
	public ModelAndView getAllBranches(HttpServletRequest request,HttpServletResponse response){
		
		FlowData flowData=null;
		//HashMap<String,Object>reqDtoObject = new HashMap<String, Object>();
		HashMap<String,Object>resDtoObject = new HashMap<String, Object>();
		
		return masterServiceImpl.getAllBranches(flowData, resDtoObject);
		
	}

}
