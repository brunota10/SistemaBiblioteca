use dbBiblioteca;

INSERT INTO tb_acervo (ds_acervo,tipo_acervo) 
VALUES('Como Programar em Java','Livro'),
	  ('Java Magazine','Revista');
      
INSERT INTO tb_aluno (ra_aluno,nm_aluno,tel_aluno,end_aluno,email_aluno) 
VALUES(12345,'Aparicio Pedrosa','99991111','Rua da Serenata','aparicio@gmail.com'),
	  (67890,'Bruno Alves','99992222','Rua da Polca','bruno@hotmail.com');
      
INSERT INTO tb_emprestimo (cd_aluno,dt_emprestimo,dt_devolucao) 
VALUES(1,'2016-05-01',''),
	  (2,'2016-04-30','');

UPDATE tb_emprestimo
SET dt_devolucao=null
WHERE cd_emprestimo=2; 
      
INSERT INTO tb_item_emprestimo (cd_acervo,cd_emprestimo) 
VALUES(1,2),
	  (2,1);
      
