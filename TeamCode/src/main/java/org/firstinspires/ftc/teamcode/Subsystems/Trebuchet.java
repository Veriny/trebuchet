package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Trebuchet {
    DcMotor catapult;
    DcMotor rack;
    Servo servo;
    public static final double TICKS_PER_ROTATION = 1440;
    DcMotor[] motors;
    public Trebuchet(DcMotor catapult, DcMotor rack, Servo s){
        this.catapult = catapult;
        this.rack = rack;
        this.servo = s;
        catapult.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public void control(Gamepad gp){
//        if (gp.left_bumper) {
//            launch();
//        }
        catapult.setPower(gp.left_trigger);
        rack.setPower(gp.right_trigger);
        if (gp.a) {

        }

    }

    public void launch(){
        catapult.setTargetPosition((int)TICKS_PER_ROTATION);
        catapult.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        catapult.setPower(1);
        rest();
        resetEncoders();
    }

    public void resetEncoders(){
        catapult.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void changePos(){
        double pos = servo.getPosition();
        if (pos == 1.0){
            turnServo(servo, 0.0);
        }
        else {
            turnServo(servo, 1.0);
        }
    }
    public void turnServo(Servo serv, double pos){
        servo.setPosition(pos);
        while (servo.getPosition() != pos) {
            //wait
        }
    }

    public void rest(){
        while (catapult.isBusy()) {

        }
    }
}
