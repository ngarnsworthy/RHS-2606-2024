//Drivetrain subsystem

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constents.MotorConstents;
import input.inputSanitation;

import com.revrobotics.CANSparkMax;

public class Drivetrain extends SubsystemBase{
    //Define motors
    public final CANSparkMax frontLeftMotor = new CANSparkMax(MotorConstents.frontLeftDrive, MotorConstents.driveMotorType);
    public final CANSparkMax frontRightMotor = new CANSparkMax(MotorConstents.frontRightDrive, MotorConstents.driveMotorType);
    public final CANSparkMax backLeftMotor = new CANSparkMax(MotorConstents.backLeftDrive, MotorConstents.driveMotorType);
    public final CANSparkMax backRightMotor = new CANSparkMax(MotorConstents.backRightrive, MotorConstents.driveMotorType);

    //Define drive control
    public final MecanumDrive mecanumDrive = new MecanumDrive(frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor);

    public void Drive(double x, double y, double turn){
        mecanumDrive.driveCartesian(x, y, turn);
    }

    public void Drive(XboxController controller){
            double x = inputSanitation.SquareInput(controller.getRightX());
            double y = inputSanitation.SquareInput(controller.getRightY());

            double turn = inputSanitation.SquareInput(controller.getLeftX());

            Drive(x,y,turn);
        }
}
