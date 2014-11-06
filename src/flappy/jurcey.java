package flappy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class jurcey 
{
	static int[] ar;
	static Hashtable<Integer, Integer> f;
	static int ans;
	static ArrayList<Integer> p;
	public static void main (String args[])
	{
		Scanner s=new Scanner(System.in);
		p=new ArrayList<Integer>();
		int n=s.nextInt();
		int[] ar=new int[n];
		f=new Hashtable<Integer,Integer>();
		for(int i=0;i<n;i++)
		{
			ar[i]=s.nextInt();
			if(f.containsKey(ar[i]))
			{
				int tmp1=f.get(ar[i]);
				f.put(ar[i], tmp1+1);
			}
			else
			{
				f.put(ar[i],1);
			}
			ans+=ar[i];
		}
		
		Arrays.sort(ar);

		for(int i=n-1;i>=0;i--)
		{
			if(!p.contains(ar[i]))
			p.add(ar[i]);
		}
		p.add(0);
		System.out.println(f+" "+ans);
		try{
		ans1();
		}
		catch(Exception e)
		{
			
		}
		System.out.println(ans);
		
	}
	
	public static void ans1()
	{	
		if(p.get(0)==p.get(p.size()-1))
		{
			while(!p.isEmpty())
			p.remove(p.get(0));
			return;
		}
		if(p.size()==2)
		{	
			if(p.get(1)<p.get(0))
				ans-=p.get(1);
			
			return;
		}
		if(p.size()==1)
			return;
		int tmp=1;
		int a1=getf(tmp)*p.get(tmp)-getf(tmp+1)*p.get(tmp+1);
		for(int i=1;i<p.size();i++)
		{
//			int tmp6=getf(i);
//			int tmp5=f.get(p.get(i));
//			f.put(p.get(i),tmp5-tmp6);
//			System.out.println(f+" "+p.get(i)+" "+(tmp5-tmp6));
//			
			int tmp3=getf(i)*p.get(i)-getf(i+1)*p.get(i+1)-getf(1)*p.get(1)+getf(2)*p.get(2);
			if(tmp3>a1)
			{
				tmp=i;
				a1=tmp3;
			}
//			System.out.println(f+" "+p.get(i)+" "+(tmp5)+" "+a1+" "+tmp3);
//			f.put(p.get(i),tmp5);
//			
			
		}
		ans-=getf(tmp)*p.get(tmp);
		
		System.out.println(getf(tmp));
		
		for(int d=0;d<getf(tmp);d++)
		p.remove(p.get(tmp));
		System.out.println(p+" "+tmp+" "+p.get(tmp));
		
		
		
		int tmp6=getf(tmp);
		int tmp5=f.get(p.get(tmp));
		f.put(p.get(tmp),tmp5-tmp6);
		
		for(int d=0;d<f.get(p.get(0));d++)
			p.remove(d);
		
		System.out.println(f+" "+p.get(tmp)+" "+getf(tmp)+" "+a1+" "+p+"sdcsdc");
		
		
		ans1();
		
		
	}
	
	public static int getf(int a)
	{
		if(f.get(p.get(a))>f.get(p.get(0)))
		{
			return f.get(p.get(0));
		}
		
		return f.get(p.get(a)); 
	}
	
	
}
