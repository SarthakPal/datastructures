package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
public class AddOneToNumber {

        public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
            //ArrayList<Integer> A=new ArrayList<>();
            int count=0;
            ArrayList<Integer> res = new ArrayList<>();

            if(A.size()==1 && A.get(0)==0)
            {
                res.add(1);
                return res;
            }

            for(Integer i:A)
            {
                if(i==0)
                {
                    count++;
                }
                else{
                    break;
                }
            }

            Collections.reverse(A);

            int num=0;
            int sum=0;
            int carry=0;
            for(int i=0;i<A.size()-count;i++)
            {
                num=A.get(i);
                // System.out.println("num:"+num);
                if(i==0)
                {
                    sum=num+1;
                    //System.out.println("sum:"+sum);
                    if(sum<10)
                    {
                        res.add(sum);
                        carry=0;
                    }
                    else
                    {
                        res.add(sum%10);
                        carry=1;
                    }
                }
                else{
                    sum=num+carry;
                    if(sum<10)
                    {
                        res.add(sum);
                        carry=0;
                    }
                    else
                    {
                        res.add(sum%10);
                        carry=sum/10;
                    }
                }
            }

            if(carry!=0)
            {
                res.add(carry);
            }
            Collections.reverse(res);
            return res;
        }
    }



