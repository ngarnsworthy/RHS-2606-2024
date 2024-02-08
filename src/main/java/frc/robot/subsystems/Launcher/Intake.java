// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Launcher;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constents.ShooterConstents;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public Intake() {
    inputMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  private TalonFX inputMotor = new TalonFX(ShooterConstents.intakeMotor);
  private DigitalInput noteDetector = new DigitalInput(ShooterConstents.noteDetector);

  public void IntakeIn(){
    inputMotor.set(ShooterConstents.intakeSpeed);
  }

  public void IntakeStop(){
    inputMotor.set(0);
  }

  public void IntakeOut(){
    inputMotor.set(-ShooterConstents.intakeSpeed);
  }

  public boolean NoteDetected(){
    return noteDetector.get();
  }
}
