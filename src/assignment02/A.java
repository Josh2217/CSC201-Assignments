interface A{static<T>void p(T t){System.out.println(t);}static void main(String[]h){int a,b,c,i=0,x;var s=new java.util.Scanner(System.in);p("Enter3Ints:");a=s.nextInt();b=s.nextInt();c=s.nextInt();p("sum_"+(x=a+b+c)+"\navg_"+x/3d+"\nprod_"+a*b*c);p(a>b?"#1>#2":"#2>=#1");p(a+b>=c?"SumWins":"#3sHefty");p((a&b&c&1)==1?"HowOdd":"LuckyDuck");while(i<5)p(++i);s.close();}}