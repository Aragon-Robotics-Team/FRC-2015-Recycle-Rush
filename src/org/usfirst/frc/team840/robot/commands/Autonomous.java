package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous() {
        addSequential(new Drive(.5, 0, 2000));	//Make real numbers (these are completely random; DO NOT USE THEM)
    }
}
