/**
 * Esta función selecciona una opción de navegador de una lista con probabilidades ponderadas.
 * Si el parámetro `browser` es verdadero, la opción se selecciona en función de los pesos;
 * de lo contrario, se selecciona "chrome" de forma predeterminada.
 *
 * @param browser Un valor booleano que indica si se deben considerar los pesos al seleccionar el navegador.
 * @return El nombre del navegador seleccionado (por ejemplo, "chrome", "firefox" o "edge").
 */
def seleccionarString(browser)
{
    def opciones = [
            ["chrome", 3],
            ["firefox", 2],
            ["edge", 1]
    ]

    // Si browser es verdadero, selecciona una opción basada en los pesos
    if (browser) {
        def totalPesos = opciones.inject (0) { suma, opcion -> suma + opcion[1] }//.sum { it[1] }
        def numeroAleatorio = new Random().nextInt(totalPesos)
        def acumulado = 0

        for (opcion in opciones) {
            acumulado += opcion[1]
            if (numeroAleatorio < acumulado) {
                return opcion[0]
            }
        }
    } else {
        // Si browser es falso , retorna chrome
        return "chrome"
    }
}
/**
 * Esta función convierte un valor de estado booleano en un valor numérico que representa un tipo de entorno.
 *
 * @param status Un valor booleano ('true' o 'false') que indica el estado del entorno.
 * @return Un valor numérico que representa el tipo de entorno:
 *         - 1 si el estado es 'true', que generalmente se asocia con un entorno activo.
 *         - 2 si el estado es 'false', que generalmente se asocia con un entorno inactivo.
 */
def getEnvType(status) {
    if(status == 'true') {
        return 1
    }else{
        return 2
    }
}