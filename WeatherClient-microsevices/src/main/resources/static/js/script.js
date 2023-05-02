const searchBtn = document.querySelector('.search-btn');
const searchBar = document.querySelector('.search-bar');
const cityName = document.querySelector('.city-name');
const temp = document.querySelector('.temp');
const icon = document.querySelector('.icon');
const desc = document.querySelector('.description');
const humidity = document.querySelector('.humidity');
const windSpeed = document.querySelector('.wind-speed');
const error = document.querySelector('.error');
const weatherCard = document.querySelector('.weather');

searchBtn.addEventListener('click', () => {
  const url = `http://localhost:9099/weather/${searchBar.value}`;
  fetch(url)
    .then(response => {
      if (response.ok) {
        return response.text();
      } else {
        throw new Error('Failed to fetch weather data');
      }
    })
    .then(xml => {
      const parser = new DOMParser();
      const xmlDoc = parser.parseFromString(xml, 'text/xml');
      const city = xmlDoc.querySelector('city');
      const temperature = xmlDoc.querySelector('temperature');
      const weatherIcon = xmlDoc.querySelector('weather icon');
      const weatherDesc = xmlDoc.querySelector('weather description');
      const humidityVal = xmlDoc.querySelector('humidity');
      const windSpeedVal = xmlDoc.querySelector('wind speed');
      weatherCard.classList.remove('loading');
      cityName.textContent = city.getAttribute('name');
      temp.textContent = `${temperature.getAttribute('value')} °C`;
      icon.setAttribute('src', `http://openweathermap.org/img/w/${weatherIcon.getAttribute('icon')}.png`);
      desc.textContent = weatherDesc.getAttribute('value');
      humidity.textContent = `Humidity ${humidityVal.getAttribute('value')}%`;
      windSpeed.textContent = `${windSpeedVal.getAttribute('value')} km/h`;
      error.style.display = 'none';
    })
    .catch(error => {
      weatherCard.classList.remove('loading');
     // error.style.display = 'block';
      console.error(error);
    });
});
