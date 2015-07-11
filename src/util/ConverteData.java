package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.tomcat.util.buf.DateTool;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ConverteData {
	
	
	public static java.sql.Date strToDate(String data) throws Exception{
		if (data==null){
			return null;
		}
		
		java.util.Date dataF = null;
		
		try{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			long timestamp = dateFormat.parse(data).getTime(); 
			
			dataF = new Date(timestamp);			
		}
		catch (ParseException pE) {
			throw pE;
			
			
		}			
		java.sql.Date dat = new java.sql.Date(dataF.getTime());
		
		return dat;
	}


	public static String dateToStr(java.sql.Date date){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataS = dateFormat.format(date);
		return dataS;
	}
	
}
