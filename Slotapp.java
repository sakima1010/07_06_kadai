package toujitukadai_07_0325;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.pco2699.javafx.MyLabel;

import java.util.ArrayList;
import java.util.Random;

public class Slotapp extends Application {
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ArrayList<SlotLabel> label_array = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            label_array.add(new SlotLabel());
        }

        // ボタンを作成
            // スタートボタンを作成
            Button start_button = new Button("Start");

            start_button.setOnAction(event -> {
                for(int i = 0; i < label_array.size(); i++){
                    label_array.get(i).setSlotStarted();
                }
                    });

            // ストップボタンを作成
            Button stop_button = new Button("Stop");
//             stopボタン押下後に①の処理を止める
            stop_button.setOnAction(event -> {
                for(int i =0; i< label_array.size(); i++){
                    label_array.get(i).stopSlot();
                }
//                     現在の表示されている数字が全て同じかどうかをチェック
                        if (label_array.equals(label_array)) {
//                        // 新しいウィンドウを作成
                            Stage newStage = new Stage();
//
//                        // モーダルウィンドウに設定
                            newStage.initModality(Modality.APPLICATION_MODAL);
//                        // オーナーを設定
                            newStage.initOwner(stage);
//
//                        // 新しいウインドウ内に配置するコンテンツを生成
                            HBox hBox = new HBox();
                            Label label = new Label("おめでとう！");
                            hBox.getChildren().add(label);

                            newStage.setScene(new Scene(hBox));
                            newStage.show();
                        }
                    });


        // hBoxを作成
            // slotを入れたhBOX
            HBox slBox = new HBox(20d);
            slBox.setPadding(new Insets(10, 10, 10, 10));
            slBox.setAlignment(Pos.CENTER);

            slBox.getChildren().addAll(label_array);

            // buttonを入れたhBOX
            HBox btBox = new HBox(20d);
            btBox.setPadding(new Insets(10, 10, 10, 10));
            btBox.setAlignment(Pos.CENTER);

            btBox.getChildren().add(start_button);
            btBox.getChildren().add(stop_button);

        // hBOXをBorderPaneに入れる
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(slBox);
        borderPane.setBottom(btBox);

        // BoderPaneをSceneに入れる
        Scene scene = new Scene(borderPane, 400 ,120);
        stage.setScene(scene);
        stage.show();
    }
}
