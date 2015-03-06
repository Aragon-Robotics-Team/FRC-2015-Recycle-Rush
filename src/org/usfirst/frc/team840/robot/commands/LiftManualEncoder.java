package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *	The pulley that raises the lift is connected to a hall effect encoder. This command uses PID to set the lift to any position. The setpoint is dynamic and can be set by a joystick input.
 */
public class LiftManualEncoder extends Command {

	private double setpoint;
	private final double threshold = 0.5;	//TODO Tune experimentally (Units irrelevant, but make sure to match to the units in DistancePerPulse)
	
    public LiftManualEncoder() {
        requires(Robot.stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setpoint = Robot.stacker.getSetpoint();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	setpoint += -0.5 * Robot.oi.getOperatorPad().getLeftY();	//Add the joystick value to the setpoint. Due to the speed at which commands are called, the max speed it 5 in. / sec 
    	Robot.stacker.setSetpoint(-1 * setpoint);	//Motor is connected backwards
    	SmartDashboard.putNumber("Setpoint", Robot.stacker.getSetpoint());
    	SmartDashboard.putNumber("Current Distance", Robot.stacker.returnPIDInput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(Robot.stacker.getPosition() - setpoint) < threshold;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
