package fr.upmc.aladyn.transactionables.samples;

import fr.upmc.aladyn.transactionables.annotations.Transactionable;

public interface TransactionableNumber {
	/**
	 * @return the number
	 */
	public Integer getNum();

	/**
	 * @param number the number to set
	 */
	public void setNum(Integer n);
	
	@Transactionable
	public void plusDeux();
	
	@Transactionable
	public void divZero();
	
	@Transactionable
	public void plusDeuxDivZero();

	public void plusPlus();
}
