package edu.art.frc.recycleRush.robot.commands;

import edu.art.frc.recycleRush.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.art.frc.lib.util.Interpolation;

/**
 *
 */
public class ArcadeDrive extends Command {

	private double currentPower;
	private double targetPower;
	private double currentTurn;
	private double targetTurn;
	
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
    	targetPower = Robot.oi.getGamepad().getLeftY();
    	targetTurn = Robot.oi.getGamepad().getRightY();
    	
    	//TODO Tune percent
    	Robot.drivetrain.arcadeDrive(Interpolation.lerp(currentPower, targetPower, .25) * -1, Interpolation.lerp(currentTurn, targetTurn, .25) * -1);	//Inverted for easier driving
    	
    	currentPower = Interpolation.lerp(currentPower, targetPower, .25);
    	currentTurn = Interpolation.lerp(currentTurn, targetTurn, .25);
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
