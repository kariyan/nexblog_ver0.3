package com.namoo.mybatis.blog.domain;

public enum Gender {
	//
	Male("M", "����"),
	Female("F", "����");
	
	private String code;
	private String krName;
	
	//--------------------------------------------------------------------------
	private Gender(String code, String krName) {
		//
		this.code = code;
		this.krName = krName;
	}
	
	public String code() {
		return this.code;
	}
	
	public String krName() {
		return this.krName;
	}
	
	public static Gender getByCode(String code) {
		//
		if (Gender.Male.code.equals("M")) {
			return Gender.Male;
		}
		else if (Gender.Female.code.equals("F")) {
			return Gender.Female; 
		}
		
		return null;
	}
}

