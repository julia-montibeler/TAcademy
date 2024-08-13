// ex 3
function calcularAreaCirculo(raio: number = 1): number {
    const area = Math.PI * Math.pow(raio, 2);
    return area;
}

// ex 4
function repetirString(texto: string, vezes: number = 2): string {
    return texto.repeat(vezes);
}