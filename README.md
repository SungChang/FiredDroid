#FiredDroid

FiredDroid is an easy-to-use [Firebase](https://firebase.google.com) wrapper on Android.

## Table of Content

  1. [Installation](#installation)
  2. [Usage](#usage)
  3. [License](#license)

## Installation

  1. Add the following dependency on your `app/build.gradle` file.
  
  ```groovy
  dependencies {
    compile 'com.scalated.fireddroid:fired-droid:0.1.0'
  }
  ```
  
  Please make sure you already have added "firebase-client-android" library to use Firebase with FiredDroid.
  
  2. I strong recommend you to use [Retrolambda](https://github.com/evant/gradle-retrolambda) with FiredDroid, but it's still optional.
  
  Add the following to your build.gradle
   ```groovy
   buildscript {
      repositories {
         mavenCentral()
      }

      dependencies {
         classpath 'me.tatarka:gradle-retrolambda:3.3.0'
      }
   }

   // Required because retrolambda is on maven central
   repositories {
      mavenCentral()
   }

   apply plugin: 'com.android.application' //or apply plugin: 'java'
   apply plugin: 'me.tatarka.retrolambda'
   ```
   alternatively, you can use the new plugin syntax for gradle `2.1+`
   ```groovy
   plugins {
      id "me.tatarka.retrolambda" version "3.3.0"
   }
   ```
   
## Usage
  1. Here is an original Firebase sample code:
    ```java
    Firebase firebase = new Firebase("https://example-xxxxx.firebaseio.com/).child("version");
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
  
  2. And, following code with FiredDroid(with Retrolambda) is equivalent to above:

    ```java
    Firebase firebase = new Firebase("https://example-xxxxx.firebaseio.com/).child("version");
    FiredDroid.loadData(firebase, dataSnapshot -> {
        String version = dataSnapshot.getValue();
    });
    ```
    
## License
    

  
