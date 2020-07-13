package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    //0.Create Value
    static Scanner scanner;
    static int a;   static double x;    static double xi;
    static double[] data;   static double md;   static double xbar;
    static double[] data2;  static int a2;  static double x2;
    static String userinput;  static int userinput2;  static double sd; static double sd2;
    static double q; static double d; static double p;  static double sd2mix;
    static int qint; static int dint; static int pint;
    static double qf; static double df; static double pf;
    static int numberinput; static double qd1; static double qd3;
    static int qd1int; static int qd3int;
    static double qf1; static double qf3;   static double sdresult; static double sdpeopleresult;
    static double qd1result; static double qd3result;

    public static void main(String[] args) {

        Userinput();        //1.Input number length
        LoopUserinput();    //2.Input data
        Sort();             //3.Sort data by min to max
        MinMax();           //4.Show min-max data
        Mean();             //5.Show mean-med
        UsernumberChoice();    //6.Continued?

        while (true) {
            if (userinput.equals("Stop") || userinput.equals("stop") || userinput.equals("0"))
            {
                inputStop();            // If input Stop,0 Stop the program
                break;
            }

            else if (userinput.equals("one") || userinput.equals("One") || userinput.equals("1"))
            {
                CreateValueQDP();          //6.Create int,double,arrays.scanner


                if (numberinput==0)     //6.1.If type "0" ,Stop the program
                {
                    System.out.println("-----Thank you!!-----");
                    break;
                }

                QCalculation();         //6.2.quartile Calculation  (line 184)
                DCalculation();         //6.3.decile Calculation    (line 211)
                PCalculation();         //6.4.percentile Calculation (line 239)
                stop();                 //6.5.Show if you want to stop type "0"
            }

            else if (userinput.equals("two") || userinput.equals("Two") || userinput.equals("2"))
            {
                CreateValueMeasure();   //7.1.Create Value
                Range();                //7.2.Show Max-Min(Range)       (line 268)
                QD();                   //7.3.Show Quartile deviation   (line 284)
                MD();                   //7.4.Show Mean deviation       (line 319)
                SD();                   //7.5.Show Standard deviation and Variance  (line 333)
                CR();
                CQ();
                CM();
                CV();
                ContinuedS2();
                userinput2 = scanner.nextInt();

                if (userinput2==(0))
                {
                    inputStop();            //Show Thank you!
                    break;                  //End the Program
                }

                else if (userinput2==1)
                {
                    S2();
                    S2Calculation();
                    inputStop();
                    break;
                }
            }
            else
            {
                System.out.println();
                System.out.println("Error!");
                break;
            }

        }
    }

    private static void stop()
    {
        System.out.println("If you want to stop type \"0\" ");
        System.out.println("");
        System.out.println("--------------------");
    }

    private static void inputStop()
    {
        System.out.println("");
        System.out.println("-----Thank you!!-----");
    }

    private static void Userinput()
    {
        try
        {
            scanner = new Scanner(System.in);
            System.out.print("Input number of data : ");
            a = scanner.nextInt();
            data = new double[a];
        }
        catch (Exception e)
        {
            System.out.println("Invalid input !");
        }
    }

    private static void LoopUserinput()
    {
        for (int i =0;i<a;i++)
        {
            System.out.print("Data "+(i+1)+" : ");
            data[i] = scanner.nextInt();

        }
    }

    private static void Sort()
    {
        Arrays.sort(data);
        System.out.println("-----PLAYMAKER-----");

        System.out.print("Order number : ");
    }

    //----------------------------------Statistic------------------------------------//

    private static void MinMax()
    {
        for (int i=0;i<a;i++)
        {
            System.out.print(data[i]+" ");
        }
        System.out.println("");
        System.out.println("Min number : "+data[0]);
        System.out.println("Max number : "+data[data.length-1]);
    }

    private static void Mean()
    {
        x = 0;
        for (int i=0;i<a;i++)
        {
            x = x+data[i];
        }

        System.out.println("Mean : "+x/a);

        if (a%2!=0)
        {
            System.out.println("Med : "+data[a/2]);
        }
        else if (a%2==0)
        {
            System.out.println("Med : "+(data[(a-2)/2]+data[a/2])/2.0);
        }
    }

    private static void UsernumberChoice()
    {
        System.out.println("-----Pronphol Tangadulrat-----");
        System.out.println("");
        System.out.println("What do you want to know");
        System.out.println("Type 0 : If you want to stop");
        System.out.println("Type 1 : If ypu want to know quartile,decille,percentile");
        System.out.println("type 2 : If you want to know Measures of Dispersion");
        System.out.println();
        System.out.print("Select functions : ");
        userinput = scanner.next();
    }

    private static void CreateValueQDP()
    {
        System.out.print("Input Position: : ");
        numberinput = scanner.nextInt();
        q = (numberinput * (a + 1)) / 4.0;
        d = (numberinput * (a + 1)) / 10.0;
        p = (numberinput * (a + 1)) / 100.0;

        pint = (numberinput * (a + 1)) / 100; //for data[]
        dint = (numberinput * (a + 1)) / 10;
        qint = (numberinput * (a + 1)) / 4;

        pf = Math.floor((numberinput * (a + 1)) / 100.0);
        df = Math.floor((numberinput * (a + 1)) / 10.0);
        qf = Math.floor((numberinput * (a + 1)) / 4.0);
    }

    private static void QCalculation()
    {
        System.out.println("Position Q" + numberinput + " : " + q);
        if (q<=1)
        {
            System.out.println("null");
        }
        else if (numberinput>=4)
        {
            System.out.println("Q"+numberinput+" : null");
        }

        else if ((q%2.0)-(Math.floor(q%2.0))==0.0)
        {
            System.out.println("Q"+numberinput+" : "+data[qint-1]);
        }

        else if (((numberinput * (a + 1)) / 4.0)%2.0!=0.0)
        {
            double q1 = data[qint]-data[qint-1];
            double q2 = q-qf;
            double q3 = q1*q2;
            double qresult = data[qint-1]+q3;
            System.out.println("Q"+numberinput+" : "+qresult);
        }
    }

    private static void DCalculation()
    {
        System.out.println("");
        System.out.println("Position D" + numberinput + " : " + d);
        if (d<=1)
        {
            System.out.println("null");
        }
        else if (numberinput>=10)
        {
            System.out.println("D"+numberinput+" : null");
        }

        else if ((d%2.0)-(Math.floor(d%2))==0.0)
        {
            System.out.println("D"+numberinput+" : "+data[dint-1]);
        }

        else if (((numberinput * (a + 1)) / 10.0)%2!=0.0)
        {
            double d1 = data[dint]-data[dint-1];
            double d2 = d-df;
            double d3 = d1*d2;
            double dresult = data[dint-1]+d3;
            System.out.println("D"+numberinput+" : "+dresult);
        }
    }

    private static void PCalculation()
    {
        System.out.println("");
        System.out.println("Position P" + numberinput + " : " + p);
        if (p<=1)
        {
            System.out.println("null");
        }
        else if (numberinput>=100)
        {
            System.out.println("P"+numberinput+" : null");
        }
        else if ((p%2.0)-(Math.floor(p%2))==0.0)
        {
            System.out.println("P"+numberinput+" : "+data[pint-1]);
        }

        else if (((numberinput * (a + 1)) / 100.0)%2.0!=0.0)
        {
            double p1 = data[pint]-data[pint-1];
            double p2 = p-pf;
            double p3 = p1*p2;
            double presult = data[pint-1]+p3;
            System.out.println("P"+numberinput+" : "+presult);
        }
    }

    //---------------------------- Measure of Dispersion------------------------------//

    private static void Range()
    {
        System.out.println();
        System.out.println("Range : "+(data[data.length-1]-data[0]));
    }
    private static void CreateValueMeasure()
    {
        qd1 = (1*(a+1))/4.0;
        qd1int = (1*(a+1))/4;
        qf1 =  Math.floor((1 * (a + 1)) / 4.0);

        qd3 = (3*(a+1))/4.0;
        qd3int = (3*(a+1))/4;
        qf3 =  Math.floor((3 * (a + 1)) / 4.0);
    }

    private static void QD()
    {
        if ((qd1%2.0)-(Math.floor(qd1%2.0))==0.0)
        {
            qd1result = data[qd1int-1];
            //System.out.println("Q1 : "+qd1result); For show Q1
        }

        else if (((1 * (a + 1)) / 4.0)%2.0!=0.0)
        {
            double q1 = data[qd1int]-data[qd1int-1];
            double q2 = qd1-qf1;
            double q3 = q1*q2;
            qd1result = data[qd1int-1]+q3;
            //System.out.println("Q1 : "+qd1result);    For show Q1
        }

        if ((qd3%2.0)-(Math.floor(qd3%2.0))==0.0)
        {
            qd3result = data[qd3int-1];
            //System.out.println("Q3 : "+qd3result);    For show Q3
        }

        else if (((3 * (a + 1)) / 4.0)%2.0!=0.0)
        {
            double q1 = data[qd3int]-data[qd3int-1];
            double q2 = qd3-qf3;
            double q3 = q1*q2;
            qd3result = data[qd3int-1]+q3;
            //System.out.println("Q3 : "+qd3result);    For show Q3
        }
        double QDresult = ((qd3result-qd1result)/2);
        System.out.println("Q.D. : "+QDresult);
    }

    private static void MD()
    {
        xbar = x/a;
        xi = 0;
        //System.out.println("Mean : "+xbar);   For show Mean

        for (int i=0;i<a;i++)
        {
            xi = Math.abs(xbar-data[i])+xi;
        }
        md = (xi/a);
        System.out.println("M.D. : "+md);
    }

    private static void SD()
    {
        sd = 0;
        for (int i=0;i<a;i++)
        {
            sd = Math.pow((data[i]-xbar),2)+sd;
        }
        sdresult = Math.sqrt((sd/(a-1)));
        System.out.println("S.D. : "+sdresult);
        sdpeopleresult = Math.sqrt((sd/(a)));
        System.out.println("S.D.(People) : "+sdpeopleresult);
        System.out.println("Variance : "+sd/(a-1));
        System.out.println("Variance (People) : "+sd/(a));
    }

    private static void CR()
    {
        System.out.println();
        double cr;
        cr = (data[data.length-1]-data[0])/(data[data.length-1]+data[0]);
        System.out.println("C.R. : "+cr);
    }

    private static void CQ()
    {
        double cq = ((qd3result-qd1result)/(qd3result+qd1result));
        System.out.println("C.Q. : "+cq);
    }

    private static void CM()
    {
        double cm = (md/xbar);
        System.out.println("C.M. : "+cm);
    }

    private static void CV()
    {
        double cvpeople = (sdpeopleresult/xbar);
        double cv = (sdresult/xbar);
        System.out.println("C.V. : "+cv);
        System.out.println("C.V. (People): "+cvpeople);
    }

    //------------------------Variance 2---------------------------//

    private static void ContinuedS2()
    {
        System.out.println();
        System.out.println("Type 0 : If you want to Exit");
        System.out.println("Type 1 : If you want Combined Variance");
        System.out.print("Select functions : ");
    }

    private static void S2()
    {
        System.out.println();
        System.out.print("Input number of data : ");
        a2 = scanner.nextInt();
        data2 = new double[a2];
        for (int i=0;i<a2;i++)
        {
            System.out.print("Data #2 "+(i+1)+" : ");
            data2[i] = scanner.nextInt();
        }
        Arrays.sort(data2);
    }

    private static void S2Calculation()
    {
        x2 = 0;
        for (int i=0;i<a2;i++)
        {
            x2 = x2+data2[i];
        }

        double xbar1 = x/a;
        double xbar2 = x2/a2;
        double xbarmix = ((a*xbar1)+(a2*xbar2)/(a+a2));
        System.out.println();
        //System.out.println("Mean : "+xbar1);
        //System.out.println("Mean2 : "+xbar2);

        sd2 = 0;
        for (int i=0;i<a2;i++)
        {
            sd2 = Math.pow((data2[i]-(x2/a2)),2)+sd2;
        }

        double v1 = sd/a;
        double v2 = sd2/a2;

        System.out.println("Variance (People) : "+v1);
        System.out.println("Variance 2(People) : "+v2);

        if ((xbar1)==(xbar2))
        {
            sd2mix = ((a*v1)+(a2*v2))/(a+a2);
            System.out.println("Combined Variance : "+sd2mix);
        }

        else if ((xbar1)!=(xbar2))
        {
            sd2mix = ((a*v1)+(a2*v2)+(a*Math.pow((xbar1-xbarmix),2))+(a2*Math.pow((xbar2-xbarmix),2)))/(a+a2);
            System.out.println("Combined Variance : "+sd2mix);
        }
    }
}
//PLAYMAKER