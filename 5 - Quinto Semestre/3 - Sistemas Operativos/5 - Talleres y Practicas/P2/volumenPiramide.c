#include <stdio.h>

int main() {
    float base, altura, volumen;


    printf("Ingrese la longitud de la base de la pirámide: ");
    scanf("%f", &base);

    printf("Ingrese la altura de la pirámide: ");
    scanf("%f", &altura);

    volumen = (base * base * altura) / 3.0;

    printf("El volumen de la pirámide es: %.2f\n", volumen);

    return 0;
}
