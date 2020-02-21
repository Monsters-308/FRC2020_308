package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;;

/**
 * A simple command that runs the shooter forward with the {@link HopperSubsystem}.  Written explicitly for
 * pedagogical purposes.  Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class LongShooter extends CommandBase {
  // The subsystem the command runs on
  private final ShooterSubsystem m_shooterSubsystem;

  public LongShooter(ShooterSubsystem subsystem) {
    m_shooterSubsystem = subsystem;
    addRequirements(m_shooterSubsystem);
  }

  @Override
  public void initialize() {
    m_shooterSubsystem.forwardShooter();
  }
  @Override
  public void execute(){
    m_shooterSubsystem.updatevalues();
  }

  @Override
  public boolean isFinished() {
    SmartDashboard.putNumber("longShootSpeed",(double)m_shooterSubsystem.getShooterVelocity());
    if((double)m_shooterSubsystem.getShooterVelocity() > Constants.ShooterConstants.kLongShotRPM){
      return true;
    }else{
      return false;
    }
  }
}
