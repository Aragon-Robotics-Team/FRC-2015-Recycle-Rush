package org.usfirst.frc.team840.robot.commands.lift.presets;

import org.usfirst.frc.team840.robot.Robot;
import org.usfirst.frc.team840.robot.commands.lift.LiftSet;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Sets the lift to the height needed to load totes from the ground using PID.
 */
public class SetLiftLoadTote extends CommandGroup {
    
    public  SetLiftLoadTote() {
    	requires(Robot.lift);
        addSequential(new LiftSet(Robot.lift.loadToteHeight));
    }
}
