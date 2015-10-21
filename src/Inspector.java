

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
		
		getInterfaces(aClass);
		getMethods(aClass);
		while (superClass != null){
			String className = superClass.getName();
			System.out.println("	Super Class: " + className);
			
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
	
	public void getConstructors(){
		
	}
}
