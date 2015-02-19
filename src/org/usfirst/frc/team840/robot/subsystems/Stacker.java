package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.HoldLift;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Controls the stacking cage mechanism. Has a Talon/mechanical encoder PID for the winch/garage door opener, a double solenoid for the rodless cylinders, and reed switches for manual position sensing. All lengths are in inches
 */
public class Stacker extends PIDSubsystem {

	private Talon liftMotor;
	private Encoder liftEncoder;
	private DoubleSolenoid rodlessCylinderLeft, rodlessCylinderRight;
	
	private int liftPosition;	//0 - 4; Bottom, score platform, score co-op, load tote, load bin 
	
	public final double liftMotorManualPower = 0.5;
	public final double liftMotorInitPower = -0.125;
	public final double bottomHeight = 0;
	public final double loadToteHeight = 15;
	public final double scorePlatformHeight = 5;
	
    // Initialize your subsystem here
    public Stacker() {
        super("Stacker", .75, 0.0, 0.0);	//TODO Tune PID constants
        liftMotor = new Talon(RobotMap.liftMotor[0]);
        liftEncoder = new Encoder(RobotMap.liftEncoder[0], RobotMap.liftEncoder[1]);
        rodlessCylinderLeft = new DoubleSolenoid(1, RobotMap.rodlessCylinderLeft[0], RobotMap.rodlessCylinderLeft[1]);	//TODO Put CAN ID in robot map, but only after merge
        rodlessCylinderRight = new DoubleSolenoid(1, RobotMap.rodlessCylinderRight[0], RobotMap.rodlessCylinderRight[1]);

        liftEncoder.setReverseDirection(false);
        liftEncoder.setDistancePerPulse((2 * Math.PI) / 497);	//Circumference over ticks per rotation. All units in in.
        liftEncoder.reset();
        
        getPIDController().setContinuous(false);
        getPIDController().setAbsoluteTolerance(0.05);
        //getPIDController().setInputRange(0, 250);	//In encoder ticks. 250 is 50 in.
        setSetpoint(bottomHeight);
        enable();
        
        liftPosition = 0;
    }
    
    public void setLiftMotor(double power) {
    	liftMotor.set(power);
    }
    
    public void resetLiftEncoder() {
    	liftEncoder.reset();
    }
    
    public void slideOutLeft() {
    	rodlessCylinderLeft.set(DoubleSolenoid.Value.kForward);
    }
    
    public void slideOutRight() {
    	rodlessCylinderRight.set(DoubleSolenoid.Value.kForward);
    }
    
    public void slideInLeft() {
    	rodlessCylinderLeft.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void slideInRight() {
    	rodlessCylinderRight.set(DoubleSolenoid.Value.kReverse);
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
    
    public int getLiftPosition() {
    	return liftPosition;
    }
    
    public void setLiftPosition(int liftPosition) {
    	this.liftPosition = liftPosition;
    }
}
