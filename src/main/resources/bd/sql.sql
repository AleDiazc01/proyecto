drop schema delacasa ;
drop user usuario_prueba;

CREATE SCHEMA delacasa ;
create user 'usuario_prueba'@'%' identified by 'Usuar1o_Clave.';
grant all privileges on delacasa.* to 'usuario_prueba'@'%';
flush privileges;

create table delacasa.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20),
  password varchar(200),
PRIMARY KEY (id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE delacasa.cliente (
  id_cliente INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  telefono VARCHAR(15) NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE delacasa.receta (
  id_receta INT NOT NULL AUTO_INCREMENT,
  id_cliente INT NOT NULL,	
  nombre VARCHAR(50) NOT NULL,
  descripcion VARCHAR(120) NOT NULL,
  ingredientes TEXT NOT NULL,
  preparacion TEXT NOT NULL,
	imagen varchar(150),
foreign key fk_receta_cliente (id_cliente) references cliente(id_cliente) ,
  PRIMARY KEY (`id_receta`))
  ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE delacasa.comentario (
  id_comentario INT NOT NULL AUTO_INCREMENT,
  id_receta INT NOT NULL,	
  id_cliente INT NOT NULL,
  texto VARCHAR(400) NOT NULL,
foreign key fk_comentario_receta (id_receta) references receta(id_receta) ,
foreign key fk_comentario_cliente (id_cliente) references cliente(id_cliente) ,
  PRIMARY KEY (`id_comentario`))
  ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;



 
INSERT INTO delacasa.cliente (id_cliente, nombre, apellidos, correo, telefono) VALUES 
(1,'Juan', 'Castro Mora',    'jcastro@gmail.com',    '4556-8978'),
(2,'Ana',  'Contreras Mora', 'acontreras@gmail.com', '5456-8789'),
(3,'Luis', 'Mena Loria',     'lmena@gmail.com',      '7898-8936');

create table delacasa.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

insert into delacasa.usuario (id_usuario, username, password) values 
(1,'juan','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.'),
(2,'rebeca','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi'),
(3,'pedro','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO');

insert into delacasa.rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_ADMIN',1), (2,'ROLE_VENDEDOR',1), (3,'ROLE_USER',1),
 (4,'ROLE_VENDEDOR',2), (5,'ROLE_USER',2),
 (6,'ROLE_USER',3);
 
INSERT INTO delacasa.receta (id_receta,id_cliente, nombre, descripcion, ingredientes, preparacion,imagen) VALUES 
(1,1, 'Arroz con Pollo', 'Un plato tradicional de la cocina peruana que combina arroz, pollo, cebolla, ají amarillo, ajo y cilantro.', '1 taza de arroz, 4 presas de pollo, 1 cebolla picada, 1 ají amarillo picado, 2 dientes de ajo picados, 1/2 taza de cilantro picado', '1. Sofría la cebolla, el ají y el ajo en aceite hasta que estén dorados. 2. Agregue el pollo y cocine hasta que esté dorado. 3. Añada el arroz y mezcle bien. 4. Agregue agua suficiente para cubrir el arroz y deje cocinar hasta que el agua se haya absorbido. 5. Tape la olla y cocine a fuego bajo hasta que el arroz esté cocido. 6. Agregue cilantro picado y mezcle bien antes de servir.','https://upload.wikimedia.org/wikipedia/commons/3/39/Arroz-con-Pollo.jpg'),
(2,1, 'Ensalada César', 'Una ensalada de lechuga romana, crutones, parmesano y pollo. Se sirve con una salsa César.', '1 lechuga romana, 2 pechugas de pollo, 1/2 taza de crutones, 1/2 taza de queso parmesano rallado, 1/2 taza de salsa César', '1. Cocine las pechugas de pollo a la parrilla o a la plancha hasta que estén doradas. 2. Lave y corte la lechuga en trozos pequeños. 3. Agregue los crutones, el queso y la salsa César a la lechuga. 4. Corte el pollo en tiras y agregue a la ensalada antes de servir.','https://www.goodnes.com/sites/g/files/jgfbjl321/files/srh_recipes/755f697272cbcdc6e5df2adb44b1b705.jpg'),
(3,3, 'Spaghetti a la Boloñesa', 'Una pasta italiana clásica con una salsa a base de carne de res, tomates y especias.', '1 paquete de spaghetti, 1/2 libra de carne molida, 1 lata de tomates pelados, 1 cebolla picada, 2 dientes de ajo picados, 1/4 taza de vino tinto, 1 cucharadita de orégano, 1 cucharadita de albahaca, Sal y pimienta', '1. Cocine la pasta según las instrucciones del paquete. 2. En una sartén, sofría la cebolla y el ajo en aceite hasta que estén dorados. 3. Agregue la carne molida y cocine hasta que esté dorada. 4. Agregue los tomates pelados, el vino tinto, el orégano y la albahaca. 5. Cocine a fuego medio hasta que la salsa espese. 6. Sirva la pasta con la salsa y queso parmesano rallado al gusto.','https://www.laespanolaaceites.com/wp-content/uploads/2019/05/espaguetis-a-la-bolonesa-1080x671.jpg'),
(4,2, 'Tacos de Carne Asada', 'Tacos mexicanos rellenos de carne asada, cebolla, cilantro y limón.', '1 libra de carne asada, 1 cebolla picada, 1/2 taza de cilantro picado, 1 limón, Sal y pimienta, Tortillas de maíz', '1. Cocine la carne asada a la parrilla o a la plancha hasta que esté dorada. 2. Corte la carne en tiras. 3. Caliente las tortillas de maíz en una sartén o en el horno. 4. Rellene cada tortilla con carne asada, cebolla, cilantro y limón. 5. Sirva caliente.','https://www.goya.com/media/4124/carne-asada-tacos1.jpg?quality=80'),
(5,3, 'Ensalada de quinoa y aguacate', 'Una ensalada saludable y deliciosa con quinoa, aguacate y verduras frescas.', '1 taza de quinoa,2 tazas de agua,1/2 cebolla roja, picada,1 tomate grande, picado,1 aguacate maduro, cortado en cubos,1/4 taza de cilantro fresco picado,2 cucharadas de jugo de limón,1 cucharada de aceite de oliva,Sal y pimienta al gusto', '1.Enjuaga la quinoa en un colador y ponla en una olla con el agua.2.Lleva la quinoa a ebullición, baja el fuego y deja cocinar tapado durante unos 15-20 minutos, o hasta que el agua se haya evaporado y los granos estén suaves.3.Mientras tanto, prepara los demás ingredientes y mézclalos en un tazón grande.4.Una vez que la quinoa esté cocida, agrégala a la mezcla de ingredientes y revuelve para combinar.5.Agrega el jugo de limón, aceite de oliva, sal y pimienta al gusto y mezcla bien.6.Sirve la ensalada y disfruta.','https://p1.pxfuel.com/preview/903/434/406/quinoa-quinoa-salad-salad-spoon.jpg');

insert into delacasa.comentario (id_comentario, id_receta,id_cliente, texto) values 
(1,1,1,'Usa un temporizador para asegurarte de que no se te pase la comida.'),
(2,2,3,'Lee la receta completa antes de comenzar a cocinar.'),
(3,3,2,'Prueba la comida antes de servirla y ajusta la sazón si es necesario.'),
(4,4,2,'Limpia a medida que avanzas para evitar una gran cantidad de platos y utensilios sucios.'),
(5,2,3,'Usa cuchillos afilados para evitar lesiones y hacer el trabajo más fácil.'),
(6,1,2,'Lava el arroz antes de cocinarlo para eliminar el exceso de almidón y evitar que se pegue.'),
(7,5,1,'Usa una proporción de 2 partes de agua por cada parte de arroz.'),
(8,3,3,'Una vez que el agua empiece a hervir, baja el fuego a bajo y tapa la olla para que el arroz se cocine a fuego lento.'),
(9,4,1,'No destapes la olla hasta que el arroz esté completamente cocido y el agua se haya evaporado.'),
(10,2,3,'Una vez que el arroz esté cocido, déjalo reposar tapado durante unos minutos antes de servir para que los granos se asienten y estén más suaves.');
 