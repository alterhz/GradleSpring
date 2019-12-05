package com.javaeffective.chapter3.item14_2;

import java.util.Comparator;

public class PhoneNumber implements Comparable<PhoneNumber> {
	private short areaCode = 0;
	private short prefix = 0;
	private short lineNum = 0;
	
	public PhoneNumber(short areaCode, short prefix, short lineNum) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNum = lineNum;
	}
	
	public short getAreaCode() {
		return areaCode;
	}

	public short getPrefix() {
		return prefix;
	}

	public short getLineNum() {
		return lineNum;
	}
	
	private static final Comparator<PhoneNumber> COMPARATOR = new Comparator<PhoneNumber>() {
			@Override
			public int compare(PhoneNumber o1, PhoneNumber o2) {
				int result = Short.compare(o1.areaCode, o2.areaCode);
				if (0 == result) {
					result = Short.compare(o1.prefix, o2.prefix);
					if (0 == result) {
						result = Short.compare(o1.lineNum, o2.lineNum);
					}
				}
				
				return result;
			}
		};

	@Override
	public int compareTo(PhoneNumber o) {
		return COMPARATOR.compare(this, o);
	}
	
}
