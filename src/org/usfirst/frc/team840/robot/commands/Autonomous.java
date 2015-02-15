package org.usfirst.frc.team840.robot.commands;

import org.usfirst.frc.team840.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Drive forward 2 feet
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous() {
        requires(Robot.drivetrainPID);
        addSequential(new DriveForward(24));
    }
}
