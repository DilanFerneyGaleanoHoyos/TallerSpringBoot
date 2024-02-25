# TallerSpringBoot
## Controlador de Veterinarios
Descripción
El veterinarian-controller gestiona operaciones relacionadas con veterinarios en el sistema.

## Endpoints Veterinarios
### Agregar Mascota a Veterinario
   PUT /veterinarians/addPet/{veterinarianId}/{petId}
   Descripción: Asocia una mascota con un veterinario.
   Parámetros:
   veterinarianId (parámetro de ruta): El ID del veterinario.
   petId (parámetro de ruta): El ID de la mascota que se va a asociar. 
   ### Obtener Todos los Veterinarios
   GET /veterinarians
   Descripción: Obtiene una lista de todos los veterinarios.
   ### Agregar Veterinario
   POST /veterinarians
   Descripción: Crea un nuevo veterinario.
   ### Obtener Veterinario por ID
   GET /veterinarians/{id}
   Descripción: Obtiene un veterinario por su ID.
   Parámetros:
   id (parámetro de ruta): El ID del veterinario a recuperar.
   ### Eliminar Veterinario
   DELETE /veterinarians/{id}
   Descripción: Elimina un veterinario por su ID.
   Parámetros:
   id (parámetro de ruta): El ID del veterinario a eliminar.
   Controlador de Registros
   Descripción
   El record-controller gestiona operaciones relacionadas con registros de mascotas en el sistema.

## Endpoints Registro 
### Agregar Registro para Mascota
   POST /records/{petId}
   Descripción: Crea un nuevo registro para una mascota.
   Parámetros:
   petId (parámetro de ruta): El ID de la mascota para la cual se está agregando el registro.
   ### Obtener Todos los Registros
   GET /records
   Descripción: Obtiene una lista de todos los registros de mascotas.
   ### Obtener Registro por ID
   GET /records/{id}
   Descripción: Obtiene un registro de mascota por su ID.
   Parámetros:
   id (parámetro de ruta): El ID del registro a recuperar.
   ### Eliminar Registro
   DELETE /records/{id}
   Descripción: Elimina un registro de mascota por su ID.
   Parámetros:
   id (parámetro de ruta): El ID del registro a eliminar.
   Controlador de Mascotas
   Descripción
   El pet-controller gestiona operaciones relacionadas con mascotas en el sistema.

## Endpoints Mascotas
### Obtener Todas las Mascotas
   GET /pets
   Descripción: Obtiene una lista de todas las mascotas.
   ### Agregar Mascota
   POST /pets
   Descripción: Crea una nueva mascota.
   ### Obtener Mascota por ID
   GET /pets/{id}
   Descripción: Obtiene una mascota por su ID.
   Parámetros:
   id (parámetro de ruta): El ID de la mascota a recuperar.
   ### Eliminar Mascota
   DELETE /pets/{id}
   Descripción: Elimina una mascota por su ID.
   Parámetros:
   id (parámetro de ruta): El ID de la mascota a eliminar.
   Controlador de Clientes
   Descripción
   El client-controller gestiona operaciones relacionadas con clientes en el sistema.

## Endpoints Clientes o dueños
### Obtener Todos los Clientes
   GET /clients
   Descripción: Obtiene una lista de todos los clientes.
   ### Agregar Cliente
   POST /clients
   Descripción: Crea un nuevo cliente.
   ### Obtener Cliente por ID
   GET /clients/{id}
   Descripción: Obtiene un cliente por su ID.
   Parámetros:
   id (parámetro de ruta): El ID del cliente a recuperar.
   ### Eliminar Cliente
   DELETE /clients/{id}
   Descripción: Elimina un cliente por su ID.
   Parámetros:
   id (parámetro de ruta): El ID del cliente a eliminar.
   ## Tecnologías Utilizadas
   Supabase: Para almacenamiento y gestión de datos.
   Spring Boot: Para construir la aplicación de backend.
   Maven: Para gestión del proyecto y resolución de dependencias.
