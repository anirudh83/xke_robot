package com.xke.robot;

/**
 * 
 * @author anirudh
 *
 */
public class Robot {
	
	private final static double WEIGHT_LIMIT =10;
	private final static double WALKING_LIMIT_PER_CHARGE=5;
	private final static String OVERWEIGHT_WARNING="Overweight";
	private Battery battery;
	private double carriedWeight;
	private double distanceTravelledInKm;
	private StringBuilder robotHead;
	private String robotDisplay;
	
	public Robot(double carriedWeight,double distanceTravelledInKm){
		
		this.carriedWeight=carriedWeight;
		if(isOverWeight()){
			robotDisplay=OVERWEIGHT_WARNING;
		}else{
			this.battery=new Battery();
			this.distanceTravelledInKm=distanceTravelledInKm;
			this.robotHead= new StringBuilder("battery is fine");
		}
	}
	
	public boolean isOverWeight(){
		return carriedWeight>WEIGHT_LIMIT;
	}
	
	public void calculateRemainingBattery(){
		double consumedBattery = calculateBatteryConsumedByCarryingWeightAndWalk();
		try {
			battery.setRemainingChargeInPercent(consumedBattery);
		} catch (NoBatteryException e) {
			System.out.println(e.getMessage());
			robotDisplay="Battery Over";
		} catch (LowBatteryException e) {
			robotHead=new StringBuilder(e.getMessage());
		}
	}
	
	public double getRemainingBattery(){
		return battery.getRemainingChargeInPercent();
	}
	
	
	private double calculateBatterConsumedByWalk(){
		return (100/WALKING_LIMIT_PER_CHARGE)*distanceTravelledInKm;
	}
	
	private double calculateBatteryConsumedByCarryingWeightAndWalk(){
		return calculateBatterConsumedByWalk()+(2*carriedWeight);
	}

	public String getRobotHead() {
		return new String(robotHead);
	}

	public String getRobotDisplay() {
		return robotDisplay;
	}

}
