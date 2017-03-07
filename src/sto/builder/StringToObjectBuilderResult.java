package sto.builder;

public class StringToObjectBuilderResult <T>{
	
	public int length;
	
	public T resultObject;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public T getResultObject() {
		return resultObject;
	}

	public void setResultObject(T resultObject) {
		this.resultObject = resultObject;
	}
	
	

}
