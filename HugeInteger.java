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
public class HugeInteger {
    public int[] bigNum;
    public boolean sign;        //positive true, negative false
    public int size =0;
    
    public HugeInteger(String val){
        
        int len=val.length();
        if(val.equals("")){
            throw new IllegalArgumentException("Requires Input");
        }
        if(!val.equals("0")&&!val.equals("-0")){
        } else {
            int[] newint = new int[1];
            bigNum=newint;
            sign=true;
            size=1;
            return;
        }
        
        if((val.charAt(0)<48||val.charAt(0)>57)&&(val.charAt(0)!=45)){
                throw new IllegalArgumentException("Illegal Character(s)");                     //checks input in range
            }
        
        for(int i=1;i<len;i++){
            if((val.charAt(i)<48||val.charAt(i)>57)){
                throw new IllegalArgumentException("Illegal Character(s)");                     //checks input in range
            }
        }
        
        int zeroCnt=0;              //counts leading zeros
        for(int i=0;i<len;i++){
            if(val.charAt(i)!='0'){
                break;
            }
            if(val.charAt(i)=='0'){
                zeroCnt++;
            }
            
        }
        
        if(val.charAt(0)=='-'){
            sign=false;
            
            int[] newInt= new int[len-zeroCnt-1];                       //negative case, loops adding string to array
            
            for(int i=zeroCnt;i<newInt.length;i++){
                
            
            newInt[i]= val.charAt(i+1)-48;
                
            }
            size=newInt.length;
            bigNum=newInt;
        }
        
            
        
        
        else{                                           //positive case, represented by true
                int[] newInt= new int[len-zeroCnt];
                sign=true;
                for(int i=zeroCnt;i<newInt.length;i++){


                newInt[i]= val.charAt(i)-48;
            }
                size=newInt.length;
                this.bigNum=newInt;
            }
        
    }
    
