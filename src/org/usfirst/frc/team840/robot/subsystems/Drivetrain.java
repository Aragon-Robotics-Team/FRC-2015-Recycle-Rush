package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Drivetrain for the robot. It is unsure at this time what the final drivetrain will be, so we will program one using standard
 *	two motor tank. This drivtrain uses the Talon motor controllers. At this time, there are no sensors.
 */
public class Drivetrain extends Subsystem {
    
	private Talon driveMotorLeft;
	private Talon driveMotorRight;
	private RobotDrive drive;
	
	public Drivetrain() {
		super();
		driveMotorLeft = new Talon(RobotMap.driveMotorLeft[0]);
		driveMotorRight = new Talon(RobotMap.driveMotorRight[0]);
		drive = new RobotDrive(driveMotorLeft, driveMotorRight);
	}
	
	public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
    
    public void setLeft(double power) {
    	driveMotorLeft.set(power * RobotMap.driveMotorLeft[1]);
    }
    
    public void setRight(double power) {
    	driveMotorRight.set(power * RobotMap.driveMotorRight[1]);
    }
    
    public void arcadeDrive(double power, double turn) {
    	drive.arcadeDrive(power, turn);
    }
    
    public double getLeftSpeed() {
    	return driveMotorLeft.getSpeed();
    }
    
    public double getRightSpeed() {
    	return driveMotorRight.getSpeed();
    }
}

