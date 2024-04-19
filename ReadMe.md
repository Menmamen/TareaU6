# Proyecto Unidad 6
## Carmen Montalvo Luque
Este proyecto es un editor de texto desarrollado en Java como parte de la Unidad 6 del curso. El editor permite realizar diversas acciones como aplicar negrita, cursiva y subrayado al texto, cambiar el color y tamaño de la fuente, así como activar un modo oscuro para mejorar la legibilidad en entornos con poca luz.

## Cómo usar el editor

1. **Ejecución del programa:**
    - Ejecuta el método `main()` en la clase `Editor` para iniciar la aplicación.

2. **Interfaz de usuario:**
    - Una vez abierto el editor, encontrarás una variedad de opciones en la parte superior para manipular el texto, cambiar el formato y el color, y activar el modo oscuro.

3. **Funcionalidades principales:**
    - **Negrita, Cursiva, Subrayado, Subíndice y Superíndice:** Utiliza los botones correspondientes para aplicar estos estilos al texto seleccionado en el área de texto.
    - **Cambio de fuente y tamaño:** Selecciona la fuente y el tamaño deseados en los combos respectivos para modificar el formato del texto.
    - **Cambio de color:** Haz clic en el botón "Color" para seleccionar un color y aplicarlo al texto seleccionado.
    - **Modo oscuro:** Activa o desactiva el modo oscuro haciendo clic en el botón correspondiente.

4. **Clases internas:**
    - Para ver el código y detalles de cada clase interna, puedes dirigirte a las siguientes secciones del archivo Java:
        - `ModOscuro`: Controla el modo oscuro del editor.
        - `NegrListener`: Maneja eventos para aplicar negrita al texto.
        - `CursListener`: Maneja eventos para aplicar cursiva al texto.
        - `SubrListener`: Maneja eventos para aplicar subrayado al texto.
        - `SubindiceListener`: Maneja eventos para aplicar subíndice al texto.
        - `SuperindiceListener`: Maneja eventos para aplicar superíndice al texto.
        - `FormatoListener`: Maneja eventos para cambiar la fuente del texto.
        - `TamanyoListener`: Maneja eventos para cambiar el tamaño de la fuente del texto.
        - `ColorListener`: Maneja eventos para cambiar el color del texto.


## Dependencias y requisitos

- Este proyecto ha sido desarrollado en Java y requiere un entorno de ejecución Java (JRE) para ejecutarse correctamente.
- No se requieren dependencias externas adicionales.

