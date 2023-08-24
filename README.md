<br />
<p align="center">
  <h2 align="center">BookShelf</h2>
  <p align="center">
    Folksdev'in başlattığı sıfırdan production'a eğitimi ile geliştirdiğimiz bir proje. Mobil uygulama bazlı bir projedir. Flutter il
    <br />
    <br />
    <a href="#">Report Bug</a>
    ·
    <a href="#">Request Feature</a>
  </p>
</p>

# About The Project

## Built With

[![C-Sharp](https://img.shields.io/badge/C%23-239120?style=for-the-badge&logo=c-sharp&logoColor=white)](https://docs.microsoft.com/en-us/dotnet/csharp/)
[![Asp-net](https://img.shields.io/badge/ASP.NET-5C2D91?style=for-the-badge&logo=.net&logoColor=white)](https://dotnet.microsoft.com/apps/aspnet)
[![MSSQL](https://img.shields.io/badge/MSSQL-004880?style=for-the-badge&logo=microsoft-sql-server&logoColor=white)](https://www.microsoft.com/en-us/sql-server/sql-server-2019?rtc=2)
[![Entity-Framework](https://img.shields.io/badge/Entity%20Framework-004880?style=for-the-badge&logo=nuget&logoColor=white)](https://docs.microsoft.com/en-us/ef/)
[![Autofac](https://img.shields.io/badge/Autofac-004880?style=for-the-badge&logo=nuget&logoColor=white)](https://autofac.org/)
[![Fluent-Validation](https://img.shields.io/badge/Fluent%20Validation-004880?style=for-the-badge&logo=nuget&logoColor=white)](https://fluentvalidation.net/)


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
