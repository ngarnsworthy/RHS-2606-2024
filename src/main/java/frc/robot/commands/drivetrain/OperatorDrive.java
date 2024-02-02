package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class OperatorDrive extends Command {
    private XboxController xboxController;
    private Drivetrain drive;

    public OperatorDrive(Drivetrain drive, XboxController xboxController, boolean fieldRelative) {
    this.xboxController = xboxController;
    this.drive = drive;

    addRequirements(drive);
  }   
  
  @Override
  public void initialize() {}

  @Override
  public void execute(){
    drive.Drive(new drive.DriveInstruction(xboxController));
  }
}
