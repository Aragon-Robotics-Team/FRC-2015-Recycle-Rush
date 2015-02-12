package org.usfirst.frc.team840.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.*;

/**
 *
 */
@SuppressWarnings("unused")
public class PDP extends Subsystem {
    
    private PowerDistributionPanel panel;
    
    public PDP() {
    	super();
    	panel = new PowerDistributionPanel();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DisplayCurrentDriveMotorLeft());
    }
    
    public double getCurrent(int port) {
    	return panel.getCurrent(port);
    }
}

