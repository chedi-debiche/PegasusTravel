-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 07 mars 2022 à 17:58
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pegasustravel`
--

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `idEvent` int(11) NOT NULL,
  `nomEvent` varchar(255) NOT NULL,
  `prixEvent` float NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`idEvent`, `nomEvent`, `prixEvent`, `date`) VALUES
(1, 'Haloween', 200, '2022-10-30'),
(2, 'Valentine', 150, '2022-02-14'),
(3, 'New Year', 200, '2022-01-01'),
(4, 'Birthday', 200, '2022-01-13'),
(5, 'fghjk', 500, '2022-03-23'),
(6, 'hihihihih', 1234.77, '2022-04-10'),
(7, 'tyui', 123.234, '2022-03-10');

-- --------------------------------------------------------

--
-- Structure de la table `maisonh`
--

CREATE TABLE `maisonh` (
  `id_maison` int(3) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `localisation` varchar(1000) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `prix` float NOT NULL,
  `image_maison` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `maisonh`
--

INSERT INTO `maisonh` (`id_maison`, `nom`, `localisation`, `description`, `prix`, `image_maison`) VALUES
(1, 'HIDEAWAY AIN DRAHEM', 'AIN DRAHEM', 'J’ai hâte d’accueillir à nouveau nos amoureux de la nature 😊C’est enfin notre saison préférée ❄️ 🌧L’équipe de HIDEAWAY aindrahem réouvre le chalet avec une nouvelle ambiance unique. 🇹🇳', 950, 'C:\\Users\\CC\\Pictures\\integrationTest1\\src\\Image\\1318106.jpg'),
(2, 'Borj Waly', 'Hammamet, Tunisie\r\n', 'Idéalement située à quelques kilomètres des villages Berbères de Jeradou, Takrouna et Zriba el Olya, notre maison de vacances vous accueille au cours d\'un séjour où vous trouverez votre bonheur, dépaysement, confort et repos autour d\'un feu de cheminée.\r\n\r\n', 370.5, ''),
(3, 'Dar Nejma', 'Tozeur, Tunisie\r\n', 'Situé à 3,5 km du zoo du Sahara, le Dar Nejma vous propose une piscine extérieure ouverte en saison et un jardin, ainsi que des hébergements climatisés dotés d\'une terrasse et d\'une connexion Wi-Fi gratuite.\r\n\r\n', 877, ''),
(4, 'Dar Boumakhlouf', 'El Kef, Tunisie\r\n', 'Au cœur de la médina d\'El KEF, Dar Boumakhlouf, un joyau à l architecture mauresque et à l\'accueil convivial vous ouvre ses portes. La terrasse Panoramique, avec vue sur la Table deJugurta en toile de fond.', 800, ''),
(5, 'Dar Jerba Narjess', 'Djerba, Tunisie\r\n', 'Situé à Djerba, l’île des rêves! l’hôtel Dar Jerba Narjess est à quelques minutes du parc Djerba explore l’un des endroits les plus visités de Djerba. l’hôtel est à seulement quelques kilomètres de la ville Midoun.\r\n', 760.2, ''),
(6, 'Le grand Vert', 'morneg , tunis', 'maison ', 450, '');

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

CREATE TABLE `publication` (
  `idPub` int(11) NOT NULL,
  `datePub` date NOT NULL,
  `Path` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`idPub`, `datePub`, `Path`, `description`) VALUES
(4, '2022-03-11', 'C:\\xampp\\htdocs\\imgDar-El-Bhar-Maison-dhôtes-a-Hammamet-1024x681.jpg', 'votre hotel'),
(5, '2022-03-18', 'C:\\xampp\\htdocs\\imgdar-nour-3.jpg', 'gchdbsj xn'),
(8, '2022-03-09', 'C:\\xampp\\htdocs\\img15195912_1169431346425532_566600027455660054_o.jpg', 'sxdfgh');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `numero` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `commentaire` varchar(255) NOT NULL,
  `dateReclamation` date NOT NULL,
  `typeReclamation` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`numero`, `nom`, `prenom`, `email`, `commentaire`, `dateReclamation`, `typeReclamation`, `id`) VALUES
(1, 'khitem', 'mathlouthi', 'gg', 'gg', '2022-03-11', 'Evenement', 14),
(3, 'a', 'a', 'a', 'a', '2022-03-10', 'Hotel', 14),
(4, 'a', 'a', 'a', 'a', '2022-03-10', 'Hotel', 14),
(6, 'a', 'a', 'a', 'spam', '2022-03-18', 'Voyage', 14),
(7, 'a', 'aaa', 'aa', 'spam', '2022-03-18', 'Voyage', 14),
(8, 'e', 'e', 'e', 'spam', '2022-03-18', 'Voyage', 14),
(9, 'a', 'ea', 'ea', 'spam', '2022-03-18', 'Hotel', 14),
(11, 'rahma', 'a', 'a', 'a', '2022-03-17', 'Voyage', 14),
(12, 'pst', 'pst', 'pst', 'pp', '2022-03-11', 'Hotel', 14),
(13, 'rahma', 'rahma', 'rahma.tiss@esprit.tn', 'alo', '2022-03-10', 'Voyage', 14),
(14, 'khitem', 'mathlouthi', 'gg', 'gg', '2022-03-11', 'Evenement', 14);

-- --------------------------------------------------------

--
-- Structure de la table `reponsereclamation`
--

CREATE TABLE `reponsereclamation` (
  `IdRep` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `Reponse` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reponsereclamation`
