package sto;

import java.util.List;
import java.util.Map;

import sto.builder.StringToObjectBuilder;
import sto.builder.StringToObjectBuilderResult;
import sto.objects.MessageObjectContainer;
import sto.objects.TestDetail;
import sto.objects.TestHeader;

public class StringToObjectProcessorImpl {
	
	private static String testString = "header  2detail1detail2";
	
//	public static MessageObjectContainer createObjectContainer(String message) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException{
//		MessageObjectContainer c = new MessageObjectContainer();
//		Integer index = 0;
//		
//		TestHeader h = StringToObjectBuilder.buildObject(TestHeader.class, testString,index);
//		c.header = h;
//		
//		index += StringToObjectBuilder.getObjectDefinitionLength(TestHeader.class);
//		
//		int count = h.getCount();
//		int detailLength = StringToObjectBuilder.getObjectDefinitionLength(TestDetail.class);
//		for(int i = 0; i < count; i++){
//			TestDetail d = StringToObjectBuilder.buildObject(TestDetail.class, testString,index);
//			c.getDetails().add(d);
//			
//			index += detailLength;
//		}
//		
//		return c;		
//	}
//	
	public static MessageObjectContainer createObjectContainerWithResult(String message) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException{
		MessageObjectContainer container = new MessageObjectContainer();
		Integer index = 0;
		
		StringToObjectBuilderResult<TestHeader> headResult = StringToObjectBuilder.buildObjectResult(TestHeader.class, testString,index);
		TestHeader header = headResult.getResultObject();
		container.header = header;
		index += headResult.getLength();
		
		int count = header.getCount();
		for(int i = 0; i < count; i++){
			StringToObjectBuilderResult<TestDetail> detailResult = StringToObjectBuilder.buildObjectResult(TestDetail.class, testString,index);
			TestDetail detail = detailResult.getResultObject();
			container.getDetails().add(detail);
			
			index += detailResult.getLength();
		}
		
		return container;		
	}
	
	public static void main(String[] args){
		try {
//			MessageObjectContainer t = StringToObjectProcessorImpl.createObjectContainer(testString);
//			System.out.println(t.getHeader().header);
//			System.out.println(t.getHeader().count);
//			
//			List<TestDetail> ds = t.getDetails();
//			for(TestDetail d:ds){
//				System.out.println(d.detail);
//			}
			
			
			MessageObjectContainer tt = StringToObjectProcessorImpl.createObjectContainerWithResult(testString);
			System.out.println(tt.getHeader().header);
			System.out.println(tt.getHeader().count);
			
			List<TestDetail> dst = tt.getDetails();
			for(TestDetail d:dst){
				System.out.println(d.detail);
			}
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
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
