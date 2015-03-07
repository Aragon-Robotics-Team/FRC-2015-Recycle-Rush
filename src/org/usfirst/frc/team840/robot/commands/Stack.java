package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Stack extends CommandGroup {
    
    public  Stack() {
        requires(Robot.stacker);
        
        addSequential(new SetLiftLoadToteEncoder());
        addSequential(new SetLiftBottomEncoder());
        addSequential(new SetLiftLoadToteEncoder());  
    }
}
