package fr.univtln.bruno.samples.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int value() default 1;
    String name () default "test";

}
