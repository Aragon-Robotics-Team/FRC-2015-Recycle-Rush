package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.driving.ArcadeDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class LeftDrive extends PIDSubsystem {

    private Talon driveMotorLeft;
    private Encoder driveEncoderLeft;
    
    public LeftDrive() {
        super("Left drivetrain", 1, 0, 0);
        
        driveMotorLeft = new Talon(RobotMap.driveMotorLeft[0]);
        driveEncoderLeft = new Encoder(RobotMap.driveEncoderLeft[0], RobotMap.driveEncoderLeft[1]);
        
        driveEncoderLeft.setReverseDirection(false);
        driveEncoderLeft.setDistancePerPulse((4 * Math.PI) / 4);
        driveEncoderLeft.reset();
        
        getPIDController().setContinuous(true);
        getPIDController().setAbsoluteTolerance(1);
        setSetpoint(0);
        enable();
    }
    
    public void initDefaultCommand() {
        //setDefaultCommand(new ArcadeDrive());
    }
    
    protected double returnPIDInput() {
    	return driveEncoderLeft.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        driveMotorLeft.set(output);
    }
    
    public Talon getDriveMotor() {
    	return driveMotorLeft;
    }
    
    public void resetLeftEncoder() {
    	driveEncoderLeft.reset();
    }
}
