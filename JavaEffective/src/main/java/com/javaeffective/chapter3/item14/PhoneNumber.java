package com.javaeffective.chapter3.item14;

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

	@Override
	public int compareTo(PhoneNumber o) {
		int result = Short.compare(areaCode, o.areaCode);
		if (0 == result) {
			result = Short.compare(prefix, o.prefix);
			if (0 == result) {
				result = Short.compare(lineNum, o.lineNum);
			}
		}
		
		return result;
	}
	
	
}
