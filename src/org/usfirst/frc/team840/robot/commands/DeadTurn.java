//do stuff

package org.usfirst.frc.team840.robot.commands;
//import edu.wpi.first.wpilibj.*;

public class DeadTurn extends Command {
    private double time;
    private String direction;
  
    public DeadTurn(double t, String whichDirection) {
      requires(Robot.drivetrain);
      time = t;
      direction = whichDirection;
      }
  

  public void initialize () {
    Timer.delay(time);
  }

  public void execute () {
    
    if (direction.equals("left")){
      Robot.drivetrain.setLeft(-1.0);
      Robot.drivetrain.setRight(1.0);
    } else if (direction.equals("right")) {
      Robot.drivetrain.setLeft(1.0);
      Robot.drivetrain.setRight(-1.0);
    }
    Timer.delay(time);
    Robot.drivetrain.setLeft(0.0);
    Robot.drivetrain.setRight(0.0);
  }

}
