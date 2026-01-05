import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

/* =========================================================
   DOMAIN — ENTIDADE
   ========================================================= */

data class Remedio(
    val nome: String,
    val Lotedate: LocalDate,
    val fabricante: String,
    val dosagem: String,
    val usorecomendado: String,
)

/* =========================================================
   SERVICE — REGRAS DE NEGÓCIO
   ========================================================= */

class RemedioService {

    private val remedios = mutableListOf<Remedio>()

    fun cadastrar(remedio: Remedio) {
        remedios.add(remedio)
    }

    fun listar(): List<Remedio> =
        remedios.toList()

    fun estaVazio(): Boolean =
        remedios.isEmpty()
}

/* =========================================================
   UTILS — DATA
   ========================================================= */

object DateUtils {

    private const val DATE_PATTERN = "dd/MM/yyyy"

    val formatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern(DATE_PATTERN)

    fun parse(texto: String): LocalDate =
        LocalDate.parse(texto, formatter)
}

/* =========================================================
   UTILS — INPUT
   ========================================================= */

object InputUtils {

    fun readText(label: String): String {
        print(label)
        return readLine()?.trim().orEmpty()
    }

    fun readDate(label: String): LocalDate {
        while (true) {
            try {
                return DateUtils.parse(readText(label))
            } catch (e: DateTimeParseException) {
                println("❌ Data inválida. Use o formato dd/MM/yyyy.")
            }
        }
    }
}

/* =========================================================
   UI — APPLICATION
   ========================================================= */

fun main() {
    val service = RemedioService()

    while (true) {
        mostrarMenu()

        when (InputUtils.readText("Escolha uma opção: ")) {
            "1" -> cadastrarRemedio(service)
            "2" -> listarRemedios(service)
            "3" -> {
                println("Encerrando o sistema...")
                return
            }
            else -> println("❌ Opção inválida!\n")
        }
    }
}

/* =========================================================
   CASOS DE USO
   ========================================================= */

fun cadastrarRemedio(service: RemedioService) {
    val remedio = Remedio(
        nome = InputUtils.readText("Nome do remédio: "),
        Lotedate = InputUtils.readDate("Data do lote (dd/MM/yyyy): "),
        fabricante = InputUtils.readText("Fabricante: "),
        dosagem = InputUtils.readText("Dosagem (ex: 30 mg): "),
        usorecomendado = InputUtils.readText( label= "uso recomendado: ")
    )

    service.cadastrar(remedio)
    println("✅ Remédio cadastrado com sucesso!\n")
}

fun listarRemedios(service: RemedioService) {
    if (service.estaVazio()) {
        println("⚠ Nenhum remédio cadastrado.\n")
        return
    }

    println("📋 LISTA DE REMÉDIOS")
    service.listar().forEach { exibirRemedio(it) }
}

/* =========================================================
   VIEW
   ========================================================= */

fun exibirRemedio(remedio: Remedio) {
    println(
        """
        Nome: ${remedio.nome}
        Data do lote: ${remedio.Lotedate.format(DateUtils.formatter)}
        Fabricante: ${remedio.fabricante}
        Dosagem: ${remedio.dosagem.uppercase()}
        usorecomendado: ${remedio.usorecomendado}
        -----------------------------
        """.trimIndent()
    )
}

/* =========================================================
   MENU
   ========================================================= */

fun mostrarMenu() {
    println(
        """
        ===== MENU =====
        1 - Cadastrar novo remédio
        2 - Listar remédios cadastrados
        3 - Sair
        """.trimIndent()
    )
}
