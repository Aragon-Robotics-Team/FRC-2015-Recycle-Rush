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
	private double seconds;
	public double xVel = 0.0;
	public double yVel = 0.0;
	public double zVel = 0.0;
	public double xPos = 0.0;
	public double yPos = 0.0;
	public double zPos = 0.0;
	
	public Accelerometer(double time) {
		super();
		acc = new BuiltInAccelerometer(RobotMap.accRange);
		seconds = time;
	}
	
    public void initDefaultCommand() {
    }
    public double getSeconds() {
    	return seconds;
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
    public double getXVelocity() {
    	return xVel;
    }
    public double getYVelocity() {
    	return yVel;
    }
    public double getZVelocity() {
    	return zVel;
    }
    public double getXDistance() {
    	return xPos;
    }
    public double getYDistance() {
    	return yPos;
    }
    public double getZDistance() { //lol
    	return zPos;
    }
    public double update() {
    	xVel += getXAcc() * seconds;
    	yVel += getYAcc() * seconds;
    	zVel += getZAcc() * seconds;
    	xPos += xVel * seconds;
    	yPos += yVel * seconds;
    	zPos += zVel * seconds;
    }
    
    //any corresponding magnitude and angle methods can be used to get vectors.
    public double getAccMagnitude() {
    	double toReturn = 0.0;
    	toReturn += getYAcc() * getYAcc() * getYAcc();
    	toReturn += getXAcc() * getXAcc() * getXAcc();
    	//time to sqrt
    	toReturn = Math.sqrt(toReturn); //pythagorean theorem
    	return toReturn;
    }
    public double getVelocityMagnitude() {
    	double toReturn = 0.0;
    	toReturn += getYVelocity() * getYVelocity();
    	toReturn += getXVelocity() * getXVelocity();
    	toReturn = Math.sqrt(toReturn);
    	return toReturn;
    }
    public double getDisplacementMagnitude() {
    	double toReturn = 0.0;
    	toReturn += getYDistance() * getYDistance();
    	toReturn += getXDistance() * getXDistance();
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
    public double getAngleofVelocity() {
    	double angleToReturn; double slope;
    	slope = getYVelocity() / getXVelocity();
    	angleToReturn = Math.arctan(slope);
    	return angleToReturn;
    }
    public double getAngleofDisplacement() { //only works for movement. will make method that works for sitting still as well
    	double angleToReturn; double slope;
    	slope = getYDistance() / getXDistance();
    	angleToReturn = Math.arctan(slope);
    }
}