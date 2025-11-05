FROM eclipse-temurin:21-alpine

WORKDIR /root

ENV LANG=C.UTF-8

COPY entrypoint.sh /root

COPY your-financeje-banking.jar /root/your-financeje-banking.jar

ENTRYPOINT ["/root/entrypoint.sh"]

EXPOSE 8080
