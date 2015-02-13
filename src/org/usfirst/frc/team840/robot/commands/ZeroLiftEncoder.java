package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroLiftEncoder extends Command {

    public ZeroLiftEncoder() {
        requires(Robot.stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.stacker.disable();
    	Robot.stacker.setLiftMotor(Robot.stacker.liftMotorInitPower);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.stacker.getBottomReed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.stacker.setLiftMotor(0);
    	Robot.stacker.resetLiftEncoder();
    	Robot.stacker.enable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.stacker.resetLiftEncoder();
    	Robot.stacker.enable();
    }
}
