
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;


public class HeteroGenerator {
	
	public static void main(String args[]){
		int model1 = 1;
		int model2 = 1;
		HeteroGenerator generator = new HeteroGenerator(model1, model2);
		
		try {
			generator.generate();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public double[] mafs = new double[10];
	public Random random = new Random();
	public double[] penetrances1 = new double[9];
	public double[] penetrances2 = new double[9];
	
	public int model1;
	public int model2;
	
	public HeteroGenerator(int model1, int model2){
		this.model1 = model1;
		this.model2 = model2;
		
		createPentrances(penetrances1, model1);
		createPentrances(penetrances2, model2);

		createMafs(model1, model2);
	}
	
	public Random status1Random = new Random();
	public Random status2Random = new Random();

	
	public void generate() throws FileNotFoundException{
		
		int c1=0;
		int c2=0;

		PrintStream fout=new PrintStream("Model"+model1+"_"+model2+".csv");
		String  head= "X1" + "," + "X2" + "," + "X3" + "," + "X4" + "," 
			+ "X5" + "," + "X6" + "," + "X7" + "," + "X8" + "," + "X9" + "," + "X10," + "C";
		fout.println(head);
		int cases=0;
		int controls = 0;
		
		while(controls<200){
			String s="";
			for(int j=0; j<10; j++){
				s += generateOneNp(mafs[j])+',';
			}
			int thisCase1 = getStatus1(s, penetrances1);
			int thisCase2 = getStatus2(s, penetrances2);
			System.out.println("-------");
			int thisCase =0;
			
			if(thisCase1==1) c1++;
			if(thisCase2==1) c2++;
			if(thisCase1 ==1&&thisCase2 ==1) {
				continue;
			}
			if(thisCase1 ==1 || thisCase2 ==1){
				cases++;
				thisCase = 1;
			}
			
			else controls++;
			s+=thisCase;
			//System.out.println(s);
			fout.println(s);
		}
		//System.out.println(cases);
		
		while(cases<100){
			String s="";
			for(int j=0; j<10; j++){
				s += generateOneNp(mafs[j])+',';
			}
			int thisCase1 = getStatus1(s, penetrances1);
			int thisCase2 = getStatus2(s, penetrances2);

			System.out.println("-------");
			if(thisCase1 ==1&&thisCase2 ==1) {
				continue;
			}
			
			if(thisCase1 ==1||thisCase2==1){
				cases++;
				s+=1;
				System.out.println(s);
				fout.println(s);
			}
			if(thisCase1==1) c1++;
			if(thisCase2==1) c2++;
		}
		controls = 0;
		while(controls<100){
			String s="";
			for(int j=0; j<10; j++){
				s += generateOneNp(mafs[j])+',';
			}
			int thisCase1 =0;// assesRisk(model1,getIndex1(s,penetrances1));
			int thisCase2 =0;// assesRisk(model2,getIndex2(s,penetrances2));
			
			if(thisCase1 ==0 && thisCase2==0){
				controls++;
				s+=1;
				//System.out.println(s);
				fout.println(s);
			}
		}
		System.out.println(c1);
		System.out.println(c2);
		
	}
		
	public String generateOneNp(double maf){
		
		char father;
		double p =random.nextDouble();
		if(p>maf){
			father = 'A';
		}else{
			father='a';
		}
		
		char mother;
		p =random.nextDouble();
		if(p>maf){
			mother = 'A';
		}else{
			mother ='a';
		}
		String s = ""+father+mother;
		if(s.equals("aA")) s="Aa";
		
		return s;
	}
	
	public int getStatus1(String snps, double[] penetrances){
		
		String active = snps.substring(24);
		
		int index =-1;
		if(active.equals("AA,AA,")) index = 0;
		if(active.equals("AA,Aa,")) index = 1;
		if(active.equals("AA,aa,")) index = 2;
		if(active.equals("Aa,AA,")) index = 3;
		if(active.equals("Aa,Aa,")) index = 4;
		if(active.equals("Aa,aa,")) index = 5;
		if(active.equals("aa,AA,")) index = 6;
		if(active.equals("aa,Aa,")) index = 7;
		if(active.equals("aa,aa,")) index = 8;
		
		double penetrance = penetrances1[index];
		double outcome = status1Random.nextDouble();
		int n=-1;
		if(outcome<penetrance){
			n= 1;
		}else
			n= 0;
		System.out.println(active+" "+n);
		return n;
	}
	
	public int getStatus2(String snps, double[] penetrances){
		
		String active = snps.substring(18,24);
	///System.out.println(active);
		int index =-1;
		if(active.equals("AA,AA,")) index = 0;
		if(active.equals("AA,Aa,")) index = 1;
		if(active.equals("AA,aa,")) index = 2;
		if(active.equals("Aa,AA,")) index = 3;
		if(active.equals("Aa,Aa,")) index = 4;
		if(active.equals("Aa,aa,")) index = 5;
		if(active.equals("aa,AA,")) index = 6;
		if(active.equals("aa,Aa,")) index = 7;
		if(active.equals("aa,aa,")) index = 8;
		
		double penetrance = penetrances2[index];
		double outcome = status2Random.nextDouble();
		int n=-1;
		if(outcome<penetrance){
			n= 1;
		}else
			n= 0;
		System.out.println(active+" "+n);
		return n;
	}

	public int getIndex1(String snps, double[] penetrances){
		String active = snps.substring(24);
		int index =-1;
		if(active.equals("AA,AA,")) index = 0;
		if(active.equals("AA,Aa,")) index = 1;
		if(active.equals("AA,aa,")) index = 2;
		if(active.equals("Aa,AA,")) index = 3;
		if(active.equals("Aa,Aa,")) index = 4;
		if(active.equals("Aa,aa,")) index = 5;
		if(active.equals("aa,AA,")) index = 6;
		if(active.equals("aa,Aa,")) index = 7;
		if(active.equals("aa,aa,")) index = 8;
		
		return index;
	}
	
	public int getIndex2(String snps, double[] penetrances){
		String active = snps.substring(18,23);
		int index =-1;
		if(active.equals("AA,AA,")) index = 0;
		if(active.equals("AA,Aa,")) index = 1;
		if(active.equals("AA,aa,")) index = 2;
		if(active.equals("Aa,AA,")) index = 3;
		if(active.equals("Aa,Aa,")) index = 4;
		if(active.equals("Aa,aa,")) index = 5;
		if(active.equals("aa,AA,")) index = 6;
		if(active.equals("aa,Aa,")) index = 7;
		if(active.equals("aa,aa,")) index = 8;
		
		return index;
	}
	
	
	public int assesRisk(int model, int index){
		
		int risk = -1;
		switch(model){
		case 1:
			if(index==1||index==3||index==5||index==7) risk = 1;
			else risk = 0;
			break;
		case 2:
			if(index==2||index==4||index==6) risk = 1;
			else risk = 0;
			break;
		case 3:
			if(index==0||index==1||index==3||index==5||index==7) risk = 1;
			else risk = 0;
			break;
		case 4:
			if(index==2||index==4||index==5||index==6||index==7) risk = 1;
			else risk = 0;
			break;
		case 5:
			if(index==0||index==1||index==3||index==4) risk = 1;
			else risk = 0;
			break;
		case 6:
			if(index==0||index==2||index==3||index==4||index==8) risk = 1;
			else risk = 0;
			break;
		}
		return risk;
	}
	
	
	
	public void createMafs(int model1, int model2){
		
		//inactive
		for(int i = 0; i<6; i+=3){
			mafs[i]=0.5;
		}
		for(int i = 1; i<6; i+=3){
			mafs[i]=0.25;
		}
		for(int i = 2; i<6; i+=3){
			mafs[i]=0.1;
		}
		
		//active
		switch(model1){
		case 1:
			mafs[8]=0.5;
			mafs[9]=0.5;
			break;
		case 2:
			mafs[8]=0.5;
			mafs[9]=0.5;
			break;
		case 3:
			mafs[8]=0.25;
			mafs[9]=0.75;
			break;
		case 4:
			mafs[8]=0.25;
			mafs[9]=0.75;
			break;
		case 5:
			mafs[8]=0.1;
			mafs[9]=0.9;
			break;
		case 6:
			mafs[8]=0.1;
			mafs[9]=0.9;
			break;
		}
		
		
		switch(model2){
		case 1:
			mafs[6]=0.5;
			mafs[7]=0.5;
			break;
		case 2:
			mafs[6]=0.5;
			mafs[7]=0.5;
			break;
		case 3:
			mafs[6]=0.25;
			mafs[7]=0.75;
			break;
		case 4:
			mafs[6]=0.25;
			mafs[7]=0.75;
			break;
		case 5:
			mafs[6]=0.1;
			mafs[7]=0.9;
			break;
		case 6:
			mafs[6]=0.1;
			mafs[7]=0.9;
			break;
		}
	}
	
	
	public void createPentrances(double []penetrances, int model){
		for(int i = 0; i<9; i++){
			penetrances[i]=0;
		}
		switch(model){
		case 1:
			penetrances[1]=0.1;
			penetrances[3]=0.1;
			penetrances[5]=0.1;
			penetrances[7]=0.1;
			break;
		case 2:
			penetrances[2]=0.1;
			penetrances[4]=0.05;
			penetrances[6]=0.1;
			break;
		case 3:
			penetrances[0]=0.08;
			penetrances[1]=0.07;
			penetrances[2]=0.05;
			penetrances[3]=0.1;
			penetrances[5]=0.1;
			penetrances[6]=0.03;
			penetrances[7]=0.1;
			penetrances[8]=0.04;
			break;
		case 4:
			penetrances[1]=0.01;
			penetrances[2]=0.09;
			penetrances[3]=0.04;
			penetrances[4]=0.01;
			penetrances[5]=0.08;
			penetrances[6]=0.07;
			penetrances[7]=0.09;
			penetrances[8]=0.03;
			break;
		case 5:
			penetrances[1]=0.07;
			penetrances[1]=0.05;
			penetrances[2]=0.02;
			penetrances[3]=0.05;
			penetrances[4]=0.09;
			penetrances[5]=0.01;
			penetrances[6]=0.02;
			penetrances[7]=0.01;
			penetrances[8]=0.03;
			break;
		case 6:
			penetrances[1]=0.09;
			penetrances[1]=0.001;
			penetrances[2]=0.02;
			penetrances[3]=0.08;
			penetrances[4]=0.07;
			penetrances[5]=0.005;
			penetrances[6]=0.003;
			penetrances[7]=0.007;
			penetrances[8]=0.02;
			break;
		}
	}
}

