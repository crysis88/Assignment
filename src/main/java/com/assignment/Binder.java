package com.assignment;

import com.assignment.repository.AuthenticationRepository;
import com.assignment.repository.EmployeeRepository;
import com.assignment.service.AuthenticationService;
import com.assignment.service.EmployeeService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class Binder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(EmployeeService.class).to(EmployeeService.class);
        bind(EmployeeRepository.class).to(EmployeeRepository.class);
        bind(AuthenticationService.class).to(AuthenticationService.class);
        bind(AuthenticationRepository.class).to(AuthenticationRepository.class);
    }
}
