package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.art.frc.lib.util.Interpolation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArcadeDriveCreep extends Command {

	private double lerpFactor;
	private double creepFactor;
	private double currentPower;
	private double targetPower;
	private double currentTurn;
	private double targetTurn;
	private double lerpedPower;
	private double lerpedTurn;
	private RobotDrive drive;
	
	public ArcadeDriveCreep() {	
		requires(Robot.leftDrive);
        requires(Robot.rightDrive);
        
        drive = new RobotDrive(Robot.leftDrive.getDriveMotor(), Robot.rightDrive.getDriveMotor());
	}

	protected void initialize() {
		Robot.leftDrive.getPIDController().free();
    	Robot.rightDrive.getPIDController().free();
		currentPower = 0;
		currentTurn = 0;
	}

	protected void execute() {
		lerpFactor = SmartDashboard.getNumber("Lerp factor: ");
		creepFactor = SmartDashboard.getNumber("Creep factor: ");
		
		SmartDashboard.putString("Driving mode: ", "Creeping at " + creepFactor * 100 + "% power");
		
		targetPower = Robot.oi.getDriverPad().getLeftY();
		if (Math.abs(targetPower) < .0625) targetPower = 0;
		targetTurn = Robot.oi.getDriverPad().getRightX();
		if (Math.abs(targetTurn) < .0625) targetTurn = 0;
    	
		lerpedPower = Interpolation.lerp(currentPower, targetPower, lerpFactor);
		lerpedTurn = Interpolation.lerp(currentTurn, targetTurn, lerpFactor);
    	
		drive.arcadeDrive(lerpedPower * creepFactor, lerpedTurn * creepFactor);
    	
		currentPower = lerpedPower;
		currentTurn = lerpedTurn;
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
}
