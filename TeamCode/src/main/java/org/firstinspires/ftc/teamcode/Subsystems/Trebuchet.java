package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Trebuchet {
    DcMotor catapult;
    DcMotor rack;
    public static final double TICKS_PER_ROTATION = 1440;
    DcMotor[] motors;
    public Trebuchet(DcMotor catapult, DcMotor rack){
        this.catapult = catapult;
        this.rack = rack;
        catapult.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public void control(Gamepad gp){
        if (gp.left_bumper) {
            launch();
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

    public void rest(){
        while (catapult.isBusy()) {

        }
    }
}
