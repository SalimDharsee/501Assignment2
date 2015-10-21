

import java.lang.reflect.*;
public class Inspector {
	
	
	
	public void inspect(Object obj, boolean recursive){
		
		getDeclaringClass(obj);
		getSuperClass(obj);
		
	}
	
	private void getSuperClass(Object obj) {
		Class aClass = obj.getClass();
		Class superClass = aClass.getSuperclass();
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
		for (int counter = 0; counter < arrayClass.length; counter++){
			System.out.println("Interface: "+ arrayClass[counter]);
		}
			
	}
}
