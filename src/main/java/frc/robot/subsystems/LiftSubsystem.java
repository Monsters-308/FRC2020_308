package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;
import frc.robot.Constants.LiftConstants;

/**
 * A Lift mechanism actuated by a single {@link WPI_TalonSRX}.
 */
public class LiftSubsystem extends SubsystemBase {
  private final WPI_TalonSRX m_liftMotor = new WPI_TalonSRX(LiftConstants.kLiftMotorCANPort);

  private DigitalInput m_liftLimit = new DigitalInput(Constants.LiftConstants.kLiftSensorPort);

  public LiftSubsystem(){
    m_liftMotor.setNeutralMode(NeutralMode.Brake);
  }

  /**
   * Forward Lift.
   */
  public void forwardLift() {
    if(m_liftLimit.get()){
      m_liftMotor.set(ControlMode.PercentOutput,LiftConstants.kLiftMotorForwardSpeed);
    }else{
      m_liftMotor.set(ControlMode.PercentOutput, 0.0);
    }
  }

  /**
   * Reverse Lift.
   */
  public void reverseLift() {
    m_liftMotor.set(ControlMode.PercentOutput,LiftConstants.kLiftMotorReverseSpeed);
  }

  /**
   * Stop Lift.
   */
  public void stopLift() {
    m_liftMotor.set(ControlMode.PercentOutput,LiftConstants.kLiftMotorStopSpeed);
  }


  public boolean getLimitSwitch(){
    return m_liftLimit.get();
  }

  @Override
  public void periodic(){
    SmartDashboard.putBoolean("Lift Limit", m_liftLimit.get());
  }  

}
