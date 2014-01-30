package fr.upmc.aladyn.transactionables.samples;

public class TransactionableNumberBean implements TransactionableNumber {
	private Integer number;
	
	public TransactionableNumberBean() {
		this.number =  new Integer(0);
	}
	
	public TransactionableNumberBean(Integer num) {
		this.number = num;
	}

	/**
	 * @return the number
	 */
	public Integer getNum() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNum(Integer number) {
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
		System.out.println(this.number+"+2");
		this.plusDeux();
		System.out.println(this.number+"/0");
		this.number /= 0;
	}
}
