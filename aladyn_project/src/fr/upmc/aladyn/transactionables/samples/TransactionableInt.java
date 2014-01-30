package fr.upmc.aladyn.transactionables.samples;

import fr.upmc.aladyn.transactionables.annotations.Transactionable;

public interface TransactionableInt {
	/**
	 * @return the number
	 */
	public int getNum();

	/**
	 * @param number the number to set
	 */
	public void setNum(int n);
	
	@Transactionable
	public void plusDeux();
	
	@Transactionable
	public void divZero();
	
	@Transactionable
	public void plusDeuxDivZero();

	public void plusPlus();
}
