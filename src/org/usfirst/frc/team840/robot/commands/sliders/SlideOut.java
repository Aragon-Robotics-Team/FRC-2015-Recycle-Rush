package org.usfirst.frc.team840.robot.commands.sliders;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	Pushes the rodless cylinders out.
 */
public class SlideOut extends Command {
	
    public SlideOut() {
        requires(Robot.sliders);
    }

    protected void initialize() {
    	Robot.sliders.slideOutLeft();
    	Robot.sliders.slideOutRight();
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
