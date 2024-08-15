// ex 25
interface InformacoesPessoais {
    nome: string;
    email: string;
}

interface DetalhesDeLogin {
    username: string;
    senha: string;
}

interface Permissoes {
    podeVisualizar: boolean;
    podeEditar: boolean;
    podeDeletar: boolean;
}

type Usuario = InformacoesPessoais & DetalhesDeLogin & Permissoes;

const usuario: Usuario = {
    nome: 'João Silva',
    email: 'joao.silva@example.com',
    username: 'joaos',
    senha: 'senha123',
    podeVisualizar: true,
    podeEditar: false,
    podeDeletar: false,
};

console.log(usuario.nome);
console.log(usuario.podeEditar);

// ex 26
type ChaveValida<T, K extends keyof T> = T[K];

function obterValor<T, K extends keyof T>(objeto: T, chave: K): ChaveValida<T, K> {
    return objeto[chave];
}



