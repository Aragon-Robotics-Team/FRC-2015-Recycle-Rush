package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Sets the lift to the height needed to load totes from the ground using PID.
 */
public class SetLiftLoadToteEncoder extends CommandGroup {
    
    public  SetLiftLoadToteEncoder() {
    	requires(Robot.stacker);
        addSequential(new SetLiftEncoder(Robot.stacker.loadToteHeight));
    }
}
