// ex 13
type Ponto2D = [number, number];

function calcularDistancia(ponto: Ponto2D): number {
    const [x, y] = ponto;
    return Math.sqrt(x * x + y * y);
}

// ex 14
enum DiasDaSemana {
    Domingo,
    Segunda,
    Terca,
    Quarta,
    Quinta,
    Sexta,
    Sabado,
}
function verificarDia(dia: DiasDaSemana): string {
    if (dia === DiasDaSemana.Sabado || dia === DiasDaSemana.Domingo) {
        return "Fim de semana";
    } else {
        return "Dia útil";
    }
}

console.log(verificarDia(DiasDaSemana.Domingo));
console.log(verificarDia(DiasDaSemana.Segunda));

