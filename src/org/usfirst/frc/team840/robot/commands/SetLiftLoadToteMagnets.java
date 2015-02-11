package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Sets the lift to the height needed to load totes from the ground using the reed switches.
 */
public class SetLiftLoadToteMagnets extends CommandGroup {
    
    public  SetLiftLoadToteMagnets() {
        requires(Robot.stacker);
        addSequential(new SetLiftMagnets(3));
    }
}
