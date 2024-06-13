class Device {
  public void guessSize(){
    System.out.println("Device may have different sizes!");
  }
}

class Computer extends Device{
  public void guessSize(){
    System.out.println("The size if computer device usually big.");
  }
}

class Laptop extends Device{
  public void guessSize(){
    System.out.println("Laptop computer is smaller one.");
  }
}
class Mobile extends Device{
  public void guessSize(){
    System.out.println("You can carry a mobile phone in hand or pocket.");
  }
}

public class TestExample{ //must be file name
  public static void main (String[] args) {
    //create objects of device and subclasses 
    Device device = new Device();
    Device computer = new Computer();
    Device laptop = new Laptop();
    Device mobile = new Mobile();
    
    //execute the methods
    device.guessSize();
    computer.guessSize();
    laptop.guessSize();
    mobile.guessSize();
  }
}

/**
 * Output: 
 * 
 * 
 *Device may have different sizes!
 * The size if computer device usually
 * big
 * Laptop computer is smaller one.
 * You can carry a mobile phone in hand or pocket.

 */