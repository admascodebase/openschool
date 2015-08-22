package com.admas.ngemp.sms.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.admas.logiware.services.CustomerServices;
import com.admas.logiware.services.UserManagementService;
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