--

INSERT INTO `reponsereclamation` (`IdRep`, `numero`, `Reponse`) VALUES
(1, 1, 'aa'),
(2, 3, 'aaaa'),
(3, 3, 'a'),
(6, 13, 'dfgb'),
(7, 13, 'dfgb'),
(8, 13, 'dfgb'),
(9, 13, 'dfgb'),
(10, 13, 'aaaaaa'),
(12, 12, 'aaaaaa');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `idClient` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `nomClient` varchar(255) NOT NULL,
  `prenomClient` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reservationevenement`
--

CREATE TABLE `reservationevenement` (
  `idRE` int(11) NOT NULL,
  `nomRE` varchar(255) NOT NULL,
  `dateRE` date NOT NULL,
  `idEvent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservationevenement`
--

INSERT INTO `reservationevenement` (`idRE`, `nomRE`, `dateRE`, `idEvent`) VALUES
(1, 'nono', '2022-03-17', 2),
(7, 'mimi', '2022-03-24', 1),
(9, 'new reservation ', '2022-02-14', 2),
(10, 'new reservation1 ', '2022-03-05', 5),
(11, 'Haloween', '2022-03-05', 1),
(12, 'today', '2022-03-05', 5),
(14, 'New Year', '2022-03-05', 3);

-- --------------------------------------------------------

--
-- Structure de la table `reservationm`
--

CREATE TABLE `reservationm` (
  `id_res` int(11) NOT NULL,
  `nb_chambre` int(11) NOT NULL,
  `nb_personne` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `id_maison` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reservationv`
--

