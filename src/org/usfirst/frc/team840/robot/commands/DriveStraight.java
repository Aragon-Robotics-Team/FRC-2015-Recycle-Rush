package org.usfirst.frc.team840.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveStraight extends CommandGroup {
    
    public  DriveStraight(double setpoint) {
        addParallel(new DriveLeft(setpoint));
        addParallel(new DriveRight(setpoint));
    }
}
