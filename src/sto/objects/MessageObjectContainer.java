package sto.objects;

import java.util.ArrayList;
import java.util.List;

public class MessageObjectContainer {
	
	public TestHeader header;
	public List<TestDetail> details = new ArrayList<TestDetail>();
	public TestHeader getHeader() {
		return header;
	}
	public void setHeader(TestHeader t) {
		this.header = t;
	}
	public List<TestDetail> getDetails() {
		return details;
	}
	public void setDetails(List<TestDetail> details) {
		this.details = details;
	}
	
	

}
