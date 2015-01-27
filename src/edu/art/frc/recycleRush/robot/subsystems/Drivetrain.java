package edu.art.frc.recycleRush.robot.subsystems;

import edu.art.frc.recycleRush.robot.RobotMap;
import edu.art.frc.recycleRush.robot.commands.TankDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Drivetrain for the robot. It is unsure at this time what the final drivetrain will be, so we will program one using standard
 *	two motor tank. This drivtrain uses the TalonSRX motor controllers. At this time, there are no sensors.
 */
public class Drivetrain extends Subsystem {
    
	private Talon driveMotorLeft;
	private Talon driveMotorRight;
	
	public Drivetrain() {
		super();
		driveMotorLeft = new Talon(RobotMap.driveMotorLeft);
		driveMotorRight = new Talon(RobotMap.driveMotorRight);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
    
    public void setLeft(double power) {
    	driveMotorLeft.set(power * RobotMap.driveMotorLeftDir);
    }
    
    public void setRight(double power) {
    	driveMotorRight.set(power * RobotMap.driveMotorRightDir);
    }
    
    public double getLeftSpeed() {
    	return driveMotorLeft.getSpeed();
    }
    
    public double getRightSpeed() {
    	return driveMotorRight.getSpeed();
    }
}

