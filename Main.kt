enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String, val telefone: String, val senha: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)

    }

    fun listarMatriculas() : List<Usuario>{
        return inscritos.toList()

    }

    fun cadastrados (formacao: Formacao){
        println("Alunos Cadastrados na formação de ${formacao.nome}")
        formacao.listarMatriculas().forEach{ user ->
            println("Aluno: ${user.email}")

        }
    }
}

fun main() {

    val usuario1 = Usuario("João", "joaorodriguesprado17@gmail.com", "11999999999", "senhaJoao1234@")
    val usuario2 = Usuario("Paulo", "pauloOpaulo@gmail.com", "14999999999", "senhaPaulo1234@")
    val usuario3 = Usuario("Carlos", "carlosOcarlos@gmail.com", "18999999999", "senhaCarlos1234@")

    val conteudoKotlin1 = ConteudoEducacional("Orientação a Objetos em Kotlin", 80)
    val conteudoKotlin2 = ConteudoEducacional("Testes em Kotlin", 40)
    val conteudoKotlin3= ConteudoEducacional("Estrtura de Dados em Kotlin", 60)
    val formacaoKotlin = Formacao("Formação Kotlin", listOf(conteudoKotlin1, conteudoKotlin2, conteudoKotlin3), Nivel.valueOf("BASICO"))

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    formacaoKotlin.cadastrados(formacaoKotlin)

    val conteudoJava1 = ConteudoEducacional("Orientação a Objetos em Java", 70)
    val formacaoJava = Formacao("Formação Java", listOf(conteudoJava1), Nivel.valueOf("DIFICIL"))
    formacaoJava.matricular(usuario1)
    formacaoJava.matricular(usuario3)

    formacaoJava.cadastrados(formacaoJava)


}

