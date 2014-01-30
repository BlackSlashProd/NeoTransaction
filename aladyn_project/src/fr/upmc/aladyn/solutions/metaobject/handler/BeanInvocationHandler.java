package fr.upmc.aladyn.solutions.metaobject.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import fr.upmc.aladyn.solutions.metaobject.invoke.Interceptor;
import fr.upmc.aladyn.solutions.metaobject.invoke.Invocation;

/**
 * Appel l'invocation qui implémentera dynamiquement l'instance grâce aux intercepteurs
 * @author Alain Defrance
 */
public class BeanInvocationHandler implements InvocationHandler {
    private Object bean;
    private Interceptor[] interceptors;

    public BeanInvocationHandler(Object bean, Interceptor[] interceptors) {
        this.bean = bean;
        this.interceptors = interceptors;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(bean, interceptors, method, args);
        return invocation.nextInterceptor();
    }
}