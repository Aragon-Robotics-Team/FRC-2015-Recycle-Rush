package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;
import org.usfirst.frc.team840.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command for the DrivetrainTank. This command drives the chassis using generic tank drive controls at a fraction of the full speed. There is no feedback currently. 
 */
public class TankDriveCreep extends Command {

	private double power;
	
    public TankDriveCreep(double power) {
    	this.power = power;
    	
        requires(Robot.drivetraintank);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetraintank.setLeft(Robot.oi.getJoyLeft().getY() * power);
    	Robot.drivetraintank.setRight(Robot.oi.getJoyRight().getY() * power);
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
    }
}
