package org.usfirst.frc.team840.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import java.lang.Math;

import org.usfirst.frc.team840.robot.Robot;

import edu.art.frc.lib.util.Interpolation;

public class ArcadeDrive extends Command {

	private double currentPower;
	private double targetPower;
	private double currentTurn;
	private double targetTurn;
	private double lerpedPower;
	private double lerpedTurn;
	
    public ArcadeDrive() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentPower = 0;
    	currentTurn = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO Add deadband
    	targetPower = Robot.oi.getGamepad().getLeftY();
    	if (Math.abs(targetPower) < .125) targetPower = 0;
    	targetTurn = Robot.oi.getGamepad().getRightY();
    	if (Math.abs(targetTurn) < .125) targetTurn = 0;
    	
    	lerpedPower = Interpolation.lerp(currentPower, targetPower, .025);	//TODO Tune percent
    	lerpedTurn = Interpolation.lerp(currentTurn, targetTurn, .025);
    	
    	Robot.drivetrain.arcadeDrive(lerpedPower * -1, lerpedTurn * -1);	//Inverted for easier driving
    	
    	currentPower = lerpedPower;
    	currentTurn = lerpedTurn;
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
