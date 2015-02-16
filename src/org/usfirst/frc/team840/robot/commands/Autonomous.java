package org.usfirst.frc.team840.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Drive forward 2 feet
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous() {
        addSequential(new DriveStraight(24));
    }
}
