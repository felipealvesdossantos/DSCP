-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2.1
-- http://www.phpmyadmin.net
--
-- Máquina: 186.202.152.144
-- Data de Criação: 01-Jul-2014 às 22:45
-- Versão do servidor: 5.1.71
-- versão do PHP: 5.3.3-7+squeeze18

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `site312701`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `atividade`
--

CREATE TABLE IF NOT EXISTS `atividade` (
  `idAtividade` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `codigoMae` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `descricao` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `formula` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `pontos` float DEFAULT NULL,
  `idAtividadeMae_idAtividade` int(11) DEFAULT NULL,
  `idFormula` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAtividade`),
  KEY `FK_bw8lhsxxx8bybtxguy0s3thjj` (`idAtividadeMae_idAtividade`),
  KEY `FK_651l3m30j5jp9wo9cwou6qju6` (`idFormula`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=222 ;

--
-- Extraindo dados da tabela `atividade`
--

INSERT INTO `atividade` (`idAtividade`, `codigo`, `codigoMae`, `descricao`, `formula`, `pontos`, `idAtividadeMae_idAtividade`, `idFormula`) VALUES
(199, 'V - 2 - 3 - 3.2', '197', 'Em outra instituiÃ§Ã£o', '', 6, NULL, NULL),
(198, 'V - 2 - 3 - 3.1', '197', 'Na instituiÃ§Ã£o ', '', 4, NULL, NULL),
(197, 'V - 2 - 3', '192', 'Membro de banca de defesa de dissertaÃ§Ã£o de mestrado', '', 0, NULL, NULL),
(196, 'V - 2 - 2', '192', 'Membro de banca de concurso para docente substituto', '', 2, NULL, NULL),
(192, 'V - 2', '156', 'Atividades AcadÃªmicas â€“ Bancas e Cursos', '', 0, NULL, NULL),
(191, 'V - 1 - 34', '157', 'Aluno orientado em PrÃ¡tica como Componente Curricular (PCC)', '', 1, NULL, NULL),
(189, 'V - 1 - 32', '157', 'Aluno orientado em atividade nÃ£o curricular sem bolsa', '', 1, NULL, NULL),
(188, 'V - 1 - 31', '157', 'Aluno orientado em atividade nÃ£o curricular com bolsa', '', 2, NULL, NULL),
(187, 'V - 1 - 30', '157', 'Aluno orientado em programa de monitoria', '', 3, NULL, NULL),
(181, 'V - 1 - 24', '157', 'Aluno orientado em programa especial de treinamento (PET)', '', 5, NULL, NULL),
(179, 'V - 1 - 22', '157', 'Aluno orientado em programa de iniciaÃ§Ã£o cientÃ­fica \n(PIBIC/PIVIC/PROLICEN/PICME-OBMEP)', '', 6, NULL, NULL),
(178, 'V - 1 - 21', '157', 'Aluno de outra IFE co-orientado em dissertaÃ§Ã£o de mestrado em andamento ', '', 1, NULL, NULL),
(177, 'V - 1 - 20', '157', 'Aluno de outra IFE orientado em dissertaÃ§Ã£o de mestrado em andamento', '', 2, NULL, NULL),
(173, 'V - 1 - 16', '157', 'Aluno de outra IFE orientado em tese de doutorado em andamento ', '', 3, NULL, NULL),
(172, 'V - 1 - 15', '157', 'Aluno de outra IFE co-orientado em tese de doutorado defendida e aprovada', '', 3, NULL, NULL),
(169, 'V - 1 - 12', '157', 'Aluno orientado em estÃ¡gio supervisionado', '', 3, NULL, NULL),
(168, 'V - 1 - 11', '157', 'Aluno orientado em residÃªncia mÃ©dica ou em residÃªncia multiprofissional em saÃºde', '', 5, NULL, NULL),
(167, 'V - 1 - 10', '157', 'Aluno orientado em monografia de especializaÃ§Ã£o em andamento (total mÃ¡ximo \na ser considerado neste item sÃ£o 12 pontos)', '', 4, NULL, NULL),
(166, 'V - 1 - 9', '157', 'Aluno orientado em monografia de especializaÃ§Ã£o aprovada (mÃ¡ximo de 24 pontos)', '', 8, NULL, NULL),
(162, 'V - 1 - 5', '157', 'Aluno orientado em dissertaÃ§Ã£o de mestrado defendida e aprovada', '', 15, NULL, NULL),
(159, 'V - 1 - 2', '157', 'Aluno co-orientado em tese de doutorado defendida e aprovada', '', 7, NULL, NULL),
(158, 'V - 1 - 1', '157', 'Aluno orientado em tese de doutorado defendida e aprovada', '', 20, NULL, NULL),
(157, 'V - 1', '156', 'Atividades AcadÃªmicas - OrientaÃ§Ã£o', '', 0, NULL, NULL),
(156, 'V', '', 'OUTRAS ATIVIDADES', '', 0, NULL, NULL),
(155, 'IV - 2 - 5', '150', 'Atividades acadÃªmicas e administrativas designadas por portaria do Reitor; \nPrÃ³-Reitor ou Diretor de Unidade AcadÃªmica com carga horÃ¡ria >=150 horas', '', 10, NULL, NULL),
(152, 'IV - 2 - 2', '150', 'Coordenador de curso de especializaÃ§Ã£o; residÃªncia mÃ©dica ou residÃªncia \nmultiprofissional em saÃºde (total mÃ¡ximo a ser considerado neste item sÃ£o 10 \npontos)', '', 10, NULL, NULL),
(151, 'IV - 2 - 1', '150', 'Coordenador de projeto institucional com financiamento ou de contratos e \nconvÃªnio com plano de trabalho aprovado', '', 5, NULL, NULL),
(148, 'IV - 1 - 12', '136', 'Diretor do Hospital VeterinÃ¡rio', '', 8, NULL, NULL),
(147, 'IV - 1 - 11', '136', 'Vice-diretor de Unidade AcadÃªmica ou Unidade AcadÃªmica Especial ou do \nCEPAE', '', 8, NULL, NULL),
(146, 'IV - 1 - 10', '136', 'Coordenador de Curso de Ensino BÃ¡sico ou de GraduaÃ§Ã£o', '', 8, NULL, NULL),
(144, 'IV - 1 - 8', '136', 'Coordenador ou assessor vinculado Ã s PrÃ³-Reitorias ou Ã  DireÃ§Ã£o dos Campus \ndo Interior', '', 8, NULL, NULL),
(143, 'IV - 1 - 7', '136', 'Diretor Geral do Hospital das ClÃ­nicas', '', 10, NULL, NULL),
(141, 'IV - 1 - 5', '136', 'Diretor de Campus do interior', '', 12, NULL, NULL),
(135, 'IV', '', 'ATIVIDADES ADMINISTRATIVAS E DE REPRESENTAÃ‡ÃƒO', '', 0, NULL, NULL),
(136, 'IV - 1', '135', 'DireÃ§Ã£o e FunÃ§Ã£o Gratificada', '', 0, NULL, NULL),
(131, 'III - 2 - 11 - 11.2', '129', 'ComissÃ£o organizadora', '', 4, NULL, NULL),
(129, 'III - 2 - 11', '112', 'PromoÃ§Ã£o ou produÃ§Ã£o de eventos artÃ­sticos e cientÃ­ficos nacionais', '', 0, NULL, NULL),
(126, 'III - 2 - 10', '112', 'PromoÃ§Ã£o ou produÃ§Ã£o de eventos artÃ­sticos e cientÃ­ficos regionais', '', 0, NULL, NULL),
(125, 'III - 2 - 9 - 9.2', '123', 'ComissÃ£o organizadora', '', 2, NULL, NULL),
(124, 'III - 2 - 9 - 9.1', '123', 'Presidente', '', 4, NULL, NULL),
(123, 'III - 2 - 9', '112', 'PromoÃ§Ã£o ou produÃ§Ã£o de eventos artÃ­sticos e cientÃ­ficos locais', '', 0, NULL, NULL),
(122, 'III - 2 - 8 - 8.3', '119', 'Evento regional ou local (total mÃ¡ximo a ser considerado neste item sÃ£o 9 \npontos)', '', 3, NULL, NULL),
(121, 'III - 2 - 8 - 8.2', '119', 'Evento nacional (total mÃ¡ximo a ser considerado neste item sÃ£o 12 pontos) ', '', 4, NULL, NULL),
(117, 'III - 2 - 6', '112', 'Curso de extensÃ£o ministrado com 20 ou mais horas (total mÃ¡ximo a ser \nconsiderado neste item sÃ£o 15 pontos)', '', 5, NULL, NULL),
(116, 'III - 2 - 5', '112', 'Participante de projeto de extensÃ£o/cultura cadastrado na PROEC (total \nmÃ¡ximo a ser considerado neste item sÃ£o 15 pontos)', '', 3, NULL, NULL),
(113, 'III - 2 - 2', '112', 'Coordenador de projeto ou programa de extensÃ£o/cultura cadastrado na \nPROEC (total mÃ¡ximo a ser considerado neste item sÃ£o 15 pontos)', '', 5, NULL, NULL),
(111, 'III - 2', '106', 'Atividades de ExtensÃ£o', '', 0, NULL, NULL),
(112, 'III - 2 - 1', '112', 'Coordenador de projeto de extensÃ£o aprovado com comprovaÃ§Ã£o de \nfinanciamento (exceto bolsas)', '', 10, NULL, NULL),
(102, 'II - 4 - 4', '98', 'ApresentaÃ§Ã£o oral de trabalho publicado em anais de congresso cientÃ­fico \n(total mÃ¡ximo a ser considerado neste item sÃ£o 9 pontos)', '', 3, NULL, NULL),
(101, 'II - 4 - 3', '98', 'Artigos de divulgaÃ§Ã£o cientÃ­fica; tecnolÃ³gica e artÃ­stica veiculados em jornais \ne revistas (eletrÃ´nico ou impresso)', '', 3, NULL, NULL),
(98, 'II - 4', '8', 'Outro Tipo de ProduÃ§Ã£o', '', 0, NULL, NULL),
(97, 'II - 3 - 18 - 18.2', '95', 'Participante (total mÃ¡ximo a ser considerado neste item sÃ£o 9 pontos)', '', 3, NULL, NULL),
(95, 'II - 3 - 18', '71', 'ProduÃ§Ã£o de cinema; vÃ­deo; rÃ¡dio; TV ou mÃ­dias digitais ', '', 0, NULL, NULL),
(94, 'II - 3 - 17', '71', 'Curadoria de exposiÃ§Ãµes', '', 5, NULL, NULL),
(92, 'II - 3 - 16 - 16.1', '91', 'RestauraÃ§Ã£o de obra artÃ­stica', '', 20, NULL, NULL),
(90, 'II - 3 - 15', '71', 'Desenvolvimento de maquete', '', 5, NULL, NULL),
(88, 'II - 3 - 13', '71', 'Anais; Manuais; catÃ¡logos; boletins; com ficha bibliogrÃ¡fica (organizador / \nredator)', '', 5, NULL, NULL),
(87, 'II - 3 - 12 - 12.4', '83', 'Projeto ou RelatÃ³rio TÃ©cnico sem anotaÃ§Ã£o de responsabilidade tÃ©cnica \n(ART) ou registro de responsabilidade tÃ©cnica (RRT)', '', 10, NULL, NULL),
(86, 'II - 3 - 12 - 12.3', '83', 'Projeto ou RelatÃ³rio TÃ©cnico com anotaÃ§Ã£o de responsabilidade tÃ©cnica (ART) ou registro de responsabilidade tÃ©cnica (RRT)', '', 20, NULL, NULL),
(84, 'II - 3 - 12 - 12.1', '83', 'Parecer com anotaÃ§Ã£o de responsabilidade tÃ©cnica (ART) ou registro de \nresponsabilidade tÃ©cnica (RRT)', '', 10, NULL, NULL),
(83, 'II - 3 - 12', '71', 'Projeto; parecer ou relatÃ³rio tÃ©cnico realizado em consultoria ou assessoria \noficializada por convite; convÃªnio; contrato ou designaÃ§Ã£o', '', 0, NULL, NULL),
(77, 'II - 3 - 6', '71', 'Desenvolvimento e registro no INPI de desenho industrial ', '', 20, NULL, NULL),
(78, 'II - 3 - 7', '71', 'Desenvolvimento e registro no INPI de processo de indicaÃ§Ã£o geogrÃ¡fica', '', 20, NULL, NULL),
(76, 'II - 3 - 5', '71', 'Desenvolvimento de produto; processo ou tÃ©cnica com registro de patente no \nINPI ou modelo de utilidade', '', 20, NULL, NULL),
(66, 'II - 2 - 9 - 9.2', '64', 'Nacional', '', 10, NULL, NULL),
(61, 'II - 2 - 8 - 8.2', '59', 'Publicadas em revistas cientÃ­ficas', '', 20, NULL, NULL),
(60, 'II - 2 - 8 - 8.1', '59', 'Editadas', '', 20, NULL, NULL),
(59, 'II - 2 - 8', '40', 'ComposiÃ§Ãµes musicais', '', 0, NULL, NULL),
(58, 'II - 2 - 7 - 7.2', '56', 'ParticipaÃ§Ã£o coletiva ou coadjuvante', '', 15, NULL, NULL),
(57, 'II - 2 - 7 - 7.1', '56', 'ParticipaÃ§Ã£o individual; camerista; solista ou ator principal ', '', 20, NULL, NULL),
(56, 'II - 2 - 7', '40', 'ExposiÃ§Ãµes e apresentaÃ§Ãµes artÃ­sticas internacionais', '', 0, NULL, NULL),
(55, 'II - 2 - 6 - 6.2', '53', 'ParticipaÃ§Ã£o coletiva ou coadjuvante ', '', 10, NULL, NULL),
(53, 'II - 2 - 6', '40', 'ExposiÃ§Ãµes e apresentaÃ§Ãµes artÃ­sticas nacionais', '', 0, NULL, NULL),
(52, 'II - 2 - 5 - 5.2', '50', 'ParticipaÃ§Ã£o coletiva ou coadjuvante', '', 5, NULL, NULL),
(51, 'II - 2 - 5 - 5.1', '50', 'ParticipaÃ§Ã£o individual; camerista; solista ou ator principal ', '', 16, NULL, NULL),
(50, 'II - 2 - 5', '40', 'ExposiÃ§Ãµes e apresentaÃ§Ãµes artÃ­sticas locais ou regionais', '', 0, NULL, NULL),
(49, 'II - 2 - 6', '40', 'Design de interfaces digitais ou produtos com inovaÃ§Ã£o tecnolÃ³gica', '', 20, NULL, NULL),
(47, 'II - 2 - 4', '40', 'Design de impressos por peÃ§a (limitados a 20 pontos)', '', 1, NULL, NULL),
(45, 'II - 2 - 2', '40', 'CriaÃ§Ã£o e produÃ§Ã£o do projeto grÃ¡fico de livros: concepÃ§Ã£o grÃ¡fica (mancha \ngrÃ¡fica; diagramaÃ§Ã£o; escolha de fonte)', '', 10, NULL, NULL),
(40, 'II - 2', '8', 'ProduÃ§Ã£o ArtÃ­stica e Cultural ', '', 0, NULL, NULL),
(39, 'II - 1 - 19', '9', 'Tese de Doutorado defendida e aprovada (sendo o docente o autor da tese)', '', 15, NULL, NULL),
(38, 'II - 1 - 18', '9', 'DissertaÃ§Ã£o de Mestrado defendida de aprovada (sendo o docente o autor da \ndissertaÃ§Ã£o)', '', 10, NULL, NULL),
(37, 'II - 1 - 17 - 17.3', '34', 'Internacional', '', 20, NULL, NULL),
(36, 'II - 1 - 17 - 17.2', '34', 'Nacional', '', 20, NULL, NULL),
(35, 'II - 1 - 17 - 17.1', '34', 'Local ou regional ', '', 15, NULL, NULL),
(34, 'II - 1 - 17', '9', 'Editor de jornais ou revistas com distribuiÃ§Ã£o', '', 0, NULL, NULL),
(33, 'II - 1 - 16', '9', 'Editor de periÃ³dicos especializados indexados com corpo editorial ', '', 20, NULL, NULL),
(32, 'II - 1 - 15', '9', 'Livro didÃ¡tico desenvolvido para projetos institucionais/governamentais', '', 10, NULL, NULL),
(30, 'II - 1 - 13', '9', 'TraduÃ§Ã£o ou revisÃ£o cientÃ­fica de livro traduzido e publicado com selo de \neditora que possua corpo editorial', '', 10, NULL, NULL),
(29, 'II - 1 - 12', '9', 'CapÃ­tulo traduzido de livro publicado com selo de editora que possua corpo \neditorial (total mÃ¡ximo a ser considerado neste item sÃ£o 20 pontos)', '', 5, NULL, NULL),
(28, 'II - 1 - 11', '9', 'EdiÃ§Ã£o ou organizaÃ§Ã£o de livro (coletÃ¢nea) publicado com selo de editora que \npossua corpo editorial', '', 12, NULL, NULL),
(27, 'II - 1 - 10', '9', 'CapÃ­tulo de livro publicado com selo de editora que possua corpo editorial \n(total mÃ¡ximo a ser considerado neste item sÃ£o 40 pontos)', '', 10, NULL, NULL),
(26, 'II - 1 - 9', '9', 'Livro publicado com selo de editora que nÃ£o possua corpo editorial', '', 10, NULL, NULL),
(24, 'II - 1 - 7', '9', 'Editor ou Coordenador editorial de livro publicado com selo de editora que \npossua corpo editorial', '', 20, NULL, NULL),
(22, 'II - 1 - 5 - 5.3', '19', 'Regional ou Local', '', 2, NULL, NULL),
(20, 'II - 1 - 5 - 5.1', '19', 'Internacional', '', 4, NULL, NULL),
(18, 'II - 1 - 4 - 4.3', '15', 'Regional ou Local', '', 4, NULL, NULL),
(2, 'I -1 ', '1', 'GraduaÃ§Ã£o ', '', 0, NULL, NULL),
(3, 'I -1 -1', '2', 'Aulas presenciais na graduaÃ§Ã£o', '*(AULAS/32)', 10, NULL, NULL),
(4, 'I -1 -2', '3', 'Aulas do ensino a distÃ¢ncia na graduaÃ§Ã£o ', '*(AULAS/32)', 10, NULL, NULL),
(5, 'I - 2', '1', 'PÃ³s-GraduaÃ§Ã£o stricto e lato sensu', '', 0, NULL, NULL),
(6, 'I - 2 - 1', '5', 'Aulas presenciais na pÃ³s-graduaÃ§Ã£o', '*(AULAS/30)', 10, NULL, NULL),
(7, 'I - 2 - 2', '6', 'Aulas do ensino a distÃ¢ncia na pÃ³s-graduaÃ§Ã£o ', '*(AULAS/30)', 10, NULL, NULL),
(8, 'II', '', 'PRODUÃ‡ÃƒO INTELECTUAL', '', 0, NULL, NULL),
(9, 'II -1 ', '8', 'ProduÃ§Ã£o CientÃ­fica', '', 0, NULL, NULL),
(10, 'II - 1 - 1', '9', 'Artigo completo ou texto literÃ¡rio publicado em periÃ³dico', '', 0, NULL, NULL),
(11, 'II - 1 - 1 - 1.1', '10', 'Com classificaÃ§Ã£o no Qualis/CAPES', '', 20, NULL, NULL),
(12, 'II - 1 - 1 - 1.2', '10', 'NÃ£o sujeito Ã  classificaÃ§Ã£o no Qualis/CAPES', '', 10, NULL, NULL),
(13, 'II - 1 - 2', '9', 'Resumo de artigo em periÃ³dicos especializados nacional ou internacional \ncom corpo editorial', '', 5, NULL, NULL),
(14, 'II - 1 - 3', '9', 'Artigos ou textos literÃ¡rios em repositÃ³rios de publicaÃ§Ã£o eletrÃ´nica ligados a \neditoras ou universidades (total mÃ¡ximo a ser considerado neste item sÃ£o 10 \npontos)', '', 5, NULL, NULL),
(15, 'II - 1 - 4', '9', 'Resumo expandido publicado em anais (total mÃ¡ximo a ser considerado neste \nitem sÃ£o 10 pontos) de congresso', '', 0, NULL, NULL),
(195, 'V - 2 - 1 - 1.2', '193', 'Em outra instituiÃ§Ã£o ', '', 6, NULL, NULL),
(193, 'V - 2 - 1', '192', 'Membro de banca de concurso para docente efetivo', '', 0, NULL, NULL),
(194, 'V - 2 - 1 - 1.1', '193', 'Na instituiÃ§Ã£o', '', 4, NULL, NULL),
(190, 'V - 1 - 33', '157', 'Pesquisador supervisionado em estÃ¡gio de pÃ³s-doutoramento (PRODOC; \nPNPD; DCR; entre outros)', '', 8, NULL, NULL),
(186, 'V - 1 - 29', '157', 'Aluno orientado com bolsa PROCOM ou similar; vinculada a projeto de \npesquisa/extensÃ£o/ensino', '', 5, NULL, NULL),
(185, 'V - 1 - 28', '157', 'Aluno orientado em projetos de extensÃ£o/cultura/ensino sem bolsa ', '', 3, NULL, NULL),
(183, 'V - 1 - 26', '157', 'Aluno orientado com bolsa de licenciatura (PIBID e similares)', '', 5, NULL, NULL),
(184, 'V - 1 - 27', '157', 'Aluno orientado com bolsa extensÃ£o/cultura/ensino', '', 5, NULL, NULL),
(182, 'V - 1 - 25', '157', 'Aluno orientado com bolsa de DTI; PIBIT; AT; Jovens Talentos e similares', '', 5, NULL, NULL),
(180, 'V - 1 - 23', '157', 'Aluno orientado em programa de iniciaÃ§Ã£o cientÃ­fica jÃºnior', '', 5, NULL, NULL),
(176, 'V - 1 - 19', '157', 'Aluno de outra IFE co-orientado em dissertaÃ§Ã£o de mestrado defendida e \naprovada', '', 2, NULL, NULL),
(175, 'V - 1 - 18', '157', 'Aluno de outra IFE orientado em dissertaÃ§Ã£o de mestrado defendida e aprovada', '', 4, NULL, NULL),
(174, 'V - 1 - 17', '157', 'Aluno de outra IFE co-orientado em tese de doutorado em andamento', '', 2, NULL, NULL),
(170, 'V - 1 - 13', '157', 'Aluno orientado em projeto de final de curso ', '', 3, NULL, NULL),
(171, 'V - 1 - 14', '157', 'Aluno de outra IFE orientado em tese de doutorado defendida e aprovada', '', 6, NULL, NULL),
(165, 'V - 1 - 8', '157', 'Aluno co-orientado em dissertaÃ§Ã£o de mestrado em andamento', '', 3, NULL, NULL),
(164, 'V - 1 - 7', '157', 'Aluno orientado em dissertaÃ§Ã£o de mestrado em andamento ', '', 8, NULL, NULL),
(163, 'V - 1 - 6', '157', 'Aluno co-orientado em dissertaÃ§Ã£o de mestrado defendida e aprovada', '', 5, NULL, NULL),
(161, 'V - 1 - 4', '157', 'Aluno co-orientado em tese de doutorado em andamento ', '', 4, NULL, NULL),
(160, 'V - 1 - 3', '157', 'Aluno orientado em tese de doutorado em andamento', '', 10, NULL, NULL),
(154, 'IV - 2 - 4', '150', 'Membro do Conselho de Curadores ou do PlenÃ¡rio do CEPEC ou de Conselho \nde FundaÃ§Ãµes', '', 10, NULL, NULL),
(153, 'IV - 2 - 3', '150', 'Membro representante de classe da carreira docente no CONSUNI', '', 10, NULL, NULL),
(150, 'IV - 2', '135', 'Atividades Administrativas ', '', 0, NULL, NULL),
(149, 'IV - 1 - 13', '136', 'Diretor de Ã“rgÃ£o da AdministraÃ§Ã£o (CERCOMP; CGA; CEGRAF; CIAR; \nDDRH; CS; SIASS; Museu; RÃ¡dio; Biblioteca etc.)', '', 8, NULL, NULL),
(145, 'IV - 1 - 9', '136', 'Coordenador de Programa de PÃ³s-GraduaÃ§Ã£o stricto sensu', '', 8, NULL, NULL),
(142, 'IV - 1 - 6', '136', 'Vice-diretor de Campus do interior', '', 12, NULL, NULL),
(140, 'IV - 1 - 4', '136', 'Diretor de Unidade AcadÃªmica; de Unidade AcadÃªmica Especial ou do \nCEPAE', '', 10, NULL, NULL),
(137, 'IV - 1 - 1', '136', 'Reitor ou Vice-Reitor ou PrÃ³-Reitor', '', 14, NULL, NULL),
(138, 'IV - 1 - 2', '136', 'Chefe de Gabinete', '', 10, NULL, NULL),
(139, 'IV - 1 - 3', '136', 'Coordenador ou assessor vinculado Ã  Reitoria ', '', 10, NULL, NULL),
(133, 'III - 2 - 12 - 12.1', '132', 'Presidente', '', 10, NULL, NULL),
(134, 'III - 2 - 12 - 12.2', '132', 'ComissÃ£o organizadora', '', 5, NULL, NULL),
(132, 'III - 2 - 12', '112', 'PromoÃ§Ã£o ou produÃ§Ã£o de eventos artÃ­sticos e cientÃ­ficos internacionais', '', 0, NULL, NULL),
(130, 'III - 2 - 11 - 11.1', '129', 'Presidente', '', 8, NULL, NULL),
(127, 'III - 2 - 10 - 10.1', '126', 'Presidente', '', 6, NULL, NULL),
(128, 'III - 2 - 10 - 10.2', '126', 'ComissÃ£o organizadora', '', 3, NULL, NULL),
(120, 'III - 2 - 8 - 8.1', '119', 'Evento internacional (total mÃ¡ximo a ser considerado neste item sÃ£o 15 \npontos)', '', 5, NULL, NULL),
(119, 'III - 2 - 8', '112', 'Palestrante; conferencista ou participante em mesa redonda em evento cientÃ­fico; \ncultural ou artÃ­stico ', '', 0, NULL, NULL),
(118, 'III - 2 - 7', '112', 'Curso de extensÃ£o ministrado com menos de 20 horas (total mÃ¡ximo a ser \nconsiderado neste item sÃ£o 10 pontos)', '', 2, NULL, NULL),
(115, 'III - 2 - 4', '112', 'Coordenador de contratos e de convÃªnios de cooperaÃ§Ã£o institucional \nnacional', '', 3, NULL, NULL),
(114, 'III - 2 - 3', '112', 'Coordenador de contratos e de convÃªnios de cooperaÃ§Ã£o institucional \ninternacional', '', 5, NULL, NULL),
(110, 'III - 1 - 3', '107', 'Coordenador de projeto de pesquisa aprovado sem financiamento (total \nmÃ¡ximo a ser considerado neste item sÃ£o 10 pontos)', '', 5, NULL, NULL),
(109, 'III - 1 - 2', '107', 'Coordenador de projeto de pesquisa aprovado com comprovaÃ§Ã£o de \nfinanciamento (exceto bolsas)', '', 10, NULL, NULL),
(108, 'III - 1 - 1', '107', 'Coordenador de projeto conjuntos de pesquisa e cooperaÃ§Ã£o cientÃ­fica (tipo \nPRODOC; PROCAD; PNPD; entre outros) e de cursos MINTER e DINTER \naprovados por Ã³rgÃ£os oficiais de fomento', '', 10, NULL, NULL),
(106, 'III', '', 'ATIVIDADES DE PESQUISA E EXTENSÃƒO', '', 0, NULL, NULL),
(107, 'III - 1', '106', 'Atividades de CoordenaÃ§Ã£o de Pesquisa', '', 0, NULL, NULL),
(105, 'II - 4 - 7', '98', 'Tese; dissertaÃ§Ã£o e trabalho de iniciaÃ§Ã£o cientÃ­fica premiados por instituiÃ§Ãµes \nde fomento (sendo o docente o autor ou orientador do produto)', '', 8, NULL, NULL),
(104, 'II - 4 - 6', '98', 'Trabalho premiado em evento cientÃ­fico nacional ou internacional', '', 5, NULL, NULL),
(103, 'II - 4 - 5', '98', 'ApresentaÃ§Ã£o em painel de trabalho publicado em anais de congresso \ncientÃ­fico (total mÃ¡ximo a ser considerado neste item sÃ£o 3 pontos)', '', 1, NULL, NULL),
(100, 'II - 4 - 2', '98', 'Texto ou material didÃ¡tico para uso institucional (nÃ£o fracionados e com \nampla divulgaÃ§Ã£o)', '', 2, NULL, NULL),
(99, 'II - 4 - 1', '98', 'Artigos de opiniÃ£o veiculados em jornais e revistas (eletrÃ´nico ou impresso) ', '', 1, NULL, NULL),
(96, 'II - 3 - 18 - 18.1', '95', 'Editor', '', 20, NULL, NULL),
(93, 'II - 3 - 16 - 16.2', '91', 'ConservaÃ§Ã£o de obra artÃ­stica', '', 10, NULL, NULL),
(91, 'II - 3 - 16', '71', 'ManutenÃ§Ã£o de obra artÃ­stica', '', 0, NULL, NULL),
(89, 'II - 3 - 14', '71', 'ProduÃ§Ã£o e publicaÃ§Ã£o de mapas; cartas ou similares', '', 10, NULL, NULL),
(85, 'II - 3 - 12 - 12.2', '83', 'Parecer sem anotaÃ§Ã£o de responsabilidade tÃ©cnica (ART) ou registro de \nresponsabilidade tÃ©cnica (RRT)', '', 5, NULL, NULL),
(82, 'II - 3 - 11', '71', 'Parecer de consultoria ad hoc para periÃ³dicos especializados com corpo \neditorial ou para instituiÃ§Ãµes de fomento Ã  pesquisa ou para livros de editoras \ncom corpo editorial', '', 3, NULL, NULL),
(81, 'II - 3 - 10', '71', 'Parecer de consultoria ad hoc em comitÃªs de avaliaÃ§Ã£o de concursos e editais \nde publicaÃ§Ã£o de livros de editoras com corpo editorial', '', 3, NULL, NULL),
(80, 'II - 3 - 9', '71', 'ParticipaÃ§Ã£o em comitÃª editorial de periÃ³dicos especializados indexados e de \neditoras universitÃ¡rias', '', 10, NULL, NULL),
(79, 'II - 3 - 8', '71', 'Desenvolvimento e registro no INPI de marcas ', '', 5, NULL, NULL),
(75, 'II - 3 - 4', '71', 'Desenvolvimento e registro no INPI de topografia de circuito integrado', '', 20, NULL, NULL),
(74, 'II - 3 - 3', '71', 'Desenvolvimento de software para uso institucional (total mÃ¡ximo a ser \nconsiderado neste item sÃ£o 10 pontos)', '', 5, NULL, NULL),
(73, 'II - 3 - 2', '71', 'Desenvolvimento de software com divulgaÃ§Ã£o em periÃ³dicos indexados e \ncom corpo editorial ou em anais de congresso cientÃ­fico', '', 10, NULL, NULL),
(72, 'II - 3 - 1', '71', 'Desenvolvimento de programa de computador (software) com registro no \nINPI ou com ampla disponibilizaÃ§Ã£o em ambientes de software livre', '', 20, NULL, NULL),
(71, 'II - 3 ', '8', 'ProduÃ§Ã£o TÃ©cnica e TecnolÃ³gica', '', 0, NULL, NULL),
(70, 'II - 2 - 12', '40', 'Sonoplastia (cinema; mÃºsica; rÃ¡dio; televisÃ£o; teatro)', '', 3, NULL, NULL),
(69, 'II - 2 - 11', '40', 'ApresentaÃ§Ã£o artÃ­stica ou cultural em rÃ¡dio ou TV ', '', 5, NULL, NULL),
(68, 'II - 2 - 10', '40', 'Arranjos musicais (canto; coral e orquestral)', '', 5, NULL, NULL),
(67, 'II - 2 - 9 - 9.3', '64', 'Internacional', '', 15, NULL, NULL),
(65, 'II - 2 - 9 - 9.1', '64', 'Local ou regional ', '', 5, NULL, NULL),
(63, 'II - 2 - 8 - 8.4', '59', 'Executadas em apresentaÃ§Ãµes pÃºblicas', '', 15, NULL, NULL),
(64, 'II - 2 - 9', '40', 'ProduÃ§Ã£o artÃ­stica; arquitetÃ´nica ou de design premiada em evento', '', 0, NULL, NULL),
(62, 'II - 2 - 8 - 8.3', '59', 'Gravadas', '', 15, NULL, NULL),
(54, 'II - 2 - 6 - 6.1', '53', 'ParticipaÃ§Ã£o individual; camerista; solista ou ator principal ', '', 20, NULL, NULL),
(48, 'II - 2 - 5', '40', 'Design de interfaces digitais ', '', 19, NULL, NULL),
(46, 'II - 2 - 3', '40', 'Design (grÃ¡fico; de luz; de figurino e formas animadas; cenogrÃ¡fico e similares)', '', 5, NULL, NULL),
(44, 'II - 2 - 1 - 1.3', '41', 'Internacionais', '', 20, NULL, NULL),
(43, 'II - 2 - 1 - 1.2', '41', 'Nacionais', '', 15, NULL, NULL),
(42, 'II - 2 - 1 - 1.1', '41', 'Locais ou regionais', '', 10, NULL, NULL),
(41, 'II - 2 - 1', '40', 'CriaÃ§Ã£o; produÃ§Ã£o e direÃ§Ã£o de filmes; vÃ­deos; discos; audiovisuais; \ncoreografias; peÃ§as teatrais; Ã³peras ou musicais; ou musicais apresentados em \neventos', '', 0, NULL, NULL),
(31, 'II -1 - 14', '9', 'Resenhas; prefÃ¡cios ou verbetes', '', 10, NULL, NULL),
(25, 'II - 1 - 8', '9', 'Livro publicado com selo de editora que possua corpo editorial', '', 40, NULL, NULL),
(23, 'II - 1 - 6', '9', 'Trabalho completo publicado em anais de congresso cientifico', '', 10, NULL, NULL),
(21, 'II - 1 - 5 - 5.2', '19', 'Nacional', '', 3, NULL, NULL),
(19, 'II - 1 - 5', '9', 'Resumo simples publicado em anais (total mÃ¡ximo a ser considerado neste item \nsÃ£o 10 pontos) de congresso', '', 0, NULL, NULL),
(16, 'II - 1 - 4 - 4.1', '15', 'Internacional', '', 8, NULL, NULL),
(17, 'II - 1 - 4 - 4.2', '15', 'Nacional', '', 6, NULL, NULL),
(1, 'I', '', 'ATIVIDADES DE ENSINO', '', 0, NULL, NULL),
(200, 'V - 2 - 4', '192', 'Membro de banca de defesa de tese de doutorado', '', 0, NULL, NULL),
(201, 'V - 2 - 4 - 4.1', '200', 'Na instituiÃ§Ã£o', '', 6, NULL, NULL),
(202, 'V - 2 - 4 - 4.2', '200', 'Em outra instituiÃ§Ã£o ', '', 8, NULL, NULL),
(203, 'V - 2 - 5', '192', 'Membro de banca de qualificaÃ§Ã£o de mestrado', '', 0, NULL, NULL),
(204, 'V - 2 - 5 - 5.1', '203', 'Na instituiÃ§Ã£o', '', 3, NULL, NULL),
(205, 'V - 2 - 5 - 5.2', '203', 'Em outra instituiÃ§Ã£o', '', 4, NULL, NULL),
(206, 'V - 2 - 6', '192', 'Membro de banca de qualificaÃ§Ã£o de doutorado', '', 0, NULL, NULL),
(207, 'V - 2 - 6 - 6.1', '206', 'Na instituiÃ§Ã£o ', '', 5, NULL, NULL),
(208, 'V - 2 - 6 - 6.2', '206', 'Em outra instituiÃ§Ã£o', '', 6, NULL, NULL),
(209, 'V - 2 - 7', '192', 'Membro de banca de defesa de monografia; projeto final de curso e outros tipos \nde bancas (total mÃ¡ximo a ser considerado neste item sÃ£o 10 pontos)', '', 2, NULL, NULL),
(210, 'V - 2 - 8', '192', 'Membro de corpo de jÃºri', '', 0, NULL, NULL),
(211, 'V - 2 - 8 - 8.1', '210', 'Concursos internacionais', '', 8, NULL, NULL),
(212, 'V - 2 - 8 - 8.2', '210', 'Concursos nacionais ', '', 6, NULL, NULL),
(213, 'V - 2 - 9', '192', 'Cursos; palestras ou treinamento nÃ£o curricular ministrados para docentes; \nfuncionÃ¡rios ou alunos da UFG ', '', 2, NULL, NULL),
(214, 'V - 2 - 10', '192', 'Coordenador de projeto institucional de intercÃ¢mbio internacional ', '', 10, NULL, NULL),
(215, 'V - 3', '156', 'Atividades de Aprendizado e AperfeiÃ§oamento', '', 0, NULL, NULL),
(216, 'V - 3 - 1', '215', 'Docente regularmente matriculado em curso de doutorado com relatÃ³rios de \npÃ³s-graduaÃ§Ã£o aprovados (pontuaÃ§Ã£o por mÃªs de curso)', '', 12, NULL, NULL),
(217, 'V - 3 - 2', '215', 'EstÃ¡gio PÃ³s-Doutoral ou EstÃ¡gio SÃªnior (pontuaÃ§Ã£o por mÃªs de estÃ¡gio) ', '', 12, NULL, NULL),
(218, 'V - 3 - 3', '215', 'Docente em licenÃ§a para capacitaÃ§Ã£o (Artigo 87; Lei N.8112) (pontuaÃ§Ã£o por \nmÃªs de licenÃ§a)', '', 12, NULL, NULL),
(219, 'V - 3 - 4', '215', 'Curso de aperfeiÃ§oamento realizado com carga horÃ¡ria superior a 40 horas ', '', 3, NULL, NULL),
(220, 'V - 3 - 5', '215', 'Curso de aperfeiÃ§oamento realizado com carga horÃ¡ria inferior a 40 horas', '', 1, NULL, NULL),
(221, 'V - 3 - 6', '215', 'ParticipaÃ§Ã£o em Congressos; SeminÃ¡rios; Encontros; Jornadas etc. (total \nmÃ¡ximo a ser considerado neste item sÃ£o 3 pontos)', '', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `classe`
--

CREATE TABLE IF NOT EXISTS `classe` (
  `idClasse` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `idNiveis` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `tipo` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`idClasse`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `classesNiveis`
--

CREATE TABLE IF NOT EXISTS `classesNiveis` (
  `idClasse` int(11) NOT NULL,
  `idNivel` int(11) NOT NULL,
  KEY `FK_bic7qdjc0xwdqjvani1p98oka` (`idNivel`),
  KEY `FK_eyebfadjwn6pa9sp4ot2w3iuw` (`idClasse`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `docente`
--

CREATE TABLE IF NOT EXISTS `docente` (
  `idDocente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `nomeDocente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDocente`),
  KEY `FK_mwcdmbir36pc08phuqnkxrw0u` (`nomeDocente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `docenteClasses`
--

CREATE TABLE IF NOT EXISTS `docenteClasses` (
  `idDocente` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  KEY `FK_aniv00hli8pfn5q99b8btc3nt` (`idClasse`),
  KEY `FK_vko7woa1wdmquew4t5r35s96` (`idDocente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `formula`
--

CREATE TABLE IF NOT EXISTS `formula` (
  `idFormula` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`idFormula`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `formula`
--

INSERT INTO `formula` (`idFormula`, `descricao`) VALUES
(2, 'A + B'),
(3, 'A - B');

-- --------------------------------------------------------

--
-- Estrutura da tabela `nivel`
--

CREATE TABLE IF NOT EXISTS `nivel` (
  `idNivel` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`idNivel`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `nivel`
--

INSERT INTO `nivel` (`idNivel`, `descricao`) VALUES
(1, '1'),
(2, '2'),
(3, '3');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `endereco` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `idade` int(11) NOT NULL,
  `login` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `senha` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `telefone` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
