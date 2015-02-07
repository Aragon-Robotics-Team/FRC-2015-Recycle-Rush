package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.HoldLift;

import edu.wpi.first.wpilibj.DigitalInput;
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
	private DigitalInput bottomReed, loadToteReed, loadBinReed, scorePlatformReed, scoreCoOpReed;
	private DoubleSolenoid sliderCylinders;
	
	private int liftPosition;	//0 - 5; Bottom, score platform, score co-op, load tote, load bin 
	
	public double liftMotorManualPower = 0.5;
	
    // Initialize your subsystem here
    public Stacker() {
        super("Stacker", 2.0, 0.0, 0.0);	//TODO Tune PID constants
        liftMotor = new Talon(RobotMap.liftMotor[0]);
        liftEncoder = new Encoder(RobotMap.liftEncoder[0], RobotMap.liftEncoder[0]);
        sliderCylinders = new DoubleSolenoid(RobotMap.slidingCylinder[0],RobotMap.slidingCylinder[0]);
        bottomReed = new DigitalInput(RobotMap.bottomReed[0]);
        loadToteReed = new DigitalInput(RobotMap.loadToteReed[0]);
        loadBinReed = new DigitalInput(RobotMap.loadBinReed[0]);
        scorePlatformReed = new DigitalInput(RobotMap.scorePlatformReed[0]);
        scoreCoOpReed = new DigitalInput(RobotMap.scoreCoOpReed[0]);
        
        liftEncoder.setDistancePerPulse(0.2);	//All units in in.
        getPIDController().setContinuous(false);
        getPIDController().setAbsoluteTolerance(0.05);
        getPIDController().setInputRange(0, 250);	//In encoder ticks. 250 is 50 in.
        
        liftPosition = 0;
    }
    
    public void setLiftMotor(double power) {
    	liftMotor.set(power);
    }
    
    public void slideOut() {
    	sliderCylinders.set(DoubleSolenoid.Value.kForward);
    }
    
    public void slideIn() {
    	sliderCylinders.set(DoubleSolenoid.Value.kReverse);
    }
    
    public boolean getBottomReed() {
    	return bottomReed.get();
    }
    
    public boolean getLoadToteReed() {
    	return loadToteReed.get();
    }
    
    public boolean getLoadBinReed() {
    	return loadBinReed.get();
    }

    public boolean getScorePlatformReed() {
    	return scorePlatformReed.get();
    }
    
    public boolean getScoreCoOpReed() {
    	return scoreCoOpReed.get();
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
    
    public int getLiftPosition() {
    	return liftPosition;
    }
    
    public void setLiftPosition(int liftPosition) {
    	this.liftPosition = liftPosition;
    }
}