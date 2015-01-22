package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Drivetrain for the robot. It is unsure at this time what the final drivetrain will be, so we will program one using standard
 *	two motor tank. This drivtrain uses the TalonSRX motor controllers. At this time, there are no sensors.
 */
public class Accelerometer extends Subsystem {
    
	private BuiltInAccelerometer acc;
	
	public Accelerometer() {
		super();
		acc = new BuiltInAccelerometer(RobotMap.accRange);
	}
	
    public void initDefaultCommand() {
    }
    
    public double getXAcc() {
        return acc.getX();
    }
    
    public double getYAcc() {
        return acc.getY();
    }
    
    public double getZAcc() {
        return acc.getZ();
    }
}
