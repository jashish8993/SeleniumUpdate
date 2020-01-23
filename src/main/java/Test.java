import java.util.Arrays;

public class Test {
public static void main(String args[]) throws Exception
{
Sheet s=new Sheet();
String str=Arrays.toString(s.sheetname());
String[] str1=s.sheetname();
//System.out.println(str);
//System.out.println(str1);
for(String gen : s.sheetname())
{
	if(gen!=null)
    System.out.print(gen+ " ");
}

}}

