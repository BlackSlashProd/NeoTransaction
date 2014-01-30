package fr.upmc.aladyn.transactionables.samples;

public class TransactionableIntBean implements TransactionableInt {
	private int number;
	
	public TransactionableIntBean() {
		this.number =  0;
	}
	
	public TransactionableIntBean(int num) {
		this.number = num;
	}

	/**
	 * @return the number
	 */
	public int getNum() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNum(int number) {
		this.number = number;
	}
	
	/**
	 * 
	 */
	public void plusPlus() {
		System.out.println(this.number+"++");
		this.number++;
	}
	
	/**
	 * 
	 */
	public void plusDeux() {
		System.out.println(this.number+"+2");
		this.number += 2;
	}
	
	/**
	 * 
	 */
	public void divZero() {
		System.out.println(this.number+"/0");
		this.number /= 0;
	}	
	
	/**
	 * 
	 */
	public void plusDeuxDivZero() {
		this.plusDeux();
		this.divZero();
	}
}
