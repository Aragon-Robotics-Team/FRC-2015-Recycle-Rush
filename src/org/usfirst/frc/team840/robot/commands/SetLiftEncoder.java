package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	The pulley that raises the lift is connected to a hall effect encoder. This command uses PID to set the lift to any position. It is best not to call this directly, but rather to use one of the presets provided in the form of command groups.
 */
public class SetLiftEncoder extends Command {

	private double setpoint;
	private final double threshold = 2;	//TODO Tune experimentally (Units irrelevant, but make sure to match to the units in DistancePerPulse)
	
    public SetLiftEncoder(double setpoint) {
        requires(Robot.stacker);
        setTimeout(3);
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.stacker.setSetpoint(-1 * setpoint);	//Motor is connected backwards
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return Math.abs(Robot.stacker.getPosition() - setpoint) < threshold;	//Stop the command when it is within the threshold
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
