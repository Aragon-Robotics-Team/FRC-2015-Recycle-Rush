package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Sets the lift to the height needed to score on the platforms using the reed switches.
 */
public class SetLiftScorePlatfromMagnets extends CommandGroup {
    
    public  SetLiftScorePlatfromMagnets() {
    	requires(Robot.stacker);
        addSequential(new SetLiftMagnets(1));
    }
}
