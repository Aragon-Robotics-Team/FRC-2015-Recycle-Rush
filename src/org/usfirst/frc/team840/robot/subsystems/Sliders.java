package org.usfirst.frc.team840.robot.subsystems;

import org.usfirst.frc.team840.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sliders extends Subsystem {
    
	private DoubleSolenoid rodlessCylinderLeft, rodlessCylinderRight;

	public Sliders() {
		super();
		rodlessCylinderLeft = new DoubleSolenoid(1, RobotMap.rodlessCylinderLeft[0], RobotMap.rodlessCylinderLeft[1]);
        rodlessCylinderRight = new DoubleSolenoid(1, RobotMap.rodlessCylinderRight[0], RobotMap.rodlessCylinderRight[1]);
	}
	
	protected void initDefaultCommand() {
		
	}
	
	public void slideOutLeft() {
    	rodlessCylinderLeft.set(DoubleSolenoid.Value.kForward);
    }
    
    public void slideOutRight() {
    	rodlessCylinderRight.set(DoubleSolenoid.Value.kForward);
    }
    
    public void slideInLeft() {
    	rodlessCylinderLeft.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void slideInRight() {
    	rodlessCylinderRight.set(DoubleSolenoid.Value.kReverse);
    }

}

