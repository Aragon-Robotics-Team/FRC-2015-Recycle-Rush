package org.usfirst.frc.team840.robot.commands;
import org.usfirst.frc.team840.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DeadStraight extends Command {

    private double time;
    
    public DeadStraight(double t) {
        requires(Robot.drivetrain); 
        time = t;
    }
    protected void initialize() {
        Robot.drivetrain.setLeft(1.0);
        Robot.drivetrain.setRight(1.0);
        Timer.delay(time); 
        Robot.drivetrain.setLeft(0.0);
        Robot.drivetrain.setRight(0.0);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
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
