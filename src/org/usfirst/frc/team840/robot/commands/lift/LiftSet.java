package org.usfirst.frc.team840.robot.commands.lift;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	The pulley that raises the lift is connected to a hall effect encoder. This command uses PID to set the lift to any position. It is best not to call this directly, but rather to use one of the presets provided in the form of command groups.
 */
public class LiftSet extends Command {

	private double setpoint;
	private final double threshold = 0.5;	//TODO Tune experimentally (Units irrelevant, but make sure to match to the units in DistancePerPulse)
	
    public LiftSet(double setpoint) {
        requires(Robot.lift);
        this.setpoint = setpoint;
    }

    protected void initialize() {
    	Robot.lift.setSetpoint(-1 * setpoint);	//Motor is connected backwards
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Math.abs(Robot.lift.getPosition() - setpoint) < threshold;	//Stop the command when it is within the threshold
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
