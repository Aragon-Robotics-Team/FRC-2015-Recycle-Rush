package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import java.lang.Math;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Drivetrain for the robot. It is unsure at this time what the final drivetrain will be, so we will program one using standard
 *	two motor tank. This drivtrain uses the TalonSRX motor controllers. At this time, there are no sensors.
 */
public class Accelerometer extends Subsystem {
    
	private BuiltInAccelerometer acc;
	
	public Accelerometer() {
		super();
		acc = new BuiltInAccelerometer(RobotMap.accRange);
	}
	
    public void initDefaultCommand() {
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
    //these two methods can be used to get an acceleration vector.
    public double getAccMagnitude() {
    	double toReturn = acc.getZ() * acc.getZ() * acc.getZ;
    	toReturn += acc.getY() * acc.getY() * acc.getY();
    	toReturn += acc.getX() * acc.getX() * acc.getX();
    	//time to sqrt
    	toReturn = Math.sqrt(toReturn);
    	return toReturn;
    }
    public double getAngleofAcc() {
    	//will find "forward" position later. for now forward is the Y value
    	//normal to Z
    	double angleToReturn; double slope;
    	slope = getYAcc() / getXAcc(); //units: x/t^2
    	angleToReturn = Math.arctan(slope);
    	return angleToReturn; 
    }
}
