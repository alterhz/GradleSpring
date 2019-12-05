package com.javaeffective.chapter3.item14_1;

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
	
	private static final Comparator<PhoneNumber> COMPARATOR 
		= Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
		.thenComparingInt(pn -> pn.prefix)
		.thenComparingInt(pn -> pn.lineNum);

	@Override
	public int compareTo(PhoneNumber o) {
		return COMPARATOR.compare(this, o);
	}
	
}
