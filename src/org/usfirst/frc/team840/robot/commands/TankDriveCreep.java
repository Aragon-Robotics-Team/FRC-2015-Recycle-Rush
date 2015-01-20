package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command for the DrivetrainTank. This command drives the chassis using generic tank drive controls
 * at a fraction of the maximum speed. There is no feedback currently. Note that this function only 
 * operates one motor, not both.
 */
public class TankDriveCreep extends Command {

  boolean leftSide;
  double powerMultiplier;
  
    public TankDriveCreep(bool leftSide, double powerMultiplier) {
      this.leftSide = leftSide; //If leftSide is true, this will engage on the left side only
      this.powerMultiplier = powerMultiplier;
    
      requires(Robot.drivetraintank);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(leftSide) Robot.drivetraintank.setLeft(Robot.oi.getJoyLeft().getY() * powerMultiplier);
    	else Robot.drivetraintank.setRight(Robot.oi.getJoyRight().getY()  * powerMultiplier));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
