package hugeinteger3;
import java.math.BigInteger;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author calebgannon
 */
public class HugeIntTiming {
    

    
  public double timeAdd(int MAXNUMINTS, int MAXRUN, int n){
          HugeInteger huge1, huge2, huge3;
          
          
long startTime, endTime;
double runTime=0.0;
for (int numInts=0; numInts < MAXNUMINTS; numInts++){
 //   System.out.println(""+numInts);
huge1 = new HugeInteger(n); //creates a random integer of n digits
huge2 = new HugeInteger(n); //creates a random integer of n digits
startTime = System.currentTimeMillis();
for(int numRun=0; numRun < MAXRUN; numRun++)
{ huge3 = huge1.add(huge2); }
endTime = System.currentTimeMillis();
runTime +=(double) (endTime - startTime)/((double) MAXRUN);
}
runTime = runTime/((double)MAXNUMINTS);

return runTime;
  }  
  
  public double timeSub(int MAXNUMINTS, int MAXRUN, int n){
          HugeInteger huge1, huge2, huge3;
          
          
long startTime, endTime;
double runTime=0.0;
for (int numInts=0; numInts < MAXNUMINTS; numInts++){
 //   System.out.println(""+numInts);
huge1 = new HugeInteger(n); //creates a random integer of n digits
huge2 = new HugeInteger(n); //creates a random integer of n digits
startTime = System.currentTimeMillis();
for(int numRun=0; numRun < MAXRUN; numRun++)
{ huge3 = huge1.subtract(huge2); }
endTime = System.currentTimeMillis();
runTime +=(double) (endTime - startTime)/((double) MAXRUN);
}
runTime = runTime/((double)MAXNUMINTS);

return runTime;
  }  
    
    
  public double timeMultiply(int MAXNUMINTS, int MAXRUN, int n){
          HugeInteger huge1, huge2, huge3;
          
          
long startTime, endTime;
double runTime=0.0;
for (int numInts=0; numInts < MAXNUMINTS; numInts++){
 //   System.out.println(""+numInts);
huge1 = new HugeInteger(n); //creates a random integer of n digits
huge2 = new HugeInteger(n); //creates a random integer of n digits
startTime = System.currentTimeMillis();
for(int numRun=0; numRun < MAXRUN; numRun++)
{ huge3 = huge1.multiply(huge2); }
endTime = System.currentTimeMillis();
runTime +=(double) (endTime - startTime)/((double) MAXRUN);
}
runTime = runTime/((double)MAXNUMINTS);

return runTime;
  }  
    
  
  public double timeDiv(int MAXNUMINTS, int MAXRUN, int n){
          HugeInteger huge1, huge2, huge3;
          
          
long startTime, endTime;
double runTime=0.0;
for (int numInts=0; numInts < MAXNUMINTS; numInts++){
//    System.out.println(""+numInts);
huge1 = new HugeInteger(n); //creates a random integer of n digits
huge2 = new HugeInteger(1); //creates a random integer of n digits
startTime = System.currentTimeMillis();
for(int numRun=0; numRun < MAXRUN; numRun++)
{ huge3 = huge1.divide(huge2); }
endTime = System.currentTimeMillis();
runTime +=(double) (endTime - startTime)/((double) MAXRUN);
}
runTime = runTime/((double)MAXNUMINTS);

return runTime;
  }  


 public double BtimeAdd(int MAXNUMINTS, int MAXRUN, int n){
          BigInteger huge1, huge2, huge3;
          Random rand = new Random();
          
          
long startTime, endTime;
double runTime=0.0;
for (int numInts=0; numInts < MAXNUMINTS; numInts++){
 //   System.out.println(""+numInts);
huge1 = new BigInteger(n, rand); //creates a random integer of n digits
huge2 = new BigInteger(n,rand); //creates a random integer of n digits
startTime = System.currentTimeMillis();
for(int numRun=0; numRun < MAXRUN; numRun++)
{ huge3 = huge1.subtract(huge2); }
endTime = System.currentTimeMillis();
runTime +=(double) (endTime - startTime)/((double) MAXRUN);
}
runTime = runTime/((double)MAXNUMINTS);

return runTime;
  }  
    
  
  public double BtimeDiv(int MAXNUMINTS, int MAXRUN, int n){
          BigInteger huge1, huge2, huge3;
          Random rand = new Random();
          
long startTime, endTime;
double runTime=0.0;
for (int numInts=0; numInts < MAXNUMINTS; numInts++){
//    System.out.println(""+numInts);
huge1 = new BigInteger(n, rand); //creates a random integer of n digits
huge2 = new BigInteger("1"); //creates a random integer of n digits
startTime = System.currentTimeMillis();
for(int numRun=0; numRun < MAXRUN; numRun++)
{ huge3 = huge1.divide(huge2); }
endTime = System.currentTimeMillis();
runTime +=(double) (endTime - startTime)/((double) MAXRUN);
}
runTime = runTime/((double)MAXNUMINTS);

return runTime;
  }  
}

