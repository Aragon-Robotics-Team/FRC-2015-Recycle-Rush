package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.HoldLift;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Controls the stacking cage mechanism. Has PID for the winch/garage door opener and a double solenoid for the rodless cylinders
 */
public class Stacker extends PIDSubsystem {

	private Talon liftMotor;
	private Encoder liftEncoder;
	private DoubleSolenoid sliderCylinders;
	
    // Initialize your subsystem here
    public Stacker() {
        super("Stacker", 2.0, 0.0, 0.0);	//TODO Tune PID constants
        liftMotor = new Talon(RobotMap.liftMotor[0]);
        liftEncoder = new Encoder(RobotMap.liftEncoder[0], RobotMap.liftEncoder[0]);
        sliderCylinders = new DoubleSolenoid(RobotMap.slidingCylinder[0],RobotMap.slidingCylinder[0]);
        
        liftEncoder.setDistancePerPulse(840);	//TODO Tune experimentally
    }
    
    public void slideOut() {
    	sliderCylinders.set(DoubleSolenoid.Value.kForward);
    }
    
    public void slideIn() {
    	sliderCylinders.set(DoubleSolenoid.Value.kReverse);
    }
    
    public DoubleSolenoid.Value getValue() {
    	return sliderCylinders.get();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new HoldLift());
    }
    
    protected double returnPIDInput() {
        return liftEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        liftMotor.set(output);
    }
}