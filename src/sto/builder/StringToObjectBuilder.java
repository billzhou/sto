package sto.builder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import sto.annotation.DefinitionAnnotation;

public class StringToObjectBuilder {
	
//	private static String testString = "testa321";
	private static Map<String,String> objectDefinitionMap = initDefinitionMap();	

	
	private static Map<String, String> initDefinitionMap(){
		Map<String,String> objectDefinitionMap = new HashMap<String,String>();
		objectDefinitionMap.put("sto.objects.TestHeader", "sto.definition.TestHeaderDefinition");
		objectDefinitionMap.put("sto.objects.TestDetail", "sto.definition.TestDetailDefinition");
		return objectDefinitionMap;		
	}
	
//	public static <T> T buildObject(Class<T> c, String objectData, Integer index) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
//		String className = c.getName();
//		String definitionName = objectDefinitionMap.get(className);
//		Class definitionClass = Class.forName(definitionName);
//		
//		T t = c.newInstance();	
//		for(Field f:definitionClass.getFields()){
//			DefinitionAnnotation anno = f.getAnnotation(DefinitionAnnotation.class);
//			int length = anno.length();
//			int start = anno.start();
//			
//			String fieldName = f.getName();
//			Field ff = c.getField(fieldName);
//			String value = objectData.substring(start+index,start+index+length);
//			String type = ff.getType().getName();
//			
//			switch(type){
//				case "java.lang.String":
//					ff.set(t,value);
//					break;
//				case "int":
//					ff.setInt(t, Integer.parseInt(value.trim()));
//					break;
//			}
//
//		}
//		
//		return t;
//	}
	
	
	public static <T> StringToObjectBuilderResult<T> buildObjectResult(Class<T> c, String objectData, Integer index) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		String className = c.getName();
		String definitionName = objectDefinitionMap.get(className);
		Class definitionClass = Class.forName(definitionName);
		
		T t = c.newInstance();	
		int totalLength = 0;
		for(Field definitionField:definitionClass.getFields()){
			DefinitionAnnotation definitionAnnotation = definitionField.getAnnotation(DefinitionAnnotation.class);
			int length = definitionAnnotation.length();
			int start = definitionAnnotation.start();
			
			String fieldName = definitionField.getName();
			Field field = c.getField(fieldName);
			String value = objectData.substring(start+index,start+index+length);
			String type = field.getType().getName();
			
			totalLength += length;
			
			switch(type){
				case "java.lang.String":
					field.set(t,value);
					break;
				case "int":
					field.setInt(t, Integer.parseInt(value.trim()));
					break;
			}

		}
		
		StringToObjectBuilderResult<T> result = new StringToObjectBuilderResult<T>();
		result.setLength(totalLength);
		result.setResultObject(t);
		
		return result;
	}
	
	
	public static void main(String[] args){
//		try {
//			TestHeader t = StringToObjectBuilder.buildObject(TestHeader.class,"testa321",0);
//			System.out.println(t.header);
//			System.out.println(t.count);
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchFieldException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
