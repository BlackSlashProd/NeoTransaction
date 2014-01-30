package fr.upmc.aladyn.solutions.metaobject.invoke;

import java.lang.reflect.Method;

/**
 * Permet de gérer l'éxecution successive des intercepteurs
 * @author Alain Defrance
 */
public class Invocation {
    private Object bean;
    private ObjectStore objStore;
    private Interceptor[] interceptors;
    private Method method;
    private Object[] args;
    private int index;
    
    /**
     * 
     * @param bean
     * @param interceptors
     * @param method
     * @param args
     */
    public Invocation(Object bean, Interceptor[] interceptors, Method method, Object[] args) {
        this.bean = bean;
        this.interceptors = interceptors;
        this.method = method;
        this.args = args;
        this.objStore = null;
    }
    
    /**
     * 
     * @return
     */
    public Object getBean() {
        return bean;
    }

    /**
     * 
     * @return
     */
    public Method getMethod() {
        return method;
    }
    
    /**
     * 
     * @return
     */
    public Object[] getArgs() {
        return args;
    }
    /**
     * 
     * @return
     */
    public Object nextInterceptor() {
        try {
            return interceptors[index++].invoke(this);
        } finally {
            index--;
        }
    }
    
    /**
     * 
     */
    public void storeState() {
    	this.objStore = new ObjectStore(this.bean);
    }
    
    /**
     * 
     */
    public void restoreState() {
    	this.objStore.objectRestore(this.bean);
    }
}