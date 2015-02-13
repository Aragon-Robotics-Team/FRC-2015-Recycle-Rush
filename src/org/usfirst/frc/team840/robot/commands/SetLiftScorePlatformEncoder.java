package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Sets the lift to its bottom position from the ground using PID.
 */
public class SetLiftScorePlatformEncoder extends CommandGroup {
    
    public  SetLiftScorePlatformEncoder() {
    	requires(Robot.stacker);
        addSequential(new SetLiftEncoder(Robot.stacker.scorePlatformHeight));
    }
}
