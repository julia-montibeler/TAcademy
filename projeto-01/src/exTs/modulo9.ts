// ex 17
function inverterFrase(frase: string): string {
    return frase.split(' ').reverse().join(' ');
}

// ex 18
function contarVogais(texto: string): number {
    const vogais = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
    let cont = 0;

    for (const p of texto) {
        if (vogais.includes(p)) {
            cont++;
        }
    }

    return cont;
}

