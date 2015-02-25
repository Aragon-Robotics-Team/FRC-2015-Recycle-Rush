package org.usfirst.frc.team840.robot.commands.lift;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroLiftEncoder extends Command {

    public ZeroLiftEncoder() {
        requires(Robot.lift);
    }

    protected void initialize() {
    	Robot.lift.resetLiftEncoder();
    	Robot.lift.setSetpoint(0);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
