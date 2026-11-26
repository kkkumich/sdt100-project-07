package part2_trace;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] a=part1_bubble_sort.Main.randomArray(5,new Random(150)); // Seed makes the random example reproducible.
        System.out.println("<p>Random seed: 150</p><p>Initial: "+java.util.Arrays.toString(a)+"</p>");
        for(int end=a.length-1,pass=1;end>0;end--,pass++) {
            boolean swapped=false;
            System.out.println("<h3>Outer loop, iteration "+pass+"</h3><p>Before: "+java.util.Arrays.toString(a)+"</p>");
            for(int j=0;j<end;j++) {
                boolean changed=a[j]>a[j+1];
                if(changed) { int temp=a[j]; a[j]=a[j+1]; a[j+1]=temp; swapped=true; }
                StringBuilder row=new StringBuilder("<p>Inner iteration "+(j+1)+": ");
                for(int k=0;k<a.length;k++) {
                    if(changed && k==j) row.append("<b>");
                    row.append(a[k]).append(' ');
                    if(changed && k==j+1) row.append("</b>");
                }
                System.out.println(row.append(changed?"(swap)</p>":"(no swap)</p>"));
            }
            if(!swapped) { System.out.println("<p>No swaps: early stop.</p>"); break; }
        }
        System.out.println("<p>Sorted: "+java.util.Arrays.toString(a)+"</p>");
    }
}
