Innopolis University

AQA Engineer (Java) course 2021
### Example 40 Rabbitapp
Rabbitapp is the example springboot application using RabbitMQ for sending and receiving messages

Sending message example (GET method): `http://localhost:8080/send?message=hello+world!`

Receiving message (GET method): `http://localhost:8080/read`



To start RabbitMQ server in Docker container the next line can be used:
`docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.9-management`