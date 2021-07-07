import java.util.*;
import java.io.*;
import static java.lang.System.out;

class task1{
    public static void main(String [] args) throws Exception{
      //  args = new String [] {"txt.txt"};
        
        float sum = 0;
        int size = 0;
        float t;
        
        try(Scanner scan = new Scanner(new File(args[0]))){
            List<Float> list = new ArrayList<>();
            while (scan.hasNext()){
                t = (scan.nextFloat());
                sum += t;
                size += 1;
                list.add(t);
            }
            Collections.sort(list);
            
        float k = (float)((size - 1) * 0.9);
        int f = (int)Math.floor(k);
        int c = (int)Math.ceil(k);
        if (f == c){
            out.printf("%.2f\n", list.get(f));
        }
        else{
            out.printf("%.2f\n", list.get(f)*(((float)c)-k)+list.get(c)*(((float)k)-f));
        }
        
        if ((size%2)==0){
            out.printf("%.2f\n", (float)(list.get((int)(size/2))+list.get(((int)(size/2))-1))/2);
        }
        else{
            out.printf("%.2f\n", list.get((int)(size/2)));
        }
        
        out.printf("%.2f\n", list.get(size - 1));
        out.printf("%.2f\n", list.get(0));
        out.printf("%.2f\n", sum / size);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("usage: java task <file1>");
        }
    }
}

class task2{
   public static void main(String [] args) throws Exception{
        
   //     args = new String[] {"txt1.txt", "txt2.txt"};
        
        try(Scanner scan = new Scanner(new File(args[0]));
        Scanner scan2 = new Scanner(new File(args[1]))
        
        ){
        
        float x1 = scan.nextFloat();
        float y1 = scan.nextFloat();
        float x2 = scan.nextFloat();
        float y2 = scan.nextFloat();
        float x3 = scan.nextFloat();
        float y3 = scan.nextFloat();
        float x4 = scan.nextFloat();
        float y4 = scan.nextFloat();
        
        float b1 = (y2 - y1) / (x2 - x1);
        float b2 = (y3 - y2) / (x3 - x2);
        float b3 = (y4 - y3) / (x4 - x3);
        float b4 = (y1 - y4) / (x1 - x4);
        
        float a1 = (x2 * b1 - y2) / b1;
        float a2 = (x3 * b2 - y3) / b2;
        float a3 = (x4 * b3 - y4) / b3;
        float a4 = (x1 * b4 - y1) / b4;
    
        while (scan2.hasNext()){
            
            float a = scan2.nextFloat();
            float b = scan2.nextFloat();
            if (
            (a == x1 && b == y1) ||
            (a == x2 && b == y2) ||
            (a == x3 && b == y3) ||
            (a == x4 && b == y4)){
                out.println(0);
            } 
            
            else if (
            ((((x1==x2)&&(x1==a))||((y1==y2)&&(y1==b))||((a-a1)*b1==b))
            &&(((x1<x2)&&(x1<a)&&(x2>a))||((x1>x2)&&(x1>a)&&(x2<a))
            ||((y1<y2)&&(y1<a)&&(y2>a))||((y1>y2)&&(y1>a)&&(y2<a))))&&
            
            ((((x2==x3)&&(x2==a))||((y2==y3)&&(y2==b))||((a-a2)*b2==b))
            &&(((x2<x3)&&(x2<a)&&(x3>a))||((x2>x3)&&(x2>a)&&(x3<a))
            ||((y2<y3)&&(y2<a)&&(y3>a))||((y2>y3)&&(y2>a)&&(y3<a))))&&
            
            ((((x3==x4)&&(x3==a))||((y3==y4)&&(y3==b))||((a-a3)*b3==b))
            &&(((x3<x4)&&(x3<a)&&(x4>a))||((x3>x4)&&(x3>a)&&(x4<a))
            ||((y3<y4)&&(y3<a)&&(y4>a))||((y3>y4)&&(y3>a)&&(y4<a))))&&
            
            ((((x4==x1)&&(x4==a))||((y4==y1)&&(y4==b))||((a-a4)*b4==b))
            &&(((x4<x1)&&(x4<a)&&(x1>a))||((x4>x1)&&(x4>a)&&(x1<a))
            ||((y4<y1)&&(y4<a)&&(y1>a))||((y4>y1)&&(y4>a)&&(y1<a))))
            
            ){
                out.println(1);
            }
            else{
                boolean c1 = false;
                boolean c2 = false;
                if ((((y1<y2)&&(y1<b)&&(y2>b))||((y1>y2)&&(y1>b)&&(y2<b)))){
                    if (x1 == x2){
                        if (x1 > a){
                            c2 = true;
                        }
                        else c1 = true;
                    }
                    else if (((b / b1) + a1) > a) c2 = true;
                    else c1 = true;
                }
                if ((((y2<y3)&&(y2<b)&&(y3>b))||((y2>y3)&&(y2>b)&&(y3<b)))){
                    if (x2 == x3){
                        if (x2 > a) c2 = true;
                        else c1 = true;
                    }
                    else if (((b / b2) + a2) > a) c2 = true;
                    else c1 = true;
                }
                
                if ((((y3<y4)&&(y3<b)&&(y4>b))||((y3>y4)&&(y3>b)&&(y4<b)))){
                    if (x3 == x4){
                        if (x3 > a){
                            c2 = true;
                        }
                        else c1 = true;
                    }
                    else if (((b / b3) + a3) > a) c2 = true;
                    else c1 = true;
                }
                if ((((y4<y1)&&(y4<b)&&(y4>b))||((y4>y1)&&(y4>b)&&(y1<b)))){
                    if (x4 == x1){
                        if (x4 > a) c2 = true;
                        else c1 = true;
                    }
                    else if (((b / b4) + a4) > a) c2 = true;
                    else c1 = true;
                }
                
                if (!(c1 && c2)){
                    out.println(3);
                    continue;
                }
                c2 = false;
                c1 = false;
                
                if ((((x1<x2)&&(x1<a)&&(x2>a))||((x1>x2)&&(x1>a)&&(x2<a)))){
                    if (y1 == y2){
                        if (y1 > b){
                            c2 = true;
                        }
                        else {
                            c1 = true;
                        }
                    }
                    if (((a-a1)*b1) > b) c2 = true;
                    else c1 = true;
                }
                
                if ((((x2<x3)&&(x2<a)&&(x3>a))||((x2>x3)&&(x2>a)&&(x3<a)))){
                    if (y2 == y3){
                        if (y2 > b){
                            c2 = true;
                        }
                        else {
                            c1 = true;
                        }
                    }
                    if (((a-a2)*b2) > b) c2 = true;
                    else c1 = true;
                }
                
                if ((((x3<x4)&&(x3<a)&&(x4>a))||((x3>x4)&&(x3>a)&&(x4<a)))){
                    if (y3 == y4){
                        if (y3 > b){
                            c2 = true;
                        }
                        else {
                            c1 = true;
                        }
                    }
                    if (((a-a3)*b3) > b) c2 = true;
                    else c1 = true;
                }
                
                if ((((x4<x1)&&(x4<a)&&(x1>a))||((x4>x1)&&(x4>a)&&(x1<a)))){
                    if (y4 == y1){
                        if (y4 > b){
                            c2 = true;
                        }
                        else{
                            c1 = true;
                        }
                    }
                    if (((a-a4)*b4) > b) c2 = true;
                    else c1 = true;
                }
                
                if (!(c1 && c2)){
                    out.println(3);
                    continue;
                }
                
                out.println(2);
                
            }
            
        }
        
    }
    catch(ArrayIndexOutOfBoundsException e){
        System.out.println("usage: java task <file1> <file2>");
    }
        
    }
}


