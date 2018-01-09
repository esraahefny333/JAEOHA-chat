/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverfunctions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
/**
 *
 * @author omnia
 */
public class Chart extends Application{

    ServerFunctions server=new ServerFunctions();
    final static String female = "female";
    final static String male = "male";
    
    Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception {
        
       stage.setTitle("Bar Chart ");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        
        bc.setTitle("number of females vs number of males");
        xAxis.setLabel("gender");       
        yAxis.setLabel("number");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("female");       
        series1.getData().add(new XYChart.Data(female, server.numberOfFemale()));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("males");

        series2.getData().add(new XYChart.Data(male, server. numberOfmale())); 
        
        Scene scene  = new Scene(bc,700,600);
        bc.getData().addAll(series1, series2);
        stage.setScene(scene);
        stage.show();
    }
  public static void main(String[] args) {
        launch(args);
    }
      
 }
