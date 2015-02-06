
package org.usfirst.frc.team840.robot;

import org.usfirst.frc.team840.robot.subsystems.DrivetrainTank;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DrivetrainTank drivetraintank;
	public static Accelerometer accelerometer;
	public static OI oi;
	
	public double xDist;
	public double yDist;
	public double zDist;
	public double distanceMagnitude;//
	public double distanceAngle; //
	
	public double xVelocity;
	public double yVelocity;
	public double zVelocity;
	public double velocityMagnitude;//
	public double velocityAngle;//
	
	public double xAcc;
	public double yAcc;
	public double zAcc;
	public double accMagnitude;
	public double accAngle;
	
	public double seconds = 0.005;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	drivetraintank = new DrivetrainTank();
    	oi = new OI();
    	accelerometer = new Accelerometer(seconds);
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        xAcc = accelerometer.getXAcc();
        yAcc = accelerometer.getYAcc();
        zAcc = accelerometer.getZAcc();
        accMagnitude = accelerometer.getAccMagnitude();
        accAngle = accelerometer.getAngleofAcc();
        xVelocity = accelerometer.getXVelocity();
        yVelocity = accelerometer.getYVelocity();
        zVelocity = accelerometer.getZVelocity();
        velocityMagnitude = accelerometer.getVelocityMagnitude();
        velocityAngle = accelerometer.getAngleofVelocity();
        xDist = accelerometer.getXDistance();
        yDist = accelerometer.getYDistance();
        zDist = accelerometer.getZDistance();
        distanceMagnitude = accelerometer.getDisplacementMagnitude;
        distanceAngle = accelerometer.getAngleofDisplacement();
        
        accelerometer.update();
        //do stuff
        
        Timer.delay(seconds);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
