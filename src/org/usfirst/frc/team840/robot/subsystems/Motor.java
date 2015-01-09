package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;
import org.usfirst.frc.team840.robot.commands.Stop;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *	Victor attached to the robot. Serves no purpose other than testing. It is unknown whether or not it will be attached to a
 *	wheel even.
 */
public class Motor extends Subsystem {
    
    private Victor motor;
    
    public Motor() {
    	super();
    	motor = new Victor(RobotMap.motor);
    	SmartDashboard.putString("DB/String 0", "Thing was built");
    }

    public void initDefaultCommand() {
        setDefaultCommand(new Stop());
    }
    
    public void rotatePositive() {
    	SmartDashboard.putString("DB/String 1", "Motor set to pos");
    	motor.set(.75);
    }
    
    public void rotateNegative() {
    	SmartDashboard.putString("DB/String 1", "Motor set to neg");
    	motor.set(-.75);
    }
    
    public void stop() {
    	SmartDashboard.putString("DB/String 1", "Motor stopped");
    	motor.set(0);
    }
    
}

