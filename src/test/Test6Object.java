package test;
/** 
 * @author Ekata Ghimire
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import json.*;
class Test6Object {

	@Test
	void test() throws JSONException {
		JSONObject obj1 = JSONFactory.createObject();
		JSONObject obj9 = JSONFactory.createObject(obj1);
		assertTrue(obj1.isObject());

		JSONObject obj2 = JSONFactory.createObject();
		obj2.addMember("DO");

		assertNotEquals("DO",obj2.getMember("DO"));

		assertNotEquals(23,obj1.hashCode());
		
		obj2.isNull();

		obj2.addMember("Bekhyung","123");

		obj2.addMember("Lay",12.34d);

		obj2.addMember("Suho",34.23f);

		obj2.addMember("Sehun",12344L);

		obj2.addMember("Chen",true);

		obj2.addMember("Chanyeol",false);

		obj1.addMember("Xumin", obj2);

		int size = obj2.size();
		// System.out.println(size);

		obj2.hasMember("Tao");

		obj1.copy();

		obj1.asObject();
		assertThrows(JSONException.class, () -> obj1.asBoolean(), "");


		obj1.toString();

		obj1.equals(obj2);

		assertFalse(obj1.equals(null));

		assertTrue(obj2.equals(obj2));

		obj2.values();

		obj2.members();

		obj2.iterator();

		JSONValue a = JSONFactory.createArray();
		obj2.addMember("Kris", a);

		JSONArray arr = JSONFactory.createArray();
		obj2.addMember("Luhan", arr);


		Boolean ob =obj2.hasBooleanMember("DO");
		obj2.hasBooleanMember(null);

		
	}

}
