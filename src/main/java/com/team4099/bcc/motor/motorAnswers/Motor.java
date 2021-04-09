package com.team4099.bcc.motor.motorAnswers;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
    //Make a TalonSRX motor with an id of 10 and another with an id of 11

    private TalonSRX talon1 = new TalonSRX((10));
    private TalonSRX talon2 = new TalonSRX((11));
    //Make a CANSparkMax brushless motor with an id of 5 and another with an id of 6

    private CANSparkMax spark = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax sparkMax = new CANSparkMax(6, CANSparkMaxLowLevel.MotorType.kBrushless);

    //This part needs to be in a method to work
    private void method() {
        //Set the speed of a TalonSRX motor to spin at 50% and the other to spin the opposite direction at 100%

        talon1.set(ControlMode.PercentOutput, 0.1);
        //Set the speed of a CANSparkMax motor to spin at 30% and the other to spin the opposite direction at 25%

        spark.set(-.25);
        sparkMax.set(0.3);
        //Make one of the CANSparkMax motors follow the other

        spark.follow(sparkMax);
        //Make one of the CANSparkMax motors follow the other inverted

        spark.follow(sparkMax, true);
    }
    //Create a method that would set both of the TalonSRX motors to the same speed

    public void setTalonPower(double power) {
        talon1.set(ControlMode.PercentOutput, power);
        talon2.set(ControlMode.PercentOutput, power);
    }
    //Create a method that would set a TalonSRX motor and a CANSparkMax motor to the same speed

    public void setMotorPower(double power) {
        talon1.set(ControlMode.PercentOutput, power);
        spark.set(power);
    }
}
