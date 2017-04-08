Algoritmo alumnosBancos
	
	Definir alumnos, bancos Como Entero;
	
	Imprimir "Ingrese la cantidad de bancos";
	Leer bancosIngresados;
	bancos <- bancosIngresados;
	Imprimir "Ingrese la cantidad de alumnos";
	Leer alumnosIngresados;
	alumnos <- alumnosIngresados;
	
	Si bancos >= alumnos Entonces
		Imprimir "Hay suficientes bancos";
	Sino
		Imprimir "Faltan ", alumnos - bancos, " bancos";
	FinSi
	
FinAlgoritmo
