package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SetLiftLoadToteEncoder extends CommandGroup {
    
    public  SetLiftLoadToteEncoder() {
    	requires(Robot.stacker);
        addSequential(new SetLiftEncoder(Robot.stacker.loadToteHeight));
    }
}
