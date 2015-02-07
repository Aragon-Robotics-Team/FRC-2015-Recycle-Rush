package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SetLiftLoadBinMagnets extends CommandGroup {
    
    public  SetLiftLoadBinMagnets() {
    	requires(Robot.stacker);
        addSequential(new SetLiftMagnets(4));
    }
}
