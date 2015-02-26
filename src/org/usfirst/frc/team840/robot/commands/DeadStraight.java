package org.usfirst.frc.team840.robot.commands;
import org.usfirst.frc.team840.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DeadStraight extends Command {
    
    public DeadStraight(double time) {
        requires(Robot.drivetrain); 
        setTimeout(time);
    }
    protected void initialize() {
        Robot.drivetrain.arcadeDrive(0.75, 0);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    return isTimedOut();
    }
    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.arcadeDrive(0, 0);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
