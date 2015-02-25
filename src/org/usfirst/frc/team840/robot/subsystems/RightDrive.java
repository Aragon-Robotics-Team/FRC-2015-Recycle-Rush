package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class RightDrive extends PIDSubsystem {

    private Talon driveMotorRight;
    private Encoder driveEncoderRight;
    
    public RightDrive() {
        super("Right drivetrain", 1, 0, 0);
        
        driveMotorRight = new Talon(RobotMap.driveMotorRight[0]);
        driveEncoderRight = new Encoder(RobotMap.driveEncoderRight[0], RobotMap.driveEncoderRight[1]);
        
        driveEncoderRight.setReverseDirection(false);
        driveEncoderRight.setDistancePerPulse((4 * Math.PI) / 4);
        driveEncoderRight.reset();
        
        getPIDController().setContinuous(true);
        getPIDController().setAbsoluteTolerance(1);
        setSetpoint(0);
        enable();
    }
    
    public void initDefaultCommand() {
        
    }
    
    protected double returnPIDInput() {
    	return driveEncoderRight.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        driveMotorRight.set(output * RobotMap.driveMotorRight[1]);
    }
    
    public Talon getDriveMotor() {
    	return driveMotorRight;
    }
    
    public void resetRightEncoder() {
    	driveEncoderRight.reset();
    }
}
