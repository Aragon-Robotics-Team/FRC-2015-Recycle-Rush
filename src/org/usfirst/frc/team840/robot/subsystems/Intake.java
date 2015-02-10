package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.RollStop;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	These two rollers move totes and bins into the robot's stacking subsystem.
 */
public class Intake extends Subsystem {
    
    private Victor intakeMotorLeft, intakeMotorRight;
    
    public Intake() {
    	super();
    	intakeMotorLeft = new Victor(RobotMap.intakeMotorLeft[0]);
    	intakeMotorRight = new Victor(RobotMap.intakeMotorRight[0]);
    }
    
    public void setLeft(double power) {	//Positive for rolling in
    	intakeMotorLeft.set(power * RobotMap.intakeMotorLeft[1]);
    }
    
    public void setRight(double power) {	//Positive for rolling in
    	intakeMotorRight.set(power * RobotMap.intakeMotorRight[1]);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new RollStop());
    }
}

