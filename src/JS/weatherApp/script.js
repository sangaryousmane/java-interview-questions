const PASSWORD = "0b03cd4625a6c4a4fdef5d4612f2ebef"
const URL = "https://api.openweathermap.org/data/2.5/weather?q="
const errorCode = document.querySelector(".error");
const weather = document.querySelector(".weather");
const searchBox = document.querySelector(".search input");
const searchButton = document.querySelector(".search button");
const weatherIcon = document.querySelector(".weather-icon");


async function checkWeather(city) {
    let response = await fetch(URL + city + `&appid=${PASSWORD}`);

    if (response.status === 404) {
        errorCode.style.display = "block";
        weather.style.display = "none";
    } else {
        let data = await response.json();
        console.log(data)
        document.querySelector(".city").innerHTML = data.name;
        document.querySelector(".humidity").innerHTML = data.main.humidity + " %";
        document.querySelector(".temp").innerHTML =Math.round(data.main.temp) + " °c";
        document.querySelector(".wind").innerHTML = data.wind.speed + " km/hr";
        document.querySelector(".country-code").innerHTML = data.sys.country
        // Loop through weather condition
        switch (data.weather[0].main){
            case "Clouds": weatherIcon.src = "./images/clouds.png";break;
            case "Rain": weatherIcon.src = "./images/rain.png";break;
            case "Mist": weatherIcon.src = "./images/mist.png";break;
            case "Drizzle": weatherIcon.src = "./images/drizzle.png";break;
            case "Clear": weatherIcon.src = "./images/clear.png";break;
            default: weatherIcon.src = "./images/snow.png";
        }
        weather.style.display = "block";
        errorCode.style.display = "none";

    }
}

searchButton.addEventListener("click", () => {
    checkWeather(searchBox.value).then(r => console.log(r));
})