#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define N 5 //Número de filósofos
#define VIDA 10
#define IZQUIERDA(x)    ((x) !=0 ? (x)-1 : (N-1)) //Calcula el filósofo de la izquierda
#define DERECHA(x)      (((x)+1)%N) //Calcula el filósofo de la derecha

typedef enum{
    PENSANDO, HAMBRIENTO, COMIENDO
} status;

status estado[N]; //Estado en el que está cada filósofo en cada momento (pensando, hambriento o comiendo)
sem_t mutex, s[N]; //Mutex: Solo un filósofo puede coger o soltar tenedores; s[N]: Controlamos si he podido coger tenedores o no, si no he podido, me bloqueo hasta que nos despierte el filósofo de la izquierda o derecha

void pensar(int id);
void comer(int id);
void coger_tenedores(int id);
void Comprobar(int id);
void soltar_tenedores(int id);
void print_scene();

int main()
{
    extern status estado[N]; //No es necesario
    extern sem_t mutex, s[N]; //No es necesario

    int v[N]/*para decirle a cada hilo quien es*/, value, i;
    sem_init(&mutex, 0, 1);
    pthread_t filosofo[N];
    void *Filosofo(void *);

    for (i = 0; i < N; i++)                //NO SE PUEDEN LANZAR LOS HILOS HASTA QUE LOS SEMÁFOROS NO ESTÉN INICIALIZADOS
    {
        sem_init(&s[i], 0, 0);
        estado[i] = PENSANDO;

    }

    for (i = 0; i < N; i++)
    {
        v[i] = i;
        if (value = pthread_create(&filosofo[i], NULL, Filosofo, (void *)&v[i]))
            exit(value);

    }

    for (i = 0; i < N; i++)
    {
        pthread_join(filosofo[i], NULL);
    }

    return 0;
}

void *Filosofo(void *i)
{
    int id, j;
    id = *(int *)i;

    for (j = 0; j < 2; j++)
    {
        pensar(id);
        coger_tenedores(id);
        comer(id);
        soltar_tenedores(id);
    }

    printf("Filosofo[%d] terminó de comer\n", id);
    pthread_exit(NULL);
}

void pensar(int id)
{
    estado[id] = PENSANDO;
    print_scene();
    sleep(random() % 10);
}

void comer(int id)
{
    estado[id] = COMIENDO;
    print_scene();
    sleep(random() % 10);
}

void coger_tenedores(int id)
{
    sem_wait(&mutex); //Si un filosofo está cogiendo tenedores, no podré coger y me quedaré bloqueado. Si no hay nadie cogiendo tenedores, cogeré yo
    estado[id] = HAMBRIENTO;
    Comprobar(id);
    sem_post(&mutex); //Permito que otro filosofo coja tenedores
    sem_wait(&s[id]); //Si no hace el post de la función Comprobar(), se quedaría pillado aquí
    printf("Filosofo[%d] cogió los tenedores %d y %d\n", id, id, DERECHA(id));
    print_scene();
}

void Comprobar(int id)
{
    if (estado[id] == HAMBRIENTO && estado[IZQUIERDA(id)] != COMIENDO && estado[DERECHA(id)] != COMIENDO)
    {
        estado[id] = COMIENDO;
        sem_post(&s[id]); //Sirve para liberar al filosofo para que no se quede pillado más adelante, puesto que ha podido coger tenedores
    }
}

void soltar_tenedores(int id)
{
    sem_wait(&mutex); //Si hay alguien cogiendo tenedores, nadie más puede coger. Si estoy cogiendo tenedores, bloqueo para que nadie más pueda hacerlo 
    estado[id] = PENSANDO;
    printf("Filosofo[%d] soltó los tenedores %d y %d\n", id, id, DERECHA(id));
    Comprobar(IZQUIERDA(id));
    Comprobar(DERECHA(id));
    sem_post(&mutex);
    print_scene();
}

void print_scene() {
    char philosopher_state[N][10]; // Array para almacenar el estado de cada filósofo
    char thinking[] = "PENSANDO";
    char eating[] = "COMIENDO";
    char waiting[] = "HAMBRIENTO";

    // Llenar el array con los estados
    for (int i = 0; i < N; i++) {
        if (estado[i] == PENSANDO) {
            snprintf(philosopher_state[i], 10, "%s", thinking);
        } else if (estado[i] == COMIENDO) {
            snprintf(philosopher_state[i], 10, "%s", eating);
        } else {
            snprintf(philosopher_state[i], 10, "%s", waiting);
        }
    }

    // Imprimir la escena
    printf("Escena: | %s | %s | %s | %s | %s |\n", philosopher_state[0], philosopher_state[1], philosopher_state[2], philosopher_state[3], philosopher_state[4]);
}
