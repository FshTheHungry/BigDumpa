// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.OperatorConstants;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

    private final PWMSparkMax leftMotorLeader = new PWMSparkMax(OperatorConstants.leftDriveMotorPort);
    private final PWMSparkMax leftMotorFollower = new PWMSparkMax(OperatorConstants.leftDriveMotorFollowerPort);
    private final PWMSparkMax rightMotorLeader = new PWMSparkMax(OperatorConstants.rightDriveMotorPort);
    private final PWMSparkMax rightMotorFollower = new PWMSparkMax(OperatorConstants.rightDriveMotorFollowerPort);

    private final DifferentialDrive drive = new DifferentialDrive(
      leftMotorLeader :: set,
      rightMotorLeader :: set
    );

  public DriveSubsystem() {
    leftMotorLeader.addFollower(leftMotorFollower);
    rightMotorLeader.addFollower(rightMotorFollower);

    rightMotorLeader.setInverted(false);
  }

  public void arcadeDrive(double fwd, double rot) {
    drive.arcadeDrive(fwd, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
