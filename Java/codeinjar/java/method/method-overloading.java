public class Addition{
  
  public int add(int x, int y){
    return x+y;
  }
  public int add(int x, int y, int z){
    return x+y+z;
  }
  public float add(float x, float y){
    return x+y;
  }
  
  public static void main (String[] args) {
    Addition obj = new Addition();
    
    System.out.println("Addition of 2 int numbers are "+ obj.add(75, 75));
    System.out.println("Addition of 3 int numbers are "+ obj.add(75, 25, 50));
    System.out.println("Addition of 2 float number s are "+ obj.add(7.5f, 7.5f));
  }
}

//output

Addition of 2 int numbers are 150
Addition of 3 int numbers are 150
Addition of 2 float number s are 15.0
