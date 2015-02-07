package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SetLiftBottomMagnets extends CommandGroup {
    
    public  SetLiftBottomMagnets() {
        requires(Robot.stacker);
        addSequential(new SetLiftMagnets(0));
    }
}
