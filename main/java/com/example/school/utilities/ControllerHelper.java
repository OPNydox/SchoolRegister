package com.example.school.utilities;

public class ControllerHelper {
	public static ReturnResult returnError(String message) {
		ReturnResult result = new ReturnResult();
		result.setSuccesful(false);
		result.setMessage(message);
		return result;
	}
}