class task3{
    public static void main(String [] args) throws Exception{
       try(Scanner scan1 = new Scanner(new File(args[0]));
        Scanner scan2 = new Scanner(new File(args[1]));
        Scanner scan3 = new Scanner(new File(args[2]));
        Scanner scan4 = new Scanner(new File(args[3]));
        Scanner scan5 = new Scanner(new File(args[4]))
        ){
            float max = 0;
            int no = 1;
            float v = 0;
            for (int i = 1; i < 17; i++){
                v =  scan1.nextFloat() + scan2.nextFloat() +
                + scan3.nextFloat() + scan4.nextFloat() +
                + scan5.nextFloat();
                if (v > max){
                    max = v;
                    no = i;
                }
            }
            System.out.println(no);
        }
        
    catch(ArrayIndexOutOfBoundsException e){
        System.out.println("usage: java task <file1> <file2> <file3> <file4> <file5>");
    }
        
    }
}

class task4{
    static class cucle{
        public int min = 0;
        public int max = 0;
        public cucle next = null;
    }
    
    private static int toMins(String s) {
       String[] hourMin = s.split(":");
       return 60 * Integer.parseInt(hourMin[0]) + Integer.parseInt(hourMin[1]);
    }
    
    public static void main(String [] args) throws Exception{
      //  args = new String [] {"txt.txt"};
        try(Scanner scan = new Scanner(new File(args[0]))){
            cucle lop = new cucle();
            cucle v = lop;
            final cucle base = lop;
            int cucle_len = 0;
            while (scan.hasNext()){
                lop = v;
                lop.min = toMins(scan.next());
                lop.max = toMins(scan.next());
                v = new cucle();
                lop.next = v;
                cucle_len += 1;
            }
            lop.next = base;
            
            int max = -1;
            int c = 0;
            
            boolean refresh = false;
            
            ArrayList<Integer> list  = new ArrayList(10);
            
            int min = 0;
            int start_time = 0;
            
            for (int i = 480; i <= 1600; i++){
                c = 0;
                for (int j = 0; j < cucle_len; j ++){
                    v = lop.next;
                    lop = v;
                    if (i > lop.min && i <= lop.max){
                        c += 1;
                    }
                }
                if (c > max) max = c;
            }
            refresh = true;
            for (int i = 480; i <= 1600; i++){
                c = 0;
                for (int j = 0; j < cucle_len; j ++){
                    v = lop.next;
                    lop = v;
                    if (i >= lop.min && i < lop.max){
                        c += 1;
                    }
                }
                if (c == max){
                    if (refresh){
                        start_time = i;
                        refresh = false;
                    }
                }
                else{
                    if (!refresh){
                        refresh = true;
                        list.add(start_time);
                        list.add(i);
                    }
                }
            }
            
            refresh = false;
            for (int i: list){
                out.printf("%d:%02d ", i / 60, i % 60);
                if (refresh) out.println();
                refresh = !refresh;
            }
            
        }
        catch(ArrayIndexOutOfBoundsException e){
           System.out.println("usage: java task <file1>");
        }
    }
}
