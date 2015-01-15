package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.Stop;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Victor attached to the robot. Serves no purpose other than testing. It is unknown whether or not it will be attached to a
 *	wheel even.
 */
public class Motor extends Subsystem {
    
    private Victor motor;
    
    public Motor() {
    	super();
    	motor = new Victor(RobotMap.motor);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new Stop());
    }
    
    public void rotatePositive() {
    	motor.set(.75);
    }
    
    public void rotateNegative() {
    	motor.set(-.75);
    }
    
    public void stop() {
    	motor.set(0);
    }
    
}

