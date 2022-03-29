# IPAU Problematica Location 

Servicio backend que provee una serie de **endpoints** para el ABMC de problemáticas. Estas problemáticas las genera el usuario utilizando la aplicación **IPAU**.

## Endpoints

- `problematicasLocation`: Lista todas las problemáticas.
- `/problematicasLocationPerPrivacy/{isPrivacy}/{idProb3}`: Lista una problemática específica. Se debe enviarle:
    - isPrivacy: determina si la problemática localizada es privada
    - idProb3: Id de la problemática nivel 3.
- `/getLocation/{latitud}/{longitud}`: obtiene una problemática utilizando la latitud y longitud especificada.
- `/locationsProb3/{prob3}`: obtiene una problemática de nivel 3 utilizando el id especificado.
- `/addProblematicaLocation`: permite agregar una problemática.
- `/updateCountMarker/{idProbLocation}`: permite aumentar las veces que una misma problemática fue localizada.