
// Questão 1
class Produto(var nome: String, var preco: Double, var categoria: String? = null, var quantidadeEstoque: Int = 0 ) {
    // Implemente os construtores conforme especificado na questão
    constructor(nome: String, preco: Double): this(nome, preco, null, 0)
    constructor(nome: String, preco: Double, categoria: String): this(nome, preco, categoria, 0)
    override fun toString(): String {
        return "Nome: $nome\nPreço: R$$preco\nCategoria: ${categoria ?: "Não definida"}\nEstoque: $quantidadeEstoque"
    }
}
fun main2() {
    // Crie instâncias das diferentes classes Produto utilizando os seus construtores e imprima os detalhes de cada produto.
    val produto1 = Produto("Camiseta", 59.90)
    val produto2 = Produto("Livro", 45.0, "Literatura")
    val produto3 = Produto("Smartphone", 1200.0, "Tecnologia", 5)
    println(produto1)
    println("\n")
    println(produto2)
    println("\n")
    println(produto3)
}

// Questão 2
class Cliente {
    var nome: String = ""
    private var idade: Int = 0


    // Utilize os modificadores de visibilidade para definir os atributos nome e idade conforme especificado na questão
    val nomeCompleto: String
        get() = "Nome: $nome"

    var idadeReal: Int
        get() = idade
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException("Idade não pode ser negativa.")
            }
            idade = value
        }
    // Crie um método público na classe Cliente chamado mostrarIdade() conforme especificado na questão
    fun mostrarIdade() {
        println("Idade: $idadeReal")
    }
}

fun main3() {
    val cliente = Cliente()
    cliente.nome = "Gustavo Wagner"
    cliente.idadeReal = 32
    cliente.mostrarIdade()
}
// Crie um método abstrato atacar() conforme especificado na questão

// Questão 3
abstract class Personagem {
    // Crie um método abstrato atacar() conforme especificado na questão
    abstract fun atacar(): String

    // Implementação de método apresentar a personagem
    open fun apresentar() {
        println("Sou um personagem")
    }
}
class Guerreiro : Personagem() {
    // Implemente o método atacar() de acordo com as características do Guerreiro
    override fun atacar(): String {
        return "Atk com espada!"
    }

    override fun apresentar() {
        super.apresentar()
        println("Sou o maior guerreiro de world kotlin!")
    }
}


class Mago : Personagem() {
    override fun atacar(): String {
        return "Atk com magia!"
        // Implemente o método atacar() de acordo com as características do Mago
    }
    override fun apresentar() {
        super.apresentar()
        println("Sou um mago poderoso de world kotlin!")
    }
}


fun main4() {
    // Crie instâncias de Guerreiro e Mago e chame o método atacar() de cada um para verificar se estão realizando os ataques corretamente de acordo com suas respectivas classes.
    val guerreiro = Guerreiro()
    val mago = Mago()

    guerreiro.apresentar()
    println(guerreiro.atacar())

    println("\n")

    mago.apresentar()
    println(mago.atacar())
}

// Questão 4
interface FormaGeometrica {
    // Declare um método abstrato calcularArea() conforme especificado na questão
    fun calcularArea(): Double
}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Retangulo conforme especificado na questão
        return altura * largura
    }
}

class Circulo(val raio: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Circulo conforme especificado na questão
        return Math.PI * raio * raio
    }
}

fun main5() {
    // Crie instâncias dessas duas classes e chame o método calcularArea() em cada uma delas para verificar o resultado.
    val retangulo = Retangulo(5.0, 3.0)
    val circulo = Circulo(4.0)

    println("Área do retângulo: ${retangulo.calcularArea()}")
    println("Área do círculo: ${circulo.calcularArea()}")
}

// Questão 5
class ContaBancaria {
    var numeroConta: String = ""
    var nomeTitular: String = ""
    private var saldo: Double = 0.0

    // Implemente um getter personalizado para a propriedade nomeTitular conforme especificado na questão
    val nomeFormatado: String
        get() {
            return if (nomeTitular.isNotEmpty()) {
                val primeiraLetra = nomeTitular[0].uppercaseChar()
                val restanteNome = nomeTitular.substring(1).lowercase()
                "$primeiraLetra$restanteNome"
            } else {
                ""
            }
        }

    // Implemente override do setter para o atributo saldo conforme especificado na questão
    var saldoAtual: Double
        get() = saldo
        set(value) {
            if (value < 0.0) {
                throw IllegalArgumentException("Saldo não pode ser negativo.")
            }
            saldo = String.format("%.2f", value).toDouble()
        }
}

fun main() {
    // Crie uma instância de ContaBancaria. Altere o nome do titular para uma string que inicie com letra minúscula e mude o saldo para um valor negativo. Imprima os valores para verificar se as regras dos getters e setters estão sendo aplicadas corretamente.
    val conta = ContaBancaria()
    conta.numeroConta = "123456-7"
    conta.nomeTitular = "Marcos AND Lima"
    conta.saldoAtual = -100.0

    println("Nome do titular: ${conta.nomeFormatado}")
    println("Saldo atual: R$${conta.saldoAtual}")
}

