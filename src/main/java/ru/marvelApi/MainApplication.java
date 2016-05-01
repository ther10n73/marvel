package ru.marvelApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("/ru/marvelApi/controller/")
public class MainApplication {
    public static void main (String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SpringApplication.run(MainApplication.class, args);
    }
}
