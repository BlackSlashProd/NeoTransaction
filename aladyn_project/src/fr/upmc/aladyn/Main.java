/**
 * Main.java
 */
package fr.upmc.aladyn;

import fr.upmc.aladyn.solutions.metaobject.container.BeansContainer;
import fr.upmc.aladyn.transactionables.samples.TransactionableInt;
import fr.upmc.aladyn.transactionables.samples.TransactionableIntBean;

/**
 * 
 * @author clem
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        BeansContainer mc = new BeansContainer();
        mc.register(TransactionableIntBean.class, TransactionableInt.class);
        TransactionableInt tn = mc.createBean(TransactionableInt.class);
        /* num = 42.	*/
        tn.setNum(42);
        System.out.println("num="+tn.getNum()+"\n");
        /* num++. num = 43. */
        tn.plusPlus(); 
        System.out.println("num="+tn.getNum()+"\n");
        /* num + 2. num = 45. */
        tn.plusDeux();
        System.out.println("num="+tn.getNum()+"\n");
        /* num / 0. Exception. num = 45. */
        tn.divZero();
        System.out.println("num="+tn.getNum()+"\n");
        /* (num+2) / 0. Exception. num = 45. */
        tn.plusDeuxDivZero();
        System.out.println("num="+tn.getNum()+"\n");
	}
}
