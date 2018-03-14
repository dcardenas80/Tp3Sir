# TP3SIR 

Ce repositoire a le code d'une application qui montre l'implantation de bases de données non relationnelles (MongoDB, Redis) et des exemples en java de persistance avec ces bases.

## Reponse Questions TP
- Quelles sont les limites d’une base données orientées document ?
    la plupart de bases de données non-sql ne peuvent pas faire de transactions de type ACID, les propriétés ACID dans les bases de données SQL permet de garder la validité des données, par exemple à la présence des erreurs durant la transaction.
- Quelles sont les types de données stockés dans Redis, que peut on faire comme types de requêtes ? 
    les types de données stockés sur Redis sont:
    - String
    - Hashes
    - listes
    - Sets
    - Sorted sets
    - Bit arrays
    - HyperLogLogs.
    
    Redis a plusieurs commandes pour faire de requêtes vers les bases de données mais, aussi au redis pour l'administration des bases, par exemple des commandes on peut mentionner append qui donne une valeur à une clé, la commande Key qui permet d'avoir toutes les clés qui suivent un même patron, la commande move qui permet de déplacer une clé à une autre base de données.
    
## Instalation et Mise en marche du projet 
une fois le projet soit telechargé ou clone du repositoire github, importer sur eclipse et faire courir la classe APP, pour faire marcher ce projet il faut avoir installe une distribution de MongoDB et avoir lancé le serveur Redis.
