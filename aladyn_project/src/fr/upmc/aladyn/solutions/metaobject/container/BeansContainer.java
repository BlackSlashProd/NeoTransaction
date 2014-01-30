package fr.upmc.aladyn.solutions.metaobject.container;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import fr.upmc.aladyn.solutions.metaobject.handler.BeanInvocationHandler;
import fr.upmc.aladyn.solutions.metaobject.invoke.BeanInterceptor;
import fr.upmc.aladyn.solutions.metaobject.invoke.Interceptor;
import fr.upmc.aladyn.solutions.metaobject.invoke.TransactionableInterceptor;

/**
 * BeansContainer allows to use several beans on several different classes.
 * @author BARBIER Clément
 */
public class BeansContainer {
    private Map<Class<?>, Class<?>> registry;
    private Interceptor[] interceptors;

    /**
     * Constructor of BeansContainer.
     */
    public BeansContainer() {
        registry = new HashMap<Class<?>, Class<?>>();
        interceptors = new Interceptor[] {
            new TransactionableInterceptor(),
            new BeanInterceptor()
        };
    }

    /**
     * Store beans with associate classes in the container.
     * @param impl
     * @param iface 
     * @return The container to chain the beans.
     */
	public <T> BeansContainer register(Class<? extends T> impl, Class<T> iface) {
		registry.put(iface, impl);
		return this;
	}

	/**
	 * Create a new instance of bean registered for the class. 
	 * @param iface The class to instantiate.
	 * @return The new instance.
	 */
	public <T> T createBean(Class<T> iface) {
        try {
            Class<? extends T> impl = (Class<? extends T>) registry.get(iface);
			BeanInvocationHandler handler = new BeanInvocationHandler(impl.newInstance(), interceptors);
            T newProxyInstance = (T) Proxy.newProxyInstance(
            		Thread.currentThread().getContextClassLoader(),
                    new Class[] {iface},
                    handler);
			return newProxyInstance;
        } catch (Exception e) {
        	throw new ContainerException(e.getMessage());
        }
    }
}