CREATE TABLE `reservationv` (
  `IdR` int(11) NOT NULL,
  `NB_personnes` int(11) NOT NULL,
  `Date` varchar(30) NOT NULL,
  `Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservationv`
--

INSERT INTO `reservationv` (`IdR`, `NB_personnes`, `Date`, `Id`) VALUES
(123456, 2, '2022-04-01', 2000);

-- --------------------------------------------------------

--
-- Structure de la table `sponsor`
--

CREATE TABLE `sponsor` (
  `idS` int(11) NOT NULL,
  `prenomS` varchar(255) NOT NULL,
  `descriptionS` varchar(255) NOT NULL,
  `nomS` varchar(255) NOT NULL,
  `imageS` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `sponsor`
--

INSERT INTO `sponsor` (`idS`, `prenomS`, `descriptionS`, `nomS`, `imageS`) VALUES
(1, 'mouthlouthi', 'naghara', 'khoutam', 'strin'),
(2, 'khitem', '1000', 'mathlouthi', 'string1'),
(5, 'mylove', 'myworld', 'mimi', 'string5'),
(6, 'tiss', 'azer', 'vasco', 'C:\\Users\\rahma\\Desktop\\java\\Pijava\\Images271741865_1001556257466077_5068675950781625094_n.jpg'),
(10, 'yohohooh', 'ldxugh', 'oyuifcv', 'C:\\Users\\rahma\\Desktop\\java\\Pijava\\ImagesWIN_20210217_11_40_15_Pro.jpg'),
(12, 'kjfb', 'qldhkfbjs', 'yoyoyoy', 'string3'),
(14, 'cola', 'kdjzhgfsdjkfgsjh', 'coca', 'C:\\xampp\\htdocs\\img1318106.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `pwd` varchar(500) NOT NULL,
  `poste` varchar(30) DEFAULT NULL,
  `salaire` varchar(30) DEFAULT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `nom`, `prenom`, `email`, `pwd`, `poste`, `salaire`, `role`) VALUES
(14, 'skye', 'kiticat', 'sova@russia', 'imthehunter', NULL, NULL, 'Client'),
(20, 'Brimstone', 'hernandes', 'reyna@mexice', 'youarcaword', 'duelst', '1000', 'employee'),
(21, 'kratos', 'godofwar', 'Artuse@myson', 'b616c24c5a2f72da2a3070fd0a137b8fd3a44f52', NULL, '3000', 'admin'),
(22, 'kratos', 'godofwar', 'Artuse@myson', 'ilikefighting', NULL, '3000', 'admin'),
(23, 'Mimir', 'sage', 'sage@gmail.com', 'iheb', NULL, NULL, 'Client'),
(39, 'iheb ', 'zoghlami', 'iheb@gmail.com', 'ihebiheb', NULL, NULL, 'Client'),
(79, 'qsdqsdq', 'qsdqsd', 'qsdqsd', 'qsdqsd', NULL, NULL, 'Client'),
(80, 'iheb', 'zg', 'zg@gmail.com', 'iheb', NULL, NULL, 'Client'),
(81, 'iheb', 'zgzg', 'qsdqsdqsd', 'iheb', NULL, NULL, 'Client'),
(82, 'chedi', 'debiche', 'chedi.de@efgef.com', '37f4331f458be95e77dd379b951d74d4cfe1db5c', NULL, NULL, 'Client'),
(83, 'chedi', 'debiche', 'chedidebiche1@gmail.com', '37f4331f458be95e77dd379b951d74d4cfe1db5c', '', '1500', 'admin'),
(84, 'zew', 'zg', 'zewpain98@gmail.com', 'b1f8662fa6828b138efff79b05d5f0ca9126d14c', NULL, NULL, 'Client');

-- --------------------------------------------------------

--
-- Structure de la table `voyage`
--

CREATE TABLE `voyage` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(150) NOT NULL,
  `Destination` varchar(30) NOT NULL,
  `Description` varchar(2000) NOT NULL,
  `Prix` int(11) NOT NULL,
  `Image` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `voyage`
--

INSERT INTO `voyage` (`Id`, `Nom`, `Destination`, `Description`, `Prix`, `Image`) VALUES
(1221, 'Voyage À Istanbul À Prix Imbattable', 'Istanbul - Turquie', 'Istanbul peut être considérée comme la capitale turque de la culture et de la mode et offre de nombreuses opportunités de shopping. La variété de magasins de la ville allant des produits traditionnels aux produits modernes fait d’Istanbul un centre d’attraction pour les amateurs de shopping', 1200, 'javafx.scene.image.Image@70e2a71'),
(2000, 'Escapade Au Caire À Petit Prix', 'Le Caire - Egypte', 'Egypte peut être considérée comme la capitale turque de la culture et de la mode et offre de nombreuses opportunités de shopping. La variété de magasins de la ville allant des produits traditionnels aux produits modernes fait d’Istanbul un centre d’attraction pour les amateurs de shopping', 1400, 'null');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`idEvent`),
  ADD UNIQUE KEY `idEvent` (`idEvent`);

--
-- Index pour la table `maisonh`
--
ALTER TABLE `maisonh`
  ADD PRIMARY KEY (`id_maison`);

--
-- Index pour la table `publication`
--
ALTER TABLE `publication`
  ADD PRIMARY KEY (`idPub`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `reponsereclamation`
--
ALTER TABLE `reponsereclamation`
  ADD PRIMARY KEY (`IdRep`),
  ADD KEY `numero` (`numero`);

--
-- Index pour la table `reservationevenement`
--
ALTER TABLE `reservationevenement`
  ADD PRIMARY KEY (`idRE`),
  ADD KEY `idEvent` (`idEvent`);

--
-- Index pour la table `reservationm`
--
ALTER TABLE `reservationm`
  ADD PRIMARY KEY (`id_res`),
  ADD KEY `maisonH_reservationm` (`id_maison`);

--
-- Index pour la table `reservationv`
--
ALTER TABLE `reservationv`
  ADD PRIMARY KEY (`IdR`),
  ADD KEY `Id` (`Id`);

--
-- Index pour la table `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`idS`),
  ADD UNIQUE KEY `idS` (`idS`),
  ADD UNIQUE KEY `idS_2` (`idS`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `voyage`
--
ALTER TABLE `voyage`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `idEvent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `maisonh`
--
ALTER TABLE `maisonh`
  MODIFY `id_maison` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `publication`
--
ALTER TABLE `publication`
  MODIFY `idPub` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `reponsereclamation`
--
ALTER TABLE `reponsereclamation`
  MODIFY `IdRep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `reservationevenement`
--
ALTER TABLE `reservationevenement`
  MODIFY `idRE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `reservationm`
--
ALTER TABLE `reservationm`
  MODIFY `id_res` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=155044334;

--
-- AUTO_INCREMENT pour la table `reservationv`
--
ALTER TABLE `reservationv`
  MODIFY `IdR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13243463;

--
-- AUTO_INCREMENT pour la table `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `idS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT pour la table `voyage`
--
ALTER TABLE `voyage`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9877;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `reclamation_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `reponsereclamation`
--
ALTER TABLE `reponsereclamation`
  ADD CONSTRAINT `reponsereclamation_ibfk_1` FOREIGN KEY (`numero`) REFERENCES `reclamation` (`numero`);

--
-- Contraintes pour la table `reservationevenement`
--
ALTER TABLE `reservationevenement`
  ADD CONSTRAINT `reservationevenement_ibfk_1` FOREIGN KEY (`idEvent`) REFERENCES `evenement` (`idEvent`);

--
-- Contraintes pour la table `reservationm`
--
ALTER TABLE `reservationm`
  ADD CONSTRAINT `maisonH_reservationm` FOREIGN KEY (`id_maison`) REFERENCES `maisonh` (`id_maison`);

--
-- Contraintes pour la table `reservationv`
--
ALTER TABLE `reservationv`
  ADD CONSTRAINT `voyage_reservationv` FOREIGN KEY (`Id`) REFERENCES `voyage` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
