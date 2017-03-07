package sto.definition;

import sto.annotation.DefinitionAnnotation;

public class TestHeaderDefinition {
	
	@DefinitionAnnotation(length=6,start=0)
	public String header;

	@DefinitionAnnotation(length=3,start=6)
	public int count;

}
