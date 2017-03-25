package com.satyendra.demo;

import com.satyendra.demo.config.StudentManagementConfiguration;
import com.satyendra.demo.core.StudentService;
import com.satyendra.demo.core.StudentServiceImpl;
import com.satyendra.demo.health.DefaultHealthCheck;
import com.satyendra.demo.resources.StudentResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class StudentManagementApplication extends Application<StudentManagementConfiguration> {

    public static void main(final String[] args) throws Exception {
        new StudentManagementApplication().run(args);
    }

    @Override
    public String getName() {
        return "StudentManagement";
    }

    @Override
    public void initialize(final Bootstrap<StudentManagementConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final StudentManagementConfiguration configuration,
                    final Environment environment) {
    	
    	final StudentService service = new StudentServiceImpl(configuration);
    	final StudentResource resource = new StudentResource(service);
		final DefaultHealthCheck healthCheck = new DefaultHealthCheck();
		environment.healthChecks().register("Default Health Check", healthCheck);
        environment.jersey().register(resource);
    }

}
