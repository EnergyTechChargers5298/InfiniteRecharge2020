/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;

public class IntakeGrabBall extends CommandBase {
  /**
   * Creates a new GrabBall.
   */

  // Holds the Intake Subsystem
  private Intake intake;

  public IntakeGrabBall(Intake intake) {
    // Passes the Intake Subsystem into Field
    this.intake = intake;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Moves Motors to Intake the Balls
    intake.grabBall();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Runs Only Once
    if(RobotContainer.operatorController.getBButtonReleased()) {
      return true;
    }
    return false;
  }
}
