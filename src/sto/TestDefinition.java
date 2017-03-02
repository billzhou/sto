package sto;

public class TestDefinition {
	
	@DefinitionAnnotation(length=5,start=0,type="String")
	public String field1;

	@DefinitionAnnotation(length=3,start=5,type="int")
	public int field2;
}
