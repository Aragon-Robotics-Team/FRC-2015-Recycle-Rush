package org.usfirst.frc.team840.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

//to be implemented in the OperatorControl() method.

public class Tankdrive extends Subsystem {

    public void Tankdrive() {
        lTalon.set(lStick.getY());
        rTalon.set(rStick.getY());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
