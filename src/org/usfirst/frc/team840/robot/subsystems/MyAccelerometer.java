package org.usfirst.frc.team840.robot;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MyAccelerometer extends Subsystem {
	
	private BuiltInAccelerometer acc;

	public MyAccelerometer() {
		acc = new BuiltInAccelerometer();
	}

	public double getXAcc() {
		return acc.getX();
	}
	public double getYAcc() {
		return acc.getY();
	}
	public double getZAcc() {
		return acc.getZ();
	}
	
	public void prints() {
		SmartDashboard.putString("X Acceleration", "" + getXAcc());
		SmartDashboard.putString("Y Acceleration", "" + getYAcc());
		SmartDashboard.putString("Z Acceleration", "" + getZAcc());
	}
	public void update() {
		
	}
	
	protected void initDefaultCommand() {
	}

}
