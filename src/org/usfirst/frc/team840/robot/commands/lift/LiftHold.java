package org.usfirst.frc.team840.robot.commands.lift;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command uses PID to hold the lift where it is, using the motor to counteract any outside forces affecting the system.
 */
public class LiftHold extends Command {

	private double holdPoint;
	
    public LiftHold() {
        requires(Robot.lift);
    }

    protected void initialize() {
    	holdPoint = Robot.lift.getPosition();
    	Robot.lift.setSetpoint(holdPoint);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
