package Test;

import org.apache.commons.lang3.StringUtils;

public class Test123 {
	private String responseMessage;
	
	public String getResponseMessage() {
		return responseMessage;
	}
	
	public void setResponseMessage(String responseMessage) {
		if(StringUtils.isNotBlank(responseMessage) && responseMessage.length() > 10) {
			responseMessage = responseMessage.substring(0, 10);
		}
		this.responseMessage = responseMessage;
	}
	
	public static void main(String[] args) {
		Test123 o = new Test123();
		o.setResponseMessage(null);
		System.out.println(o.getResponseMessage());
		String s = "";
		System.out.println(s.toUpperCase());
	}
}
