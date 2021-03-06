#FiredDroid

FiredDroid is an easy-to-use [Firebase](https://firebase.google.com) wrapper on Android.
Just started working on this library, and it's primarily for myself. Not so much useful yet.

## Table of Content

  1. [Installation](#installation)
  2. [Usage](#usage)
  3. [License](#license)

## Installation

  1. Add the following dependency on your `app/build.gradle` file.
  
  ```groovy
  allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
  }
  ```
  ```groovy
  dependencies {
    compile 'com.sungchang.fireddroid:fired-droid:0.1.2'
  }
  ```
  
  Please make sure you already have added "firebase-client-android" library to use Firebase with FiredDroid.
   
## Usage
  1. Here is an original Firebase sample code:
    ```java
    Firebase firebase = new Firebase("https://example-xxxxx.firebaseio.com/").child("version");
    firebase.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String version = dataSnapshot.getValue();
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {
        
        }
    });
    ```
  
  2. And, following code with FiredDroid is equivalent to above:

    ```java
    Firebase firebase = new Firebase("https://example-xxxxx.firebaseio.com/").child("version");
    FiredDroid.loadData(firebase, dataSnapshot -> {
        String version = dataSnapshot.getValue();
    });
    ```
    
## License
    
    Copyright 2016 Steve Chang
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

  
