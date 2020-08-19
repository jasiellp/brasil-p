package com.brasil.prev.util;

public class Util
{
	
	public static String FormatCPF(String cpf)
	{
		if(cpf.length() == 11)
			return cpf.substring(0, 3).concat(".").concat(cpf.substring(3, 6)).concat(".")
					.concat(cpf.substring(6, 9).concat("-")).concat(cpf.substring(9, 11));
		else
			return "";
	}
	
	
	
	
}
