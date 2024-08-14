#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define STACK_SIZE 100

typedef struct {
    double items[STACK_SIZE];
    int top;
} Stack;

void initStack(Stack *s) {
    s->top = -1;
}

int isEmpty(Stack *s) {
    return s->top == -1;
}

int isFull(Stack *s) {
    return s->top == STACK_SIZE - 1;
}

void push(Stack *s, double value) {
    if (isFull(s)) {
        printf("Error: Stack is full\n");
        exit(EXIT_FAILURE);
    }
    s->items[++s->top] = value;
}

double pop(Stack *s) {
    if (isEmpty(s)) {
        printf("Error: Stack is empty\n");
        exit(EXIT_FAILURE);
    }
    return s->items[s->top--];
}

void doOperation(Stack *s, char op) {
    double x, y, result;
    y = pop(s);
    x = pop(s);
    switch (op) {
        case '+':
            result = x + y;
            break;
        case '-':
            result = x - y;
            break;
        case '*':
            result = x * y;
            break;
        case '/':
            result = x / y;
            break;
        case '^':
            result = pow(x, y);
            break;
        case 's':
            result = sin(y);
            break;
        case 'c':
            result = cos(y);
            break;
        case 't':
            result = tan(y);
            break;
        default:
            printf("Error: Invalid operator\n");
            exit(EXIT_FAILURE);
    }
    push(s, result);
}

int main() {
    Stack stack;
    initStack(&stack);

    char expression[STACK_SIZE];
    char option;
    do {
        printf("\nMENU:\n");
        printf("1. Ingresar expresion\n");
        printf("2. Ver resultado\n");
        printf("3. Ver procedimiento\n");
        printf("4. Salir\n");
        printf("Seleccione una opcion: ");
        scanf(" %c", &option);

        switch (option) {
            case '1':
                printf("Ingrese la expresion RPN (separada por espacios): ");
                scanf(" %[^\n]", expression);
                char *token = strtok(expression, " ");
                while (token != NULL) {
                    if (isdigit(token[0])) {
                        push(&stack, atof(token));
                    } else if (token[0] == '+' || token[0] == '-' || token[0] == '*' || token[0] == '/' || token[0] == '^' || token[0] == 's' || token[0] == 'c' || token[0] == 't') {
                        doOperation(&stack, token[0]);
                    } else {
                        printf("Error: Invalid token\n");
                        exit(EXIT_FAILURE);
                    }
                    token = strtok(NULL, " ");
                }
                break;
            case '2':
                if (!isEmpty(&stack)) {
                    printf("Resultado: %.2f\n", stack.items[stack.top]);
                } else {
                    printf("La pila esta vacia\n");
                }
                break;
            case '3':
                printf("Procedimiento:\n");
                for (int i = 0; i <= stack.top; i++) {
                    printf("%.2f ", stack.items[i]);
                }
                printf("\n");
                break;
            case '4':
                printf("Saliendo...\n");
                break;
            default:
                printf("Opcion invalida\n");
        }
    } while (option != '4');

    return 0;
}
