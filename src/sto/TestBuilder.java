package sto;

import java.lang.reflect.Field;

public class TestBuilder {
	
	private static String testString = "testa321";
	
	public static Test buildTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Test t = new Test();
		
		for(Field f:TestDefinition.class.getFields()){
			DefinitionAnnotation anno = f.getAnnotation(DefinitionAnnotation.class);
			int length = anno.length();
			int start = anno.start();
//			String type = anno.type();
			
			String fieldName = f.getName();
			Field ff = Test.class.getField(fieldName);
			String value = testString.substring(start,start+length);
			String type = ff.getType().getName();
			
			
			switch(type){
				case "java.lang.String":
					ff.set(t,value);
					break;
				case "int":
					ff.setInt(t, Integer.parseInt(value));
					break;
			}
			
			
			
			
//			Class C = t.field1.getClass();
//			t.field1 = (C);
		}
		
		return t;
	}
	
	public static void main(String[] args){
		try {
			Test t = TestBuilder.buildTest();
			System.out.println(t.field1);
			System.out.println(t.field2);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
