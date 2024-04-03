package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BlinkinSubsystem extends SubsystemBase {
    Spark blinkin1;
    Spark blinkin2;

    // limelight 
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);

    public BlinkinSubsystem() {
		blinkin1 = new Spark(1);
    blinkin2 = new Spark(2);
	}

  public Command BlinkinConfetti() {
      return runOnce(() -> {
        blinkin1.set(-0.87);
      });
  }

  public Command TVCheck() {
    //checks if tv is >.9 or <.9, flashes slow green if >, flashes fast red if <
    return run(() -> {
      if (tv > 0.9999) {
        blinkin1.set(-0.91); //forest pallette
        try {
          wait(500);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
        }
        blinkin1.set(0.99); //black
        try {
          wait(500);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
        }
      } else if (tv < 0.9999) {
        blinkin1.set(0.61); //red
        try {
          wait(200);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
        }
        blinkin1.set(0.99); //black
        try {
          wait(200);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
        }
      }
    });

  }

}
