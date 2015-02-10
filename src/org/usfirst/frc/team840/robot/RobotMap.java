package org.usfirst.frc.team840.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //Arrays for physical devices' parameters
    public static final int[] driveMotorLeft = {0, 1};	//Port, direction
    public static final int[] driveMotorRight = {1, -1};	//Port, direction
    
    public static final int[] intakeMotorLeft = {4, 1};
    public static final int[] intakeMotorRight = {5, -1};
    
    
}
