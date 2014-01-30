package fr.upmc.aladyn.solutions.metaobject.invoke;

import java.lang.reflect.Method;

/**
 * Intercepteur redirigeant l'appel vers l'implémentation originelle
 * @author Alain Defrance
 */
public class BeanInterceptor implements Interceptor {

    /**
     * Intercepte l'appel pour invoquer la méthode implémentée par le développeur
     * @param invocation Invocation qui sera utilisée pour appliquer la chaîne d'intercepteurs
     * @return retour de l'appel de l'invocation
     */
    public Object invoke(Invocation invocation) {
        try {
            Object bean = invocation.getBean();
            Method method = invocation.getMethod();
            Object[] args = invocation.getArgs();
            return method.invoke(bean, args);
        } catch (Exception e) {
        	/* 
        	 * An exception : Object must be restored.
        	 * */
        	System.out.println("DEBUG: Exception detect.\n");
        	invocation.restoreState();
        	return null;
        }
    }
}