package org.usfirst.frc.team840.robot.subsystems;

import java.lang.Math;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *	Drivetrain for the robot. It is unsure at this time what the final drivetrain will be, so we will program one using standard
 *	two motor tank. This drivtrain uses the TalonSRX motor controllers. At this time, there are no sensors.
 */
public class Accelerometer1 extends Subsystem {
    
	private static BuiltInAccelerometer acc;
	private static double seconds;
	public static double xVel = 0.0;
	public static double yVel = 0.0;
	public static double zVel = 0.0;
	public static double xPos = 0.0;
	public static double yPos = 0.0;
	public static double zPos = 0.0;
	
	public Accelerometer1() {
		super();
		acc = new BuiltInAccelerometer();
		seconds = .005;
	}
	
    public void initDefaultCommand() {
    }
    public double getSeconds() {
    	return seconds;
    }
    public static double getXAcc() {
        return acc.getX();
    }
    
    public static double getYAcc() {
        return acc.getY();
    }
    
    public static double getZAcc() {
        return acc.getZ();
    }
    public static double getXVelocity() {
    	return xVel;
    }
    public static double getYVelocity() {
    	return yVel;
    }
    public static double getZVelocity() {
    	return zVel;
    }
    public static double getXDistance() {
    	return xPos;
    }
    public static double getYDistance() {
    	return yPos;
    }
    public static double getZDistance() { //lol
    	return zPos;
    }
    public static void update() {
    	xVel += getXAcc() * seconds;
    	yVel += getYAcc() * seconds;
    	zVel += getZAcc() * seconds;
    	xPos += xVel * seconds;
    	yPos += yVel * seconds;
    	zPos += zVel * seconds;
    	Timer.delay(seconds);
    }
    
    //any corresponding magnitude and angle methods can be used to get vectors.
    public static double getAccMagnitude() {
    	double toReturn = 0.0;
    	toReturn += getYAcc() * getYAcc() * getYAcc();
    	toReturn += getXAcc() * getXAcc() * getXAcc();
    	//time to sqrt
    	toReturn = Math.sqrt(toReturn); //pythagorean theorem
    	return toReturn;
    }
    public static double getVelocityMagnitude() {
    	double toReturn = 0.0;
    	toReturn += getYVelocity() * getYVelocity();
    	toReturn += getXVelocity() * getXVelocity();
    	toReturn = Math.sqrt(toReturn);
    	return toReturn;
    }
    public static double getDisplacementMagnitude() {
    	double toReturn = 0.0;
    	toReturn += getYDistance() * getYDistance();
    	toReturn += getXDistance() * getXDistance();
    	toReturn = Math.sqrt(toReturn);
    	return toReturn;
    }
    public static double getAngleofAcc() {
    	//will find "forward" position later. for now forward is the Y value
    	//normal to Z
    	double angleToReturn; double slope;
    	slope = getYAcc() / getXAcc(); //units: x/t^2
        angleToReturn = Math.atan(slope);
    	return angleToReturn; 
    }
    public static double getAngleofVelocity() {
    	double angleToReturn; double slope;
    	slope = getYVelocity() / getXVelocity();
    	angleToReturn = Math.atan(slope);
    	return angleToReturn;
    }
    public static double getAngleofDisplacement() { //only works for movement. will make method that works for sitting still as well
    	double angleToReturn; double slope;
    	slope = getYDistance() / getXDistance();
    	angleToReturn = Math.atan(slope);
    	return angleToReturn;
    }
    public static void prints() {
    	SmartDashboard.putNumber("X Acceleration", getXAcc());
		SmartDashboard.putNumber("Y Acceleration", getYAcc());
		SmartDashboard.putNumber("Z Acceleration", getZAcc());
		SmartDashboard.putNumber("X Velocity", getXVelocity());
		SmartDashboard.putNumber("Y Velocity", getYVelocity());
		SmartDashboard.putNumber("Z Velocity", getZVelocity());		
		SmartDashboard.putNumber("X Distance", getXDistance());
		SmartDashboard.putNumber("Y Distance", getYDistance());
		SmartDashboard.putNumber("Z Distance", getZDistance()); 
		SmartDashboard.putNumber("Magnitude of acceleration", getAccMagnitude());
		SmartDashboard.putNumber("Angle of acceleration", getAngleofAcc());
    }
}