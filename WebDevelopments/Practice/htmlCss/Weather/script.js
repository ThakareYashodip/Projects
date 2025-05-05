const key = "cd0bce9cf58b904c36e5457b74fea9eb";
const searchBox = document.querySelector(".search input");
const searchBtn = document.querySelector(".search button");
const weatherIcon = document.querySelector(".weather-icon");

async function getWeather(city) {
  if (!city) {
    alert("Please enter a city name.");
    return;
  }

  const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${key}`;

  try {
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error("City not found");
    }

    const data = await response.json();
    console.log(data);

    document.querySelector(".city").innerHTML = data.name;
    document.querySelector(".temp").innerHTML =
      Math.round(data.main.temp) + "°c";
    document.querySelector(".humidity").innerHTML = data.main.humidity + "%";
    document.querySelector(".wind").innerHTML = data.wind.speed + " km/h";

    if (data.weather[0].main == "Clouds") {
      weatherIcon.src = "https://ssl.gstatic.com/onebox/weather/64/cloudy.png";
    } else if (data.weather[0].main == "Rain") {
      weatherIcon.src = "https://ssl.gstatic.com/onebox/weather/64/rain.png";
    } else if (data.weather[0].main == "Mist") {
      weatherIcon.src =
        "https://png.pngtree.com/png-clipart/20230823/original/pngtree-daytime-foggy-weather-clouds-illustration-picture-image_8201381.png";
    } else if (data.weather[0].main == "Drizzle") {
      weatherIcon.src =
        "https://cdn3d.iconscout.com/3d/premium/thumb/rainy-day-3d-icon-download-in-png-blend-fbx-gltf-file-formats--rain-cloud-sun-weather-pack-icons-5753017.png?f=webp";
    }

    document.querySelector(".weather").style.display = "block";
  } catch (error) {
    alert(error.error);
    console.error("Error fetching weather:", error);
  }
}

// 🔍 Event: Search button click
searchBtn.addEventListener("click", () => {
  const city = searchBox.value.trim();
  getWeather(city);
});
