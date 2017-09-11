My Text Entry Device
=====================

Technique used:
----------------

This is a multi-tap technique, allowing the user to choose one group of three letters (abc, def, ghi, …), and then select which one of the three was meant to be typed (left, center or right letter).

The final device has 9 touches representing the 26 letters and the space character. A delete button is also used for correction. The letter buttons are indexed from 1 to 9. (1 represents the group abc, 2 the group def, ...).
Only the buttons 4,5 and 6 are used for letter selection (4: left, 5: center, 6: right).

Please see a picture of the device here: https://github.com/idd-fall17/hw2-dany25/blob/master/device1.jpg

Why this technique ?
--------------------
This technique is close to the old phone multi-tap technique. Here for every letter meant to be typed, exactly two buttons are necessary pressed. In the original method, on, two or three buttons are required and sometimes some waiting time when it comes to write two letters that are on the same digit (example b and c on the touch 1).
I was also curious to see if, with a designed device, this technique is comfortable and if the user can get faslty used to it.


Implementation:
----------------
The code is event-based. Each switch, when pressed triggers an event. 
During the initialization, an array of size two is created to store the index of the key pressed during the two different phases (see below). The first phase corresponds to the selection of a letter when a letter button (from 1 to 9) is pressed The second one is when the user is asked to choose one between the three letters selected. To separate those two situations (choose a group of letter and choose the letter), two states are implemented: 
  - state 0: the user has to choose a group of three letters. During this phase, the key pressed is saved in the first case of the array.
  - state 1: the user has to select the letter. When one of the 4, 5 or 6 touch is pressed, the key index is stored in the second case of the array, the program prints the letter pressed and the state switch again to 0.
  
  In fact, if the key pressed during the first phase is 1 (group abc) and the key pressed during the second phase is 5 (center letter). The letter meant is the 3*1+5-7 = 1 so 2nd letter of the alphabet (The index starts at 0).
  This computation makes us able to find the letter in the alphabet : 3*array[0]+array[1]-7


Construction of the physical device:
-------------------------------------
The device is made of plywood. There is one layer of wood treated with the laser-cutting machine to grave the positions of the buttons, the letters, to cut the holes for the branches of the switches.
This is an illustrator picture:  https://github.com/idd-fall17/hw2-dany25/blob/master/device2.png
Then, the idea was to solder the switches with the wires in the back of the layer. I bought an arduino head connector and soldered the wires to it to make a convenient port gathering all the wires.
Please see picture: https://github.com/idd-fall17/hw2-dany25/blob/master/device3.jpg

I then designed a box made of plywood to transform the device into a remote.
Final device: https://github.com/idd-fall17/hw2-dany25/blob/master/device4.jpg

Wiring diagram: https://github.com/idd-fall17/hw2-dany25/blob/master/device5.jpg

Video demo
----------
Youtube Link:
https://youtu.be/eKFkr00kdVI


Android Things empty project template 
=====================================

Use this empty project as a template for your Android Things project.


Pre-requisites
--------------

- Android Things compatible board
- Android Studio 2.2+


Build and install
=================

On Android Studio, click on the "Run" button.

If you prefer to run on the command line, type

```bash
./gradlew installDebug
adb shell am start com.example.androidthings.myproject/.MainActivity
```

License
-------

Copyright 2016 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
