package com.admas.ngemp.sms.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.admas.logiware.services.CustomerServices;
import com.admas.logiware.services.usermgt.UserManagementService;
import com.admas.logiware.services.contractcomp.CompRouteServices;
import com.admas.logiware.services.contractcomp.ContractCompServices;
import com.admas.logiware.services.masters.MasterServices;
import com.admas.logiware.transowner.services.TransOwnerServices;
import com.admas.logiware.transowner.services.TransportDetailServices;
import com.admas.ngemp.sms.services.SmsService;

/**
 * @author 
 *
 */
public class ApplicationConfig extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();

   
    public ApplicationConfig() {
       // singletons.add(new RuleService());
        singletons.add(new SmsService());
        singletons.add(new CustomerServices());
        singletons.add(new UserManagementService());
        singletons.add(new MasterServices());
        singletons.add(new ContractCompServices());
        singletons.add(new TransOwnerServices());
        singletons.add(new TransportDetailServices());
        singletons.add(new CompRouteServices());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}