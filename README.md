# Emlak İlan Sistemi
Emlakjet Java Spring Boot Bootcamp Final Project <br><br>


 ## PROJE KONUSU
 
 Emlak İlan Sistemi
Proje Konusu:
Bir ilan sistemi için, ilan bilgilerini alıp ilan kaydı oluşturan, belli kriterlere göre ilan sorgulamalarının
yapılabildiği restful bir uygulamanın Spring Boot framework kullanılarak yazılması 
Gereksinimler:

- Kullanıcıdan ad-soyad, telefon, email, password bilgileri alınarak, kullanıcı kaydı
yapılmalıdır.
- Kaydedilen kullanıcının sisteme giriş yapabilmesi için bir authentication servisi
bulunmalıdır.
- Sistemde kayıtlı bir yönetici kullanıcı olmalıdır.
- Kullanıcıların ilan kaydı oluşturabildiği ve güncelleyebildiği bir servis bulunmalıdır.
- İlan kaydı oluşturulduktan sonra veya güncellendikten sonra pasif olmalı, yönetici
kullanıcı bu ilanı onaylamalı veya reddedebilmelidir. (Onay için servis bulunmalı bu
servis yalnızca yönetici kullanıcı tarafından çalıştırılabilmelidir.)
- Oluşturulan ve onaylanan son 10 ilanı listeleyen bir servis olmalıdır.
- Yönetici için, pasif ilanların görüntülenebildiği bir servis olmalıdır. (Görüntülenen
ilanları onaylayabilmek için ilan onay urlleri de döndürülebilir.)
- Onaylanan ilanlar message queue ya alınmalıdır.
- Message queue’daki ilanlar raporlama servisi tarafından alınarak her ilan için rapor
oluşturulmalıdır. (“... ilanı … kullanıcısı tarafından … gün önce oluşturulmuştur. İlan
… kere görüntülenmiştir.” Şeklinde bir metin oluşturulup veritabanına kaydedilebilir.
Görüntülenme sayısı için ilan servisinden bilgi alınabilir. Görüntülenme sayısı her
istekte bir artırılabilir. ”)
- Raporlama servisi rapor oluşturmak için bir api sunmalıdır. Ilan id ile istek
yapıldığında oluşturulan rapor güncellenmelidir.
- Uygulama docker üzerinde çalışmalıdır.
- Uygulama mikroservis mimarisi ile gerçekleştirilmeli ve haberleşmede message broker
kullanılmalıdır. <br>


 <a href="https://dev.java/" rel="nofollow"> <img src="https://camo.githubusercontent.com/4516a1dca56d6cc15e4102e39acf0c139cc69f220d05b9136af0dfece96a3dfd/68747470733a2f2f75706c6f61642e77696b696d656469612e6f72672f77696b6970656469612f74722f322f32652f4a6176615f4c6f676f2e737667" alt="nodejs" width="40" height="40" data-canonical-src="https://upload.wikimedia.org/wikipedia/tr/2/2e/Java_Logo.svg" style="max-width: 100%;"> </a> <a href="https://spring.io/" rel="nofollow"> <img src="https://camo.githubusercontent.com/4545b55c7771bbd175235c80b518dcbbf2f6ee0b984a51ad9363cba8cb70e67c/68747470733a2f2f7777772e766563746f726c6f676f2e7a6f6e652f6c6f676f732f737072696e67696f2f737072696e67696f2d69636f6e2e737667" alt="spring" width="40" height="40" data-canonical-src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" style="max-width: 100%;"> </a> <a href="https://www.postgresql.org" rel="nofollow"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40" style="max-width: 100%;"> </a> <a href="https://postman.com" rel="nofollow"> <img src="https://camo.githubusercontent.com/93b32389bf746009ca2370de7fe06c3b5146f4c99d99df65994f9ced0ba41685/68747470733a2f2f7777772e766563746f726c6f676f2e7a6f6e652f6c6f676f732f676574706f73746d616e2f676574706f73746d616e2d69636f6e2e737667" alt="postman" width="40" height="40" data-canonical-src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" style="max-width: 100%;"> </a>
 
