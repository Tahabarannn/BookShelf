<br />
<p align="center">
  <h2 align="center">BookShelf</h2>
  <p align="center">
    Folksdev'in başlattığı sıfırdan production'a eğitimi ile geliştirdiğimiz bir proje. Mobil uygulama bazlı bir projedir. Flutter ile mobil versiyonunu yazıp, React ile web kısmını yazıp Backend ile Frontend bağlantısını oluşturacağım. Şu an için dummy datalar ile çalışıyorum.
    <br />
    <br />
    <a href="#">Report Bug</a>
    ·
    <a href="#">Request Feature</a>
  </p>
</p>

# About The Project

## Built With

<h2>BACKEND</h2>
<ul>
  <li>Java 17</li>
  <li>Spring Boot</li>
  <li>JDBC</li>
  <li>MySql</li>
  <li>Aws</li>
</ul>

<h2>FRONTEND</h2>
<ul>
  <li>React</li>
  <li>ViteJs</li>
  <li>Material UI</li>
  <li>React Router DOM</li>
</ul>


## Layers

<details>
  <summary>Toggle Content</summary>

### Business

Business Layer created to process or control the incoming information according to the required conditions.

### Core

Core layer containing various particles independent of the project.

### DataAccess

Data Access Layer created to perform database CRUD operations.

### Entities

Entities Layer created for database tables.

### WebAPI

Web API Layer that opens the business layer to the internet.

</details><p></p>

## Models

<details>
  <summary>Toggle Content</summary>


### Product Images

| Name      | Data Type     | Allow Nulls | Default |
| :-------- | :------------ | :---------- | :------ |
| Id        | int           | False       |         |
| ProductId | int           | False       |         |
| ImagePath | nvarchar(MAX) | False       |         |
| Date      | datetime      | False       |         |

### Product

| Name                   | Data Type     | Allow Nulls | Default |
| :--------------------- | :------------ | :---------- | :------ |
| ProductId              | int           | False       |         |
| ProductName            | nvarchar(50)  | False       |         |
| CategoryId             | int           | False       |         |
| UnitPrice              | decimal(18,0) | False       |         |
| UnitinStock            | smallint      | False       |         |

### Category

| Name         | Data Type    | Allow Nulls | Default |
| :----------- | :----------- | :---------- | :------ |
| CategoryId   | int          | False       |         |
| CategoryName | nvarchar(25) | False       |         |

### Customer

| Name                | Data Type    | Allow Nulls | Default |
| :------------------ | :----------- | :---------- | :------ |
| CustomerId          | int          | False       |         |
| ContactName         | nvarchar(50) | True        |         |
| CompanyName         | nvarchar(50) | True        |         |
| City                | nvarchar(50) | True        |         |

### OperationClaims

| Name | Data Type    | Allow Nulls | Default |
| :--- | :----------- | :---------- | :------ |
| Id   | int          | False       |         |
| Name | varchar(250) | False       |         |

### UserOperationClaims

| Name             | Data Type | Allow Nulls | Default |
| :--------------- | :-------- | :---------- | :------ |
| Id               | int       | False       |         |
| UserId           | int       | False       |         |
| OperationClaimId | int       | False       |         |

### Users

| Name         | Data Type      | Allow Nulls | Default |
| :----------- | :------------- | :---------- | :------ |
| Id           | int            | False       |         |
| FirstName    | nvarchar(50)   | False       |         |
| LastName     | nvarchar(50)   | False       |         |
| Email        | nvarchar(50)   | False       |         |
| PasswordHash | varbinary(500) | False       |         |
| PasswordSalt | varbinary(500) | False       |         |
| Status       | bit            | False       |         |

</details><p></p>

# Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

# License

Distributed under the MIT License. See `LICENSE` for more information.

# Acknowledgements

- [engindemirog](https://www.linkedin.com/in/engindemirog/)
