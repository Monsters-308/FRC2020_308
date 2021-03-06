package frc.robot.commands.traverse;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.TraverseSubsystem;;

/**
 * A simple command that Forwards the Traverse with the {@link TraverseSubsystem}.  Written explicitly for
 * pedagogical purposes.  Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class ForwardTraverse extends CommandBase {
  // The subsystem the command runs on
  private final TraverseSubsystem m_traverseSubsystem;

  public ForwardTraverse(TraverseSubsystem subsystem) {
    m_traverseSubsystem = subsystem;
    addRequirements(m_traverseSubsystem);
  }

  @Override
  public void initialize() {
    m_traverseSubsystem.forwardTraverse();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
