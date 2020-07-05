import java.util.*;

class S02_03
{
public static String IntegerToRomanNumeral(int input) {
    if (input < 1 || input > 3999)
        return "null";
    String s = "";
    /*while (input >= 1000) {
        s += "M";
        input -= 1000;        }
    while (input >= 900) {
        s += "CM";
        input -= 900;
    }
    while (input >= 500) {
        s += "D";
        input -= 500;
    }
    while (input >= 400) {
        s += "CD";
        input -= 400;
    }*/
    while (input >= 100) {
        s += "C";
        input -= 100;
    }
    while (input >= 90) {
        s += "XC";
        input -= 90;
    }
    while (input >= 50) {
        s += "L";
        input -= 50;
    }
    while (input >= 40) {
        s += "XL";
        input -= 40;
    }
    while (input >= 10) {
        s += "X";
        input -= 10;
    }
    while (input >= 9) {
        s += "IX";
        input -= 9;
    }
    while (input >= 5) {
        s += "V";
        input -= 5;
    }
    while (input >= 4) {
        s += "IV";
        input -= 4;
    }
    while (input >= 1) {
        s += "I";
        input -= 1;
    }    
    return s;
}
public static void main(String args[])
{
    int s=0,l=0;
    Scanner sc = new Scanner(System.in);
    s=sc.nextInt();
    l=sc.nextInt();
    if((s>l|| s<1) ||l<1)
    {
        System.out.println("invalid input "+s+" "+l);
    }
    else
    {
        HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
        hmap.put('I',0);
        hmap.put('V',0);
        hmap.put('X',0);
        hmap.put('L',0);
        hmap.put('C',0);
        String str;
        int sum=0,b6=0,b4=0;
        for (int i=s;i<=l;i++)
        {
            str=IntegerToRomanNumeral(i);
            if (str!=null)
            {
                for(int j=0;j<str.length();j++)
                {
                    hmap.replace(str.charAt(j),hmap.get(str.charAt(j))+1);
                    if(str.charAt(j)=='I'||str.charAt(j)=='L')
                    {
                        b6++;
                    }
                    else
                    {
                        b4++;
                    }
                }
            }
        }
        
        System.out.println("I "+hmap.get('I'));
        System.out.println("V "+hmap.get('V'));
        System.out.println("X "+hmap.get('X'));
        System.out.println("L "+hmap.get('L'));
        System.out.println("C "+hmap.get('C'));
            
        sum+=b6/6;
        if(b6%6!=0)
            sum++;
        sum+=b4/4;
        if(b4%4!=0)
            sum++;
        System.out.println("TP "+sum);
    }
}
}
