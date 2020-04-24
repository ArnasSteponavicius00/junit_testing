import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ElectricityBillParamTest {
	
	private String companyName;
	private String meterID;
	private int dayTimeUnits;
	private int nightTimeUnits;
	private float dayTimeRate;
	private float nightTimeRate;
	
	private float actualMonthBill;
	private float actualDayBill;
	private String actualString;
	
	public ElectricityBillParamTest(String companyName, String meterID, int dayTimeUnits, int nightTimeUnits,
			float dayTimeRate, float nightTimeRate, float actualMonthBill, float actualDayBill, String actualString) {
		super();
		this.companyName = companyName;
		this.meterID = meterID;
		this.dayTimeUnits = dayTimeUnits;
		this.nightTimeUnits = nightTimeUnits;
		this.dayTimeRate = dayTimeRate;
		this.nightTimeRate = nightTimeRate;
		this.actualMonthBill = actualMonthBill;
		this.actualDayBill = actualDayBill;
		this.actualString = actualString;
	}
	
	@Parameters
	public static Collection<Object[]> getData() {
		Object[][] data = new Object[2][9];
		
		data[0][0] = "GMIT";
		data[0][1] = "934XYZ";
		data[0][2] = 550;
		data[0][3] = 0;
		data[0][4] = (float)0.20;
		data[0][5] = (float)0.05;
		data[0][6] = (float)110;
		data[0][7] = (float)110;
		data[0][8] = "ElectricityBill [companyName=" + data[0][0] + ", meterID=" + data[0][1] + ", dayTimeUnits=" + data[0][2]
				+ ", nightTimeUnits=" + data[0][3] + ", dayTimeRate=" + data[0][4] + ", nightTimeRate="
				+ data[0][5] + "]";
		
		data[1][0] = "GalwayCoCo";
		data[1][1] = "ABC987";
		data[1][2] = 0;
		data[1][3] = 500;
		data[1][4] = (float)0.15;
		data[1][5] = (float)0.0;
		data[1][6] = (float)0.0;
		data[1][7] = (float)0.0;
		data[1][8] = "ElectricityBill [companyName=" + data[1][0] + ", meterID=" + data[1][1] + ", dayTimeUnits=" + data[1][2]
				+ ", nightTimeUnits=" + data[1][3] + ", dayTimeRate=" + data[1][4] + ", nightTimeRate="
				+ data[1][5] + "]";
		
		return Arrays.asList(data);
	}

	@Test
	public void testMonthlyBill() {
		ElectricityBill bill = new ElectricityBill(this.companyName, this.meterID, this.dayTimeUnits, this.nightTimeUnits, (float)this.dayTimeRate, (float)this.nightTimeRate);
		float expected = bill.monthlyBill();
		
		assertEquals("Expected", expected, this.actualMonthBill, 0.0);	
	}

	@Test
	public void testDayBill() {
		ElectricityBill bill = new ElectricityBill(this.companyName, this.meterID, this.dayTimeUnits, this.nightTimeUnits, (float)this.dayTimeRate, (float)this.nightTimeRate);
		float expected = bill.dayBill();
		
		assertEquals("Expected", expected, this.actualDayBill, 0.0);	
	}

	@Test
	public void testToString() {
		ElectricityBill bill = new ElectricityBill(this.companyName, this.meterID, this.dayTimeUnits, this.nightTimeUnits, (float)this.dayTimeRate, (float)this.nightTimeRate);
		assertEquals(bill.toString(), this.actualString);
	}

}
