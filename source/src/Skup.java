import java.io.*;

public class Skup {

	public static void main(String[] args) {
		
		 int locus1;
		 int locus2;
		 int locus3;
		 int locus4;
		 double[] r= new double[2];
		 double b;
		 String s;

		 try {
			 PrintStream fout=new PrintStream("Locusi.csv");
		
		double[] niz=new double[20];	 
		for(int i=0; i<20; i++)	 {
			niz[i]=Math.random();
		}
		
		  int jedinica=0;
		  int nula=0;
		  
		  s= "X1" + "," + "X2" + "," + "X3" + "," + "X4" + "," + "X5" + "," + "X6" + "," + "X7" + "," + "X8" + "," + "X9" + "," + "X10" + "," + "X11" + "," + "X12" + "," + "X13" + "," + "X14" + "," + "C";
		  
		  fout.println(s);
		  
		  s="";
		  
		  char[] d=new char[2];
		  
		  
//random generisanje nula i jedinica		  
			 	 
		while(nula<200){
			
			s="";
			int m=0;
			
		 for(int i=0; i<20; i++){
			 double a=Math.random();
			 if (a>niz[i]){
				 d[m]='A';
				 m+=1;
			 }
			   else { 
				   d[m]='a';
				   m+=1;
			   }
			 if(i%2==1) { 
				 if(d[0]=='a' && d[1]=='A'){
					 d[0]='A';
					 d[1]='a';
				 }
				 
				 s+=(" " + d[0] + d[1] + ",");
				 m=0;
		}
			 }
		 
		 fout.print(s);
		 
		 s=" ";
				          
		 char[] zn=new char[8];
		 for(int i=0; i<8; i++){
		 double a=Math.random();
		 if (a>0.5) 
			 zn[i]='A';
		 else 
			 zn[i]='a';
		 }
	     
		 if((zn[0]=='a') &&(zn[1]=='A')){
			 zn[0]='A';
			 zn[1]='a';
		 }
		 
		 if((zn[2]=='a') && (zn[3]=='A')){
			 zn[2]='A';
			 zn[3]='a';
		 }
	    
		 if((zn[4]=='a') && (zn[5]=='A')){
			 zn[4]='A';
			 zn[5]='a';
		 }
		 
		 if((zn[6]=='a') && (zn[7]=='A')){
			 zn[6]='A';
			 zn[7]='a';
		 }
		
		 
		 fout.print(" " + zn[0] + zn[1]+ ", " + zn[2] + zn[3]+ ", " + zn[4] + zn[5] + ", " + zn[6] + zn[7] + ", ");
		 
		 if(zn[0]==zn[1]) locus1=0;
		 else locus1=1;
		 
		 if(zn[2]==zn[3]) locus2=0;
		 else locus2=1;
		 
		 if(locus1!=locus2) r[0]=0.1;
		 else r[0]=0;
		 
//modifikacija za dve tabele
		 
		 if(zn[4]==zn[5]) locus3=0;
		 else locus3=1;
		 
		 if(zn[6]==zn[7]) locus4=0;
		 else locus4=1;
		 
		 if(locus3!=locus4) r[1]=0.1;
		 else r[1]=0;
		 
		 int[] c=new int[2];
		 
		 for(int i=0; i<2; i++){ 
		 b=Math.random();
		 if(b<=r[i])
			c[i]=1;
		 else 
			c[i]=0;
		  }
		
		int rez;
		
		if((c[0]==1) || (c[1]==1)){
			rez=1;
			jedinica+=1;
		}
			else {
				rez=0;
			    nula+=1;
		}

		fout.print(rez);
		fout.println();
		}
		 		 
//kontrolisano generisanje jedinica do 300
		
	     int l = 0;
		 while(l<(100-jedinica)){	
			 
			 s="";
			 int m=0;
			 
		 for(int i=0; i<20; i++){
			 double a=Math.random();
			 if (a>niz[i]){
				 d[m]='A';
				 m+=1;
			 }
			   else { 
				   d[m]='a';
				   m+=1;
			   }
			 if(i%2==1) { 
				 if(d[0]=='a' && d[1]=='A'){
					 d[0]='A';
					 d[1]='a';
				 }
				 
				 s+=" " + d[0] + d[1] + ",";
				 m=0;
		}
			 }
		 
		
			 char[] zn=new char[8];
			 for(int i=0; i<8; i++){
			 double a=Math.random();
			
			 if (a>0.5) 
				 zn[i]='A';
			 else 
				 zn[i]='a';
			 }
		    
			 if((zn[0]=='a') &&(zn[1]=='A')){
				 zn[0]='A';
				 zn[1]='a';
			 }
			 
			 if((zn[2]=='a') && (zn[3]=='A')){
				 zn[2]='A';
				 zn[3]='a';
			 }
		    
			 if((zn[4]=='a') &&(zn[5]=='A')){
				 zn[4]='A';
				 zn[5]='a';
			 }
			 
			 if((zn[6]=='a') && (zn[7]=='A')){
				 zn[6]='A';
				 zn[7]='a';
			 }
			
			 
			 s+= " " + zn[0] + zn[1]+ "," + zn[2] + zn[3]+ "," + zn[4] + zn[5] +"," + zn[6] + zn[7]+ ",";
			 
			 if(zn[0]==zn[1]) locus1=0;
			 else locus1=1;
			 
			 if(zn[2]==zn[3]) locus2=0;
			 else locus2=1;
			 
			 if(locus1!=locus2) r[0]=0.1;
			 else r[0]=0;
			 
			 if(zn[4]==zn[5]) locus3=0;
			 else locus3=1;
			 
			 if(zn[6]==zn[7]) locus4=0;
			 else locus4=1;
			 
			 if(locus3!=locus4) r[1]=0.1;
			 else r[1]=0;
			 
			 int[] c=new int[2];
			 
			for(int i=0; i<2; i++){ 
			b=Math.random();
			if(b<=r[i])
				c[i]=1;
			else 
				c[i]=0;
			}
			
			int rez;
			
			if((c[0]==1) || (c[1]==1))
				rez=1;
			else
				rez=0;
			
		    s+=rez;
		 
		    if(rez==1){
			  fout.println(s);
		      l+=1;
		  }
			 }
		 
// generisanje ostalih 100 jedinica
		 
		 l=0;
		 while(l<100){
				s="";
				int m=0;
				 for(int i=0; i<20; i++){
					 double a=Math.random();
					 if (a>niz[i]){
						 d[m]='A';
						 m+=1;
					 }
					   else { 
						   d[m]='a';
						   m+=1;
					   }
					 if(i%2==1) { 
						 if(d[0]=='a' && d[1]=='A'){
							 d[0]='A';
							 d[1]='a';
						 }
						 
						 s+=" " + d[0] + d[1] + ",";
						 m=0;
				}
					 } 
				
		 char[] zn=new char[8];
		 
		 for(int i=0; i<8; i++){
		 double a=Math.random();
		
		 if (a>0.5) 
			 zn[i]='A';
		 else 
			 zn[i]='a';
		 }
	     
		 if((zn[0]=='a') &&(zn[1]=='A')){
			 zn[0]='A';
			 zn[1]='a';
		 }
		 
		 if((zn[2]=='a') && (zn[3]=='A')){
			 zn[2]='A';
			 zn[3]='a';
		 }
	    
		 if((zn[4]=='a') &&(zn[5]=='A')){
			 zn[4]='A';
			 zn[5]='a';
		 }
		 
		 if((zn[6]=='a') && (zn[7]=='A')){
			 zn[6]='A';
			 zn[7]='a';
		 }
		
		 
		 s+= " " + zn[0] + zn[1]+ "," + zn[2] + zn[3]+ "," + zn[4] + zn[5] +"," + zn[6] + zn[7]+ ",";
		 
		 if(zn[0]==zn[1]) locus1=1;
		 else locus1=0;
		 
		 if(zn[2]==zn[3]) locus2=1;
		 else locus2=0;
		 
		 if(zn[4]==zn[5]) locus3=1;
		 else locus3=0;
		 
		 if(zn[6]==zn[7]) locus4=1;
		 else locus4=0;
		 		 
		 int[] c=new int[2];
		 int rez;
		 
		 if(locus1==locus2)
			 c[0]=1;
		 if (locus3==locus4)
			 c[1]=1;
		 if((c[0]==1) && (c[1]==1)) 
			 rez=1;
		 else
			 rez=0;
		 s+=rez;
				  
		 if (rez==1) {
			 fout.println(s);
			 l=l+1;
		 }
		 
		 }
		 
		 } catch (FileNotFoundException e) {

				  System.out.println("Greska pri otvaranju datoteke!");
				}		
	}
}
