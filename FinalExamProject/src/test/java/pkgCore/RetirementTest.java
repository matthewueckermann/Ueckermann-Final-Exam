package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

public class RetirementTest {

	@Test
	public void TotalAmountSavedTest() {
		
		double dAnnualReturnRetired = 0.02;
		double monthlySSI = 2642;
		double requiredIncome = 10000;
		int yearsRetired = 20;
		double expectedAmount = 1454485.55;
		
		
		Retirement r1 = new Retirement();
		r1.setdAnnualReturnRetired(dAnnualReturnRetired);
		r1.setdMonthlySSI(monthlySSI);
		r1.setdRequiredIncome(requiredIncome);
		r1.setiYearsRetired(yearsRetired);
		
		assertEquals(expectedAmount, r1.TotalAmountSaved(), 0.01);
		
	}

	@Test
	public void AmountToSaveTest() {
		
		double dAnnualReturnRetired = 0.02;
		double monthlySSI = 2642;
		double requiredIncome = 10000;
		int yearsRetired = 20;
		int yearsToWork = 40;
		double dAnnualReturnWorking = 0.07;
		double expectedAmount = 554.13;
		
		
		Retirement r1 = new Retirement();
		r1.setdAnnualReturnRetired(dAnnualReturnRetired);
		r1.setdMonthlySSI(monthlySSI);
		r1.setdRequiredIncome(requiredIncome);
		r1.setiYearsRetired(yearsRetired);
		r1.setiYearsToWork(yearsToWork);
		r1.setdAnnualReturnWorking(dAnnualReturnWorking);	
		
		assertEquals(expectedAmount, r1.AmountToSave(), 0.01);
		
	}

	
}
