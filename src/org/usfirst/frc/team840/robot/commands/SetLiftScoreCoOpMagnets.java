package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Sets the lift to the height needed to score on the coopertition platform using the reed switches.
 */
public class SetLiftScoreCoOpMagnets extends CommandGroup {
    
    public  SetLiftScoreCoOpMagnets() {
    	requires(Robot.stacker);
        addSequential(new SetLiftMagnets(2));
    }
}
