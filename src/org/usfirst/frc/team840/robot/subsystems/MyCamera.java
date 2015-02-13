package org.usfirst.frc.team840.robot.subsystem;

public class MyCamera extends Subsystem {
	USBCamera cam;
	
	public MyCamera() {
		cam = new USBCamera('Joe');
		cam.setFPS(1);
	}
	
}