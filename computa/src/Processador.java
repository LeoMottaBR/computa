//package myprojects.computa;

import javax.swing.* ;

public class Processador{
	
	BR reg = new BR();
	
	public void Buscar(Memoria m){
		reg.set_RI(m.get_valor(reg.get_CI()));		 
	}
	
	public boolean verifica(Memoria m){
	  	boolean ver = true;
	  	for (int i = 0; i < 100; i++){
   			if (m.get_valor(i)/100 != 43){
    			if (i == 99){
       				JOptionPane.showMessageDialog(null,"N�o existe instru��o de parada, programa terminado!!!" ,"Computa...",JOptionPane.INFORMATION_MESSAGE);
       				//ver = false;
       				ver = true;
       				break;
      		    }else{
               	  
                }
           }else{
           	  break;
           }
       }
        return ver;
    }
	

	
	public void start(Memoria m){
		Buscar(m);
	if (verifica(m) == true){
		Decodifica();					

		while(reg.get_Cop()!=43){
			if((reg.get_Cop()/10) == 3){
				Executar(m);
			}
			else{
				OpMemory(m);
		    }
		    /*
		      if((reg.get_Cop() != 20) || (reg.get_Cop() != 21) || (reg.get_Cop() != 22)){
				JOptionPane.showMessageDialog(null, "A instru��o: " + reg.get_Cop() + " n�o � valida!" ,"Computa...",JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			else
			*/
  			
			Buscar(m);
			Decodifica();
		}//Fim while
		m.imprime();
		m.debug();
}//fim do if
	}//fim start



	public void Decodifica(){ //separa o valor da memoria identificando o tipo de opera��o
		reg.set_Cop(reg.get_RI()/100);
		reg.set_Op(reg.get_RI()%100);
		reg.set_CI(reg.get_CI() + 1);
	}
	
	public void Executar(Memoria m){
		switch (reg.get_Cop()){
		   case 30://ADD
		      reg.set_AC (reg.get_AC() + m.get_valor(reg.get_Op()));  
		      break; 
		   case 31://SUBTRACT,
		      reg.set_AC (reg.get_AC() - m.get_valor(reg.get_Op()));
		      System.out.println("Subtraido = " + reg.get_AC());
		      break; 
		   case 32: // DIVIDE
		      reg.set_AC (reg.get_AC() / m.get_valor(reg.get_Op()));
		      break;
		   case 33: // MULTIPLY
		      reg.set_AC (reg.get_AC() * m.get_valor(reg.get_Op()));
		      break;
		   default : break;	
	   }	   		
	}
	
	public void OpMemory(Memoria m){
   	   switch(reg.get_Cop()){
   		   case 10: //READ
   		      int i = Le_Inteiro(JOptionPane.showInputDialog(null,"Digite um numero para gravar na mem�ria!" ,"Computa...",JOptionPane.INFORMATION_MESSAGE));
   		      m.set_valor(i,reg.get_Op());
   		   break;   //WRITE		   
		   case 11: 
   		      System.out.println(m.get_valor(reg.get_Op()));
		   break;
   		   case 20: //LOAD
   		   	   reg.set_AC(m.get_valor(reg.get_Op()));
   		   break;
   		   case 21: //STORE
   		   	   m.set_valor(reg.get_AC(),reg.get_Op());
   		   break;
		   case 40: //BRANCH
		   	   reg.set_CI(reg.get_Op());
		   break;
		   case 41: //BRANCHNEG - coloca em CI o valor da Op para desviar a opera��o
		   	   if (reg.get_AC() < 0)
		   	   	  reg.set_CI(reg.get_Op());
		   break;		   
		   case 42: //BRANCHZERO
		   	   if (reg.get_AC() == 0)
		   	   	  reg.set_CI(reg.get_Op());		   
		   break;
		}//fim switch
	}
	

	private int Le_Inteiro(String S){
       double x = Double.parseDouble(S);
       int a = (int) x;
       return a;
    }

/**
 * I/O
 *READ = 10
 *WRITE = 11
 *
 *CARBGA/ARAMAZENAMENTO
 *LOAD = 20
 *STORE = 21 . ARMAZENA UMA PALAVRA DO ACUMULADOR EM POSI��O ESPECIFICA DA MEM�RIA
 *
 *ARITIM�TICA
 *ADD = 30 . ADICIONA UMA PALAVRA DE UMA POSI��O DE MEMORIA � PALVRA NO ACUMULADOR E DEIXA O RESULTADO NO MESMO
 *SUBTRACT = 31 . SUBTRAI UMA PALAVRA DE UMA POSI��O ESPECIFICA DA MEMORIA DA PALAVRA NO ACUMULADOR 
 *DIVIDE = 32 . DIVIDE
 *MULTIPLY = 33 . MULTIPLICA
 *
 *
 *TRANSFERENCIA DE CONTROLE
 *BRANCH = 40 . DESVIA PARA POSI��O ESPECIFICA DA MEM�RIA
 *BRANCHNEG = 41 . DESVIA PARA POSI��O ESPECIFICA DA MEM�RIA SE O ACUMULADOR FOR NEGATIVO
 *BRANCHZERO = 42 . DESVIA PARA POSI��O ESPECIFICA DA MEM�RIA SE O ACUMULADOR FOR ZERO
 *HALT = 43 . P�RA O PROGRAMA.
*/

}



