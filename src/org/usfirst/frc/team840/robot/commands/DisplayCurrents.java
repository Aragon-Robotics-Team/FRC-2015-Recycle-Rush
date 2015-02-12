package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;
import org.usfirst.frc.team840.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *This command uses the PowerDistributionPanel to display the amps that each motor currently uses.
 */
public class DisplayCurrents extends Command {
    
	public DisplayCurrents() {
        requires(Robot.pdp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Left Drive Motor Draw", Robot.pdp.getCurrent(RobotMap.driveMotorLeft[2]) + Robot.pdp.getCurrent(RobotMap.driveMotorLeft[3]));	//The drive motors have two ports on the PDP, so we add the currents together.
    	SmartDashboard.putNumber("Right Drive Motor Draw", Robot.pdp.getCurrent(RobotMap.driveMotorRight[2]) + Robot.pdp.getCurrent(RobotMap.driveMotorRight[3]));
    	SmartDashboard.putNumber("Left Intake Motor Draw", Robot.pdp.getCurrent(RobotMap.intakeMotorLeft[2]));
    	SmartDashboard.putNumber("Right Intake Motor Draw", Robot.pdp.getCurrent(RobotMap.intakeMotorRight[2]));
    	SmartDashboard.putNumber("Lift Motor Draw", Robot.pdp.getCurrent(RobotMap.liftMotor[2]) + Robot.pdp.getCurrent(RobotMap.liftMotor[3]));	//The lift motor also has two ports on the PDP.
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