    public HugeInteger(int n){
        
        if(n<1){
            throw new IllegalArgumentException("integer must be greater than 0");
        }
        
        int[] newInt = new int[n];
        double random1 = Math.random();
        
        if(random1>0.5){                    //assign pos or neg
            sign=true;
        }
        else {sign=false;}
        
            newInt[0]=(int)Math.round(Math.random()*8+1);
        
        for(int i=1;i<n;i++){
            newInt[i]=(int)Math.round(Math.random()*9);
        }
        
        
        
        size=newInt.length;
        this.bigNum=newInt;
        
        if(this.toString().equals("-0")){
            this.sign=true;                     //eliminate minus zero
        }
        
    }
    
    
    
    
    
    
    public String toString(){
        String str= new String();
        
        if(this.sign==false){
            
            str=str.concat("-");                //attach negative sign for negative case
        }
        
        for(int i=0;i<this.bigNum.length;i++){
            str=str.concat(""+this.bigNum[i]);
        }
        return str;
    }
    
    
    public HugeInteger add(HugeInteger h){
        
        if(this.sign==h.sign){
            int a=this.size;
            int b=h.size;
            int maxval= (a>b)? a:b;       //length of list
            int[] sum= new int[maxval+1];
            int[] add1=new int[maxval];
            int[] add2=new int[maxval];
            int carry=0;
            int current=0;
            int digit=0;
            
            if(a>=b){
                for(int i=maxval-1;i>=0;i--){
                    current=carry;
                    carry=0;
                    add1[i]=this.bigNum[i];
                    if(i-(a-b)>=0){
                    add2[i]=h.bigNum[i-(a-b)];
                    }
                    digit=add1[i]+add2[i];
                    if((digit+current)>9){
                        carry++;
                        digit-=10;
                    }
                    sum[i+1]=digit+current;
                    
                    
                    
                }                                               //copy this and that to equally sized lists, then add
            }
            else{
                for(int i=maxval-1;i>=0;i--){
                    current=carry;
                    carry=0;
                    if(i-(b-a)>=0){
                    add1[i]=this.bigNum[i-(b-a)];
                    }
                    add2[i]=h.bigNum[i];
                    digit=add1[i]+add2[i];
                    if((digit+current)>9){
                        carry++;
                        digit-=10;                            //note if partial sum is greater than 10, a one is carried
                    }
                    sum[i+1]=digit+current;
                }
            }
            if(carry==1){
                sum[0]+=1;                                  //catch final carry
            }
            
            
            
            if(sum[0]==0){
                int[] newSum=new int[maxval];           //remove initial zero if there is one
                for(int i=0;i<maxval;i++){
                    newSum[i]=sum[i+1];
                }
                HugeInteger finalSum=new HugeInteger("0");
                finalSum.bigNum=newSum;
                finalSum.sign=this.sign;
                finalSum.size=newSum.length;
                return finalSum;
            }
            else{
                HugeInteger finalSum=new HugeInteger("0");
                finalSum.bigNum=sum;
                finalSum.sign=this.sign;
                finalSum.size=sum.length;
                return finalSum;
            }
            
        
        
        
        
        }
        else{
            int a=this.size;
            int b=h.size;
            
            boolean bigSign;
            int x=1;
            
            if(this.size==h.size){
            
            for(int i=0;i<this.size;i++){
                if(this.bigNum[i]<h.bigNum[i]){
                    x=0;
                    break;
                }else if(this.bigNum[i]>h.bigNum[i]){
                    break;
                }
            }
            if(x==1){ 
                //System.out.println("larger");                                        //section finds larger number to determin final sign
                bigSign=this.sign;                      //as sign is the same as larger number sign
            }
            else{
                //System.out.println("smaller");
                bigSign=h.sign;
            }
        }                                                   
            else if(a>b){
                x=1;
                bigSign=this.sign;
            }
            else{
                x=0;
                bigSign=h.sign;
            }
            
            int chk=0;
            if(a==b){
                for(int i=0;i<this.size;i++){
                    if(this.bigNum[i]==h.bigNum[i]){
                        chk++;
                    }                                   // checks if same number
                }
                if(chk==this.bigNum.length){
                    return new HugeInteger("0");
                }
            }
            
            int maxval= (a>b)? a:b;       //length of list
            int[] sum= new int[maxval+1];
            int[] add1=new int[maxval];
            int[] add2=new int[maxval];
            int carry=0;
            int current=0;
            int digit=0;
            
            if((a>=b)&&(x==1)){
                for(int i=maxval-1;i>=0;i--){ 
                    //System.out.println("hola ");    //cycles from end, with careful respect to bounds
                    current=carry;
                    carry=0;
                    add1[i]=this.bigNum[i];
                    if(i-(a-b)>=0){
                    add2[i]=h.bigNum[i-(a-b)];
                    }
                    digit=add1[i]-add2[i];
                    if((digit+current)<0){
                        //System.out.println("digit is "+(digit+current));
                        carry--;
                        digit+=10;
                    }
                    sum[i+1]=digit+current;
                    
                    
                    
                    
                }
                for(int i=0;i<sum.length;i++){
                        //System.out.println("diff is ->"+sum[i]);        //copy this and that to equally sized lists, then add
            }
            }
            else{
                for(int i=maxval-1;i>=0;i--){
                    current=carry;
                    carry=0;
                    if(i-(b-a)>=0){
                    add1[i]=this.bigNum[i-(b-a)];
                    }
                    add2[i]=h.bigNum[i];
                    digit=-add1[i]+add2[i];
                    if((digit+current)<0){
                        carry--;
                        digit+=10;                            //note if partial sum is greater than 10, a one is carried
                    }
                    sum[i+1]=digit+current;
                }
            }
            if(carry==1){
                sum[0]+=1;                                  //catch final carry
            }
            
            
            if(sum[0]==0){
                int zeroCnt=0;              //counts leading zeros
                for(int i=0;i<sum.length;i++){
                    if(sum[i]!=0){
                        break;
                    }
                    if(sum[i]==0){
                        zeroCnt++;
                    }

                }
                int[] newSum=new int[maxval+1-zeroCnt];           //remove initial zero if there is one
                for(int i=0;i<newSum.length;i++){
                    newSum[i]=sum[i+zeroCnt];
                }
                HugeInteger finalSum=new HugeInteger("0");
                finalSum.bigNum=newSum;
                finalSum.sign=bigSign;
                finalSum.size=newSum.length;
                return finalSum;
            }
            else{
                HugeInteger finalSum=new HugeInteger("0");
                finalSum.bigNum=sum;
                finalSum.sign=bigSign;
                finalSum.size=sum.length;
                return finalSum;
            }
            }
    
            
                
            
        
        }
    
   
    
