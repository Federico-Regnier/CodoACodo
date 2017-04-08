Algoritmo numeroMayor
	
	Definir num1, num2, num3, numMayor Como Entero;
	
	Imprimir "Ingrese el primer numero";
	Leer num1Ingresado;
	num1 <- num1Ingresado;
	Imprimir "Ingrese el segundo numero";
	Leer num2Ingresado;
	num2 <- num2Ingresado;
	Imprimir "Ingrese el tercer numero";
	Leer num3Ingresado;
	num3 <- num3Ingresado;
	
	numMayor = num1;
	
	Si num2 > numMayor Entonces
		numMayor = num2;
	FinSi
	
	Si num3 > numMayor Entonces
		numMayor = num3;
	FinSi
	
	Imprimir "El numero mayor es ", numMayor;
	
FinAlgoritmo
