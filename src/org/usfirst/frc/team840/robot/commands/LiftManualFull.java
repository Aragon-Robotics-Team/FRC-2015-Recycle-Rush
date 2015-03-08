package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftManualFull extends Command {

    public LiftManualFull() {
        requires(Robot.stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.stacker.getPIDController().free();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.stacker.setLiftMotor(Robot.oi.getDriverPad().getLeftY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.stacker.setSetpoint(Robot.stacker.getPosition());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.stacker.setSetpoint(Robot.stacker.getPosition());
    }
}
