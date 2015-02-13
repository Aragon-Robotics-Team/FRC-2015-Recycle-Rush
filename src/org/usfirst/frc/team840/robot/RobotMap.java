package org.usfirst.frc.team840.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around. Each peripheral is designated an array; formatting is as
 * follows:
 * Talon: Port, direction, PDP port(s)
 */
public class RobotMap {
    

    public static final int[] driveMotorLeft = {0, 1, 3, 2};
    public static final int[] driveMotorRight = {1, -1, 15, 14};
    public static final int[] intakeMotorLeft = {4, -1, 0};
    public static final int[] intakeMotorRight = {5, 1, 1};
	public static final int[] liftMotor = {3, 1, 12, 13};
	
	public static final int[] rodlessCylinderLeft = {0, 1};
	public static final int[] rodlessCylinderRight = {2, 3};
	
	public static final int[] liftEncoder = {4,5};
	
	public static final int[] bottomReed = {9};	//TODO Replace dummy values
	public static final int[] loadToteReed = {7};
	public static final int[] loadBinReed = {8};
	public static final int[] scorePlatformReed = {6};
	public static final int[] scoreCoOpReed = {0};
}
