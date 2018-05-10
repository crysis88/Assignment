package com.assignment;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class AssignmentApplication extends ResourceConfig {
    public AssignmentApplication() {
        register(new Binder());
        register(JacksonFeature.class);
        packages(true, "com.assignment");
    }
}
