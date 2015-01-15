package org.usfirst.frc.team840.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
//other import-ant stuff you need

/**
 *
 */
public class Tankdrive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void Tankdrive() {
        lTalon.set(lStick.getY());
        rTalon.set(rStick.getY());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
