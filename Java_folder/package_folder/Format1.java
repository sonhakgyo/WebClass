package Java_folder.package_folder;
//에러 : The type java.text.NumberFormat cannot be resolved.
import java.text.DecimalFormat;

public class Format1 {
    public static void main(String[] args) {
        String[] pattern = {
            "###,###",
            "000.000",
            "-###.###",
            "000000,00%"
        }; //숫자값을 지정한 형식으로 출력하고 싶을 때 사용하는 Formatting

        double[] arr = {
            1.3,
            3.33,
            124.243,
            242
        };

        for(int p = 0; p < pattern.length; p++) {
            DecimalFormat d = new DecimalFormat(pattern[p]);
            System.out.println("<<<" + pattern[p] + ">>>");
            for(int i = 0; i < arr.length; i++) {
                //System.out.println(d.format(arr[i], null, null));
                //System.out.println(d.format(arr[i], null, null));
                //System.out.println(d.format(arr[i], null, null));
            }
        }
    }
}
