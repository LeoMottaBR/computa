//package myprojects.computa;

public class BR{

	public int []dump =	new int [5];
	
	public int get_RI(){return dump[0];}
	public int get_CI(){return dump[1];}
	public int get_AC(){return dump[2];}
	public int get_Cop(){return dump[3];}
	public int get_Op(){return dump[4];}
	
	public void set_RI(int valor){dump[0] = valor;}
	public void set_CI(int valor){dump[1] = valor;}
	public void set_AC(int valor){dump[2] = valor;}
	public void set_Cop(int valor){dump[3] = valor;}
	public void set_Op(int valor){dump[4] = valor;}	
	
	public BR(){
		for (int i = 0; i < 5; i++)
			dump[i] = 0;	
	}
}
