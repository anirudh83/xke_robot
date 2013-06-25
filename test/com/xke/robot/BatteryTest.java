package com.xke.robot;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author anirudh
 *
 */
public class BatteryTest {
	
	private Battery battery = new Battery();

	@Test
	public void testSetRemainingChargeConsumed50() throws NoBatteryException, LowBatteryException {
		battery.setRemainingChargeInPercent(50);
		Assert.assertEquals(50, battery.getRemainingChargeInPercent(),0);
	}
	
	@Test(expected =LowBatteryException.class)
	public void testLowBatteryException() throws NoBatteryException, LowBatteryException{
		battery.setRemainingChargeInPercent(90);
	}
	
	@Test(expected =NoBatteryException.class)
	public void testNoBatteryException() throws NoBatteryException, LowBatteryException{
		battery.setRemainingChargeInPercent(101);
	}
	

}
