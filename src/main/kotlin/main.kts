import java.time.LocalDate
import java.time.format.DateTimeFormatter

// Classe Remedio
class Remedio(
    val nome: String,
    val dataLote: LocalDate,
    val fabricante: String,
    val dosagem: String
) {
    fun mostrarDados() {
        println("Nome: $nome")
        println("Data do Lote: ${dataLote.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}")
        println("Fabricante: $fabricante")
        println("Dosagem: ${dosagem.uppercase()}")
        println("-----------------------------")
    }
}

fun main() {

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val listaRemedios = mutableListOf<Remedio>()

    while (true) {
        println("===== MENU =====")
        println("1 - Cadastrar remédio")
        println("2 - Listar remédios")
        println("3 - Sair")
        print("Escolha uma opção: ")

        val opcao = readLine()

        when (opcao) {
            "1" -> {
                print("Nome do remédio: ")
                val nome = readLine() ?: ""

                print("Data do lote (dd/MM/yyyy): ")
                val dataTexto = readLine() ?: "01/01/2000"
                val dataLote = LocalDate.parse(dataTexto, formatter)

                print("Fabricante: ")
                val fabricante = readLine() ?: ""

                print("Dosagem (ex: 30 Mg): ")
                val dosagem = readLine() ?: ""

                val remedio = Remedio(nome, dataLote, fabricante, dosagem)
                listaRemedios.add(remedio)

                println("✅ Remédio cadastrado com sucesso!\n")
            }

            "2" -> {
                if (listaRemedios.isEmpty()) {
                    println("⚠ Nenhum remédio cadastrado.\n")
                } else {
                    println("📋 LISTA DE REMÉDIOS")
                    listaRemedios.forEach { it.mostrarDados() }
                }
            }

            "3" -> {
                println("Encerrando o programa...")
                break
            }

            else -> {
                println("❌ Opção inválida!\n")
            }56
        }
    }
}
