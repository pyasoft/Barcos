package com.aac.barcos.domain.model


data class NauticaComun(
    val id: Int,
    val Rumbo: String,
    val Viento: String,
    val Vela: String,
    val Elemento: String,
    val Accion: String,
    val Comentario: String,
)

enum class Rumbos {
    CENIDA, TRAVES, POPA;

    fun descripcion(): String {
        return when (this) {
            CENIDA -> "Ceñida"
            TRAVES -> "Traves"
            POPA   -> "Empopada"
        }
    }
}

enum class Vientos {
    FLOJO, MEDIO, FUERTE;

    fun descripcion(): String {
        return when (this) {
            FLOJO  -> "Flojo"
            MEDIO  -> "Medio"
            FUERTE -> "Fuerte"
        }
    }
}

enum class Velas {
    MAYOR, GENOVA, SPI, GEN;

    fun descripcion(): String {
        return when (this) {
            MAYOR  -> "Mayor"
            GENOVA -> "Genova"
            SPI    -> "Spinaker"
            GEN    -> "Genaker"
        }
    }
}

/*
    //Parametros
    val EXTRA_NAUTICA = "EXTRA_NAUTICA"

    val EXTRA_VELA = "EXTRA_VELA"
    val EXTRA_RUMBO = "EXTRA_RUMBO"
    val EXTRA_VIENTO = "EXTRA_VIENTO"

    //Velas
    val Mayor = "MAYOR"
    val Genova = "GENOVA"
    val Ambas  = "AMBAS"
    val SPI = "SPI"
    val GEN = "GEN"

    //Rumbos
    val Ceñida = "CENIDA"
    val Traves = "TRAVES"
    val Empopada1 = "POPA1"
    val Empopada2 = "POPA2"
    //Vientos
    val Flojo = "FLOJO"
    val Medio = "MEDIO"
    val Fuerte = "FUERTE"

    //Textos TAB
    val VelaMayor  = "Vela Mayor"
    val VelaGenova  = "Vela Génova"
    val VelaAmbas  = "Ambas Velas"
    val VelaSPI  = "Vela SPI"
    val VelaGENNAKER  = "Vela GENNAKER (SPI asimétrico)"

    //Elementos
    val Driza = "Driza"
    val Pajarin = "Pajarín"
    val Contra = "Contra"
    val Backstay = "Backstay"
    val Carroescota = "Carro escota"
    val Escota = "Escota"
    val Stay = "Stay"
    val Enrollador = "Enrollador"
    val Rizos = "Rizos"
    val Cunningham = "Cunningham"
    val General = "General"
    val Tangon = "Tangón"
    val Puñoamuraescota = "Puño amura/escota"
    val BrazaEscota = "Braza/Escota"
    val Puñosamuraescota = "Puños amura/escota"
    val Barberdepopa = "Barber de popa"
    val Puñosbrazaescota = "Puños braza/escota"
    val Arriado = "Arriado"
    val Uso = "Uso"
    val Aparejo = "Aparejo"
    val Puñoamura = "Puño amura"
    val ambasvelas = "ambas velas"
    val aorejasdeburro = "a orejas de burro"

    val newNauticas = listOf(
        NauticaComun( 1,    "CENIDA", "FLOJO",  "MAYOR",  "Driza",              "Poca tensión", "...pero sin arrugas en el grátil." ),
        NauticaComun( 2,    "CENIDA", "FLOJO",  "MAYOR",  "Pajarín",            "Amollar con oleaje. Tensar sin olas", "" ),
        NauticaComun( 3,    "CENIDA", "FLOJO",  "MAYOR",  "Contra",             "Amollada", "" ),
        NauticaComun( 4,    "CENIDA", "FLOJO",  "MAYOR",  "Backstay",           "Un poco de tensión", "" ),
        NauticaComun( 5,    "CENIDA", "FLOJO",  "MAYOR",  "Carro escota",       "A barlovento", "Botavara Cerca línea crujia." ),
        NauticaComun( 6,    "CENIDA", "FLOJO",  "MAYOR",  "Escota",             "Cazar/amollar...", "Cazar, atentos a los catavientos del primer sable hasta que se esconda tras la vela. A continuación, amollar un poco hasta que de nuevo asome." ),
        NauticaComun( 7,    "CENIDA", "FLOJO",  "GENOVA", "Stay",               "Con algo de tensión", "Ya lo tenemos algo tenso desde el Backstay y ayudará a pasar mejora la ola." ),
        NauticaComun( 8,    "CENIDA", "FLOJO",  "GENOVA", "Driza",              "Poca tensión", "...pero sin arrugas en el grátil." ),
        NauticaComun( 9,    "CENIDA", "FLOJO",  "GENOVA", "Carro escota",       "Lleva hacia proa", "...para un mejor embolsamiento." ),
        NauticaComun( 10,   "CENIDA", "FLOJO",  "GENOVA", "Escota",             "Cazar/amollar", "...hasta que los catavientos estén paralelos." ),
        NauticaComun( 11,   "CENIDA", "MEDIO",  "MAYOR",  "Driza",              "Tensar ligeramente", "" ),
        NauticaComun( 12,   "CENIDA", "MEDIO",  "MAYOR",  "Pajarín",            "Tensado", "" ),
        NauticaComun( 13,   "CENIDA", "MEDIO",  "MAYOR",  "Contra",             "Suelta", "" ),
        NauticaComun( 14,   "CENIDA", "MEDIO",  "MAYOR",  "Backstay",           "Aumentar tensión", "" ),
        NauticaComun( 15,   "CENIDA", "MEDIO",  "MAYOR",  "Escota",             "Cazar/amollar", "...mismo criterio que con viento flojo." ),
        NauticaComun( 16,   "CENIDA", "MEDIO",  "MAYOR",  "Carro escota",       "Más de 20º escora: carro a sotavento", "Si no adriza embarcación, tras pasarlo a sotavento, amollar un poco escota. Sinó, rizar mayor." ),
        NauticaComun( 17,   "CENIDA", "MEDIO",  "GENOVA", "Driza",              "Tensar ligeramente", "...pero sin arrugas en grátil." ),
        NauticaComun( 18,   "CENIDA", "MEDIO",  "GENOVA", "Carro escota",       "Punto intermedio", "...para un mejor embolsamiento." ),
        NauticaComun( 19,   "CENIDA", "MEDIO",  "GENOVA", "Escota",             "Cazar ", "...hasta catavientos barlov/sotavento paralelos." ),
        NauticaComun( 20,   "CENIDA", "MEDIO",  "GENOVA", "Enrollador",         "Aplicar con más de 20º escora", "" ),
        NauticaComun( 21,   "CENIDA", "FUERTE", "MAYOR",  "Rizos",              "1, 2 ó 3", "...en función intensidad viento." ),
        NauticaComun( 22,   "CENIDA", "FUERTE", "MAYOR",  "Driza",              "Tensar si aparecen arrugas en grátil", "" ),
        NauticaComun( 23,   "CENIDA", "FUERTE", "MAYOR",  "Cunningham ",        "Tensar", "...para desplazar la bolsa hacia adelante." ),
        NauticaComun( 24,   "CENIDA", "FUERTE", "MAYOR",  "Contra",             "Tensar", "" ),
        NauticaComun( 25,   "CENIDA", "FUERTE", "MAYOR",  "Pajarín",            "Máxima tensión", "" ),
        NauticaComun( 26,   "CENIDA", "FUERTE", "MAYOR",  "Backstay",           "Máxima tensión", "" ),
        NauticaComun( 27,   "CENIDA", "FUERTE", "MAYOR",  "Carro escota",       "A sotavento", "" ),
        NauticaComun( 28,   "CENIDA", "FUERTE", "MAYOR",  "Escota",             "Muy cazada", "" ),
        NauticaComun( 29,   "CENIDA", "FUERTE", "GENOVA", "Stay",               "Dar más tensión si aumenta oleaje", "...para mejor paso de ola." ),
        NauticaComun( 30,   "CENIDA", "FUERTE", "GENOVA", "Driza",              "Máxima tensión", "" ),
        NauticaComun( 31,   "CENIDA", "FUERTE", "GENOVA", "Enrollador",         "Aplicar para reducir/rizar", "" ),
        NauticaComun( 32,   "CENIDA", "FUERTE", "GENOVA", "Carro escota",       "Hacia popa", "...para aplanar la vela." ),
        NauticaComun( 33,   "CENIDA", "FUERTE", "GENOVA", "Escota",             "Cazar/amollar", "...hasta alinear los catavientos." ),
        NauticaComun( 34,   "TRAVES", "FLOJO",  "MAYOR",  "Driza",              "Poca tensión", "...aunque con algunas arrugas en el grátil." ),
        NauticaComun( 35,   "TRAVES", "FLOJO",  "MAYOR",  "Pajarín",            "Amollar ligeramente", "" ),
        NauticaComun( 36,   "TRAVES", "FLOJO",  "MAYOR",  "Backstay",           "Poca tensión", "" ),
        NauticaComun( 37,   "TRAVES", "FLOJO",  "MAYOR",  "Carro escota",       "A sotavento", "" ),
        NauticaComun( 38,   "TRAVES", "FLOJO",  "MAYOR",  "Escota",             "Amollar", "...hasta que embolse bién. angulo botavar 20º ó 30º respecto linea de crujía." ),
        NauticaComun( 39,   "TRAVES", "FLOJO",  "MAYOR",  "Contra",             "Cazar/amollar", "...hasta que el catavientos del primer sable se esconda tras la vela. Amollamos entonces un poco hasta que asome de nuevo. Al cazar la contra conseguimos que la vela se aplane con su superficie hacia el viento, así no rozará con crucetas/obenques, y nos permitirá en caso de abrir rumbo largar escota hasta poner la botavara a 80/90º resp. crujia." ),
        NauticaComun( 40,   "TRAVES", "FLOJO",  "GENOVA", "Stay",               "Poca tensión", "...ya lo tenemos algo tenso desde el Backstay." ),
        NauticaComun( 41,   "TRAVES", "FLOJO",  "GENOVA", "Driza",              "Poca tensión", "...y con arrugas en el grátil." ),
        NauticaComun( 42,   "TRAVES", "FLOJO",  "GENOVA", "Carro escota",       "Lleva hacia proa", "...para un mejor embolsamiento." ),
        NauticaComun( 43,   "TRAVES", "FLOJO",  "GENOVA", "Escota",             "Cazar/amollar", "...hasta que los catavientos estén paralelos." ),
        NauticaComun( 44,   "TRAVES", "MEDIO",  "MAYOR",  "Driza",              "Poca tensión", "...y con algunas arrugas en el grátil." ),
        NauticaComun( 45,   "TRAVES", "MEDIO",  "MAYOR",  "Pajarín",            "Amollar", "" ),
        NauticaComun( 46,   "TRAVES", "MEDIO",  "MAYOR",  "Contra",             "Cazada", "...atentos al cataviento 1er sable." ),
        NauticaComun( 47,   "TRAVES", "MEDIO",  "MAYOR",  "Backstay",           "Poca tensión", "" ),
        NauticaComun( 48,   "TRAVES", "MEDIO",  "MAYOR",  "Carro escota",       "A sotavento", "Más de 20º escora: carro a sotavento, Si no adriza embarcación, tras pasarlo a sotavento, amollar un poco escota. Sinó, rizar mayor." ),
        NauticaComun( 49,   "TRAVES", "MEDIO",  "MAYOR",  "Escota",             "cazar/amollar...", "angulo botavar 20º ó 30º respecto linea de crujía." ),
        NauticaComun( 50,   "TRAVES", "MEDIO",  "GENOVA", "Stay",               "Mantener tensión", "...backstay ya realiza tensión." ),
        NauticaComun( 51,   "TRAVES", "MEDIO",  "GENOVA", "Driza",              "Tensar", "...hasta que desaparezcan las arrugas del grátil." ),
        NauticaComun( 52,   "TRAVES", "MEDIO",  "GENOVA", "Escota",             "Cazar/amollar", "...hasta catavientos barlov/sotavento paralelos." ),
        NauticaComun( 53,   "TRAVES", "FUERTE", "MAYOR",  "Driza",              "Tensar ligeramente en función del viento", "...y que se sigan formando arrugas en el grátil." ),
        NauticaComun( 54,   "TRAVES", "FUERTE", "MAYOR",  "Pajarín",            "Totalmente tensado", "" ),
        NauticaComun( 55,   "TRAVES", "FUERTE", "MAYOR",  "Backstay",           "Totalmente tensado", "" ),
        NauticaComun( 56,   "TRAVES", "FUERTE", "MAYOR",  "Contra",             "Tensar", "" ),
        NauticaComun( 57,   "TRAVES", "FUERTE", "MAYOR",  "Pajarín",            "Máxima tensión", "" ),
        NauticaComun( 58,   "TRAVES", "FUERTE", "MAYOR",  "Backstay",           "Máxima tensión", "" ),
        NauticaComun( 59,   "TRAVES", "FUERTE", "MAYOR",  "Carro escota",       "A sotavento", "Más de 20º escora: carro a sotavento, Si no adriza embarcación, tras pasarlo a sotavento, amollar un poco escota. Sinó, rizar mayor." ),
        NauticaComun( 60,   "TRAVES", "FUERTE", "MAYOR",  "Escota",             "cazar/amollar...", "angulo botavar 20º ó 30º respecto linea de crujía." ),
        NauticaComun( 61,   "TRAVES", "FUERTE", "MAYOR",  "Contra",             "Muy cazada", "" ),
        NauticaComun( 62,   "TRAVES", "FUERTE", "MAYOR",  "Rizos",              "Proceder si aumenta escora", "" ),
        NauticaComun( 63,   "TRAVES", "FUERTE", "GENOVA", "Stay",               "Tensado", "...ya tensado desde backstay." ),
        NauticaComun( 64,   "TRAVES", "FUERTE", "GENOVA", "Driza",              "Tensar", "...hasta que desaparezcan las arrugal del grátil, pero no más." ),
        NauticaComun( 65,   "TRAVES", "FUERTE", "GENOVA", "Carro escota",       "Hacia popa", "" ),
        NauticaComun( 66,   "TRAVES", "FUERTE", "GENOVA", "Escota",             "Cazar/amollar", "...hasta alinear los catavientos." ),
        NauticaComun( 67,   "POPA1",  "FLOJO",  "MAYOR",  "Driza",              "Poca tensión", "...aunque con algunas arrugas en el grátil." ),
        NauticaComun( 68,   "POPA1",  "FLOJO",  "MAYOR",  "Pajarín",            "Amollar ", "" ),
        NauticaComun( 69,   "POPA1",  "FLOJO",  "MAYOR",  "Backstay",           "En banda/suelto", "" ),
        NauticaComun( 70,   "POPA1",  "FLOJO",  "MAYOR",  "Carro escota",       "A sotavento", "" ),
        NauticaComun( 71,   "POPA1",  "FLOJO",  "MAYOR",  "Escota",             "Amollar ", "...hasta situar la vela perpendicular al viento." ),
        NauticaComun( 72,   "POPA1",  "FLOJO",  "MAYOR",  "Contra",             "Cazar/amollar", "...hasta formar 90º de angulo, la botavara, respecto al palo." ),
        NauticaComun( 73,   "POPA1",  "FLOJO",  "GENOVA", "General",            "Buena alternativa", "...para navegar entre 130º y 160º. Disfrutaremos de una placentera navegación si no tenemos mar de popa." ),
        NauticaComun( 74,   "POPA1",  "FLOJO",  "SPI",    "Tangón",             "Alto y perpendicular", "...lo situaremos en la parte alta del palo y lo abriremos hasta posicionarlo perpendicular al viento aparente." ),
        NauticaComun( 75,   "POPA1",  "FLOJO",  "SPI",    "Puño amura/escota",  "Paralelos", "Ambos a la misma altura respecto al mar." ),
        NauticaComun( 76,   "POPA1",  "FLOJO",  "SPI",    "Braza/Escota",       "Jugar simultaneamente", "" ),
        NauticaComun( 77,   "POPA1",  "FLOJO",  "GEN",    "Uso",                "Buena alternativa", "...para navegar de aleta o través. ." ),
        NauticaComun( 78,   "POPA1",  "FLOJO",  "GEN",    "Aparejo",            "Con o sin tangón", "Lo podremos aparejar sin tangón para estos vientos, aunque si quisieramos navegar próximo a la popa cerrada, deberemos recurrir al tangón." ),
        NauticaComun( 79,   "POPA1",  "FLOJO",  "GEN",    "Puño amura",         "75cms por encima de la cubierta", "Través (De 55º a 90º)...- Aleta (De 90º a 120º) ...si arrecia, cazar la amura para aplanar la vela." ),
        NauticaComun( 80,   "POPA1",  "FLOJO",  "GEN",    "Escota",             "llevar muy a popa", "Través (De 55º a 90º) ...como con vientos flojos - Aleta (De 90º a 120º) ...pero más amollada." ),
        NauticaComun( 81,   "POPA1",  "FLOJO",  "GEN",    "Backstay",           "Templado", "Través (De 55º a 90º) ...para mantener el palo recto - Aleta (De 90º a 120º)." ),
        NauticaComun( 82,   "POPA1",  "FLOJO",  "GEN",    "Tangón",             "Rumbos más de popa", "...Tendremos que atangonar el gennaker para sacar el puño de braza/amura más a barlovento y que reciba el viento limpio." ),
        NauticaComun( 83,   "POPA1",  "MEDIO",  "MAYOR",  "Driza",              "Poca tensión", "" ),
        NauticaComun( 84,   "POPA1",  "MEDIO",  "MAYOR",  "Pajarín",            "Amollar unos centímetros", "" ),
        NauticaComun( 85,   "POPA1",  "MEDIO",  "MAYOR",  "Backstay",           "Soltar hasta que el palo esté recto", "" ),
        NauticaComun( 86,   "POPA1",  "MEDIO",  "MAYOR",  "Carro escota",       "A sotavento", "" ),
        NauticaComun( 87,   "POPA1",  "MEDIO",  "MAYOR",  "Escota",             "Amollar ", "...hasta situar la vela perpendicular al viento." ),
        NauticaComun( 88,   "POPA1",  "MEDIO",  "MAYOR",  "Contra",             "Cazar", "...hasta que el catavientos 1er sable esté a punto de desaparecer tras la vela." ),
        NauticaComun( 89,   "POPA1",  "MEDIO",  "GENOVA", "General",            "Buena alternativa", "...para navegar entre 130º y 160º. Disfrutaremos de una placentera navegación si no tenemos mar de popa." ),
        NauticaComun( 90,   "POPA1",  "MEDIO",  "SPI",    "Tangón",             "Más bajo y perpendicular", "" ),
        NauticaComun( 91,   "POPA1",  "MEDIO",  "SPI",    "Puños amura/escota", "Paralelos", "Ambos a la misma altura respecto al mar." ),
        NauticaComun( 92,   "POPA1",  "MEDIO",  "SPI",    "Backstay",           "Sin tensión", "" ),
        NauticaComun( 93,   "POPA1",  "MEDIO",  "SPI",    "Barber de popa",     "Aconsejable", "...para reducir el balanceo del SPI y cerrar un poco las balumas." ),
        NauticaComun( 94,   "POPA1",  "MEDIO",  "GEN",    "Uso",                "Buena alternativa", "...para navegar de aleta o través. ." ),
        NauticaComun( 95,   "POPA1",  "MEDIO",  "GEN",    "Aparejo",            "Con o sin tangón", "Lo podremos aparejar sin tangón para estos vientos, aunque si quisieramos navegar próximo a la popa cerrada, deberemos recurrir al tangón." ),
        NauticaComun( 96,   "POPA1",  "MEDIO",  "GEN",    "Puño amura",         "75cms por encima de la cubierta", "Través (De 55º a 90º)...- Aleta (De 90º a 120º) ...si arrecia, cazar la amura para aplanar la vela." ),
        NauticaComun( 97,   "POPA1",  "MEDIO",  "GEN",    "Escota",             "llevar muy a popa", "Través (De 55º a 90º) ...como con vientos flojos - Aleta (De 90º a 120º) ...pero más amollada." ),
        NauticaComun( 98,   "POPA1",  "MEDIO",  "GEN",    "Backstay",           "Templado", "Través (De 55º a 90º) ...para mantener el palo recto - Aleta (De 90º a 120º)." ),
        NauticaComun( 99,   "POPA1",  "MEDIO",  "GEN",    "Tangón",             "Rumbos más de popa", "...Tendremos que atangonar el gennaker para sacar el puño de braza/amura más a barlovento y que reciba el viento limpio." ),
        NauticaComun( 100,  "POPA1",  "FUERTE", "MAYOR",  "Driza",              "Poca tensión", "...igual que con poco viento." ),
        NauticaComun( 101,  "POPA1",  "FUERTE", "MAYOR",  "Pajarín",            "Tensar un poco", "" ),
        NauticaComun( 102,  "POPA1",  "FUERTE", "MAYOR",  "Backstay",           "Templado", "" ),
        NauticaComun( 103,  "POPA1",  "FUERTE", "MAYOR",  "Contra",             "Cazada", "...igual que con viento medio. SI el barco balancea y amenaza con meter la punta de la botavara debajo del agua, deberemos estar pendientes para soltar la contra, y así la botavara subirá." ),
        NauticaComun( 104,  "POPA1",  "FUERTE", "MAYOR",  "Carro escota",       "A sotavento", "" ),
        NauticaComun( 105,  "POPA1",  "FUERTE", "MAYOR",  "Escota",             "Amollar ", "...hasta situar la vela perpendicular al viento." ),
        NauticaComun( 106,  "POPA1",  "FUERTE", "MAYOR",  "Rizos",              "Rizar", "...si aparecen síntomas de poco estabilidad." ),
        NauticaComun( 107,  "POPA1",  "FUERTE", "GENOVA", "General",            "Buena alternativa", "...para navegar entre 130º y 160º. Disfrutaremos de una placentera navegación si no tenemos mar de popa." ),
        NauticaComun( 108,  "POPA1",  "FUERTE", "SPI",    "Tangón",             "Más bajo aún", "...para favorecer el aplanamiento de la vela y dejar que se vacie el exceso de presión." ),
        NauticaComun( 109,  "POPA1",  "FUERTE", "SPI",    "Puños braza/escota", "Paralelos", "Ambos a la misma altura respecto al mar." ),
        NauticaComun( 110,  "POPA1",  "FUERTE", "SPI",    "Backstay",           "Un poco más de tensión", "" ),
        NauticaComun( 111,  "POPA1",  "FUERTE", "SPI",    "Arriado",            "Si el viento arrecia", "...será más prudente arriar el SPI." ),
        NauticaComun( 112,  "POPA1",  "FUERTE", "GEN",    "Uso",                "Buena alternativa", "...para navegar de aleta o través. ." ),
        NauticaComun( 113,  "POPA1",  "FUERTE", "GEN",    "Aparejo",            "Con o sin tangón", "Lo podremos aparejar sin tangón para estos vientos, aunque si quisieramos navegar próximo a la popa cerrada, deberemos recurrir al tangón." ),
        NauticaComun( 114,  "POPA1",  "FUERTE", "GEN",    "Puño amura",         "75cms por encima de la cubierta", "Través (De 55º a 90º)...- Aleta (De 90º a 120º) ...si arrecia, cazar la amura para aplanar la vela." ),
        NauticaComun( 115,  "POPA1",  "FUERTE", "GEN",    "Escota",             "LLevar muy a popa", "Través (De 55º a 90º) ...como con vientos flojos - Aleta (De 90º a 120º) ...pero más amollada." ),
        NauticaComun( 116,  "POPA1",  "FUERTE", "GEN",    "Backstay",           "Templado", "Través (De 55º a 90º) ...para mantener el palo recto - Aleta (De 90º a 120º)." ),
        NauticaComun( 117,  "POPA1",  "FUERTE", "GEN",    "Tangón",             "Rumbos más de popa", "...Tendremos que atangonar el gennaker para sacar el puño de braza/amura más a barlovento y que reciba el viento limpio." ),
        NauticaComun( 118,  "POPA2",  "FLOJO",  "AMBAS",  "Ambas velas",        "Mayor y Génova", "Preferentemente navegaremos con ambas velas cuando el viento lo tengamos entre 120º y 180º (aleta)." ),
        NauticaComun( 119,  "POPA2",  "FLOJO",  "AMBAS",  "A orejas de burro",  "Mayor y Génova", "Ideal para navegar a 180º con todos los vientos, con piloto automático." ),
        NauticaComun( 120,  "POPA2",  "MEDIO",  "AMBAS",  "Ambas velas",        "Mayor y Génova", "Preferentemente navegaremos con ambas velas cuando el viento lo tengamos entre 120º y 180º (aleta)." ),
        NauticaComun( 121,  "POPA2",  "MEDIO",  "AMBAS",  "A orejas de burro",  "Mayor y Génova", "Ideal para navegar a 180º con todos los vientos, con piloto automático." ),
        NauticaComun( 122,  "POPA2",  "FUERTE", "AMBAS",  "Ambas velas",        "Mayor y Génova", "Preferentemente navegaremos con ambas velas cuando el viento lo tengamos entre 120º y 180º (aleta)." ),
        NauticaComun( 123,  "POPA2",  "FUERTE", "AMBAS",  "A orejas de burro",  "Mayor y Génova", "Ideal para navegar a 180º con todos los vientos, con piloto automático." ),
    )
*/

