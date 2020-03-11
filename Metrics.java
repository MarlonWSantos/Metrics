public class Metrics{
  private int totalMotes;
  private int rangeWireless=100;
  private int area=100;

  public void setTotalMotes(int totalMotes){
    this.totalMotes=totalMotes;
  }

  public int getTotalMotes(){
    return totalMotes; 
  }

  public void rangeWireless(int rangeWireless){
    this.rangeWireless=rangeWireless;
  }

  public int getRangeWireless(){
    return rangeWireless;
  }

  public void setArea(int area){
    this.area=area;
  }

  public int getArea(){
    return area;
  }

  public static void main(String []args){

    Metrics obj = new Metrics();    


    try{
      while(true){

        int num = ((int)(Math.random()*10)+1);
        obj.setTotalMotes(num);

        int result = (obj.getTotalMotes() * obj.getRangeWireless())/obj.getArea();
        System.out.println(result);

        Thread.sleep(1000);
      }
    }
    catch(InterruptedException e){
      System.out.println("Error!");
    }
  }
}