    public HugeInteger subtract(HugeInteger h){
        HugeInteger hCopy=new HugeInteger("0");
        hCopy.bigNum=h.bigNum;
        hCopy.sign=!h.sign;
        hCopy.size=h.size;
        return this.add(hCopy);
    }
        
    
    public HugeInteger multiply(HugeInteger h){
        HugeInteger max=(this.size>h.size)? this:h;
        HugeInteger min=(this.size>h.size)? h:this;
        if(this.size==h.size){
            int x=1;
            for(int i=0;i<this.size;i++){
                if(this.bigNum[i]<h.bigNum[i]){             //checks which is larger
                    x=0;
                    break;
                }
                else if(this.bigNum[i]>h.bigNum[i]){
                    break;
                }
            }
            if(x==1){
                max=this;
                min=h;
            }
            else{
                max=h;
                min=this;
            }
        }
        
        
        boolean aSign=this.sign;
        boolean bSign=h.sign;
        
        this.sign=true;
        h.sign=true;
        
        HugeInteger prod=new HugeInteger("0");
        
        for(HugeInteger i=new HugeInteger("0");!(i.toString().equals(min.toString()));i=i.add(new HugeInteger("1"))){
            prod=prod.add(max);
        }
        this.sign=aSign;
        h.sign=bSign;
        
        prod.sign=!XOR(this.sign,h.sign);
        return prod;
    }
    
    
    
    
    public HugeInteger divide(HugeInteger h){
        if(h.compareTo(new HugeInteger("0"))==0){
            throw new IllegalArgumentException("Divisor is Zero");
        }
        boolean aSign=this.sign;
        boolean bSign=h.sign;
        
        this.sign=true;
        h.sign=true;
        
        if(this.compareTo(h)==-1){
            return new HugeInteger("0");
        }
        
        HugeInteger div=new HugeInteger(this.toString());
        HugeInteger i=new HugeInteger("0");
        int sizeCng=i.size;
        
        while(true){
            div=div.subtract(h);
            if(!(div.toString().charAt(0)!='-')&&(div.toString().charAt(0)!='0')){
                break;
            }
            i=i.add(new HugeInteger("1"));
        }
        this.sign=aSign;
        h.sign=bSign;
        
        i.sign=!XOR(this.sign,h.sign);
        return i;
    }
    public static boolean XOR(boolean x, boolean y) {
    return ( ( x || y ) && (!( x && y )) );
}
    public int compareTo(HugeInteger h){
        int a=this.size;
        int b=h.size;
        int x=2;
        boolean bigSign;
        if(a==b){
        for(int i=0;i<((this.size>h.size)?this.size:h.size);i++){
                if(this.bigNum[i]<h.bigNum[i]){
                    x=0;
                    break;
                }else if(this.bigNum[i]>h.bigNum[i]){
                    x=1;
                    break;
                }
            }
            if(x==1){ 
                //System.out.println("larger");                                        //section finds larger number to determin final sign
                bigSign=this.sign;                      //as sign is the same as larger number sign
            }
            else{
                //System.out.println("smaller");
                bigSign=h.sign;
            }
            }                                       
            else if(a>b){
                x=1;
                bigSign=this.sign;
            }
            else{
                x=0;
                bigSign=h.sign;
            }
        
            if(this.sign&&!h.sign){
                return 1;
            }
            if(!this.sign&&h.sign){
                return -1;                          //checks
            }
            if(!this.sign&&!h.sign){
            if(x==2){
                return 0;
            }
            if(x==1){
                return -1;
            }
            if(x==0){
                return 1;
            }
            }
            
            if(x==2){
                return 0;
            }
            if(x==1){
                return 1;
            }
            if(x==0){
                return -1;
            }
            
            
        return 420;
    

} 
}    