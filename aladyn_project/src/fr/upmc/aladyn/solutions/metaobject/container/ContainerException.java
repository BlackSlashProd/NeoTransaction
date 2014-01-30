package fr.upmc.aladyn.solutions.metaobject.container;

/**
 * When an exception appear during the instantiation in the beans container.
 * @author BARBIER Clément
 */
public class ContainerException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor of ContainerExecption.
	 * @param message
	 */
	public ContainerException(String message) {
        super(message);
    }
}