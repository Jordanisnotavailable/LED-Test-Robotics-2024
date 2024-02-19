// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase {
  AddressableLED led;
  AddressableLEDBuffer led_Buffer;
  Color ledOff = new Color();
  boolean atEnd = false;

  int m_rainbowFirstPixelHue = 40;
  /** Creates a new LED. */
  public LED() {

    led = new AddressableLED(9);

    led_Buffer = new AddressableLEDBuffer(60);

    led.setLength(led_Buffer.getLength());
    led.start();
  }

  public void ledShortChase(Color color){
    for(int i = 0; i < led_Buffer.getLength(); i++){
      led_Buffer.setLED(i, color);
      if(i+2 >= led_Buffer.getLength()){
        led_Buffer.setLED(i-58, color);
      }
      else{
        led_Buffer.setLED(i, color);
      }
      if(i > 0){
        led_Buffer.setLED(i-1,ledOff);
      }
      else if(i == 0){
        led_Buffer.setLED(led_Buffer.getLength()-1, ledOff);
      }
        Timer.delay(0.005);
      
        led.setData(led_Buffer);
    }
  
  }

  



  public void ledOff(){
    for(int i = 0; i < led_Buffer.getLength(); i++){
      
        led_Buffer.setRGB(i, 0, 0, 0);

    }
    led.setData(led_Buffer);
  }

  public void solidColor(Color color){
    for(var i = 0; i < led_Buffer.getLength(); i++){
      
        led_Buffer.setLED(i, color);

    }
    led.setData(led_Buffer);
  }

 public void ledChase(Color color){
    for(int i = 0; i < led_Buffer.getLength(); i++){
      if(i+16 > led_Buffer.getLength()){ //add lights: add 1 to integer
        led_Buffer.setLED(i-(led_Buffer.getLength()-17), color); //add lights: subtract 1 from integer
      }
      else{
        led_Buffer.setLED(i, color);
        led_Buffer.setLED(i + 1, color);
        led_Buffer.setLED(i + 2, color);
        led_Buffer.setLED(i + 3, color);
        led_Buffer.setLED(i + 4, color);
        led_Buffer.setLED(i + 5, color);
        led_Buffer.setLED(i + 6, color);
        led_Buffer.setLED(i + 7, color);
        led_Buffer.setLED(i + 8, color);
        led_Buffer.setLED(i + 9, color);
        led_Buffer.setLED(i + 10, color);
        led_Buffer.setLED(i + 11, color);
        led_Buffer.setLED(i + 12, color);
        led_Buffer.setLED(i + 13, color);
        led_Buffer.setLED(i + 14, color);
        led_Buffer.setLED(i + 15, color);
      }
      if(i > 0){
        led_Buffer.setLED(i-1,ledOff);
      }
      else if(i == 0){
        led_Buffer.setLED(led_Buffer.getLength()-1, ledOff);
      }
        Timer.delay(0.007);
      
        led.setData(led_Buffer);
    }
  
  }

   public void ledFullChase(Color color){
    for(int i = led_Buffer.getLength() - 1; i > 0; i--){
      led_Buffer.setLED(i, color);
      led.setData(led_Buffer);
      Timer.delay(0.01);
    }
    for(int i = led_Buffer.getLength() - 1; i>0; i--){
      led_Buffer.setLED(i, ledOff);
      led.setData(led_Buffer);
      Timer.delay(0.01);
    }
   }

  public void ledBounce(Color color){
    while (!atEnd){
      for(int i = 0; i < led_Buffer.getLength(); i++){
        //led forward
        led_Buffer.setLED(i, color);
      if(i+16 > led_Buffer.getLength()){
        led_Buffer.setLED(i-(led_Buffer.getLength()-17), ledOff);
      }
      else{
        led_Buffer.setLED(i, color);
        led_Buffer.setLED(i + 1, color);
        led_Buffer.setLED(i + 2, color);
        led_Buffer.setLED(i + 3, color);
        led_Buffer.setLED(i + 4, color);
        led_Buffer.setLED(i + 5, color);
        led_Buffer.setLED(i + 6, color);
        led_Buffer.setLED(i + 7, color);
        led_Buffer.setLED(i + 8, color);
        led_Buffer.setLED(i + 9, color);
        led_Buffer.setLED(i + 10, color);
        led_Buffer.setLED(i + 11, color);
        led_Buffer.setLED(i + 12, color);
        led_Buffer.setLED(i + 13, color);
        led_Buffer.setLED(i + 14, color);
        led_Buffer.setLED(i + 15, color);
      }
      if(i > 0){
        led_Buffer.setLED(i-1,ledOff);
      }
      
        Timer.delay(0.005);
      
        led.setData(led_Buffer);
        if(i+16 > led_Buffer.getLength()){
          atEnd = true;
        }
      }
    }
    while (atEnd){
      for(int i = led_Buffer.getLength()-1; i > 0; i--){
        //led backward
        led_Buffer.setLED(i, color);
      if(i-16 < led_Buffer.getLength()-led_Buffer.getLength()){
        led_Buffer.setLED(led_Buffer.getLength()-1, ledOff);
      }
      else{
        led_Buffer.setLED(i, color);
        led_Buffer.setLED(i - 1, color);
        led_Buffer.setLED(i - 2, color);
        led_Buffer.setLED(i - 3, color);
        led_Buffer.setLED(i - 4, color);
        led_Buffer.setLED(i - 5, color);
        led_Buffer.setLED(i - 6, color);
        led_Buffer.setLED(i - 7, color);
        led_Buffer.setLED(i - 8, color);
        led_Buffer.setLED(i - 9, color);
        led_Buffer.setLED(i - 10, color);
        led_Buffer.setLED(i - 11, color);
        led_Buffer.setLED(i - 12, color);
        led_Buffer.setLED(i - 13, color);
        led_Buffer.setLED(i - 14, color);
        led_Buffer.setLED(i - 15, color);
      }
      if(i < led_Buffer.getLength()-1){
        led_Buffer.setLED(i+1, ledOff);
      }
      
        Timer.delay(0.005);
      
        led.setData(led_Buffer);
        if(i-16 < led_Buffer.getLength()-led_Buffer.getLength()){
          atEnd = false;
        }
      }
    }
        Timer.delay(0.005);
      
        led.setData(led_Buffer);
    
  
  }

  public void rainbow() {
    // For every pixel
    for (var i = 0; i < led_Buffer.getLength(); i++) {
      // Calculate the hue - hue is easier for rainbows because the color
      // shape is a circle so only one value needs to precess
      final var hue = (m_rainbowFirstPixelHue + (i * 180 / led_Buffer.getLength())) % 180;
      // Set the value
      led_Buffer.setHSV(i, hue, 255, 128);
    }
    // Increase by to make the rainbow "move"
    m_rainbowFirstPixelHue += 3;
    // Check bounds
    m_rainbowFirstPixelHue %= 180;

    led.setData(led_Buffer);
  }

   @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}