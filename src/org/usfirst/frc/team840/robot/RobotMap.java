package org.usfirst.frc.team840.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //Ports on the roboRio, and directional multiplier
	public static final int[] driveMotorLeft = {0,1};
	public static final int[] driveMotorRight = {0,-1};
	public static final int[] liftMotor = {0,1};
	
	public static final int[] slidingCylinder = {0,1};
	
	public static final int[] liftEncoder = {0,1};
	
	public static final int[] bottomReed = {0};	//TODO Replace dummy values
	public static final int[] loadToteReed = {0};
	public static final int[] loadBinReed = {0};
	public static final int[] scorePlatformReed = {0};
	public static final int[] scoreCoOpReed = {0};
    
}
