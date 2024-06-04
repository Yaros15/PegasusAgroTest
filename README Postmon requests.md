GET - Все машины: http://localhost:8080/car
GET - Одна машина: http://localhost:8080/car/1
POST - Добавить машину: http://localhost:8080/car  => JSON: {
                                                                "numberCar": "Car A3",
                                                                "buildDate": "2024-04-13"
                                                            }
PUT - Изменить машину: http://localhost:8080/car/1  => JSON: {
                                                                "numberCar": "Car A3",
                                                                "buildDate": "2024-04-13"
                                                            }
DELETE - Удалить машину: http://localhost:8080/car/1


GET - Все владельцы машин: http://localhost:8080/carOwner
GET - Один владелец машин: http://localhost:8080/carOwner/1
POST - Добавить владельца машин: http://localhost:8080/carOwner  => JSON: {
                                                                              "fullName": "Марк Старк",
                                                                              "telephone": 1111111111,
                                                                              "email": "marc1@email.ru",
                                                                              "carsId": [1, 2]
                                                                          }
PUT - Изменить владельца машин: http://localhost:8080/carOwner/1  => JSON: {
                                                                              "fullName": "Старк Марк",
                                                                              "telephone": 222222222,
                                                                              "email": "cnfhr1@email.ru",
                                                                              "carsId": [3, 4]
                                                                          }
PUT - Забрать у владельца одну машину: http://localhost:8080/carOwner/1/remove/1                                                                            
DELETE - Удалить владельца машин: http://localhost:8080/carOwner/1


GET - Все дилеры: http://localhost:8080/dealer
GET - Один дилеры: http://localhost:8080/dealer/1
POST - Добавить дилера: http://localhost:8080/dealer  => JSON: {
                                                                    "nameOrganization": "Агро-Дилер",
                                                                    "email": "agro_diler@mail.ru",
                                                                    "representativeFullName": "Петров Петр",
                                                                    "carOwnersId": [1]
                                                                }
PUT - Изменить дилера: http://localhost:8080/dealer/1  => JSON: {
                                                                    "nameOrganization": "Агро-Дилер",
                                                                    "email": "agro_diler@mail.ru",
                                                                    "representativeFullName": "Петров Петр",
                                                                    "carOwnersId": [1]
                                                                }
PUT - Отвезать от дилера владельца машин:  http://localhost:8080/dealer/1/remove/1                                                         
DELETE - Удалить дилера: http://localhost:8080/dealer/1
