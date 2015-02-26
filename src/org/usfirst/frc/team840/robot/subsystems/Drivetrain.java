package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Drivetrain for the robot. It is unsure at this time what the final drivetrain will be, so we will program one using standard
 *	two motor tank. This drivetrain uses the Talon motor controllers. At this time, there are no sensors.
 */
public class Drivetrain extends PIDSubsystem {
    
	private Talon driveMotorLeft, driveMotorRight;
	private RobotDrive drive;
	
	private Encoder encoder;
	
	public Drivetrain() {
		super("Drivetrain", 10, 0, 0);
		driveMotorLeft = new Talon(RobotMap.driveMotorLeft[0]);
		driveMotorRight = new Talon(RobotMap.driveMotorRight[0]);
		drive = new RobotDrive(driveMotorLeft, driveMotorRight);
		encoder = new Encoder(RobotMap.driveEncoderLeft[0], RobotMap.driveEncoderRight[1]);	//Change to right encoder if left one breaks 
		
		encoder.setReverseDirection(false);
		encoder.setDistancePerPulse((4 * Math.PI) / 4);
		encoder.reset();
        
        getPIDController().setContinuous(true);
        getPIDController().setAbsoluteTolerance(1);
        setSetpoint(0);
        enable();
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

	protected double returnPIDInput() {
		return encoder.getDistance();
	}

	protected void usePIDOutput(double output) {
		driveMotorLeft.set(output * RobotMap.driveMotorLeft[1]);
		driveMotorRight.set(output * RobotMap.driveMotorRight[1]);
	}
}

