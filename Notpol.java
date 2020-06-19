/*
 * Notación prefija o Polaca es una 
 * forma de escribir operaciones diferente a 
 * la ordinaria
 * Ejemplo 
 * 		Normal ==> Polaca
 * 		3 + 4  ==> + 3 4 
 * 
 * Siempre usamos un <espacio> entre los
 * operandos y la operación va al principio,
 * y se repite hasta terminar con los operandos
 * 
 *   + 3 10 
 *   13
 * Los operandos se toman de dos en dos
 * por lo que :
 * 
 *   + 4 5 6 7
 * 
 * implica primero resolver: 4 + 5 = 9
 * 
 * + 9 6 7
 * 
 * volvemos a tomar dos numeros: 9 + 6 = 15
 * 
 * + 15 7
 * 
 * repetimos hasta que no haya más: 15 + 7
 * 
 * 22
 * 
 * 
 * Nota:
 * La notacion polaca no funciona exactamente
 * como la describi aqui, en Automatas I y II
 * se vera a profundidad.
 * 
 * Ejercicio
 * Escribir una calculadora basica en notacion
 * polaca para aplicar operaciones basicas de
 * Suma, Resta, Multiplicacion y Division
 * que implemente una cola circular que
 * soporte 1 Operacion y 5 operandos.
 * Escriba el resultado e imprima.
 * 
 * Corrida de escritorio
 * 
 * Bienvenido a este programa!
 * Escribe tu operacion:
 * > +
 * Escribe el operando 1:
 * > 1
 * Escribe el operando 2:
 * > 2
 * Escribe el operando 3:
 * > 3
 * Escribe el operando 4:
 * > 4
 * Escribe el operando 5:
 * > 5
 * 
 * El resulado es 15
 * Notacion Polaca: + 1 2 3 4 5 
 */ 
import  java.io.BufferedReader ;
import  java.io.IOException ;
import  java.io.InputStreamReader ; 
public class Notpol {
	public static void main (String[] args) throws IOException {
	BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	String tmp=""; {
		int ope1=0,ope2=0,ope3=0,ope4=0,ope5=0;
		double NumSacado=0,NumNuevo=0;
	BufferedReader Teclado =new BufferedReader (new InputStreamReader(System.in));
	Calculadora not=new Calculadora(5);
	//Bienvenido a este programa!
	System.out.println("Bienvenido a este programa! ");
	System.out.println("ESCRIBE TU OPERACION:");
	System.out.println(" + SUMA");
	System.out.println(" - RESTA");
	System.out.println(" * MULTIPLICACION");
	System.out.println(" / DIVISION");
	
	tmp=(Teclado.readLine());
	try {
		System.out.println("Escribe el operando 1:");
		ope1=Integer.parseInt(Teclado.readLine());
		not.encolar(ope1);
		System.out.println("Escribe el operando 2:");
		ope2=Integer.parseInt(Teclado.readLine());
		not.encolar(ope2);
		System.out.println("Escribe el operando 3:");
		ope3=Integer.parseInt(Teclado.readLine());
		not.encolar(ope3);
		System.out.println("Escribe el operando 4:");
		ope4=Integer.parseInt(Teclado.readLine());
		not.encolar(ope4);
		System.out.println("Escribe el operando 5:");
		ope5=Integer.parseInt(Teclado.readLine());
		not.encolar(ope5);
	}catch (ExceptionColaLlena Err) {
		System.out.println(Err.getMessage()); 
	}
	switch(tmp){
		case "+":
			try {
				while(!not.colaVacia()){
					NumSacado=not.sacar();
					NumNuevo=NumSacado+NumNuevo;
				}
			}catch(ExceptionColaVacia Err){
				System.out.println(Err.getMessage());
			}
			break;
		case "-":
			try {
				while(!not.colaVacia()){  
					NumSacado=not.sacar();
						if(not.ObtenerFrente()==1){
							NumNuevo=NumSacado-NumNuevo;
						}else{
							NumNuevo=NumNuevo-NumSacado;
						} 
				}
			}catch(ExceptionColaVacia Err){
				System.out.println(Err.getMessage());
			}
			break;
		case "*":
			try { 
				while(!not.colaVacia()){  
					NumSacado=not.sacar();
						if(not.ObtenerFrente()==1){
							NumNuevo=NumSacado;
						}else{ 
							NumNuevo=NumNuevo*NumSacado;
						}
				}
			}catch(ExceptionColaVacia Err){
				System.out.println(Err.getMessage());
			}
			break;
		case "/":
			try {
				while(!not.colaVacia()){
					NumSacado=not.sacar();
						if(not.ObtenerFrente()==1) {
							NumNuevo=NumSacado;
						}else{
							NumNuevo=(NumNuevo)/(NumSacado);
						}
				}
			}catch(ExceptionColaVacia Err) {
				System.out.println(Err.getMessage());
			}
			break;
	}
	System.out.println("El resulado es:= "+ NumNuevo);
	System.out.println("Notacion Polaca:= " + tmp + " " + ope1 + " " +ope2 + " " + ope3 + " " + ope4 + " " + ope5);
	}
	}
}
