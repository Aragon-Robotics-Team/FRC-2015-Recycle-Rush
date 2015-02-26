package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.art.frc.lib.util.Interpolation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArcadeDrive extends Command {

	private double lerpFactor;
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
    	Robot.drivetrain.getPIDController().free();
		currentPower = 0;
		currentTurn = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lerpFactor = SmartDashboard.getNumber("Lerp factor: ");
    	
		SmartDashboard.putString("Driving mode: ", "Standard");
    	
		targetPower = Robot.oi.getDriverPad().getLeftY();
		if (Math.abs(targetPower) < .0625) targetPower = 0;
		targetTurn = Robot.oi.getDriverPad().getRightX();
		if (Math.abs(targetTurn) < .0625) targetTurn = 0;
    	
		lerpedPower = Interpolation.lerp(currentPower, targetPower, lerpFactor);
		lerpedTurn = Interpolation.lerp(currentTurn, targetTurn, lerpFactor);
		
		Robot.drivetrain.arcadeDrive(lerpedPower, -1 * lerpedTurn);
		
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
