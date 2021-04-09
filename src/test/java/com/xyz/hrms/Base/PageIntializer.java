package com.xyz.hrms.Base;

import com.xyz.hrms.pages.LoginPageElements;


public class PageIntializer extends BaseClass {

	public static LoginPageElements loginpage;
	
	public static void intialize() {
		loginpage= new LoginPageElements();
	}
}
