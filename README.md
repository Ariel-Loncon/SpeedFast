# Sistema de Gestión de Envíos - SpeedFast

Proyecto desarrollado para la asignatura **Desarrollo Orientado a Objetos II** (Semana 3 / Evaluación Sumativa). Consiste en un sistema integral de reparto de pedidos que gestiona la asignación de repartidores, estimación de tiempos de entrega, despacho, cancelación e historial de envíos.

---

## 📋 Características y Principios Aplicados

### 1. Jerarquía de Clases y Abstracción
* **`pedido`**: Clase abstracta base que encapsula los atributos comunes (`idPedido`, `direccionEntrega`, `tipoEntrega`, `distanciaKm`, `repartidor`, `estado`).
* **`calcularTiempoEntrega()`**: Método abstracto que implementa la lógica específica de estimación de tiempo según el tipo de pedido:
  * `pedidoComida`: $15 + (2 \times \text{distancia})$.
  * `pedidoEncomienda`: $20 + (1.5 \times \text{distancia})$.
  * `pedidoExpress`: 10 minutos base (+5 min por cada 5 km extra).

### 2. Polimorfismo
* **Sobrescritura (`@Override`)**: Método `asignarRepartidor()` adaptado en cada subclase para la asignación automática por tipo de servicio.
* **Sobrecarga**: Método `asignarRepartidor(String nombre)` disponible en la clase base para permitir la asignación manual de repartidores.

### 3. Interfaces y Desacoplamiento
* **`despachable`**: Define la capacidad de despachar el pedido actualizando su estado.
* **`cancelable`**: Define el comportamiento para anular un envío.
* **`rastreable`**: Implementada en `controladorDeEnvios` para desacoplar el almacenamiento y visualización del historial de entregas.

---

## 🛠️ Estructura del Proyecto

```text
src/
├── data/
│   └── controladorDeEnvios.java
├── main/
│   └── main.java
└── model/
    ├── interfaces/
    │   ├── cancelable.java
    │   ├── despachable.java
    │   └── rastreable.java
    ├── pedido.java
    ├── pedidoComida.java
    ├── pedidoEncomienda.java
    └── pedidoExpress.java
