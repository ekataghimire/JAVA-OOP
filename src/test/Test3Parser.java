package test;
/** 
 * @author Ekata Ghimire
 */
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import json.*;

import org.junit.jupiter.api.Test;

class Test3Parser {
	@Test
	void testParseFile() throws FileNotFoundException, IOException, JSONException {

		JSONValue value = JSONParser.parseFile("example.json");
		assertTrue(value.isObject());

		JSONObject jsonObj = value.asObject();

		JSONValue assocVal = jsonObj.getMember("prop3");
		assertTrue(assocVal.isNumber());
		float floatVal = assocVal.asFloat();
		assertEquals(3.142f, floatVal);

		JSONValue assocVal2 = jsonObj.getMember("prop1");
		assertTrue(assocVal.isNumber());
		String stringVal = assocVal2.asString();
		assertEquals("A string", stringVal);

		JSONValue assocVal3 = jsonObj.getMember("prop2");
		assertTrue(assocVal.isNumber());
		float floatVal2 = assocVal3.asFloat();
		assertEquals(0, floatVal2);

		JSONValue assocVal4 = jsonObj.getMember("prop4");
		assertTrue(assocVal4.isBoolean());
		boolean bval1 = assocVal4.asBoolean();
		assertEquals(true, bval1);

		JSONValue assocVal5 = jsonObj.getMember("prop5");
		assertTrue(assocVal5.isBoolean());
		boolean bval2 = assocVal5.asBoolean();
		assertEquals(false, bval2);

		JSONValue assocVal6 = jsonObj.getMember("prop6");
		assertTrue(assocVal6.isNull());

		JSONObject assocVal7 = (JSONObject) jsonObj.getMember("prop7");
		JSONValue jvalue1 = assocVal7.getMember("prop7_A");
		boolean bval3 = jvalue1.asBoolean();
		assertEquals(true, bval3);
		assertTrue(jvalue1.isBoolean());

		JSONValue jvalue2 = assocVal7.getMember("prop7_B");
		boolean bval4 = jvalue2.asBoolean();
		assertEquals(false, bval4);
		assertTrue(jvalue2.isBoolean());

		JSONValue jvalue3 = assocVal7.getMember("prop7_C");
		String str1 = jvalue3.asString();
		assertEquals("nested string", str1);
		assertTrue(jvalue3.isString());

		JSONArray assocVal8 = (JSONArray) jsonObj.getMember("array1");
		assertTrue(assocVal8.isArray());
		for (int i = 0; i < assocVal8.size(); i++) {

			assertEquals(i, assocVal8.get(i).asInteger());
		}

		JSONArray assocVal9 = (JSONArray) jsonObj.getMember("array2");
		assertTrue(assocVal9.isArray());
		assertEquals("this", assocVal9.get(0).asString());
		assertEquals("is", assocVal9.get(1).asString());
		assertEquals("an", assocVal9.get(2).asString());
		assertEquals("array", assocVal9.get(3).asString());

		JSONArray assocVal10 = (JSONArray) jsonObj.getMember("array3");
		assertTrue(assocVal10.isArray());
		assertEquals("this", assocVal10.get(0).asString());
		assertEquals(0, assocVal10.get(5).asInteger());
		assertEquals(true, assocVal10.get(6).asBoolean());
		assertEquals(false, assocVal10.get(7).asBoolean());

		assertTrue(assocVal10.get(8).isNull());

		assertEquals(6.232F, assocVal10.get(9).asFloat());

		// a
		JSONObject objInside = (JSONObject) assocVal10.get(10);
		assertTrue(objInside.isObject());

		JSONArray arrayInside = (JSONArray) assocVal10.get(11);
		assertTrue(arrayInside.isArray());

		JSONValue assocValue11 = jsonObj.getMember("escape_string");
		assertTrue(assocValue11.isString());

		JSONValue jValueStr1 = JSONParser.parse("{}");
		assertTrue(jValueStr1.isObject());
		
		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Name\": \"Ekata\",}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Name\": \"Ekata\","));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Name\": \"Ekata\""));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Name\" \"Ekata\""));

// string parse string

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"\\h\" : \"hello\"}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\""));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Right\" : [1,]}"));
		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Right\" : [1}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Right\" : [0,"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Error\" :tue}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Error\" :flse}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Error\" :nul}"));

		// parse number

		// for unicode

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"ErrorUni\" : \"\\u123\"}"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"ErrorUni\" : \"\\u\"}"));

		assertThrows(JSONException.class, () -> JSONParser.parseFile("testfileekata.json"));

		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Error\" :$"));
		assertThrows(JSONException.class, () -> JSONParser.parse("{\"Error\" :-"));
		assertThrows(JSONException.class, () -> JSONParser.parse("{"));

	}
}