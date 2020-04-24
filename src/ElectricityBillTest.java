import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ElectricityBillTest {

	@Test
	public void testMonthlyBill() {
		ElectricityBill bill = new ElectricityBill("LaserQuest", "123ABC", 1000, 200, (float)0.14, (float)0.07);
		float actual = bill.monthlyBill();
		
		assertEquals((float)154, actual, 0.0);	
	}

	@Test
	public void testChangeDayRate() {
		ElectricityBill bill = new ElectricityBill("LaserQuest", "123ABC", 1000, 200, (float)0.14, (float)0.07);
		bill.changeDayRate((float) 0.16);
		
		float actual = bill.getDayRate();
		
		assertEquals((float)0.16, actual, 0.0);	
	}

	@Test
	public void testGetDayRate() {
		ElectricityBill bill = new ElectricityBill("LaserQuest", "123ABC", 1000, 200, (float)0.14, (float)0.07);
		double actual = bill.getDayRate();
		
		assertEquals((float)0.14, actual, 0.0);
	}

	@Test
	public void testToString() {
		ElectricityBill bill = new ElectricityBill("LaserQuest", "123ABC", 1000, 200, (float)0.14, (float)0.07);
		assertEquals(bill.toString(),
				"ElectricityBill [companyName=LaserQuest, meterID=123ABC, dayTimeUnits=1000, nightTimeUnits=200, dayTimeRate=0.14, nightTimeRate=0.07]");
	}

}
