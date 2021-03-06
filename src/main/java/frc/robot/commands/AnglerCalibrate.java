/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Angler;

public class AnglerCalibrate extends CommandBase {
  /**
   * Creates a new AnglerCalibrate.
   */

  private Angler angler;

  public AnglerCalibrate(Angler angler) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.angler = angler;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    angler.moveAngle(-1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    angler.moveAngle(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Uses Boolean Zen :D
    return angler.getHighLimit();
  }
}
