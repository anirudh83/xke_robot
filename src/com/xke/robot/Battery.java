package com.xke.robot;

/**
 * 
 * @author anirudh
 *
 */
public class Battery {
	
	private double remainingChargeInPercent;
	private static final double BATTERY_WARNING_LIMIT=15;
	
	public Battery(){
		this.remainingChargeInPercent=100;
	}

	public double getRemainingChargeInPercent() {
		return remainingChargeInPercent;
	}

	public void setRemainingChargeInPercent(double batteryConsumedInAction) throws NoBatteryException, LowBatteryException {
		double remainingBattery = remainingChargeInPercent-batteryConsumedInAction;
		this.remainingChargeInPercent=remainingBattery;
		
		if(remainingBattery<0){
			this.remainingChargeInPercent=0;
			throw new NoBatteryException("The battery is exhausted, not enough battery to complete this action");
		}else if( remainingBattery<BATTERY_WARNING_LIMIT){
			throw new LowBatteryException("Low Battery");
		}
	}
	
}
