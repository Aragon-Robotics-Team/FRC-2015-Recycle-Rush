package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetLiftMagnets extends Command {

	private int currentPosition;
	private int setpoint;
	private int direction;	//Direction lift needs to move from current position to reach setpoint. 0 - 2: Up, down, nothing
	
    public SetLiftMagnets(int setpoint) {
        requires(Robot.stacker);
        this.setpoint = setpoint;
        currentPosition = Robot.stacker.getLiftPosition();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Set direction motor must turn to reach setpoint
    	if(setpoint > currentPosition)
    		direction = 0;
    	else if(setpoint < currentPosition)
    		direction = 1;
    	else
    		direction = 2;
    	
    	//Set motor power based on direction
    	if(direction == 0)
    		Robot.stacker.setLiftMotor(Robot.stacker.liftMotorManualPower);
    	else if(direction == 1)
    		Robot.stacker.setLiftMotor(-1 * Robot.stacker.liftMotorManualPower);
    	else
    		Robot.stacker.setLiftMotor(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        switch(setpoint) {
        	case 0: return Robot.stacker.getBottomReed();
        	case 1: return Robot.stacker.getScorePlatformReed();
        	case 2: return Robot.stacker.getScoreCoOpReed();
        	case 3: return Robot.stacker.getLoadToteReed();
        	case 4: return Robot.stacker.getLoadBinReed();
        	
        	default: return true;
        }
   	}

    // Called once after isFinished returns true
    protected void end() {
    	Robot.stacker.setLiftPosition(setpoint);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
