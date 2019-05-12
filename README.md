# MVP_Petagram

queryCrearTablaMascotas = "CREATE TABLE mascotas (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, imagen INTEGER, dinamico BOOLEAN)";

queryCrearTablaLikesMascotas = "CREATE TABLE mascotasLikes (id INTEGER PRIMARY KEY AUTOINCREMENT, id_contacto INTEGER, likes INTEGER,
FOREIGN KEY (id_contacto) REFERENCES mascotas (id))";

queryCrearTablaFavsMascotas = "CREATE TABLE mascotaFavs (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, id_contacto INTEGER,
imagen INTEGER, dinamico BOOLEAN, FOREIGN KEY (id_contacto) REFERENCES mascotas (id))";
