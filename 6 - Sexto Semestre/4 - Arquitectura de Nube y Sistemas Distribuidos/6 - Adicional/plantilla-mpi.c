/*
 * 1. Instalar MPI en ubuntu
 * # apt update
 * # apt install openmpi-bin openmpi-doc libopenmpi-dev nano
 * 
 * 2. Crear un usuario en ubuntu (min privilegio
 * # useradd -m aospina -s /bin/bash
 * 
 * 3. cambiarme al usuario creado
 * # su - aospina
 * 
 * 4. Como compilar con MPI
 * gcc    compilador gnu de c
 * mpicc  compilador gnu de MPI
 * icc  compilador intel  de MPI  ($$$$$)
 * 
 * $ nano -w ej1.c
 * $ mpicc ej1.c -o ej
 * 
 * // $mpicc <source.code>.c -o <ejecutable>
 * 
 * 
 * 5. Como ejecutar
 * $ mpirun 
 */


#include <stdio.h>
#include <mpi.h>

int main(int argc, char **argv)
{
	int pid, npr, A=2;
	MPI_Init(&argc, &argv);
	MPI_Comm_rank(MPI_COMM_WORLD,&pid);
	MPI_Comm_size(MPI_COMM_WORLD,&npr);
	
	
	MPI_Finalize();
	return 0;
}

