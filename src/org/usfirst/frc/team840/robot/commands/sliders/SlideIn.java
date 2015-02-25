package org.usfirst.frc.team840.robot.commands.sliders;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	Pulls the rodless cylinders in.
 */
public class SlideIn extends Command {
	
    public SlideIn() {
        requires(Robot.sliders);
        
    }

    protected void initialize() {
    	Robot.sliders.slideInLeft();
    	Robot.sliders.slideInRight();
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
