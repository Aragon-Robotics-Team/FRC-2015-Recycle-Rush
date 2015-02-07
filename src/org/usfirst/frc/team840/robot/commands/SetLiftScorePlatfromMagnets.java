package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SetLiftScorePlatfromMagnets extends CommandGroup {
    
    public  SetLiftScorePlatfromMagnets() {
    	requires(Robot.stacker);
        addSequential(new SetLiftMagnets(1));
    }
}
