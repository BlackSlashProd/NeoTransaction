package fr.upmc.aladyn.solutions.metaobject.invoke;

import fr.upmc.aladyn.transactionables.annotations.Transactionable;

import java.lang.reflect.Method;

/**
 * @author 
 */
public class TransactionableInterceptor implements Interceptor {
    /**
     * 
     * @param invocation Invocation qui sera utilisée pour appliquer la chaîne d'intercepteurs
     * @return retour de l'appel de l'invocation
     */
    public Object invoke(Invocation invocation) {
        if(invocation.getMethod().isAnnotationPresent(Transactionable.class)) {
        	// Save state of Transactionable object.
        	invocation.storeState();
        	// Invoking the developper's method.
        	System.out.println("DEBUG: Invoking " + invocation.getMethod().getName());
        }
        return invocation.nextInterceptor();
    }
}