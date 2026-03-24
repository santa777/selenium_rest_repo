package com.practice.Interview.data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

	@DataProvider(name = "userNameAndPassword")
	private String[][] getUserNameAndPassword() {
		String[][] data = new String[][] { { "test@linkedin.com", "passwrod1" }, { "link@linkedin.com", "passwrod2" },
				{ "linkdin@linkedin.com", "passwrod2" }

		};
		return data;
	}
}
