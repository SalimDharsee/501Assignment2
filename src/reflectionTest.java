import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;


/*
 * Salim Dharsee 
 * ID: 10062458
 * CPSC 501 T01
 * Assignment 2
 * 
 * The way I handle these test cases is by focusing on the main class call methods and see whether or not 
 * they are working as intended. Instead of checking the Parameters, Modifiers and Return types.. I tested 
 * if the class or method is called correctly and gives out the proper output.
 *
 *I have 2 test cases using ClassA and ClassB in particular to see whether getDeclaringClass is working.
 *I also have 2 test cases for getClassConstructor using ClassA/ClassB and seeing if the constructors are correct 
 *My final 2 test cases test an array that is returned from getClassFields and determining if the output is correct
 *
 *I believe these 6 test cases exhaust many if not most of the problems that I may run into
 */
public class reflectionTest {

	// The first two tests, test whether the getDeclaringClass method is working correctly
	@Test
	public void testClassA() {
		String className = null;
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
		String className = null;
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
	// The next two tests, test whether or not the method getClassConstructor is working correctly 
	@Test
	public void testClassConstructorA(){
		
		String constructorInfo = null;
		Class aClass;
		try {
			aClass = Class.forName("ClassA");
			Object obj = aClass.newInstance();
			Inspector anInspect = new Inspector();
			constructorInfo = anInspect.getClassConstructors(aClass);
			assertEquals(constructorInfo, "public ClassA(int)1");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	// The test is the same as above but using a different class for getClassConstructor() 
	@Test 
	public void testClassConstructorB(){
		
		String constructorInfo = null;
		Class aClass;
		try {
			aClass = Class.forName("ClassB");
			Object obj = aClass.newInstance();
			Inspector anInspect = new Inspector();
			constructorInfo = anInspect.getClassConstructors(aClass);
			assertEquals(constructorInfo, "public ClassB() throws java.lang.Exception1");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	// The next two tests, test whether or not the getClassFields methods is working correctly 
	public void testGetFieldA(){
		
		Field[] fieldInfo = null;
		Class aClass;
		try {
			aClass = Class.forName("ClassA");
			Object obj = aClass.newInstance();
			Inspector anInspect = new Inspector();
			fieldInfo = anInspect.getClassFields(aClass, obj);
			assertEquals(""+fieldInfo[1],"private double ClassA.val2");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	// The test is the same as above but using a different class for getClassFields()
	public void testGetFieldB(){
		
		Field[] fieldInfo = null;
		Class aClass;
		try {
			aClass = Class.forName("ClassB");
			Object obj = aClass.newInstance();
			Inspector anInspect = new Inspector();
			fieldInfo = anInspect.getClassFields(aClass, obj);
			assertEquals(""+fieldInfo[1],"private ClassA ClassB.val2");
		
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}
