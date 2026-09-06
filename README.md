![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🧠  Actividad Formativa 3: Ejecutando tareas en paralelo con hilos en java

## 👤 Autor del proyecto
- **Nombre completo:** [Ariel Gustavo Loncon Lefimil]
- **Sección:** [008A]
- **Carrera:** Desarrollo de aplicaciones
- **Sede:** [Online]

---

# Sistema de Gestión de Envíos - SpeedFast

Proyecto desarrollado para la asignatura **Desarrollo Orientado a Objetos II** (Semana 4 / Evaluación Formativa). Consiste en un sistema integral de reparto de pedidos que gestiona la asignación de repartidores, incorporando programación concurrente y ejecución multihilo mediante `Runnable` y `ExecutorService`.

---

## 📋 Características y Principios Aplicados

### 1. Jerarquía de Clases y Abstracción (Incorporado pero en desuso)
* **`pedido`**: Clase abstracta base que encapsula los atributos comunes (`idPedido`, `direccionEntrega`, `tipoEntrega`, `distanciaKm`, `repartidor`, `estado`).
* **`calcularTiempoEntrega()`**: Método abstracto que implementa la lógica específica de estimación de tiempo según el tipo de pedido:
  * `pedidoComida`: $15 + (2 \times \text{distancia})$.
  * `pedidoEncomienda`: $20 + (1.5 \times \text{distancia})$.
  * `pedidoExpress`: 10 minutos base (+5 min por cada 5 km extra).

### 2. Polimorfismo (Incorporado pero en desuso)
* **Sobrescritura (`@Override`)**: Método `asignarRepartidor()` adaptado en cada subclase para la asignación automática por tipo de servicio.
* **Sobrecarga**: Método `asignarRepartidor(String nombre)` disponible en la clase base para permitir la asignación manual de repartidores.

### 3. Interfaces y Desacoplamiento
* **`despachable`**: Define la capacidad de despachar el pedido actualizando su estado.
* **`cancelable`**: Define el comportamiento para anular un envío.
* **`rastreable`**: Implementada en `controladorDeEnvios` para desacoplar el almacenamiento y visualización del historial de entregas.

### 3. Programación Concurrente y Multihilo 
* **`Repartidor` (`Runnable`)**: Representa un trabajador independiente que procesa una lista asignada de pedidos. Cada repartidor corre en su propio hilo de ejecución, simulando la entrega con demoras aleatorias (`Thread.sleep()`).
* **`ExecutorService`**: Gestor de pool de hilos (`Executors.newFixedThreadPool`) que coordina la ejecución paralela e independiente de los repartidores en el `Main`, asegurando un apagado ordenado y sincronizado (`shutdown` / `awaitTermination`).

---

## 🛠️ Estructura del Proyecto

```text
src/
├── data/
│   └── ControladorDeEnvios.java
├── main/
│   └── Main.java
└── model/
    ├── interfaces/
    │   ├── Cancelable.java
    │   ├── Despachable.java
    │   └── Rastreable.java
    ├── Pedido.java
    ├── PedidoComida.java
    ├── PedidoEncomienda.java
    └── PedidoExpress.java
    └── Repartido.java

---

**Fecha de entrega: [07/09/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad Sumativa 1: Diseñando un sistema orientado a objetos con clases abstractas, polimorfismo e interfaces
