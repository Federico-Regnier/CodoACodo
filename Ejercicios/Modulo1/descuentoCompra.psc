Algoritmo descuentoCompra
	
	Definir compra Como Real;
	Definir formaPago Como Caracter;
	
	Imprimir "Ingrese el monto de la compra";
	Leer compraIngresada;
	compra <- compraIngresada;
	Imprimir "Ingrese la forma de pago";
	Leer formaPagoIngresada;
	formaPago <- formaPagoIngresada;
	
	Si Minusculas(formaPago) == "contado" Entonces
		Imprimir "El monto total con el descuento es ", compra * 0.9;
	Sino
		Imprimir "No hay descuento para esa forma de pago";
	FinSi
	
FinAlgoritmo
 