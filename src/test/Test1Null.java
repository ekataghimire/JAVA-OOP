package test;
/** 
 * @author Ekata Ghimire
 */
import json.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Test1Null {

	@Test
	void testNull() {
		JSONNull value = JSONFactory.createNull();
		StringBuilder builder1 = new StringBuilder();
		assertTrue(value.isNull());
		assertFalse(value.isArray());
		assertFalse(value.isNumber());
		assertFalse(value.isObject());
		assertFalse(value.isString());
		assertFalse(value.isBoolean());
		
		assertTrue(value.equals(JSONFactory.createNull()));
		assertFalse(value.equals(null));
		assertEquals("null",value.toString());
		assertEquals(953,value.hashCode());
		
		JSONArray booleanarray = JSONFactory.createArray(4);
		booleanarray.addValue();
		builder1.append(booleanarray);		
	}
}
