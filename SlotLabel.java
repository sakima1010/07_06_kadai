package toujitukadai_07_0325;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Random;

public class SlotLabel extends Label {
    // ヒント写経ここから
        // アニメーションを行うためのTimeLineオブジェクト
        private Timeline timer;
        // スロットが回っている状態かを管理するフィールド
        private boolean isSlotStarted;
    // ヒント写経ここまで

    public SlotLabel() {
        super();
        isSlotStarted = false;
        this.setText(String.valueOf(1));
        this.setPrefSize(50, 50);
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        this.setBorder( border );
        this.setAlignment(Pos.CENTER);
//        ラベルの装飾参考：http://totomo.net/11300-javafxcontrol.htm
    }

//    public void animation(){
//        while(isSlotStarted = true){
//            Timeline timer = new Timeline(new KeyFrame(Duration.millis(100), e -> {
//                Random rand = new Random();
//                int slot = rand.nextInt(9) + 1;
//                this.setText(String.valueOf(slot));
//            }));
//
//            timer.setCycleCount(timer.INDEFINITE);
//            timer.play();
//        }
//    }

    public void setSlotStarted() {
        isSlotStarted = true;
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            Random rand = new Random();
            int slot = rand.nextInt(9) + 1;
            this.setText(String.valueOf(slot));
        }));

            timer.setCycleCount(timer.INDEFINITE);
            timer.play();
    };

    public void stopSlot(){
        isSlotStarted = false;
    }

};

