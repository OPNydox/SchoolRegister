package com.example.school.utilities;

import org.springframework.stereotype.Component;

import com.example.school.utilities.interfaces.IWriter;

@Component
public class ConsoleWriter implements IWriter{

	@Override
	public void writeError(String text) {
		System.out.println(text);
	}

}
