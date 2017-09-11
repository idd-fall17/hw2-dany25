package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;


public class Hw2TemplateApp extends SimplePicoPro {
    // state 0  indicates the selection of a touch between 1 and 9 that corresponds to the selection of one group of 3 letters.
    //          e.g.  touch 1 means the selection of the group a-b-c
    // state 1  indicates the selection of the letter (with touches 4 to 6 that indicate left, center or right)
    //          among the group of three previously selected letters.
    // For example: If the user press the 2nd touch (group of the three letters def) and the 5th (corresponding to center), the letter written will be e
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

        pinMode(GPIO_174,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_174,Gpio.EDGE_BOTH);

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
        //println(""+ letter);
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

        if(pin==GPIO_128 && value==HIGH) {
            this.selection = "S  T  U";
            updateDisplay();
            this.state = 1;
            this.keys[0]=7;
        }
        else if (pin==GPIO_33 && value==HIGH) {
            this.selection = "V  W  X";
            updateDisplay();
            this.state = 1;
            this.keys[0]=8;
        }
        else if (pin==GPIO_35 && value==HIGH) {
            this.selection = "A  B  C";
            updateDisplay();
            this.state = 1;
            this.keys[0]=1;
        }
        else if (pin==GPIO_39 && value==HIGH) {
            if(this.state == 1){
                this.keys[1]=4;
                returnLetter(this.keys);
            }
            else{
                this.selection = "J  K  L";
                updateDisplay();
                this.state =1;
                this.keys[0]=4;
            }
        }
        else if (pin==GPIO_32 && value==HIGH) {
            if(this.state == 1){
                this.keys[1]=5;
                returnLetter(this.keys);
            }
            else{
                this.selection = "M  N  O";
                updateDisplay();
                this.state =1;
                this.keys[0]=5;
            }
        }
        else if (pin==GPIO_10 && value==HIGH) {
            this.selection = "D  E  F";
            updateDisplay();
            this.state = 1;
            this.keys[0]=2;
        }
        else if (pin==GPIO_172 && value==HIGH) {
            this.selection = "G  H  I";
            updateDisplay();
            this.state = 1;
            this.keys[0]=3;
        }
        else if (pin==GPIO_173 && value==HIGH) {
            if(this.state == 1){
                this.keys[1]=6;
                returnLetter(this.keys);
            }
            else{
                this.selection = "P  Q  R";
                updateDisplay();
                this.state =1;
                this.keys[0]=6;
            }
        }
        else if (pin==GPIO_34 && value==HIGH) {
            if(this.result.length() != 0 && this.state == 0) {
                this.result = this.result.substring(0, this.result.length() - 1);
                this.selection = "";
                updateDisplay();
            }
        }
        else if (pin==GPIO_174 && value==HIGH) {
            this.selection = "Y  Z  space";
            updateDisplay();
            this.state = 1;
            this.keys[0]=9;
        }

    }



}
