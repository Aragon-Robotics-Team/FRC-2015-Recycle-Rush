package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.HoldLift;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *	The lift on the stacking mechanism. Uses a single motor and a Hall-effect encoder.
 */
public class Lift extends PIDSubsystem {

	private Talon liftMotor;
	private Encoder liftEncoder;
	
	public final double liftMotorManualPower = 0.5;
	public final double liftMotorInitPower = -0.125;
	public final double bottomHeight = 0;
	public final double loadToteHeight = 15;
	public final double scorePlatformHeight = 5;
	
	public Lift() {
    	super("Stacker", .75, 0.0, 0.0);
    	liftMotor = new Talon(RobotMap.liftMotor[0]);
        liftEncoder = new Encoder(RobotMap.liftEncoder[0], RobotMap.liftEncoder[1]);
        
        liftEncoder.setReverseDirection(false);
        liftEncoder.setDistancePerPulse((2 * Math.PI) / 497);	//Circumference over ticks per rotation. All units in in.
        liftEncoder.reset();
        
        getPIDController().setContinuous(false);
        getPIDController().setAbsoluteTolerance(0.05);
        setSetpoint(bottomHeight);
        enable();
    }
    
	public void setLiftMotor(double power) {
    	liftMotor.set(power);
    }
    
    public void resetLiftEncoder() {
    	liftEncoder.reset();
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
