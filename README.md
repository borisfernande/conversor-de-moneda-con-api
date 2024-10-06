# 🌐💱 Conversor De Moneda Con Api 💲💹 
Este proyecto se desarrolló como parte del desafío de One y consiste en un **conversor de monedas** que permite 
realizar conversiones entre varias divisas populares a través de una **aplicación de consola**, 
además de guardar los resultados en un archivo JSON.
## ✨ Funcionalidades 
**Convertir entre las siguientes monedas:** 
- 🇺🇸 Dólar → 🇦🇷 Peso argentino
- 🇦🇷 Peso argentino → 🇺🇸 Dólar
- 🇺🇸 Dólar → 🇧🇷 Real brasileño
- 🇧🇷 Real brasileño → 🇺🇸 Dólar
- 🇺🇸 Dólar → 🇵🇪 Soles
-  🇵🇪 Soles → 🇺🇸 Dólar
-  🇺🇸 Dólar → 🇨🇴 Peso colombiano
-  Además, se incluye la opción de visualizar el historial de conversiones guardadas en el archivo JSON.
## 🛠 Requisitos 
- **Java 21** o superior.
- Dependencias externas para realizar consultas HTTP (por ejemplo, **HttpClient** de Java o una librería como **OkHttp**).
- **Gson v.2.11.0** para manejar la serialización y deserialización de datos JSON.
## 🗂 Estructura del Proyecto ### 
1. **Principal (Main)** En esta clase se muestran las opciones que el usuario puede elegir para convertir su moneda.
 Esta clase está enlazada con la clase `ConsultaApi` para obtener datos actualizados desde la API.
2. **ConsultaApi** Esta clase maneja la conexión a una API externa de conversión de monedas. Recibe como parámetros la moneda base y
 la moneda objetivo, y devuelve un objeto `ResultadoDelCambio` con los detalles de la conversión. Además, se encarga de manejar posibles errores en la conexión y
 respuestas inesperadas de la API.
3. **GeneradorDeArchivos** En esta clase se implementa la lógica para guardar los datos de las conversiones en formato JSON.
 Permite tanto guardar nuevos resultados como cargar el historial de conversiones previas. Se proporciona funcionalidad para
verificar si el archivo ya existe y, en caso afirmativo, agregar datos sin sobrescribir el historial anterior.
## 💡 Sugerencias Adicionales 
1. **Manejo de Errores:** Implementar una gestión robusta de errores, especialmente para manejar fallos en la conexión a la API o respuestas inválidas.
   Considera añadir mensajes informativos para el usuario.
2. **Optimización del Rendimiento:** Evalúa el rendimiento de la aplicación y busca optimizar las llamadas a la API para reducir la latencia y el uso
 innecesario de recursos.

¡Gracias por tu interés en el proyecto! Espero que disfrutes usándolo tanto como yo disfruté creándolo. Si tienes preguntas, sugerencias o comentarios, no dudes en contactarme.
    
👾🤚 **Boris Fernandez Cabrera** 😊
