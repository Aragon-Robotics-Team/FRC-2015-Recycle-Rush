package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;
import org.usfirst.frc.team840.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DisplayCurrentLiftMotor extends Command {

    public DisplayCurrentLiftMotor() {
        requires(Robot.pdp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Lift Motor Draw", Robot.pdp.getCurrent(RobotMap.liftMotor[2]) + Robot.pdp.getCurrent(RobotMap.liftMotor[3]));	//The lift motor has two ports on the PDP, so we add the currents together.
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
