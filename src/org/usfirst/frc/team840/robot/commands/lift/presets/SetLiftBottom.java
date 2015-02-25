package org.usfirst.frc.team840.robot.commands.lift.presets;

import org.usfirst.frc.team840.robot.Robot;
import org.usfirst.frc.team840.robot.commands.lift.LiftSet;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Sets the lift to its bottom position from the ground using PID.
 */
public class SetLiftBottom extends CommandGroup {
    
    public  SetLiftBottom() {
    	requires(Robot.lift);
        addSequential(new LiftSet(Robot.lift.bottomHeight));
    }
}
