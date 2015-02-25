package org.usfirst.frc.team840.robot.commands.intake;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command stops the rollers.
 */
public class RollStop extends Command {

    public RollStop() {
        requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.setLeft(0);
    	Robot.intake.setRight(0);
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
