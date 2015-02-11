package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Sets the lift to its bottom height using the reed switches.
 */
public class SetLiftBottomMagnets extends CommandGroup {
    
    public  SetLiftBottomMagnets() {
        requires(Robot.stacker);
        addSequential(new SetLiftMagnets(0));
    }
}
