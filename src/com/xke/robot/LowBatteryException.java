package com.xke.robot;

/**
 * 
 * @author anirudh
 *
 */
public class LowBatteryException extends Exception{
	
	public LowBatteryException(String msg) {
		super(msg);
	}
}
