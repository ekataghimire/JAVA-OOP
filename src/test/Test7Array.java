package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import json.*;

class Test7Array {

	@Test
	void test() throws JSONException {
		JSONArray value = JSONFactory.createArray();
		JSONArray value0 = JSONFactory.createArray();
		JSONArray values = JSONFactory.createArray(4);
		// appendTo(StringBuilder builder) testing
		StringBuilder builder1 = new StringBuilder();
//

//		value0.appendTo(builder1);

		// testing boolean equals(Object obj)
		assertTrue(value0.equals(JSONFactory.createArray())); // obj==true
		Object obj1 = new Object();
		assertTrue(value.equals(obj1 = JSONFactory.createArray()));
		assertTrue(value.equals(value));
		assertFalse(value.equals(null));

		// int hashCode() testing
		assertNotEquals("ab", value.hashCode());

		// JSONArray copy() testing
		value.copy();

		// JSONArray asArray() throws JSONException testing
		value.asArray();

		// boolean isArray() testing
		value.isArray();

		//adding values to the array
		values.addValue(3);
		values.addValue(4);
		values.addValue(5);
		System.out.println(values);

		// JSONValue get(int index) testing
		values.get(0);
		
		values.addValue(false);
		System.out.println(values.get(0));
		
		// addValue(JSONObject value) testing
		JSONObject obj2 = JSONFactory.createObject();
		assertTrue(obj2.isObject());
		obj2.addMember("Sname");
		value.addValue(obj2);
		
		// addValue(JSONArray value)
		assertTrue(value.isArray());
		value.addValue(values);
		
		//JSONArray addValue(String value)
		value.addValue("hello");
		
		//addValue(double value)
		value.addValue(76354635d);
		
		//addValue(float value)
		value.addValue(33.2f);
		
		//addValue(boolean value)
		value.addValue(false);
		value.addValue(true);
		
		//addValue(JSONValue value)
		JSONValue jasonv = JSONFactory.createNull();
		jasonv.copy();
		value.addValue(jasonv);
		
		//void addValue()	
		value.addValue(JSONFactory.createNull());
		
		//Iterator<JSONValue> iterator()
		value.iterator();
		
		value.addValue(value.copy());
		
		value.addValue();
	}

}
