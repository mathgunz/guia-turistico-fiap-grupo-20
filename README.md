# guia-turistico-fiap-grupo-20


##Compilar o projeto
Necessario JDK 11

##Instalar postgres na maquina
- Executar banco de dados via docker(se tiver docker se não pode ser uma instalação normal)
para instalar:
docker run --name fiap-postgres -p 5432:5432 -e POSTGRES_PASSWORD=1234 postgres

executar:
sudo docker start fiap-postgres

- se a senha não for 1234, necessario alterar na resources/application.yml de cada projeto e alterar a senha.
a senha.