//do stuff

package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DeadTurn extends Command {
	
    private double time;
    private boolean directionRight;
  
    public DeadTurn(double time, boolean right) {
    	//requires(Robot.drivetrain);
    	setTimeout(time);
    	directionRight = right;
    }
  
	public void initialize () {
		if (directionRight){
			Robot.drivetrain.arcadeDrive(0.0, 1.0);
	    } else if (!directionRight) {
	    	Robot.drivetrain.arcadeDrive(0.0, -1.0);
	    }
	}

	public void execute () {
	    

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.drivetrain.setLeft(0.0);
	    Robot.drivetrain.setRight(0.0);
	}
	
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
	}

}
