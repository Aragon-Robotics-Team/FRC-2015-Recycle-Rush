package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Drivetrain extends PIDSubsystem {

    private Talon driveMotorLeft, driveMotorRight;
    private Encoder driveEncoderLeft, driveEncoderRight;
    
    public Drivetrain() {
    	super("Drivetrain", 0, 0, 0);
    	
    	driveMotorLeft = new Talon(RobotMap.driveMotorLeft[0]);
    	driveMotorRight = new Talon(RobotMap.driveMotorRight[0]);
    	driveEncoderLeft = new Encoder(RobotMap.driveEncoderLeft[0],RobotMap.driveEncoderLeft[1]);
    	driveEncoderRight = new Encoder(RobotMap.driveEncoderRight[0], RobotMap.driveEncoderRight[1]);
    	
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
}

