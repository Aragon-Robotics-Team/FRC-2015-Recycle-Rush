package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *	This can only drive straight right now
 */
public class DrivetrainPID extends PIDSubsystem {

    private Talon driveMotorLeft, driveMotorRight;
    private Encoder driveEncoderLeft, driveEncoderRight;
    private RobotDrive drive;
    
    public DrivetrainPID() {
    	super("Drivetrain", 0, 0, 0);
    	
    	driveMotorLeft = new Talon(RobotMap.driveMotorLeft[0]);
    	driveMotorRight = new Talon(RobotMap.driveMotorRight[0]);
    	driveEncoderLeft = new Encoder(RobotMap.driveEncoderLeft[0],RobotMap.driveEncoderLeft[1]);
    	driveEncoderRight = new Encoder(RobotMap.driveEncoderRight[0], RobotMap.driveEncoderRight[1]);
    	drive = new RobotDrive(driveMotorLeft, driveMotorRight);
    	
        setSetpoint(0);
        enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
    	return (driveEncoderLeft.getDistance() + driveEncoderRight.getDistance()) / 2;
    }
    
    protected void usePIDOutput(double output) {
        driveMotorLeft.set(output);
        driveMotorRight.set(output);
    }
    
    public void arcadeDrive(double power, double turn) {
    	drive.arcadeDrive(power, turn);
    }
}

