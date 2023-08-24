<br />
<p align="center">
  <h2 align="center">BookShelf</h2>
  <p align="center">
    It is a project we developed with the zero to production training initiated by Folksdev. It is a mobile application based project. I will write the mobile version with Flutter, write the web part with React and create the Backend and Frontend connection. For now, I am working with dummy data.
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

# For Running the application
Please follow the steps below to run the application.

1 ) Download AWS CLI. https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html

2 ) Go to the project directory and run the following commands respectively.

- mvn clean install -D skipTest
- docker build -t lib .
- docker-compose up -d
- Run from terminal .\init-aws.sh
- docker-compose up -d

# Acknowledgements

- FolksDev
