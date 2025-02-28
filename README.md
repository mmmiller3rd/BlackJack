<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![project_license][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
<h3 align="center">Black Jack</h3>

  <p align="center">
    This is a card game where the player tries to get as close to 21 as possible without going over.
    <br />
    <a href="https://github.com/mmmiller3rd/BlackJack"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/mmmiller3rd/BlackJack">View Demo</a>
    &middot;
    <a href="https://github.com/mmmiller3rd/BlackJack/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    &middot;
    <a href="https://github.com/mmmiller3rd/BlackJack/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

This project is my approach to the classic card game Black Jack a.k.a. 21
### Game Rules
* Players receive cards face up, and the dealer's first card is face up and the second is face down
* Players can split their hand if their second card is the same as their first
* If a player's hand goes over 21, it's called a "BUST" and they lose
* A total of 21 on the first two cards is called a "BlackJack"
* Players will attempt to get close to 21 before the dealer
* 5-Card Charlie - if a player has 5 cards in their hand and a hand value less than 21, then regardless of what the dealer has the player wins
* You can choose to end the game whenever, but once you have lost all you money, it's game over
### Card Values
* Numbered cards are worth their face value
* Face cards (Jacks, Queens, and Kings) are each worth 10
* Aces are worth either 1 or 11
### Actions
* Players have the option to either HIT, SPLIT, DOUBLE DOWN, or STAY
* When taking a HIT, if the hand value exceeds 21 the player BUSTS and the hand is lost
* When splitting Aces you will not be able to take another hit
* You can only double down oon your first action
* When doubling down, you will receive 1 final card
### Bets
* Players start with $1000
* Black Jack pays 3:2 ex. You bet \$100 your prize \$150
* If splitting or doubling down a player must match their original bet for each new hand

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

[![Spring][Spring]][Spring-url]
[![JAVA][Java]][Java-url]
[![Gradle][Gradle]][Gradle-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow the steps below.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* install Java 17
  ```sh
  visit https://www.oracle.com/java/technologies/downloads/
  install Java 17 for your machine
  ```
* Verify that you have at least JDK 8 set in you environment variables

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/mmmiller3rd/BlackJack.git
   ```
2. Install Java dependencies
   ```sh
   ./gradlew clean build
   ```
3. Change git remote url to avoid accidental pushes to base project
   ```sh
   git remote set-url origin mmmiller3rd/BlackJack
   git remote -v # confirm the changes
   ```

### Running

1. Execute
    ```sh
   ./gradlew bootRun
   ```

2. Make request
    ```sh
   "numberOfPlayers" and "position" are not required in the request. The default values if none are provided are 7 and 4 respectively.
   curl --location 'localhost:8080/newGame'
   curl --location 'localhost:8080/newGame?numberOfPlayers=<SomeNumber less than 8>&position=<SomeNumber less than 8>'
    ```
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Top contributors:

<a href="https://github.com/mmmiller3rd/BlackJack/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=mmmiller3rd/BlackJack" alt="contrib.rocks image" />
</a>



<!-- CONTACT -->
## Contact

Melvin Miller - mmmiller3rd@gmail.com

Project Link: [https://github.com/mmmiller3rd/BlackJack](https://github.com/mmmiller3rd/BlackJack)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Best-README-Template](https://github.com/othneildrew/Best-README-Template/blob/main/BLANK_README.md#readme-top)
* []()
* []()

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/mmmiller3rd/BlackJack.svg?style=for-the-badge
[contributors-url]: https://github.com/mmmiller3rd/BlackJack/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/mmmiller3rd/BlackJack.svg?style=for-the-badge
[forks-url]: https://github.com/mmmiller3rd/BlackJack/network/members
[stars-shield]: https://img.shields.io/github/stars/mmmiller3rd/BlackJack.svg?style=for-the-badge
[stars-url]: https://github.com/mmmiller3rd/BlackJack/stargazers
[issues-shield]: https://img.shields.io/github/issues/mmmiller3rd/BlackJack.svg?style=for-the-badge
[issues-url]: https://github.com/mmmiller3rd/BlackJack/issues
[license-shield]: https://img.shields.io/github/license/mmmiller3rd/BlackJack.svg?style=for-the-badge
[license-url]: https://github.com/mmmiller3rd/BlackJack/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/melvin-miller-0a823799
[Spring]: https://img.shields.io/badge/Spring-6db33f?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://start.spring.io/
[Gradle]: https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white
[Gradle-url]: https://start.spring.io/
[Java]: https://img.shields.io/badge/JAVA-3a75b0?style=for-the-badge
[Java-url]: https://www.oracle.com/java/technologies/downloads/
