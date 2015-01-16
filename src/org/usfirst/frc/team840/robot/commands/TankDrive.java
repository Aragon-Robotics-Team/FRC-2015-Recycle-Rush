package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command for the DrivetrainTank. This command drives the chassis using generic tank drive controls. There is no feedback currently. 
 */
public class TankDrive extends Command {

    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetraintank);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetraintank.setLeft(Robot.oi.getJoyLeft().getY());
    	Robot.drivetraintank.setRight(-1 * Robot.oi.getJoyRight().getY());
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
    	end();
    }
}
