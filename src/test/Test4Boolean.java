package test;
/** 
 * @author Ekata Ghimire
 */
import json.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test4Boolean {

	@Test
	void test() throws JSONException{
		JSONBoolean value = JSONFactory.createBoolean(false);
		JSONBoolean value0 = JSONFactory.createBoolean(true);
		StringBuilder builder1 = new StringBuilder();

		
		assertEquals("false", value.toString());
		assertEquals("true", value0.toString());
		
		assertEquals(1231, value0.hashCode());
		assertEquals(1237, value.hashCode());
		
		JSONArray booleanarray = JSONFactory.createArray(4);
		JSONArray booleanarray2 = JSONFactory.createArray();
		booleanarray.addValue(true);
		booleanarray.addValue(false);
		builder1.append(booleanarray);
			
		assertFalse(value.equals(null));
		assertTrue(value.equals(value));
		assertEquals(true, value.isBoolean());
		assertEquals(false, value.asBoolean());
		assertEquals(true, value0.asBoolean());
		
		//for the JSONValue class
		assertThrows(JSONException.class,()->value0.asObject(),"Value is not a valid integer" );
		assertThrows(JSONException.class,()->value0.asArray(),"Vaalue is not a valid array");
		assertThrows(JSONException.class,()->value0.asString(),"Vaalue is not a valid String");
		assertThrows(JSONException.class,()->booleanarray2.asBoolean(),"Vaalue is not a valid array");
		assertThrows(JSONException.class,()->booleanarray2.asDouble(),"Vaalue is not a valid double");
		assertThrows(JSONException.class,()->booleanarray2.asFloat(),"Vaalue is not a valid float");
		assertThrows(JSONException.class,()->booleanarray2.asLong(),"Vaalue is not a valid long");
		assertThrows(JSONException.class,()->booleanarray2.asInteger(),"Vaalue is not a valid integer");
		assertThrows(JSONException.class,()->booleanarray2.asShort(),"Vaalue is not a valid short");
		assertThrows(JSONException.class,()->booleanarray2.asByte(),"Vaalue is not a valid byte");
	
		//JSONArray
		JSONArray booleanarray3 = JSONFactory.createArray(booleanarray2);
		
		
	}
}
