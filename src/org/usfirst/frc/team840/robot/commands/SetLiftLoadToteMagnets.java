package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SetLiftLoadToteMagnets extends CommandGroup {
    
    public  SetLiftLoadToteMagnets() {
        requires(Robot.stacker);
        addSequential(new SetLiftMagnets(3));
    }
}
