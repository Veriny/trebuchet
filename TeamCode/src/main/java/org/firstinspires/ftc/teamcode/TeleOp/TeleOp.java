package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.Mecanum;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="MecanumTeleOP")
public class TeleOp extends OpMode{
    public Mecanum robot;
    @Override
    public void init() {
        robot = new Mecanum(hardwareMap.dcMotor.get("topRight"), hardwareMap.dcMotor.get("bottomRight"), hardwareMap.dcMotor.get("topLeft"), hardwareMap.dcMotor.get("bottomLeft"));
    }

    @Override
    public void start() {
        telemetry.addLine("Device Started");
    }

    @Override
    public void loop() {
        robot.mecanumDrive(gamepad1);
    }

    @Override
    public void stop() {
        robot.stopMotors();
    }
}
