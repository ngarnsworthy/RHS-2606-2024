// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.input;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Launcher.Intake;

public class InputNote extends Command {
  /** Creates a new InputNote. */
  public InputNote(Intake intake) {
    addRequirements(intake);
    this.intake = intake;
  }
  private Intake intake;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.IntakeIn();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.IntakeStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return intake.NoteDetected();
  }
}
