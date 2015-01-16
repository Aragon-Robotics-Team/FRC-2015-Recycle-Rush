package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Drivetrain for the robot. It is unsure at this time what the final drivetrain will be, so we will program one using standard
 *	two motor tank. This drivtrain uses the TalonSRX motor controllers. At this time, there are no sensors.
 */
public class DrivetrainTank extends Subsystem {
    
	private Talon driveMotorLeft, driveMotorRight;
	
	public DrivetrainTank() {
		super();
		driveMotorLeft = new Talon(RobotMap.driveMotorLeft);
		driveMotorRight = new Talon(RobotMap.driveMotorRight);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
    
    public void setLeft(double power) {
    	driveMotorLeft.set(power);
    }
    
    public void setRight(double power) {
    	driveMotorRight.set(power);
    }
}