- [x] Java (Programming Language)
- [x] Spring Boot (Application Platform)
- [x] Spring Data JPA (Data Persistance)
- [x] H2 Database
- [x] Swagger
- [x] RabbitMQ
- [x] Maven
- [x] Spring Security-Authentication (Keycloak)
- [x] Postman
- [x] JUnit ve Mockito (Unit Testing)   
- [ ] Docker ...future

 
  ## PROJE DIAGRAM

 
 ![1](https://user-images.githubusercontent.com/96151920/179437421-333c13ee-64fb-4360-9a15-262254cfc81a.JPG)
 ![222](https://user-images.githubusercontent.com/96151920/179439034-13246b18-0fab-43ef-90dc-4c8b8f920db6.JPG)
![wedwf](https://user-images.githubusercontent.com/96151920/179439066-3ebeb2d6-decf-47d3-a8f6-9c7aac879d67.JPG)
![4444444](https://user-images.githubusercontent.com/96151920/179439143-14d572b6-e349-421b-b9c4-a2676c23bcd7.JPG)

<hr>
 
 ## Proje Kullanım Akışı
 * İlk etapta Discovery Server ayağa kaldırılır ve böylece Eureka yani bağlı olduğumuz microservislerin ayakta olanlarının portlarını rahat bir şekilde görebiliriz.
 
 
 ![8 eureka](https://user-images.githubusercontent.com/96151920/179439843-07eea857-1c5a-44fe-8846-4dda2d9aa125.JPG)

 <hr>
 
 * İkinci olarak Api-Gateway ayağa kaldırılır ve biz bütün Security sistemimizi burası üzerinden yönetiriz. Security için OAuth2 ve Keycloack kullanmamız gereklidir. Keycloak ilk etapta terminalde 
 ```
 docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.2 start-dev
 ```
 komutu ile açmamız gerekiyor. http://localhost:8181 üzerinden keycloack kısmına bağlanıp "defaul username" : "admin" / "defaul password" : "admin" olarak giriş yapılır. Arkasından yapılması gereken işlemler ilk etapta "realm" ismi oluşturup "Client" oluşturup Servisler kısmını "On" haline getirip daha sonra Token alıp diğer servislerimize postman üzerinden istek atabilmek adına bu tokenları kullanmayı sağlar. Aynı zamanda application.properties kısmına da token endpoint eklemesi yapılması gerekir. Adım adım fotoğraflar ektedir. <br>
 ![k1](https://user-images.githubusercontent.com/96151920/179440484-5942970f-ca44-49eb-88fa-5fbb99ad643e.JPG)

 ![k2](https://user-images.githubusercontent.com/96151920/179440498-c0975d92-1a5a-4f4a-9624-598e267f6715.JPG)
![oauth2 token alma](https://user-images.githubusercontent.com/96151920/179440604-1813eb68-aabb-4b91-a12b-cfe23ec9ea47.JPG)
![sasa](https://user-images.githubusercontent.com/96151920/179440632-7d5752ca-ef03-47de-a253-512920cf7841.JPG)


## Swagger Üzerinden Aldığımız Endpointler 

![sasasasasa](https://user-images.githubusercontent.com/96151920/179439630-acee63d0-e97f-45ae-b299-b059c30604bc.JPG)


![1111](https://user-images.githubusercontent.com/96151920/179439639-d9489e34-77cd-4117-a6f7-c8dccc623c90.JPG)



<hr>

## Postman Üzerinden Atılan İsteklere Örnekler, Kullanıcı ve İlan Ekleme Üzerine 

* Postman Üzerinde User oluşturup Console kısmında "Kullanıcı {id} ile kaydedildi" mesajı alındı

![1 postman signup isteği konsolda new user saved yazısı](https://user-images.githubusercontent.com/96151920/179439363-29a00977-ae84-4d4a-ba9c-93ec534523db.JPG)


![5 token kullanarak get isteği yapabilmemiz](https://user-images.githubusercontent.com/96151920/179439457-0360371c-d8e2-43fd-8787-69094deafa80.JPG)

<br><hr>


![6 ilan ekleme](https://user-images.githubusercontent.com/96151920/179439524-1fe89941-1cff-4706-bed8-7e2fccf8afae.JPG)

<br><hr>

## Integration Test Altyapısı Denendi Ve Çalıştığı Test Edildi
![7 test passed](https://user-images.githubusercontent.com/96151920/181358696-a2ebdec2-fc4f-487b-9ebd-16944f028009.JPG)


<br><hr>

# BİRAZ DA "İŞİN KEYİFLİ TARAFLARI"NA DEĞİNELİM 


![A1](https://user-images.githubusercontent.com/96151920/179442406-8b28c5ca-7714-4044-afe9-0a0dfcd8c447.JPG)
![A2](https://user-images.githubusercontent.com/96151920/179442460-8a4f9a3b-8263-4790-bd8d-0205e554af21.JPG)
![A3](https://user-images.githubusercontent.com/96151920/179442482-0b88cb46-5c42-4f5f-89e4-a3590c0ad09f.JPG)
![A4](https://user-images.githubusercontent.com/96151920/179442528-3b4505ac-1d49-414f-9004-67870e738950.JPG)
![A5](https://user-images.githubusercontent.com/96151920/179442548-0447e59b-f54a-41b2-818b-379129a5da9d.JPG)

