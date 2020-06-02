package com.example.school.utilities;

import com.example.school.utilities.interfaces.IWriter;

public class ConsoleWriter implements IWriter{

	@Override
	public void writeError(String text) {
		System.out.println(text);
	}

}
