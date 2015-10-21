

import java.lang.reflect.*;
import java.util.Arrays;
public class Inspector {
	
	
	
	public void inspect(Object obj, boolean recursive){
		
		getDeclaringClass(obj);
		getSuperClass(obj);
		
	}
	
	private void getSuperClass(Object obj) {
		Class aClass = obj.getClass();
		Class superClass = aClass.getSuperclass();
		
		getClassConstructors(aClass);
		getClassFields(aClass, obj);
		getInterfaces(aClass);
		getMethods(aClass);
		while (superClass != null){
			String className = superClass.getName();
			System.out.println("	Super Class: " + className);
			
			getClassConstructors(superClass);
			getClassFields(superClass, obj);
			getInterfaces(superClass);
			getMethods(superClass);
			
			aClass = superClass;
			superClass = aClass.getSuperclass();
		}
	}

	public void getDeclaringClass(Object obj){
		Class aClass = obj.getClass();
		System.out.println("	Class Name: "+ aClass);
	}
	
	public void getInterfaces(Class aClass){
		Class[] arrayClass = aClass.getInterfaces();
		System.out.println("	Class Interfaces: " + Arrays.asList(arrayClass));	
	}
	
	public void getMethods(Class aClass){
		Method[] arrayMethod = aClass.getDeclaredMethods();
		for(int counter = 0; counter < arrayMethod.length; counter++){
			System.out.println("		Method: " + arrayMethod[counter]);
			System.out.println("			Return Type: " + arrayMethod[counter].getReturnType());
			System.out.println("			Modifers: " + arrayMethod[counter].getModifiers());
			Class[] arrayException = arrayMethod[counter].getExceptionTypes();
			System.out.println("			Exceptions: " + Arrays.asList(arrayException));
			Class[] arrayParameter = arrayMethod[counter].getParameterTypes();
			System.out.println("			Parmeters: " + Arrays.asList(arrayParameter));
		}
	}
	
	public void getClassConstructors(Class aClass){
		try {
			Constructor[] aConstructor = aClass.getConstructors();
			for(int counter = 0; counter < aConstructor.length; counter++){
				System.out.println(" 	Class Constructor: "+ aConstructor[counter]);
				System.out.println("		Constuctor Modifiers:" +aConstructor[counter].getModifiers());
				Class[] arrayParameter = aConstructor[counter].getParameterTypes();
				System.out.println("  		Constructor Parameters: " + Arrays.asList(arrayParameter));
			}
			
	
		} catch (SecurityException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void getClassFields(Class aClass, Object obj){
		Field[] aField = aClass.getDeclaredFields();
		for(int counter = 0; counter <aField.length; counter++){
			aField[counter].setAccessible(true);
			System.out.println("	Declared Field: " + aField[counter]);
			System.out.println(" 		Field Modifiers: " + aField[counter].getModifiers());
			Class<?> fieldParameter = aField[counter].getType();
			System.out.println("		Field Parameters: " + Arrays.asList(fieldParameter));
			try {
				Object value = aField[counter].get(obj);
				System.out.println("		Field Value: " + value);
			} catch (IllegalArgumentException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			}
		}
		
	}
}
