# pokedexApiChallenge
Consumo de PokeApi y exposición de endPoint para busqueda de descripcion basica de Pokemon por nombre o id

# Plataforma de despliegue

Heroku 

# EndPoint
 https://pokedex-challenge-modyo.herokuapp.com/v1/pokedex/getPokemonByName/{nameOrId}
# Method
 Get
# Required Authentication
 No
# Response
code: Codigo respuesta Http  
message: Mensaje respuesta  
data: Objeto PokemonResponse  
id: id del pokemon  
name: Nombre del pokemon  
sprites: Objeto con informacion de foto  
front_default: foto frontal  
Types: lista de tipos  
Type: tipo de pokemon  
weight: peso  
abilities: Lista de habilidades

```yaml

{
    "code": 200,
    "message": "Found",
    "data": {
        "id": 1,
        "name": "bulbasaur",
        "sprites": {
            "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
        },
        "types": [
            {
                "type": {
                    "name": "grass"
                }
            },
            {
                "type": {
                    "name": "poison"
                }
            }
        ],
        "weight": "69",
        "abilities": [
            {
                "ability": {
                    "name": "overgrow"
                }
            },
            {
                "ability": {
                    "name": "chlorophyll"
                }
            }
        ]
    }
}


# Example:
 https://pokedex-challenge-modyo.herokuapp.com/v1/pokedex/getPokemonByName/1  
 https://pokedex-challenge-modyo.herokuapp.com/v1/pokedex/getPokemonByName/pikachu
