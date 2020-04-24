public class ElectricityBill{
	
	private String companyName;
	private String meterID;
	private int dayTimeUnits;
	private int nightTimeUnits;
	private float dayTimeRate;
	private float nightTimeRate;
	
	
	
	public ElectricityBill(String companyName, String meterID, int dayTimeUnits, int nightTimeUnits, float dayTimeRate,
			float nightTimeRate) {
		
		this.companyName = companyName;
		this.meterID = meterID;
		this.dayTimeUnits = dayTimeUnits;
		this.nightTimeUnits = nightTimeUnits;
		this.dayTimeRate = dayTimeRate;
		this.nightTimeRate = nightTimeRate;
	}

	public float monthlyBill()
	{
		float bill = this.dayTimeRate*this.dayTimeUnits + this.nightTimeRate*this.nightTimeUnits;
		return bill;
	}
	
	public float dayBill()
	{
		float bill = this.dayTimeRate*this.dayTimeUnits;
		return bill;
	}
	
	public void changeDayRate(float newRate)
	{
		this.dayTimeRate = newRate;
	}
	
	public void changeNightRate(float newRate)
	{
		this.nightTimeRate = newRate;
	}
	
	public float getDayRate()
	{
		return this.dayTimeRate;
	}
	
	public float getNightRate()
	{
		return this.nightTimeRate;
	}
	
	
	public String toString() {
		return "ElectricityBill [companyName=" + companyName + ", meterID=" + meterID + ", dayTimeUnits=" + dayTimeUnits
				+ ", nightTimeUnits=" + nightTimeUnits + ", dayTimeRate=" + dayTimeRate + ", nightTimeRate="
				+ nightTimeRate + "]";
	}

}
