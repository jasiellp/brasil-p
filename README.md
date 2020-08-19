# Teste API REST com SpringBoot - Brasil Prev
> API contem metodo POST e GET;
POST objetovo de Cadastrar um Cliente 
GET  objetovo de Consultar um Cliente
>

## Instalação

Criar Variavel:

```sh 
export DATABASE_URL=postgres://xyz
```

```sh
mvn clean package
```


## Run Local
```sh
java -Dserver.port=$PORT $JAVA_OPTS -jar target/brasil-prev-jasiel.jar
```

## Swagger
 [Swagger](http://brasil-prev-jasiel.herokuapp.com/swagger-ui.html)

 
## Meta

[Jasiel Pereira de Sant ana](https://twitter.com/jasiellp) – jasiellp@hotmail.com

Distribuído sob a licença XYZ. Veja `LICENSE` para mais informações.

[https://github.com/yourname/github-link](https://github.com/othonalberto/)

## Contributing

1. Faça o _fork_ do projeto (<https://github.com/jasiellp/brasil-p/fork>)
2. Crie uma _branch_ para sua modificação (`git checkout -b feature/fooBar`)
3. Faça o _commit_ (`git commit -am 'Add some fooBar'`)
4. _Push_ (`git push origin feature/fooBar`)
5. Crie um novo _Pull Request_

[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/seunome/seuprojeto/wiki
