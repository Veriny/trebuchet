package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.ChooChoo;
import org.firstinspires.ftc.teamcode.Subsystems.Mecanum;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="MecanumTeleOP")
public class TeleOp extends OpMode{
    public Mecanum robot;
    public ChooChoo catapult;
    @Override
    public void init() {
        robot = new Mecanum(hardwareMap.dcMotor.get("topRight"),
                hardwareMap.dcMotor.get("bottomRight"), hardwareMap.dcMotor.get("topLeft"),
                hardwareMap.dcMotor.get("bottomLeft"));
        catapult = new ChooChoo(hardwareMap.dcMotor.get("catapult"));
    }

    @Override
    public void start() {
        telemetry.addLine("Device Started");
    }

    @Override
    public void loop() {
        robot.mecanumDrive(gamepad1);
        catapult.controls(gamepad1);
    }

    @Override
    public void stop() {
        robot.stopMotors();
        catapult.stop();
    }
}
