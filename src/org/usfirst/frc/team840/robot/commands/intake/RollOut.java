package org.usfirst.frc.team840.robot.commands.intake;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command spins the rollers to move items out.
 */
public class RollOut extends Command {

    public RollOut() {
        requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.setLeft(-0.75);
    	Robot.intake.setRight(-0.75);
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
