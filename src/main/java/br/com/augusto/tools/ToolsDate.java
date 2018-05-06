package br.com.augusto.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ToolsDate {
	public static Date stringForDate(String string) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse(string);
		return data;
	}
}
