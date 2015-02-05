package org.usfirst.frc.team840.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //Ports on the roboRio
	public static final int driveMotorLeft = 0;
	public static final int driveMotorRight = 1;
	public static final int liftMotor = 2;
	
	public static final int slidingCylinder0 = 0;
	public static final int slidingCylinder1 = 1;
	
	public static final int liftEncoder0 = 0;
	public static final int liftEncoder1 = 1;	
	
	//Multipliers used to correct the direction of motors
	public static final int driveMotorLeftDir = 1;
	public static final int driveMotorRightDir = -1;
    
}
