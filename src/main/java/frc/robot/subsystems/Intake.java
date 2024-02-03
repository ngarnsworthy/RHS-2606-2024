package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constents.ShooterConstents;

public class Intake extends SubsystemBase {
    WPI_TalonSRX intakeTalonSRX = new WPI_TalonSRX(ShooterConstents.intakeMotor);
    DigitalInput noteDetectioInput = new DigitalInput(ShooterConstents.noteDetector);

    public void MotorIn(){
        intakeTalonSRX.set(ShooterConstents.intakeSpeed);
    }

    public void MotorOut(){
        intakeTalonSRX.set(-ShooterConstents.intakeSpeed);
    }
}
