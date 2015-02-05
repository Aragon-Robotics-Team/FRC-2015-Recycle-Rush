package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Controls the stacking cage mechanism. Has PID for the winch/garage door opener and a double solenoid for the rodless cylinders
 */
@SuppressWarnings("unused")
public class Stacker extends PIDSubsystem {

	private Talon liftMotor;
	private Encoder liftEncoder;
	private DoubleSolenoid sliderCylinders;
	
    // Initialize your subsystem here
    public Stacker() {
        super("Stacker", 2.0, 0.0, 0.0);	//TODO Tune PID constants
        liftMotor = new Talon(RobotMap.liftMotor);
        liftEncoder = new Encoder(RobotMap.liftEncoder0, RobotMap.liftEncoder1);
        sliderCylinders = new DoubleSolenoid(RobotMap.slidingCylinder0,RobotMap.slidingCylinder1);
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
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}