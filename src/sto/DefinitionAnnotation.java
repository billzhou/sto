package sto;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DefinitionAnnotation {
	int start();
	int length();
	String type();

}
