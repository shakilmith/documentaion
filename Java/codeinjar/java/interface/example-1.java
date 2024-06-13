interface Bank{
  float rateOfInterest();//return float
}

//implemented class (Bank names)

class SBI implements Bank{
  //override the rateOfInterest method
  
  @Override //not necessary to annotate
  public float rateOfInterest(){
    return 5.56f;
  }
}

class PNC implements Bank{
  //override the rateOfInterest method
  
  @Override //not necessary to annotate
  public float rateOfInterest(){
    return 8.00f;
  }
}

class TDI implements Bank{
  //override the rateOfInterest method
  
  @Override //not necessary to annotate
  public float rateOfInterest(){
    return 9.50f;
  }
}

//class that contains main method

public class ExampleApplication{
  public static void main (String[] args) {
    //Create objects of the sub classes
    SBI sbi = new SBI();
    PNC pnc = new PNC();
    TDI tdi = new TDI();
    
    //invoke the rateOfInterest method
    System.out.println("SBI interest rate is: "+sbi.rateOfInterest());
    System.out.println("PNC interest rate is: "+pnc.rateOfInterest());
    System.out.println("TD interest rate is: "+tdi.rateOfInterest());
  }
}