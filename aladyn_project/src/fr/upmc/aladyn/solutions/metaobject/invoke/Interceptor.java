package fr.upmc.aladyn.solutions.metaobject.invoke;

/**
 * 
 * @author clem
 *
 */
public interface Interceptor {
    /**
     * @param invocation invocation qui sera utilisée pour appliquer la chaîne d'interceptors
     * @return retour de l'appel de l'invocation
     */
    public Object invoke(Invocation invocation);
}
