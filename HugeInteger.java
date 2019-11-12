
/**
 *
 * @author moham
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HugeInteger {

    //Initialize Variables
    int hugeList[];
    private int sign;
    private int size = 0;

    //This is the first constructor
    public HugeInteger(String val) throws IllegalArgumentException {
        hugeList = new int[val.length()];
        //For negative cases
        if (val.charAt(0) == '-') {
            hugeList = new int[val.length() - 1];
            sign = 1; //number is negative
            for (int i = 0; i < val.length() - 1; i++) {
                //check if it is 0-9
                if (val.charAt(i + 1) > 59 || val.charAt(i + 1) < 48) {
                    throw new IllegalArgumentException("Please make sure the value is an integer!");
                } else {
                    //add digit to list as int                
                    hugeList[i] = Character.getNumericValue((val.charAt(i + 1)));
                }
            }
        } //For positive cases
        else {
            hugeList = new int[val.length()];
            sign = 0; //the number is positive
            for (int i = 0; i < val.length(); i++) {
                //check if 0-9
                if (val.charAt(i) > 59 || val.charAt(i) < 48) {
                    throw new IllegalArgumentException("Please make sure the value is an integer!");
                } else {
                    //add digit to list as int
                    hugeList[i] = Character.getNumericValue((val.charAt(i)));
                }
            }
        }
    }

    //This is the second constructor
    public HugeInteger(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("Number of digits has to be larger than or equal to 1");
        } else {
            //array for storing random numbers
            hugeList = new int[n];
            //create random object
            Random random1 = new Random();
            //get a random single digit from 1-9
            int r = random1.nextInt(9) + 1;
            Random random2 = new Random();
            //add digit to front of list
            hugeList[0] = r;
            //loop adding rest of digits from 0-9
            for (int i = 1; i < n; i++) {
                hugeList[i] = random2.nextInt(10);
            }
        }
    }

    //Addition function
    public HugeInteger add(HugeInteger h) {
        //Initialize locals
        int number1, number2, sum;
        int carry = 0;
        String output = "";
        ArrayList<String> finalSum = new ArrayList<String>();

        if(this.hugeList.length < h.hugeList.length){
            this.hugeList = this.makeEqual(h);
        }else if(this.hugeList.length > h.hugeList.length){
            h.hugeList = this.makeEqual(h);
        }
        
        int length1 = this.hugeList.length - 1;
        int length2 = h.hugeList.length - 1;
        
        int longerLength = 0;
        if (length1 > length2) {
            longerLength = length1;
        } else {
            longerLength = length2;
        }
        //Initialize output to 0s equivalent to max length of output
        for (int i = 0; i < longerLength + 1; i++) {
            finalSum.add("0");
        }
        if(longerLength == 0){
            number1 = this.hugeList[0];
            number2 = h.hugeList[0];
            sum = number1 + number2;
            return new HugeInteger(Integer.toString(sum));
        }else{
            //While loop that adds each digit
            while (longerLength >= 0) {
                number1 = this.hugeList[length1];
                number2 = h.hugeList[length2];
                sum = number1 + number2 + carry;
                carry = 0;
                //add a carry
                if (sum > 9) {
                    carry = 1;
                    sum -= 10;
                }
                finalSum.set(longerLength, Integer.toString(sum));
                length1--;
                length2--;
                longerLength--;
            }
        }
        StringBuilder _sb_out = new StringBuilder(output);
        for (int i = finalSum.size() - 1; i >= 0; i--) {
            _sb_out.insert(0, finalSum.get(i));
        }
        if(carry == 1){
            _sb_out.insert(0,1);
        }
        output = _sb_out.toString();
        HugeInteger result = new HugeInteger(output);
        return result;
    }

    //Subtraction function
    public HugeInteger subtract(HugeInteger h) {
        //save initial conditions
        HugeInteger aInit = new HugeInteger(this.toString());
        HugeInteger bInit = new HugeInteger(h.toString());
        
        //Initialize locals
        int number1, number2, sum;
        int carry = 0;
        String output = "";
        ArrayList<String> finalSum = new ArrayList<String>();

        if(this.hugeList.length < h.hugeList.length){
            this.hugeList = this.makeEqual(h);
        }else if(h.hugeList.length < this.hugeList.length){
            h.hugeList = this.makeEqual(h);
        }
        
        
        
        HugeInteger x;
        HugeInteger y;
        int flipTheSwitch=0;
        
        //assign this as larger number
        
        if(this.compareTo(h)==1){
            x=new HugeInteger(this.toString());
            this.hugeList=h.hugeList;
            this.sign=h.sign;
            this.size=h.size;
            h=x;
            flipTheSwitch=1;
        }
        
        int length1 = this.hugeList.length;
        int length2 = h.hugeList.length;
        
        int longerLength = 0;
        if (length1 > length2) {
            longerLength = length1;
        } else {
            longerLength = length2;
        }
        
        //Initialize output to 0s equivalent to max length of output
        for (int i = 0; i < longerLength + 1; i++) {
            finalSum.add("0");
        }
        //While loop that adds each digit
        while (length1 > 0 || length2 > 0) {
            number1 = this.hugeList[length1-1];
            number2 = h.hugeList[length2-1];
            
            if(length1==0){number1=0;}
            if(length2==0){number2=0;}
            sum = number1 - number2 - carry;
            carry = 0;
            //add a carry
            if (sum < 0) {
                carry = 1;
                sum += 10;
            }
            finalSum.set(longerLength, Integer.toString(sum));
            length1--;
            length2--;
            longerLength--;
        }

        longerLength = 0;
        if (length1 > length2) {
            longerLength = length1;
        } else {
            longerLength = length2;
        }

        StringBuilder _sb_out = new StringBuilder(output);

        for (int i = finalSum.size() - 1; i >= 0; i--) {
            _sb_out.insert(0, finalSum.get(i));
        }
        output = _sb_out.toString();
        if (carry == 1){
            _sb_out.insert(0, "1");
            output = _sb_out.toString();
        }
        
        //leading zeros
        String newString = new String();
        for(int i =0;i<output.length();i++){
            if(output.charAt(i)!='0'){
                for(int j=i; j<output.length();j++){
                    newString=newString.concat(""+output.charAt(j));
                }
                break;
            }
        }
        if(newString.equals("")){newString=newString.concat("0");}
        
        this.hugeList=aInit.hugeList;
        this.sign=aInit.sign;
        this.size=aInit.size;
        h=bInit;
        
        
        
        HugeInteger result = new HugeInteger(newString);
        result.sign=flipTheSwitch;
        h=h.clean();
        
        return result;
    }
    
    public HugeInteger clean(){
        String newString = new String();
        for(int i =0;i<this.toString().length();i++){
            if(this.toString().charAt(i)!='0'){
                for(int j=i; j<this.toString().length();j++){
                    newString=newString.concat(""+this.toString().charAt(j));
                }
                break;
            }
        }
        if(newString.equals("")){newString=newString.concat("0");}
        return new HugeInteger(newString);
    }

    //Multiplication function
    public HugeInteger multiply(HugeInteger h){ //repeated addition while loop
        HugeInteger counter = new HugeInteger("0");
        HugeInteger increment = new HugeInteger("1");
        HugeInteger additionPortion = new HugeInteger(this.toString());
        HugeInteger temp = new HugeInteger(this.toString());
        while(!counter.toString().equals(h.toString())){
            temp = temp.add(additionPortion);
            counter = counter.add(increment);
        }
        temp=temp.subtract(additionPortion);
        return temp;
    }
    
    
    //Division function
    public HugeInteger divide(HugeInteger h){
        HugeInteger counter = new HugeInteger("0");
        HugeInteger increment = new HugeInteger("1");
        HugeInteger subtractionPortion = new HugeInteger(h.toString());
        System.out.println("sp"+subtractionPortion.toString());
        HugeInteger temp = new HugeInteger(this.toString());
        while(temp.compareTo(new HugeInteger("0"))==-1){
            subtractionPortion=subtractionPortion.clean();
            System.out.println("temp -> "+temp.toString());
            temp = temp.subtract(subtractionPortion);
            counter = counter.add(increment);
        }
        System.out.println("sp"+subtractionPortion.toString());
        counter=counter.subtract(subtractionPortion);
        counter.subtract(new HugeInteger("2"));
        return new HugeInteger(counter.toString());
    }
    
    //CompareTo function
    public int compareTo(HugeInteger h) {
        //If both signs are positive check which is larger
        if (this.sign == 1 && h.sign == 1) {
            if (this.hugeList.length < h.hugeList.length) {
                return -1;
            } else if (this.hugeList.length == h.hugeList.length) {
                for (int i = 0; i < this.hugeList.length; i++) {
                    if (this.hugeList[i] > h.hugeList[i]) {
                        return 1;
                    }
                    if (this.hugeList[i] < h.hugeList[i]) {
                        return -1;
                    }
                }
                return 0;
            } else {
                return 1;
            }
            //If this is negative and h is positive then h is larger
        } else if (this.sign == 0 && h.sign == 1) {
            return -1;
            //If this is positive and h is negative then this is larger
        } else if (this.sign == 1 && h.sign == 0) {
            return 1;
            //If this is reached, both are negative and so either the one with less digits is larger
        } else {
            if (this.hugeList.length < h.hugeList.length) {
                return 1;
            } //Or the one with a smaller absolute value is larger
            else if (this.hugeList.length == h.hugeList.length) {
                for (int i = 0; i < this.hugeList.length; i++) {
                    if (this.hugeList[i] < h.hugeList[i]) {
                        return 1;
                    }
                    if (this.hugeList[i] > h.hugeList[i]) {
                        return -1;
                    }
                }
                return 0;
            } else {
                return -1;
            }
        }
    }

    //toString function
    public String toString() {
        String string = "";
        //add each digit to the string
        for (int i = 0; i < this.hugeList.length; i++) {
            string = string + this.hugeList[i];
        }
        //if the value is negative, add a negative to front of string
        if (this.sign == 1) {
            string = "-" + string;
        }
        return string;
    }
    
    public int[] makeEqual(HugeInteger h) {
        ArrayList<Integer> dummyList = new ArrayList<Integer>();
        
        if(this.compareTo(h) == -1){
            for(int i = 0; i < this.hugeList.length - h.hugeList.length; i++){
                dummyList.add(0);
            }
            for(int i = h.hugeList.length - 1; i > h.hugeList.length; i-- ){
                dummyList.set(this.hugeList.length - h.hugeList.length + i, h.hugeList[i]);
            }
            for(int i = 0; i < h.hugeList.length; i++){
                dummyList.add(h.hugeList[i]);
            }
        }
        else if(this.compareTo(h) == 1){
            for(int i = 0; i < h.hugeList.length - this.hugeList.length; i++){
                dummyList.add(0);
            }
            for(int i = this.hugeList.length - 1; i > this.hugeList.length; i-- ){
                dummyList.set(h.hugeList.length - this.hugeList.length + i, this.hugeList[i]);
            }
            for(int i = 0; i < this.hugeList.length; i++){
                dummyList.add(this.hugeList[i]);
            }
        }
        int[] outputList = new int[dummyList.size()];
        for(int i = 0; i < outputList.length; i++){
            outputList[i] = dummyList.get(i);
        }
        return outputList;
    }
}
