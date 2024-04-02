package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BlinkinSubsystem extends SubsystemBase {
    
    Spark blinkin1;
    Spark blinkin2;

    public BlinkinSubsystem() {
		blinkin1 = new Spark(1);
    blinkin2 = new Spark(2);
	}

  public Command BlinkinConfetti() {
      return runOnce(() -> {
        blinkin1.set(-0.87);
      });

  }


}
