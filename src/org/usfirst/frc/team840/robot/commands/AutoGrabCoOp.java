package org.usfirst.frc.team840.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGrabCoOp extends CommandGroup {
    
    public  AutoGrabCoOp() {
        addSequential(new SlideOut());
        addSequential(new SetLiftEncoder(-10));
    	addSequential(new SetLiftEncoder(0));
    	addSequential(new SlideIn());
    	addSequential(new Drive(0, .75, .7));	//CALIBRATE
    	addSequential(new Drive(0, 0, .5));
    	addSequential(new Drive(.75, 0, 1.5));
    }
}
