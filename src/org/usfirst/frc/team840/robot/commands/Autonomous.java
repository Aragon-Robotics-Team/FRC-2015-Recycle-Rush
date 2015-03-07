package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous() {
        requires(Robot.drivetrain);
        
        addSequential(new Drive(.5, 0, 2));	//Make real numbers (these are completely random; DO NOT USE THEM)
    }
}
