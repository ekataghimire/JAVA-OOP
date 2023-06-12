package test;
/** 
 * @author Ekata Ghimire
 */
import json.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test2Number {

	@Test
	void testNumber() throws JSONException {
		JSONNumber value = JSONFactory.createNumber(1);
		JSONNull value1 = JSONFactory.createNull();
		JSONNumber value0 = JSONFactory.createNumber(0);
		JSONNumber value2 = JSONFactory.createNumber(445);
		JSONNumber value3 = JSONFactory.createNumber(446);
		JSONNumber value4 = JSONFactory.createNumber(0.0f);
		
		assertEquals(445, value2.hashCode());
		assertEquals("446", value3.toString());
		
		assertFalse(value.isNull());
		assertFalse(value.isArray());
		assertFalse(value.isObject());
		assertTrue(value.isNumber());
		assertFalse(value.isString());
		assertFalse(value.isBoolean());
		
		//to test appendTo class		
		JSONString ghi = JSONFactory.createString("Ekata");
		StringBuilder builder1 = new StringBuilder();
		builder1.append(ghi.toString());
		
		JSONArray jsonArray = JSONFactory.createArray();
		jsonArray.addValue(123);
		StringBuilder builder2 = new StringBuilder();
		builder2.append(jsonArray.toString());
		
		
		//to getNumber()
		Integer num = (Integer)value0.getNumber();
		assertEquals(0, num);
//
//		num = (Integer)value.getNumber();
//		assertEquals(1, num);
//		
//		num = (Integer)value1.getNumber();
//		assertEquals(1, num);
		
		
		
		// to test boolean equals
		assertTrue(value0.equals(JSONFactory.createNumber(0)));		 // obj==true
		Object obj1 = new Object();
		assertFalse(value.equals(obj1 = JSONFactory.createNumber(0)));
		
		assertNotEquals(obj1,value.equals(obj1));
		assertTrue(value1.equals(JSONNull.JSON_NULL));	
		
		//asDOuble() 
		JSONNumber floatValue = JSONFactory.createNumber(3.1415f);
		floatValue.asDouble();
//		assertFalse(floatValue.equals(3.1415f));
		
		//System.out.println(num1);
		
		
		JSONNumber floatValue2 = JSONFactory.createNumber(0.00f);		
		floatValue2.asFloat();
		
		
		
		//return (Double) vlaue
		JSONNumber doubleValue = JSONFactory.createNumber(31414999961853027d);
		doubleValue.asDouble();
		
		
		//return(Integer)Value
		JSONNumber IntegerValue = JSONFactory.createNumber(31);
		IntegerValue.asDouble();
		
		//return(long)Value
		JSONNumber LongValue = JSONFactory.createNumber(38737283468723645L);
		LongValue.asDouble();
		
		//asFLoat()
		floatValue2.asFloat();
		IntegerValue.asFloat();
		LongValue.asFloat();
		doubleValue.asFloat();
		
		//asLong()
		IntegerValue.asLong();
		LongValue.asLong();
		assertThrows(JSONException.class,()->floatValue2.asLong(),"Number is not a valid long" );
		
		//asInteger()
		IntegerValue.asInteger();
		assertThrows(JSONException.class,()->LongValue.asInteger(),"Number is not a valid integer" );
		
		//asShort()
		JSONNumber shortV = JSONFactory.createNumber(1);	
		shortV.asShort();
		JSONNumber shortV2 = JSONFactory.createNumber(-32767);
		shortV2.asShort();
		JSONNumber shortV3 = JSONFactory.createNumber(32766);
		shortV3.asShort();
		assertThrows(JSONException.class,()->LongValue.asShort(),"Number is not a valid short" );
		
		//asByte()
		JSONNumber byteV1 = JSONFactory.createNumber(1);	
		byteV1.asByte();
		JSONNumber byteV2 = JSONFactory.createNumber(-128);
		byteV2.asByte();
		JSONNumber byteV3 = JSONFactory.createNumber(127);
		byteV3.asByte();
		assertThrows(JSONException.class,()->JSONFactory.createNumber(1.77).asByte(),"Number is not a valid byte" );
	}	
}
