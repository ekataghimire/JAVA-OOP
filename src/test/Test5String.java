package test;
/** 
 * @author Ekata Ghimire
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import json.*;

class Test5String {

	@Test
	void test() throws JSONException {
		JSONString value0 = JSONFactory.createString(null);
		JSONString value = JSONFactory.createString("Ekata");
		JSONString valuen = JSONFactory.createString("");
		JSONString value1 = JSONFactory.createString("abcd");	
		JSONString value2 = JSONFactory.createString("\"");	
		JSONString value3 = JSONFactory.createString("\\/");
		JSONString value4 = JSONFactory.createString("\b");
		JSONString value5 = JSONFactory.createString("\f");
		JSONString value6 = JSONFactory.createString("\n");
		JSONString value7 = JSONFactory.createString("\r");
		JSONString value8 = JSONFactory.createString("\t");
		
		//appendTo(StringBuilder builder) testing
		StringBuilder builder1 = new StringBuilder();
	
		value.appendTo(builder1);	
		value0.appendTo(builder1);
		//switch case testing up to \t 
		value2.appendTo(builder1);
		value3.appendTo(builder1);
		value4.appendTo(builder1);
		value5.appendTo(builder1);
		value6.appendTo(builder1);
		value7.appendTo(builder1);
		value8.appendTo(builder1);
		
		//default testing

		JSONString c2 = JSONFactory.createString("\\u00");
		JSONString c3 = JSONFactory.createString("\\u0");
		JSONString c4 = JSONFactory.createString("\\u");


		
		//testing boolean equals(Object obj)		
		assertTrue(value0.equals(JSONFactory.createString(null)));		 // obj==true
		Object obj1 = new Object();
		assertFalse(value.equals(obj1 = JSONFactory.createString(null)));		
		assertNotEquals(obj1,value.equals(obj1));
//		assertNotEquals(obj1.getClass(),value.equals(getClass()));
		
		//int hashCode() testing
		assertNotEquals("Ekata", value.hashCode());
		
		//String toString() testing
		assertNotEquals("true", value.toString());
		assertNotEquals("true", value0.toString());
		
		//boolean isString() testing
		assertTrue(value.isString());
		
		//String asString() throws JSONException testing
		value1.asString();
		
		//String getString() testing
		value1.getString();
	}

}
