package edu.art.frc.recycleRush.robot;
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
	
	//Multiplier used to correct the direction of motors
	public static final int driveMotorLeftDir = 1;
	public static final int driveMotorRightDir = -1;
	
	//Multiplier used for slower speed control
	public static final double CREEP_SPEED = 0.5;
	public static final double CREEP_SPEED_ULTRA = .125;
    
}
