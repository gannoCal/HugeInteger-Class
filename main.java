/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugeinteger3;

/**
 *
 * @author calebgannon
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a=1111111  ;
        int b=1111111  ;        
       
        
        
        
        
        System.out.println("Addition");
        System.out.println("1234 + 4242");
        HugeInteger Test1 = new HugeInteger("60099").add(new HugeInteger("0"));
        System.out.println(Test1.toString()+" == "+(654+54));
        System.out.println("");
        
        System.out.println("Add Negative");
        System.out.println("4321 + (-2424)");
        HugeInteger Test2 = new HugeInteger("654").add(new HugeInteger("54"));
        System.out.println(Test2.toString()+" == "+(654-54));
        
        System.out.println("");
        System.out.println("Subtract Positive");
        System.out.println("4343 - 6789");
        HugeInteger Test3 = new HugeInteger("128").subtract(new HugeInteger("54"));
        System.out.println(Test3.toString()+" == "+(4343-6666));
        
        System.out.println("");
        System.out.println("Subtract Negative");
        System.out.println("9876 - -(2456)");
        HugeInteger Test4 = new HugeInteger("9876").subtract(new HugeInteger("-2456"));
        System.out.println(Test4.toString()+" == "+(9876-(-2456)));
        
        System.out.println("");
        System.out.println("Compare To");
        System.out.println("9876 vs (2456)");
        int Test5 = new HugeInteger("-9876").compareTo(new HugeInteger("-2456"));
        System.out.println(Test5+" == "+-1);
        
        HugeInteger RandomTest=new HugeInteger(20);
        System.out.println("Random -> "+RandomTest.toString());
        
        System.out.println("Multiply TEST ");
        System.out.println(""+((new HugeInteger("-100001")).multiply(new HugeInteger("12345"))));
        System.out.println("");
        
        System.out.println("DIVIDE TEST");
        System.out.println(""+((new HugeInteger("10000")).divide(new HugeInteger("1"))));
        
        System.out.println("COMPARE TO TEST"+(new HugeInteger("-1")).compareTo(new HugeInteger("-10000")));
        
        
        System.out.println(new HugeInteger("-0").toString());
        
        
        
        double avgRun=0;
        int u=100;
        
        for(int i=0;i<u;i++){
        double start= System.nanoTime();
        System.out.println("addition");
        System.out.println(""+((new HugeInteger("100000064928485693")).add(new HugeInteger("2340347034"))));
        double end =System.nanoTime();
        System.out.println("RunTime "+(i+1)+" -> "+((end-start)/Math.pow(10, 6))+" ms");
        avgRun+=(end-start)/(Math.pow(10, 6));
        }
        System.out.println("Average Run Time -> "+(avgRun/u));
        
        long Start=System.nanoTime();
        System.out.println("Start-> "+Start/Math.pow(10, 9));
        
        long End= System.nanoTime();
        System.out.println("End-> "+End/Math.pow(10, 9));
        
        System.out.println("Difference (ms)-> "+((End-Start)/(int)Math.pow(10, 6)));
        
        
        
        
        HugeInteger test2=new HugeInteger("9508").subtract(new HugeInteger("1242"));
        System.out.println("Test thing "+test2.toString());
        
        
        
        HugeIntTiming test = new HugeIntTiming();
        int n=10;
        long one=System.currentTimeMillis();
        System.out.println(""+(new HugeInteger(n).multiply(new HugeInteger(n))));
        long two=System.currentTimeMillis();
        System.out.println(""+(two-one));
        
        
        System.out.println("Add Runtime-> "+test.timeAdd(50, 500, n));
        
        System.out.println("***************************************************");
        
        System.out.println("Sub Runtime-> "+test.timeSub(50, 500, n));
        
        System.out.println("***************************************************");
    
        System.out.println("Multi Runtime-> "+test.timeMultiply(25, 100, n));
        
        System.out.println("***************************************************");
        
        System.out.println("Div Runtime-> "+test.timeDiv(25, 100, n));
        
        
        
        System.out.println("Multi Runtime-> "+test.BtimeAdd(50, 500, 10));
        System.out.println("Multi Runtime-> "+test.BtimeAdd(50, 500, 100));
        System.out.println("Multi Runtime-> "+test.BtimeAdd(50, 500, 500));
        System.out.println("Multi Runtime-> "+test.BtimeAdd(50, 500, 1000));
        System.out.println("Multi Runtime-> "+test.BtimeAdd(50, 500, 5000));
        System.out.println("Multi Runtime-> "+test.BtimeAdd(50, 500, 10000));
        
    }
    
}
