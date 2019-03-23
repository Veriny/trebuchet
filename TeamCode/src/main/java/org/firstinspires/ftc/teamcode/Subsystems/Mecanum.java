package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by your mom on 9/9/18.
 */

public class Mecanum {
    public DcMotor rightTop;
    public DcMotor rightBottom;
    public DcMotor leftTop;
    public DcMotor leftBottom;
    public Mecanum(DcMotor TR, DcMotor BR, DcMotor TL, DcMotor BL){
        this.rightBottom = BR;
        this.leftBottom = BL;
        this.rightTop = TR;
        this.leftTop = TL;
    }
    public void mecanumDrive(Gamepad gp) {
        float x = (float)(Math.pow(gp.left_stick_y, 3));
        float y = (float)(Math.pow(gp.left_stick_x, 3));
        float z = (float)(Math.pow(gp.right_stick_x, 3));
//        leftBottom.setPower(-x - y - z);
//        leftTop.setPower(x - y - z);
//        rightTop.setPower(-x - y + z);
//        rightBottom.setPower(x - y + z);
        leftBottom.setPower((x)+(y)+(-z));
        leftTop.setPower((x)+(-y)+(-z));
        rightBottom.setPower((-x)+(y)+(-z));
        rightTop.setPower((-x)+(-y)+(-z));
    }

    public void stopMotors() {
        rightBottom.setPower(0);
        leftBottom.setPower(0);
        rightTop.setPower(0);
        leftTop.setPower(0);
    }
}
