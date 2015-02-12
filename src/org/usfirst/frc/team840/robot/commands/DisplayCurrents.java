package org.usfirst.frc.team840.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DisplayCurrents extends CommandGroup {
    
    public DisplayCurrents() {
        addParallel(new DisplayCurrentDriveMotorLeft());
        addParallel(new DisplayCurrentDriveMotorRight());
        addParallel(new DisplayCurrentIntakeMotorLeft());
        addParallel(new DisplayCurrentIntakeMotorRight());
        addParallel(new DisplayCurrentLiftMotor());
    }
}
