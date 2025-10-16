// Functions

/**
 * Fahrenheit
 * @param cel num
 * @return sum
 */
fun convertToFahrenheit(cel: Double = 0.0): Double {
    return (cel * 9/5) + 32
}

/**
 * Celsius
 * @param far num
 * @return sum
 */
fun convertToCelsius(far: Double = 32.0): Double {
    return (far - 32) * 5/9
}

/**
 * Kelvin
 * @param cel num
 * @return sum
 */
fun convertToKelvin(cel: Double = -273.15): Double {
    return cel + 273.15
}

/**
 * Cel2
 * @param kel num
 * @return sum
 */
fun convertToCelFromKelvin(kel: Double = 273.15): Double {
    return kel - 273.15
}

fun main() {
    // var input = readline() ?: 0
    
    println("=== Temperature Converter ===")
    println("")
    println("Input temperature in Celsius: ")
    
    val c_input = "25"
    val c_num = c_input.toDoubleOrNull() ?: 0.0
    val far_res = convertToFahrenheit(cel = c_num)
    
    println("$c_num°C = $far_res°F")
    println("")
    println("Input temperature in Fahrenheit: ")
    
    val f_input = "98.6"
    val f_num = f_input.toDoubleOrNull() ?: 0.0
    val cel_res = convertToCelsius(far = f_num)
    
    println("$f_num°C = $cel_res°F")
    println("")
    println("Input temperature in Kelvin: ")
    
    val k_input = "42"
    val k_num = k_input.toDoubleOrNull() ?: 0.0
    val cel2_res = convertToCelFromKelvin(kel = k_num)
    
    println("$k_num°C = $cel2_res°F")
    println("")
    println("Input temperature in Celsius: ")
    
    val c2_input = "14"
    val c2_num = c2_input.toDoubleOrNull() ?: 0.0
    val kel_res = convertToKelvin(cel = c2_num)
    
    println("$c2_num°C = $kel_res°F")
    println("")
    println("Conversion with default value: ")
    
    val cel3_res = convertToCelsius()
    
    println("32.0°F = $cel3_res°C")
    println("")
    println("Conversion with default value: ")
    
    val far2_res = convertToFahrenheit()
    
    println("0.0°C = $far2_res°F")
}
