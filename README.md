
# API Users BCI

Aplicación desarrollada en spring boot con jwt, clean arquitecture, api first y base de datos en memoria (H2)

La aplicación genera las interfaces de forma automática desde gradle (```Tasks -> other -> generateApi```)

El contrato se encuentra en ```src/main/resources/api.yaml``` y se puede revisar en [swagger editor](https://editor.swagger.io/)

Diagramas en ```src/main/resources/diagramas```

## Modo de uso
Se deben clonar las fuentes desde github [repo](https://github.com/fquinterosm/users)

Se deben descargas las dependencias de ```build.gradle```

Se incluye colección de postman en ```src/main/resources/postman/UserBCI.postman_collection.json```

Al ejecutar la aplicación se levantará la base de datos en memoria e insertará los datos que se encuentran en ```src/main/resources/data.sql``` 

El primer servicio que se debe ejecutar en el de ```login``` para obtener el jwt con el email y password que se genera en la base de datos por ejemplo:

```json
{
  "email": "admin@admin.com",
  "password": "password"
}
```

Luego de obtener el token en la sección de Authorization de postamn por ejemplo se agrega el jwt de tipo Bearer Token y se pueden ejecutar los otros endpoint.

Se dejó la validación de correo y password configurable en el servicio customValidation, se puede cambiar el pattern de validación del password y se pueden agregar mensajes


## Pendientes
Por tiempo no están todos los test unitarios 



