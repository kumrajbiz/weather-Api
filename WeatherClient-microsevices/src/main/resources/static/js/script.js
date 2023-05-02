const searchBtn = document.querySelector('.search-btn');
const searchBar = document.querySelector('.search-bar');
const cityName = document.querySelector('.city-name');
const temperature = document.querySelector('.temp');
const description = document.querySelector('.description');
const humidity = document.querySelector('.humidity');
const windSpeed = document.querySelector('.wind-speed');
const icon = document.querySelector('.icon');
const error = document.querySelector('.error');
const weather = document.querySelector('.weather');

searchBtn.addEventListener('click', function() {
  const url = `http://localhost:9099/weather/${searchBar.value}`;
  const xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (this.readyState === 4) {
      if (this.status === 200) {
        const data = JSON.parse(this.responseText);
        cityName.textContent = data[0].city;
        temperature.textContent = `${data[0].temperature} °C`;
        description.textContent = data[0].description;
        humidity.textContent = `Humidity ${data[0].humidity}%`;
        windSpeed.textContent = `${data[0].windSpeed} km/h`;
        error.style.display = 'none';
        weather.classList.remove('loading');
      } else {
        error.style.display = 'block';
        error.textContent = 'No weather found';
        weather.classList.remove('loading');
      }
    }
  };

  xhr.open('GET', url);
  xhr.send();
});
