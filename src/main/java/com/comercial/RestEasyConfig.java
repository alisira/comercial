package com.comercial;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestEasyConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(SampleRest.class);
        return classes;
    }
}