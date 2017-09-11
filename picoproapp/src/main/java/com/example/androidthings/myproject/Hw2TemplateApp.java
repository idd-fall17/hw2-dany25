package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;


public class Hw2TemplateApp extends SimplePicoPro {
    // state 0  indicates the selection of a touch between 1 and 9.
    // state 1  indicates the selection of the letter (with touches 4 to 6 that indicate left, center or right)
    //          among the group of three previously selected in the state 0
    private int state;
    private int[] keys;
    private String result;
    private String selection;
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz ";

    @Override
    public void setup() {
        //set two GPIOs to input
        pinMode(GPIO_128,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_128,Gpio.EDGE_BOTH);

        pinMode(GPIO_39,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_39,Gpio.EDGE_BOTH);

        pinMode(GPIO_35,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_35,Gpio.EDGE_BOTH);

        pinMode(GPIO_34,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_34,Gpio.EDGE_BOTH);

        pinMode(GPIO_33,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_33,Gpio.EDGE_BOTH);

        pinMode(GPIO_32,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_32,Gpio.EDGE_BOTH);

        pinMode(GPIO_10,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_10,Gpio.EDGE_BOTH);

        pinMode(GPIO_172,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_172,Gpio.EDGE_BOTH);

        pinMode(GPIO_173,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_173,Gpio.EDGE_BOTH);

        pinMode(GPIO_175,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_175,Gpio.EDGE_BOTH);


        keys = new int[2];
        this.state = 0;
        this.selection = "";
        this.result = "";
        printStringToScreen(this.selection + "\n" + "\n" + this.result);


    }

    @Override
    public void loop() {
        //nothing to do here

    }

    void returnLetter(int[] keys){
        println(""+keys[0]+","+keys[1]);
        char letter = this.alphabet.charAt(3*keys[0]+keys[1]-7);
        println(""+ letter);
        this.result = this.result+letter;
        clearStringOnScreen();
        printStringToScreen("\n" + "\n" + this.result);
        this.state = 0;
    }


    void updateDisplay(){
        clearStringOnScreen();
        printStringToScreen(this.selection + "\n" + "\n" + this.result);
    }

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
        //println("digitalEdgeEvent"+pin+", "+value);
        // when 128 goes from LOW to HIGH
        // this is on button button release for pull-up resistors

        if(pin==GPIO_128 && value==HIGH) {
            //printStringToScreen("stu");
            this.selection = "S  T  U";
            updateDisplay();
            this.state = 1;
            this.keys[0]=7;
        }
        //when 33 goes from LOW to HIGH
        else if (pin==GPIO_33 && value==HIGH) {
            //printStringToScreen("vwx");
            this.selection = "V  W  X";
            updateDisplay();
            this.state = 1;
            this.keys[0]=8;
        }
        //when 35 goes from HIGH to HIGH
        else if (pin==GPIO_35 && value==HIGH) {
            //printStringToScreen("abc");
            this.selection = "A  B  C";
            updateDisplay();
            this.state = 1;
            this.keys[0]=1;
        }
        //when 39 goes from HIGH to HIGH
        else if (pin==GPIO_39 && value==HIGH) {
            if(this.state == 1){
                this.keys[1]=4;
                returnLetter(this.keys);
            }
            else{
                //printStringToScreen("jkl");
                this.selection = "J  K  L";
                updateDisplay();
                this.state =1;
                this.keys[0]=4;
            }
        }
        //when 32 goes from HIGH to HIGH
        else if (pin==GPIO_32 && value==HIGH) {
            if(this.state == 1){
                this.keys[1]=5;
                returnLetter(this.keys);
            }
            else{
                //printStringToScreen("mno");
                this.selection = "M  N  O";
                updateDisplay();
                this.state =1;
                this.keys[0]=5;
            }
        }
        //when 10 goes from HIGH to HIGH
        else if (pin==GPIO_10 && value==HIGH) {
            //printStringToScreen("def");
            this.selection = "D  E  F";
            updateDisplay();
            this.state = 1;
            this.keys[0]=2;
        }
        //when 172 goes from HIGH to HIGH
        else if (pin==GPIO_172 && value==HIGH) {
            //printStringToScreen("ghi");
            this.selection = "G  H  I";
            updateDisplay();
            this.state = 1;
            this.keys[0]=3;
        }
        //when 173 goes from HIGH to HIGH
        else if (pin==GPIO_173 && value==HIGH) {
            if(this.state == 1){
                this.keys[1]=6;
                returnLetter(this.keys);
            }
            else{
                //printStringToScreen("pqr");
                this.selection = "P  Q  R";
                updateDisplay();
                this.state =1;
                this.keys[0]=6;
            }
        }
        //when 34 goes from HIGH to HIGH
        else if (pin==GPIO_34 && value==HIGH) {
            //printStringToScreen("yz_");
            this.selection = "Y  Z  space";
            updateDisplay();
            this.state = 1;
            this.keys[0]=9;
        }
    }



}
