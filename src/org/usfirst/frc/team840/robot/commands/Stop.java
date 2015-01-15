package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	Command to stop the motor. This is mostly just for use as a default command. Stops as
 *	init, then does nothing, as the program will disengage as soon as a new command is
 *	issued.
 */
public class Stop extends Command {

    public Stop() {
        requires(Robot.motor);
        setTimeout(1);	//May or may not need
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.motor.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
