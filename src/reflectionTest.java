import static org.junit.Assert.*;

import org.junit.Test;

public class reflectionTest {

	// The first two tests, test whether the getDeclaringClass method is working correctly
	@Test
	public void testClassA() {
		String className = "class ClassA";
		Class aClass;
		try {
			aClass = Class.forName("ClassA");
			Object obj = aClass.newInstance();
			Inspector anInspect = new Inspector();
			className = anInspect.getDeclaringClass(obj);
			assertEquals("class ClassA", className);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
	}
	// The test is the same as above but using a different class for getDeclaring class
	@Test
	public void testClassB() {
		String className = "class ClassB";
		Class aClass;
		try {
			aClass = Class.forName("ClassB");
			Object obj = aClass.newInstance();
			Inspector anInspect = new Inspector();
			className = anInspect.getDeclaringClass(obj);
			assertEquals("class ClassB", className);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSuperClassA(){
		
	}
	@Test 
	public void testSuperClassB(){
		
	}

}
