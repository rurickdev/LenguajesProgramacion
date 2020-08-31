/*
Programa paso por valor y referencia
Integrantes equipo:
    Maqueo Poisot Rurick
    Peña Lopez Daniel Elihu
*/

int sumPorValor(int a,int b);
void sumPorRef(int a,int b,int *resultado);

int main(){
	int a=6, b=8, res=0;

	printf("Paso de Parametros por Valor\n");
	printf("Resultado: %i\n",sumPorValor(a,b));

	printf("Paso de Parametros por Referencia %p\n",&res);
	sumPorRef(a,b,&res);
	printf("Resultado: %i\n",res);
	return 0;
}

int sumPorValor(int a, int b){
	return a+b;
}

void sumPorRef(int a,int b,int *resultado){
	*resultado = a + b;
}
