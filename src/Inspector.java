

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
		while (superClass != null){
			String className = superClass.getName();
			System.out.println("Super Class: " + className);
			getInterfaces(superClass);
			aClass = superClass;
			superClass = aClass.getSuperclass();
		}
	}

	public void getDeclaringClass(Object obj){
		
		Class aClass = obj.getClass();
		System.out.println("Class Name: "+ aClass);
		
	}
	
	public void getInterfaces(Class superClass){
		Class[] arrayClass = superClass.getInterfaces();
		System.out.println("Interfaces: " + Arrays.asList(arrayClass));	
	}
}
