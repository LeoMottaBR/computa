//package myprojects.computa;

import java.io.*;

class Computa {

	public Computa() {}
	
	public void Inicia(Memoria h){
		int i=0;
		String linha;		
		
		try{		
			BufferedReader ArqEnt = new BufferedReader(new FileReader("Memory.txt"));	
			
	   		while ( ( linha = ArqEnt.readLine() ) != null ) 
	   		{
	            h.set_valor(Integer.parseInt(linha),i);
	        	i++;      
	     	}
	     	h.imprime();
		}
		catch(IOException ioException){
			System.out.println("Arquivo nao encontrado");
		}	
	}

	public static void main(String args[]) {
		System.out.println("Starting Computa...");		
		
		Computa c = new Computa(); //Cria um computador		
		
		Memoria m = new Memoria();
		Processador p = new Processador();		
		
		c.Inicia(m);
		p.start(m);
		

		
		System.out.println("Closing Computa...");
		
	}
}
