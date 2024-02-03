// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constents.ControlConstents;
import frc.robot.constents.MotorConstents;
import input.inputSanitation;

public class Drivetrain extends SubsystemBase {

    //Gyroscope
    private AHRS navx = new AHRS();

    //Define motors
    public final CANSparkMax frontLeftMotor = new CANSparkMax(MotorConstents.frontLeftDrive, MotorConstents.driveMotorType);
    public final CANSparkMax frontRightMotor = new CANSparkMax(MotorConstents.frontRightDrive, MotorConstents.driveMotorType);
    public final CANSparkMax backLeftMotor = new CANSparkMax(MotorConstents.backLeftDrive, MotorConstents.driveMotorType);
    public final CANSparkMax backRightMotor = new CANSparkMax(MotorConstents.backRightrive, MotorConstents.driveMotorType);

    //Define drive control
    public final MecanumDrive mecanumDrive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    mecanumDrive = new MecanumDrive(frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
    /**
     * 
     * @param x The speed moved in the x direction.
     * @param y The speed moved in the y direction.
     * @param turn The speed of turning.
     * @param fieldRelative Weather to move relitave to field.
     */
    public void Drive(double x, double y, double turn, boolean fieldRelative){
      mecanumDrive.driveCartesian(x, y, turn);
    }

    /**
     * 
     * Move from controller input
     * @param controller
     */
    public void Drive(XboxController controller){
            double x = inputSanitation.SquareInput(controller.getRightY());
            double y = inputSanitation.SquareInput(controller.getRightX());

            double turn = inputSanitation.SquareInput(controller.getLeftX());

            Drive(x, y, turn, ControlConstents.fieldRelative);
        }
}
