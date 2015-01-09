package org.usfirst.frc.team840.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BackAndForth extends CommandGroup {
    
    public  BackAndForth() {
        addSequential(new RotatePositive());
        Timer.delay(2);
        //addSequential
    }
}
