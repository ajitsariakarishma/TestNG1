package MavenFirst;

public class ConvertingString {
    public static int  convertString(String number){
       int convert_string=Integer.parseInt(number);
       return convert_string;

    }
    public static double convertToDouble(String num){
        double num1=Double.parseDouble(num);
        return num1;

    }


    public static void main(String[] args) {

    int x = convertString("10");
        System.out.println("String value is converted to integer: "+x);
    double y=convertToDouble("10.20")  ;
        System.out.println("String value converted to double: "+y);
      // validating concersion
        int a = x+10;
        double b = y+20;
        System.out.println("Adding 10 to "+x+ " gives : "+a);
        System.out.println("Adding 20 to "+y+ " gives : "+b);
    }
}
