My Text Entry Device
=====================

Technique used:
----------------

This is a multi-tap technique, allowing the user to choose one group of three letters (abc, def, ghi, …), and then select which one of the three was meant to be typed (left, center or right letter).

The final device has 9 touches representing the 26 letters and the space character. A delete button is also used for correction. The letter buttons are indexed from 1 to 9. (1 represents the group abc, 2 the group def, ...).
Only the buttons 4,5 and 6 are used for letter selection (4: left, 5: center, 6: right).

Please see a picture of the device here: ....

Why this technique:
--------------------
This technique is close to the old phone multi-tap technique. Here for every letter meant to be typed, exactly two buttons are necessary pressed. In the original method, on, two or three buttons are required and sometimes some waiting time when it comes to write two letters that are on the same digit (example b and c on the touch 1).
I was also curious to see if, with a designed device, this technique is comfortable and if the user can get faslty used to it.





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
