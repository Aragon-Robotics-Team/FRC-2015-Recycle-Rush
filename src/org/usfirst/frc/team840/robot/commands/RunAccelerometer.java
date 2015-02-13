

public class RunAccelerometer extends Commands {
    
    private MyAccelerometer acc;


    public RunAccelerometer() {
        acc = new MyAccelerometer();
    }
    public void prints() {
        SmartDashboard.putString("X Acceleration", "" + acc.getXAcc());
        SmartDashboard.putString("Y Acceleration", "" + acc.getYAcc());
        SmartDashboard.putString("Z Acceleration", "" + acc.getZAcc());
    }
}
