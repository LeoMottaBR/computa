//package myprojects.computa;
import javax.swing.*;
public class Memoria{
	public int obj_Memory[] = new int[100];
	
	//Insere o valor na posicao
	public void set_valor(int valor, int pos){obj_Memory[pos]=valor;}

	public void imprime(){
	  	for (int i = 0; i<100; i++){
   			System.out.print("Linha " + i + " = " + obj_Memory[i] + " " );
      		if (i%5 == 0){
       			System.out.println(" "); 
      		}
        }
  	}

	public void debug(){
		for (int i = 0; i<100; i++){
			if (obj_Memory[i] != 0){
		       JOptionPane.showMessageDialog(null,"Linha " + i + " = " + obj_Memory[i] ,"Computa...",JOptionPane.INFORMATION_MESSAGE);
		    }
	    }
	}

	//Debug com passagem de parâmetro.
	public void debug(int i){
		JOptionPane.showMessageDialog(null,"Linha " + i + " = " + obj_Memory[i] ,"Computa...",JOptionPane.INFORMATION_MESSAGE);
		//System.out.println("linha " + i + " = " + obj_Memory[i] );
	}
	
	//Retorna o valor da pos
	public int get_valor(int pos){
		return obj_Memory[pos];
	}	
	
	//Limpa a memoria no construtor
	Memoria(){
		for(int i=0;i<100;i++)
			obj_Memory[i]=0;
	}	
}