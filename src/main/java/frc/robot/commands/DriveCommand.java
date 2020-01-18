/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase {
  /**
   * Creates a new Drive.
   */

  private final DoubleSupplier linVelocity;
  private final DoubleSupplier rotVelocity;
  private final DriveTrain driveTrain;


  public DriveCommand(DoubleSupplier linear, DoubleSupplier rotational, DriveTrain m_driveTrain) {
    // Sets the DriveTrain Subsystem as a field;
    driveTrain = m_driveTrain;

    // Sets the DoubleSuppliers
    linVelocity = linear;
    rotVelocity = rotational;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(new DriveTrain());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.drive(linVelocity.getAsDouble(), rotVelocity.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Sets motors to zero when command ends
    driveTrain.stopSpeed();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Runs until interrupted
    return false;
  }
}
