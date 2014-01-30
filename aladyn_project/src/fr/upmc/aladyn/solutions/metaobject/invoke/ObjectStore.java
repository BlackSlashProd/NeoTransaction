package fr.upmc.aladyn.solutions.metaobject.invoke;

import java.lang.reflect.Field;

public class ObjectStore {
	private String classObj;
	private Object storeObj;
	
	/**
	 * 
	 * @param transobj
	 */
	public ObjectStore(Object transobj) {
		classObj = transobj.getClass().getSimpleName();
		try {
			Class <?> c = transobj.getClass();;
			this.storeObj = transobj;
			System.out.println("GETFIELDS:");
			for(Field fld : c.getFields()) {
				System.out.println("");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DEBUG: Store object " + this.classObj);
	}
	
	/**
	 * 
	 * @param obj
	 */
	public void objectRestore(Object obj) {
		if(!obj.getClass().getSimpleName().equals(this.classObj))
			throw new RuntimeException("Can't restore an object from a different class.");
		System.out.println("DEBUG: Restore object " + obj.getClass().getSimpleName());
		for(Field fld : this.storeObj.getClass().getFields()) {
			System.out.println(fld.getName());
			try {
				System.out.println("savenum="+getInstanceValue(this.storeObj, fld.getName()));
			} catch (SecurityException | NoSuchFieldException
					| ClassNotFoundException | IllegalArgumentException
					| IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}		
	}
	
    /**
     * Returns an object containing the value of any field of an object instance (even private).
     * @param classInstance An Object instance.
     * @param fieldName The name of a field in the class instantiated by classInstance
     * @return An Object containing the field value.
     * @throws SecurityException .
     * @throws NoSuchFieldException .
     * @throws ClassNotFoundException .
     * @throws IllegalArgumentException .
     * @throws IllegalAccessException .
     */
    public static Object getInstanceValue(final Object classInstance, final String fieldName) throws SecurityException, NoSuchFieldException,
            ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        // Get the private field
        final Field field = classInstance.getClass().getDeclaredField(fieldName);
        // Allow modification on the field
        field.setAccessible(true);
        // Return the Obect corresponding to the field
        return field.get(classInstance);
    }
    
    /**
     * Use reflection to change value of any instance field.
     * @param classInstance An Object instance.
     * @param fieldName The name of a field in the class instantiated by classInstancee
     * @param newValue The value you want the field to be set to.
     * @throws SecurityException .
     * @throws NoSuchFieldException .
     * @throws ClassNotFoundException .
     * @throws IllegalArgumentException .
     * @throws IllegalAccessException .
     */
    public static void setInstanceValue(final Object classInstance, final String fieldName, final Object newValue) throws SecurityException,
            NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        // Get the private field
        final Field field = classInstance.getClass().getDeclaredField(fieldName);
        // Allow modification on the field
        field.setAccessible(true);
        // Sets the field to the new value for this instance
        field.set(classInstance, newValue);
    }
}
