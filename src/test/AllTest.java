package test;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import json.*;
@RunWith(JUnitPlatform.class)
@SelectClasses( {Test1Null.class, Test2Number.class, Test3Parser.class, 
	Test4Boolean.class, Test5String.class,Test5String.class,Test6Object.class,
	Test7Array.class} )
class AllTest {
	
}
