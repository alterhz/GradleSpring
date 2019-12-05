package com.javaeffective.chapter3.item14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PhoneNumberTest {

	@Test
	public void testCompare() {
		List<PhoneNumber> phoneNumberList = new ArrayList<PhoneNumber>();
		
		for (int i=0; i<10; ++i) {
			short areaCode = (short)(100 - i%4);
			short prefix = (short)(100 + i%2);
			short lineNum = (short)(i);
			phoneNumberList.add(new PhoneNumber(areaCode, prefix, lineNum));
		}
		
		Object[] arrayPhoneNumber = phoneNumberList.toArray();
		
		System.out.println("before sort:");
		for (Object object : arrayPhoneNumber) {
			PhoneNumber phoneNumber = (PhoneNumber)object;
			System.out.println("areaCode:" + phoneNumber.getAreaCode() 
				+ ", prefix:" + phoneNumber.getPrefix() 
				+ ", lineNum:" + phoneNumber.getLineNum());
		}
		
		Arrays.sort(arrayPhoneNumber);
		
		System.out.println();
		System.out.println("after sort:");
		for (Object object : arrayPhoneNumber) {
			PhoneNumber phoneNumber = (PhoneNumber)object;
			System.out.println("areaCode:" + phoneNumber.getAreaCode() 
				+ ", prefix:" + phoneNumber.getPrefix() 
				+ ", lineNum:" + phoneNumber.getLineNum());
		}
		
	}
}
