package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetStacker extends Command {

	private double setpoint;
	private final double threshold = 0.5;	//TODO Tune experimentally (Units irrelevant, but make sure to match to the units in DistancePerPulse)
	
    public SetStacker(double setpoint) {
        requires(Robot.stacker);
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.stacker.setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.stacker.getPosition() - setpoint) < threshold;	//Stop the command when it is within the threshold
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
